package AhmetBuyukyilmaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {

	private JFrame frame;
	private JButton signUp;
	private JButton signIn;
	private JLabel label;

	public GUI(Parent parent) {

		label = new JLabel();
		label.setText("Welcome");
		label.setBounds(225, 250, 100, 50);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVisible(true);

		signUp = new JButton();
		signUp.setText("Sign up");
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SignUpGUI(parent);
			}
		});
		signUp.setBounds(140, 325, 100, 50);
		signUp.setHorizontalTextPosition(JButton.CENTER);
		signUp.setVerticalTextPosition(JButton.CENTER);
		signUp.setFocusable(false);

		signIn = new JButton();
		signIn.setText("Log in");
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == signIn) {
					frame.dispose();
					new SignInGUI(parent);
				}
			}
		});
		signIn.setBounds(260, 325, 100, 50);
		signIn.setHorizontalTextPosition(JButton.CENTER);
		signIn.setVerticalTextPosition(JButton.CENTER);
		signIn.setFocusable(false);

		frame = new JFrame();
		frame.setLayout(null);
		frame.setTitle("Game");
		frame.setVisible(true);
		frame.setSize(500, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(3);
		frame.setLocation(400,200);


		frame.add(signUp);
		frame.add(signIn);
		frame.add(label);

	}
}