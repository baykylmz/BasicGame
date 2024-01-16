package AhmetBuyukyilmaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GameGUI {
    private JFrame frame;
    private JLabel label;
    private JButton next;
    private JTextField answer;
    private JLabel timeLabel;
    private int seconds=0;
    private int minutes=0;
    private int hours=0;
    private int elapsedTime;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string= String.format("%02d", minutes);
    String hours_string= String.format("%02d", hours);
    Timer timer;

    public GameGUI(Parent parent,Exam exam,int PrevElapsedTime){

        if(exam.getCount()==exam.getQuestionsNumber()){
            exam.calculateScore();
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            exam.setFinishDate(timeStamp);
            new ScoreShowGUI(parent,exam);
        }
        else{
            elapsedTime = PrevElapsedTime;
            timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    elapsedTime=elapsedTime+1000;
                    hours = (elapsedTime/3600000);
                    minutes = (elapsedTime/60000) % 60;
                    seconds = (elapsedTime/1000) % 60;
                    seconds_string = String.format("%02d", seconds);
                    minutes_string = String.format("%02d", minutes);
                    hours_string = String.format("%02d", hours);
                    timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
                }
            });
            timer.start();
            timeLabel = new JLabel(hours_string+":"+minutes_string+":"+seconds_string);
            timeLabel.setBounds(100, 20, 300, 180);
            timeLabel.setHorizontalAlignment(JLabel.CENTER);
            timeLabel.setVerticalAlignment(JLabel.CENTER);
            timeLabel.setFont(new Font("Serif",Font.PLAIN,30));
            timeLabel.setVisible(true);
            timeLabel.setBorder(BorderFactory.createBevelBorder(1));
            timeLabel.setOpaque(true);


            Question question = exam.getQuestions().get(exam.getCount());
            int A = question.getA();
            int B = question.getB();

            label = new JLabel();
            label.setText(A+ " x " + B + " = ?");
            label.setBounds(100, 300, 300, 20);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            label.setFont(new Font("Serif",Font.BOLD,16));

            answer = new JTextField();
            answer.setBounds(200,400,100,30);
            answer.setVisible(true);

            next = new JButton();
            next.setText("Next");
            next.setBounds(200, 500, 100, 50);
            next.setHorizontalTextPosition(JButton.CENTER);
            next.setVerticalTextPosition(JButton.CENTER);
            next.setFocusable(false);
            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(answer.getText().equals("")){
                            question.setChildsAnswer(-1);
                        }
                        else{
                            int answ = Integer.parseInt(answer.getText());
                            question.setChildsAnswer(answ);
                        }
                        question.setTime((elapsedTime-PrevElapsedTime)/1000);
                        exam.setCount(exam.getCount()+1);
                        frame.dispose();
                        new GameGUI(parent,exam,elapsedTime);
                    }catch (Exception s){
                        JOptionPane.showMessageDialog(new JFrame(), "Enter integer number", "Dialog",
                                JOptionPane.ERROR_MESSAGE);
                        frame.dispose();
                        new GameGUI(parent,exam,elapsedTime);
                    }
                }
            });

            frame = new JFrame();
            frame.setLayout(null);
            frame.setTitle("Game");
            frame.setVisible(true);
            frame.setSize(500, 700);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(3);
            frame.setLocation(400,200);

            frame.add(label);
            frame.add(answer);
            frame.add(next);
            frame.add(timeLabel);

        }
    }
}
