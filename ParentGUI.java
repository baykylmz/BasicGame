package AhmetBuyukyilmaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

public class ParentGUI {

    private JFrame frame;
    private JButton Childs;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JButton Start;
    private JButton Exit;
    private JButton GameModes;
    private JButton HighScores;
    private JComboBox ChildList;
    private JComboBox ModesList;

    public ParentGUI(Parent parent) {

        label = new JLabel();
        label.setText(parent.getUserName());
        label.setBounds(200, 10, 100, 20);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Serif",Font.BOLD,16));

        label1 = new JLabel();
        label1.setText("Child");
        label1.setBounds(100, 80, 300, 20);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setFont(new Font("Serif",Font.BOLD,12));

        ChildList = new JComboBox(parent.listChilds());
        ChildList.setBounds(100,100,300,30);
        ChildList.setVisible(true);

        label2 = new JLabel();
        label2.setText("Mode");
        label2.setBounds(100, 180, 300, 20);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Serif",Font.BOLD,12));

        ModesList = new JComboBox(parent.listModes());
        ModesList.setBounds(100,200,300,30);
        ModesList.setVisible(true);

        Start = new JButton();
        Start.setText("Start");
        Start.setBounds(200, 300, 100, 50);
        Start.setHorizontalTextPosition(JButton.CENTER);
        Start.setVerticalTextPosition(JButton.CENTER);
        Start.setFocusable(false);

        Childs = new JButton();
        Childs.setText("Childs");
        Childs.setBounds(50, 500, 100, 50);
        Childs.setHorizontalTextPosition(JButton.CENTER);
        Childs.setVerticalTextPosition(JButton.CENTER);
        Childs.setFocusable(false);

        HighScores = new JButton();
        HighScores.setText("High Scores");
        HighScores.setFont(new Font("Serif",Font.BOLD,11));
        HighScores.setBounds(200, 500, 100, 50);
        HighScores.setHorizontalTextPosition(JButton.CENTER);
        HighScores.setVerticalTextPosition(JButton.CENTER);
        HighScores.setFocusable(false);

        GameModes = new JButton();
        GameModes.setText("Modes");
        GameModes.setBounds(350, 500, 100, 50);
        GameModes.setHorizontalTextPosition(JButton.CENTER);
        GameModes.setVerticalTextPosition(JButton.CENTER);
        GameModes.setFocusable(false);
        GameModes.setVisible(true);

        Exit = new JButton();
        Exit.setText("Save");
        Exit.setBounds(200, 600, 100, 50);
        Exit.setFont(new Font("Serif",Font.BOLD,11));
        Exit.setHorizontalTextPosition(JButton.CENTER);
        Exit.setVerticalTextPosition(JButton.CENTER);
        Exit.setFocusable(false);
        Exit.setVisible(true);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.saveParent(parent);
                Excel excel = new Excel();
                try {
                    excel.writeExcel(parent);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
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

        frame.add(Childs);
        frame.add(label);
        frame.add(Start);
        frame.add(GameModes);
        frame.add(ChildList);
        frame.add(ModesList);
        frame.add(label1);
        frame.add(label2);
        frame.add(HighScores);
        frame.add(Exit);

        Childs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Childs.setEnabled(false);
                frame.dispose();
                new AddChildGUI(parent);
            }
        });
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start.setEnabled(false);
                Child child = parent.getChild((String) ChildList.getSelectedItem());
                Mode mode = parent.getModes().get(ModesList.getSelectedIndex());
                Exam exam = new Exam(mode.getA(), mode.getB(), mode.getQuestionNumber(),child.getName());
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
                exam.setStartDate((timeStamp));
                child.addExam(exam);
                frame.dispose();
                new GameGUI(parent,exam,0);
            }
        });

        GameModes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameModes.setEnabled(false);
                frame.dispose();
                new ModesGUI(parent);
            }
        });

        HighScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new HighScoresGUI(parent);
            }
        });
    }
}
