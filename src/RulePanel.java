import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class RulePanel extends JPanel{
	public static JPanel rulepanel;
	
	public static JButton btnOK;
	public RulePanel(){
		
		init();
		repaint();
	}

	public void init(){
		
		setSize(800, 600);
		setLayout(null);
		
		btnOK = new JButton("OK\n");
		btnOK.setBounds(616, 544, 115, 20);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OriginalFrame.pressOK();
			}
		});
		add(btnOK);
		
		JLabel lblNewLabel = new JLabel("1.To open a game");
		lblNewLabel.setBounds(50, 65, 279, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("a.Press “File”>>”OpenGame”>>set the number of player.");
		lblNewLabel_1.setBounds(60, 85, 513, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("b.Decide the Name and the Role for a player>>press “OK”>>”start”.");
		lblNewLabel_2.setBounds(60, 105, 458, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2.When a game is started");
		lblNewLabel_3.setBounds(50, 130, 259, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("a.Each player will be given $$ "+Constants.initial_money+", "+Constants.initial_soldier+" soldiers, and a tower with 100 blood.");
		lblNewLabel_4.setBounds(60, 155, 611, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("3.In each round, a player can");
		lblNewLabel_5.setBounds(50, 180, 299, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("a.Press “Action” and decide to go to");
		lblNewLabel_6.setBounds(60, 200, 291, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("i.Construction department (Repair tower).");
		lblNewLabel_7.setBounds(70, 215, 312, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ii.Munition factory (Buy soldiers).");
		lblNewLabel_8.setBounds(70, 230, 290, 15);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("iii.Bank (Get money).");
		lblNewLabel_9.setBounds(70, 245, 194, 15);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("iv.Explore (Try his/her luck to get more soldiers, money, and win rate).");
		lblNewLabel_10.setBounds(70, 260, 531, 15);
		add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("b.Press “Shop” to buy treasure.");
		lblNewLabel_11.setBounds(60, 280, 309, 15);
		add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("c.Press “Deploy” and set offense/defense soldier>>press “Ready” to start the war.");
		lblNewLabel_12.setBounds(60, 300, 650, 15);
		add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("4.At the end of each round, the computer will count");
		lblNewLabel_13.setBounds(50, 325, 349, 15);
		add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("a.the soldiers and the tower blood a player lost in the war, which depend on win rate,");
		lblNewLabel_14.setBounds(60, 355, 794, 15);
		add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(" the soldiers set to defense/offense, and some random mechanism. >>Press “Clear” to start next round.");
		lblNewLabel_15.setBounds(70, 370, 730, 15);
		add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("a.Surviving after 10 rounds and get more points than the enemy.");
		lblNewLabel_16.setBounds(60, 415, 740, 15);
		add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("b.destroying the enemy’s tower.");
		lblNewLabel_17.setBounds(60, 450, 259, 15);
		add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("c.Buying three kinds of treasure.");
		lblNewLabel_18.setBounds(60, 470, 263, 15);
		add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("5.To win the game by one of the condition below");
		lblNewLabel_19.setBounds(50, 395, 313, 15);
		add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Here is the rules and guides");
		lblNewLabel_20.setBounds(40, 40, 227, 15);
		add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("(The point depends on a player’s money, soldiers, and treasure.)");
		lblNewLabel_21.setBounds(70, 430, 566, 15);
		add(lblNewLabel_21);
		
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont( new Font("TimesRoman", Font.BOLD, 20) ); 
        g.drawString("Welcome to 2015-2016 NTU FOOP Final -- [ War of Three Kingdoms ]", 25, 25);
        //g.drawString("Here is the rules and guides", 25, 80);
    }
}