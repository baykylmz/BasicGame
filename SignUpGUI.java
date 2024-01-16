package AhmetBuyukyilmaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpGUI {

	private JFrame frame;
	private JButton signUp;
	private JLabel label;
	private JTextField Name;
	private JLabel label1;
	private JTextField Password;
	private JLabel label2;
	private JButton Main;

	public SignUpGUI(Parent parent) {

		label = new JLabel();
		label.setText("UserName");
		label.setBounds(150, 150, 100, 20);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		Name = new JTextField();
		Name.setBounds(250, 150, 100, 20);

		label1 = new JLabel();
		label1.setText("Password");
		label1.setBounds(150, 250, 100, 20);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.CENTER);

		Password = new JTextField();
		Password.setBounds(250, 250, 100, 20);

		label2 = new JLabel();
		label2.setBounds(0,500,500,50);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.CENTER);
		label2.setVisible(false);

		signUp = new JButton();
		signUp.setText("Sign up");
		signUp.setBounds(150, 400, 100, 50);
		signUp.setHorizontalTextPosition(JButton.CENTER);
		signUp.setVerticalTextPosition(JButton.CENTER);
		signUp.setFocusable(false);

		Main = new JButton();
		Main.setText("Main Menu");
		Main.setBounds(250, 400, 100, 50);
		Main.setHorizontalTextPosition(JButton.CENTER);
		Main.setVerticalTextPosition(JButton.CENTER);
		Main.setFocusable(false);

		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Game");
		frame.setVisible(true);
		frame.setSize(500, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.setLocation(400,200);

		frame.add(signUp);
		frame.add(label);
		frame.add(Name);
		frame.add(label1);
		frame.add(Password);
		frame.add(label2);
		frame.add(Main);

		signUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				signUp.setEnabled(false);
				Name.setEnabled(false);
				Password.setEnabled(false);
				Parent tmp = new Parent(Name.getText(), Password.getText());
				if(!parent.getUserName().equals(Name.getText())){
					parent.setUserName(Name.getText());
					parent.setPassword(Password.getText());
					label2.setText("Sign Up successful");
				}
				else{
					label2.setText("Username already exist");
				}
				label2.setVisible(true);
			}
		});

		Main.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new GUI(parent);
			}
		});
	}
}
