import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class EndFrame extends JPanel{
	public static JFrame endframe;
	private static JLabel winner;
	private static JLabel winner_name;
	private static JTextArea player_1;
	private static JTextArea player_2;
	private static JLabel winner_1;
	public static int win_flag;
	
	
	public EndFrame() {
		endframe = new JFrame();
		endframe.setResizable(false);
		endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endframe.setBounds(new Rectangle(100, 0, 550, 400));
        endframe.setTitle("Game Result");
        endframe.getContentPane().setLayout(null);
        
        winner = new JLabel("Winner is :");
        winner.setFont(new Font("Arial", Font.PLAIN, 30) );
        winner.setBounds(210, 50, 291, 27);
        winner.setVisible(false);
        endframe.getContentPane().add(winner);
        
        winner_name = new JLabel("FUCK");
        winner_name.setFont(new Font("Arial", Font.PLAIN, 25) );
        winner_name.setBounds(190, 100, 291, 27);
        winner_name.setVisible(false);
        endframe.getContentPane().add(winner_name);
       
		player_1 = new JTextArea();
		player_1.setBounds(25, 40, 240, 280);
		player_1.setEditable(false);
		player_1.setBackground(SystemColor.window);
		player_1.setForeground(null);
		player_1.setLineWrap(true);
		player_1.setFont(new Font("Arial", Font.PLAIN, 12) );
		endframe.add(player_1);
		
		player_2 = new JTextArea();
		player_2.setBounds(290, 40, 240, 280);
		player_2.setBackground(SystemColor.window);
		player_2.setForeground(null);
		player_2.setLineWrap(true);
		player_2.setEditable(false);
		player_2.setFont(new Font("Arial", Font.PLAIN, 12) );
		endframe.add(player_2);
		
		winner_1 = new JLabel("Winner is :");
        winner_1.setFont(new Font("Arial", Font.PLAIN, 14) );
        winner_1.setBounds(150, 330, 291, 27);
        winner_1.setVisible(false);
        endframe.getContentPane().add(winner_1);
        
        win_flag = 0;
		
	}
	
	public static void gameJudge(){
		if (Game.round==10){
			win_flag = 1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			//
			player_1.append("FUCK");
			
			winner_1.setVisible(true);
			winner_1.setText("Winner is :goood");
			//
			StateControl.control(StateControl.State.ENDGAME);
			
			
		}
		else if (Game.tower[0].getBlood()==0){
			win_flag = 1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			//
			//
			StateControl.control(StateControl.State.ENDGAME);
			
			
		}
		else if (Game.tower[1].getBlood()==0){
			win_flag = 1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			//
			//
			StateControl.control(StateControl.State.ENDGAME);
			
		}
		else {
			
		}
	}
}