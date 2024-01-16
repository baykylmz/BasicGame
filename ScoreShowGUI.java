package AhmetBuyukyilmaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreShowGUI {
    private JLabel label;
    private JPanel panel;
    private JButton quit;
    private JFrame frame;
    private JScrollPane scroll;
    private JTable table;

    public ScoreShowGUI(Parent parent,Exam exam){

        label = new JLabel();
        label.setText("Your Score = " + exam.getScore());
        label.setPreferredSize(new Dimension(100,50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 18));
        label.setVisible(true);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setBounds(0,0,500,700);

        String [] columns = {"question","answer","status","time"};
        Object [][] data = new Object [exam.getQuestionsNumber()][];
        for (int i = 0;i<exam.getQuestionsNumber();i++) {
            Question question = exam.getQuestions().get(i);
            Object[] obj = {question.getA() + " x " + question.getB(),question.getChildsAnswer(),question.isTrue(),question.getTime()};
            data[i] = obj;
        }
        table = new JTable(data,columns);
        table.setPreferredScrollableViewportSize(new Dimension(200,100));
        table.setFillsViewportHeight(true);
        table.setEnabled(false);

        scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(200,100));
        scroll.setVisible(true);
        scroll.setMaximumSize(new Dimension(300,300));

        quit = new JButton();
        quit.setText("Back");
        quit.setPreferredSize(new Dimension(100,50));
        quit.setHorizontalTextPosition(JButton.CENTER);
        quit.setVerticalTextPosition(JButton.CENTER);
        quit.setFocusable(false);
        quit.setAlignmentX(Component.CENTER_ALIGNMENT);
        quit.setVisible(true);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ParentGUI(parent);
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

        panel.add(Box.createRigidArea(new Dimension(200,20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(200,20)));
        panel.add(scroll);
        panel.add(Box.createRigidArea(new Dimension(200,20)));
        panel.add(quit);

        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        frame.add(panel);

    }
}
