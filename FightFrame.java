import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTextPane;
import javax.swing.JSpinner;

public class FightFrame {
	public static JFrame fightframe;
	private JSpinner Enteroff;
	private JSpinner Enterdef;
	
	
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
		
		Enteroff = new JSpinner();
		Enteroff.setBounds(53, 109, 96, 21);
		
		fightframe.getContentPane().add(Enteroff);
		
		
		Enterdef = new JSpinner();
		Enterdef.setBounds(272, 109, 96, 21);
		
		fightframe.getContentPane().add(Enterdef);
		
		
		JButton btnReady = new JButton("Ready");
		btnReady.setBounds(53, 304, 87, 23);
		fightframe.getContentPane().add(btnReady);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(272, 304, 87, 23);
		fightframe.getContentPane().add(btnCancel);
		
		
		

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fightframe.dispose();
			}
		});

		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.blockmain = false;
				fightframe.dispose();
			}
		});

		fightframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
