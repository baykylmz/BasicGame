package AhmetBuyukyilmaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ModesGUI {

    private JFrame frame;
    private JButton add;
    private JButton delete;
    private JLabel label;
    private JTextField Name;
    private JLabel label1;
    private JLabel label2;
    private JButton parentGUI;
    private JList list;
    private JScrollPane scroll;
    private JSlider A;
    private JSlider B;
    private JTextField N;
    private JLabel labelA;
    private JLabel labelB;
    private JLabel labelN;

    public ModesGUI(Parent parent) {

        label = new JLabel();
        label.setText("Your Modes");
        label.setBounds(150, 0, 200, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("A", Font.BOLD, 14));

        list = new JList(parent.listModes());
        scroll = new JScrollPane(list);
        scroll.setBounds(100,50,300,150);
        scroll.setVisible(true);

        Name = new JTextField();
        Name.setBounds(240, 250, 100, 30);

        A = new JSlider(0,10,5);
        A.setBounds(150,300,200,50);
        A.setVisible(true);
        A.setPaintTicks(true);
        A.setMajorTickSpacing(2);
        A.setPaintTrack(true);
        A.setMinorTickSpacing(1);
        A.setPaintLabels(true);

        labelA = new JLabel();
        labelA.setText("A");
        labelA.setBounds(120, 300, 100, 30);
        labelA.setVerticalAlignment(JLabel.CENTER);
        labelA.setFont(new Font("A", Font.BOLD, 14));

        B = new JSlider(0,10,5);
        B.setBounds(150,350,200,50);
        B.setVisible(true);
        B.setPaintTicks(true);
        B.setMajorTickSpacing(2);
        B.setPaintTrack(true);
        B.setMinorTickSpacing(1);
        B.setPaintLabels(true);

        labelB = new JLabel();
        labelB.setText("B");
        labelB.setBounds(120, 350, 100, 30);
        labelB.setVerticalAlignment(JLabel.CENTER);
        labelB.setFont(new Font("A", Font.BOLD, 14));

        N = new JTextField();
        N.setBounds(150,400,100,30);
        N.setVisible(true);

        labelN = new JLabel();
        labelN.setText("N");
        labelN.setBounds(120, 400, 100, 30);
        labelN.setVerticalAlignment(JLabel.CENTER);
        labelN.setFont(new Font("A", Font.BOLD, 14));

        label1 = new JLabel();
        label1.setText("Name");
        label1.setBounds(150, 250, 100, 30);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setFont(new Font("A", Font.BOLD, 18));

        label2 = new JLabel();
        label2.setText("Unsuccessful");
        label2.setBounds(0, 620, 500, 30);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Sherif", Font.BOLD, 14));
        label2.setVisible(false);

        add = new JButton();
        add.setText("Add");
        add.setBounds(150, 500, 100, 50);
        add.setHorizontalTextPosition(JButton.CENTER);
        add.setVerticalTextPosition(JButton.CENTER);
        add.setFocusable(false);

        delete = new JButton();
        delete.setText("Delete");
        delete.setBounds(250, 500, 100, 50);
        delete.setHorizontalTextPosition(JButton.CENTER);
        delete.setVerticalTextPosition(JButton.CENTER);
        delete.setFocusable(false);

        parentGUI = new JButton();
        parentGUI.setText("Back");
        parentGUI.setBounds(200, 550, 100, 50);
        parentGUI.setHorizontalTextPosition(JButton.CENTER);
        parentGUI.setVerticalTextPosition(JButton.CENTER);
        parentGUI.setFocusable(false);

        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Game");
        frame.setVisible(true);
        frame.setSize(500, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.setLocation(400,200);

        frame.add(add);
        frame.add(label);
        frame.add(Name);
        frame.add(label1);
        frame.add(parentGUI);
        frame.add(delete);
        frame.add(label2);
        frame.add(scroll);
        frame.add(A);
        frame.add(B);
        frame.add(N);
        frame.add(labelA);
        frame.add(labelB);
        frame.add(labelN);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setVisible(false);
                try {
                    int a = Integer.parseInt(N.getText());
                    if(!Name.getText().equals("")){
                        parent.addMode(new Mode(Name.getText(),a,A.getValue(),B.getValue()));
                        frame.dispose();
                        new ModesGUI(parent);
                    }else {
                        label2.setText("Name must be filled");
                        label2.setVisible(true);
                    }
                }catch (Exception x){
                    label2.setText("N must be filled with integer");
                    label2.setVisible(true);
                }
            }
        });

        parentGUI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ParentGUI(parent);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(parent.deleteMode(Name.getText())){
                    frame.dispose();
                    new ModesGUI(parent);
                }
                else{
                    label2.setText("Mode not found");
                    label2.setVisible(true);
                }
            }
        });

    }
}
