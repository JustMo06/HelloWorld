package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AuthController;

@SuppressWarnings("serial")
public class AuthView extends JFrame{
	private AuthController c;
	
	public AuthView(AuthController c){
		this.c = c;
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(new Dimension(400, 500));
		super.setTitle("Login - WordFeud");
		super.setLocationRelativeTo(null); //Make the frame centered
		super.setResizable(false);
		super.setContentPane(this.getPanel());
		super.pack();
		super.setVisible(true);
	}
	
	public AuthController getController(){
		return this.c;
	}
	
	public JPanel getPanel(){
		JPanel main = new JPanel(new BorderLayout());
		main.setBorder(new EmptyBorder(15, 15, 15, 15));
		
		JPanel logo = new JPanel(new GridLayout(2,1));
		JLabel lblLogo = new JLabel("WordFeud Logo");
		lblLogo.setFont(new Font("Verdana", Font.BOLD, 26));
		lblLogo.setForeground(Color.BLUE);
		logo.add(lblLogo);
		main.add(logo, BorderLayout.NORTH);
		
		
		JPanel form = new JPanel(new GridLayout(4,2));
		JLabel lblUsername = new JLabel("Gebruikersnaam: ");
		form.add(lblUsername);
		JTextField tfUsername = new JTextField();
		form.add(tfUsername);
		JLabel lblPassword = new JLabel("Wachtwoord: ");
		form.add(lblPassword);
		JTextField tfPassword = new JTextField();
		form.add(tfPassword);
		main.add(form, BorderLayout.CENTER);
		
		JPanel buttons = new JPanel(new BorderLayout());
		JButton btnLogin = new JButton("Inloggen");
		btnLogin.addActionListener(e -> {
			//c.getModel().doSomething();
		});
		buttons.add(btnLogin, BorderLayout.WEST);
		JButton btnRegister = new JButton("Registreren");
		btnRegister.addActionListener(e -> {
			//c.getModel().doSomething();
		});
		buttons.add(btnRegister, BorderLayout.EAST);
		main.add(buttons, BorderLayout.SOUTH);
		
		return main;
	}
}
