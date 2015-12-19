import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FightFrame {
	public static JFrame fightframe;
	private JTextField txtEnteroff;
	private JTextField txtEnterdef;
	
	
	public FightFrame(){
		fightframe = new JFrame();
		fightframe.setResizable(false);
		fightframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fightframe.setBounds(new Rectangle(100, 0, 550, 400));
		fightframe.setTitle("Prepare your fight");
		fightframe.getContentPane().setLayout(null);
		
		JLabel lblSetYourOffense = new JLabel("Set your offense soldier");
		lblSetYourOffense.setBounds(53, 51, 160, 34);
		fightframe.getContentPane().add(lblSetYourOffense);
		
		JLabel lblSetYourDefense = new JLabel("Set your defense soldier");
		lblSetYourDefense.setBounds(272, 51, 160, 34);
		fightframe.getContentPane().add(lblSetYourDefense);
		
		txtEnteroff = new JTextField();
		txtEnteroff.setBounds(53, 109, 96, 21);
		fightframe.getContentPane().add(txtEnteroff);
		txtEnteroff.setColumns(10);
		
		txtEnterdef = new JTextField();
		txtEnterdef.setBounds(272, 109, 96, 21);
		fightframe.getContentPane().add(txtEnterdef);
		txtEnterdef.setColumns(10);
		
		JButton btnReady = new JButton("Ready");
		btnReady.setBounds(53, 304, 87, 23);
		fightframe.getContentPane().add(btnReady);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(272, 304, 87, 23);
		fightframe.getContentPane().add(btnCancel);
		
	}
}
