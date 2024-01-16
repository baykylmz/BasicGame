package AhmetBuyukyilmaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddChildGUI {

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


    public AddChildGUI(Parent parent) {

        label = new JLabel();
        label.setText("Your Childs");
        label.setBounds(150, 0, 200, 50);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("A", Font.BOLD, 18));

        list = new JList(parent.listChilds());

        scroll = new JScrollPane(list);
        scroll.setBounds(100,70,300,150);
        scroll.setVisible(true);


        Name = new JTextField();
        Name.setBounds(250, 300, 100, 30);

        label1 = new JLabel();
        label1.setText("Name");
        label1.setBounds(150, 300, 100, 30);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setFont(new Font("A", Font.BOLD, 18));

        label2 = new JLabel();
        label2.setText("Unsuccessful");
        label2.setBounds(0, 600, 500, 30);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Serif", Font.BOLD, 14));
        label2.setVisible(false);

        add = new JButton();
        add.setText("Add");
        add.setBounds(150, 400, 100, 50);
        add.setHorizontalTextPosition(JButton.CENTER);
        add.setVerticalTextPosition(JButton.CENTER);
        add.setFocusable(false);

        delete = new JButton();
        delete.setText("Delete");
        delete.setBounds(250, 400, 100, 50);
        delete.setHorizontalTextPosition(JButton.CENTER);
        delete.setVerticalTextPosition(JButton.CENTER);
        delete.setFocusable(false);

        parentGUI = new JButton();
        parentGUI.setText("Back");
        parentGUI.setBounds(200, 500, 100, 50);
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
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label2.setVisible(false);
                if(!Name.getText().equals("")){
                    parent.addChild(new Child(Name.getText()));
                    frame.dispose();
                    new AddChildGUI(parent);
                }
                else {
                    label2.setText("Name must be filled");
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
                if(parent.deleteChild(Name.getText())){
                    frame.dispose();
                    new AddChildGUI(parent);
                }
                else{
                    label2.setText("Child not found");
                    label2.setVisible(true);
                }
            }
        });

    }
}
