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
	private static JLabel winner_source;
	private static JLabel statistics;
	private static JTextArea player_1;
	private static JTextArea player_2;
	private static JLabel winner_1;
	public static int win_flag = -1;
	
	
	public EndFrame() {
		endframe = new JFrame();
		endframe.setResizable(false);
		endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endframe.setBounds(new Rectangle(100, 0, 550, 400));
        endframe.setTitle("Game Result");
        endframe.getContentPane().setLayout(null);
        
        winner = new JLabel("Winner is :");
        winner.setFont(new Font("Arial", Font.PLAIN, 30) );
        winner.setForeground(Color.RED);
        winner.setBounds(210, 50, 291, 27);
        winner.setVisible(false);
        endframe.getContentPane().add(winner);
        
        winner_name = new JLabel("");
        winner_name.setFont(new Font("Arial", Font.PLAIN, 25) );
        winner_name.setBounds(190, 100, 291, 27);
        winner_name.setVisible(false);
        endframe.getContentPane().add(winner_name);
        
        winner_source = new JLabel("");
        winner_source.setFont(new Font("Arial", Font.PLAIN, 12) );
        winner_source.setBounds(110, 200, 400, 27);
        winner_source.setVisible(false);
        endframe.getContentPane().add(winner_source);
        
        statistics = new JLabel("<Game Statistics> ");
        statistics.setFont(new Font("Arial", Font.PLAIN, 20) );
        statistics.setBounds(190, 10, 291, 27);
        statistics.setVisible(false);
        endframe.getContentPane().add(statistics);
       
		player_1 = new JTextArea();
		player_1.setBounds(25, 40, 240, 280);
		player_1.setEditable(false);
		player_1.setBackground(SystemColor.window);
		player_1.setForeground(null);
		player_1.setLineWrap(true);
		player_1.setFont(new Font("Arial", Font.PLAIN, 14) );
		endframe.add(player_1);
		
		player_2 = new JTextArea();
		player_2.setBounds(290, 40, 240, 280);
		player_2.setBackground(SystemColor.window);
		player_2.setForeground(null);
		player_2.setLineWrap(true);
		player_2.setEditable(false);
		player_2.setFont(new Font("Arial", Font.PLAIN, 14) );
		endframe.add(player_2);
		
		winner_1 = new JLabel("Winner is :");
		winner_1.setForeground(Color.RED);
        winner_1.setFont(new Font("Arial", Font.PLAIN, 14) );
        winner_1.setBounds(150, 330, 291, 27);
        winner_1.setVisible(false);
        endframe.getContentPane().add(winner_1);
        
		
	}
	
	public static void gameJudge(){
		/////player1 collected three treasures
		if (Game.player[0].pocket[0]+Game.player[0].pocket[1]+Game.player[0].pocket[2]+Game.player[0].pocket[3]>=3) {
			win_flag = 0;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			winner.setVisible(true);
			winner_name.setText("Player "+Game.player[win_flag].getPlayerID()+ "  " + Game.player[win_flag].getPlayerName());
			winner_name.setVisible(true);
			winner_source.setText("You have collected three treatures and seized the win of the war");
			winner_source.setVisible(true);
			StateControl.control(StateControl.State.ENDGAME);
		}////player2 collected three treasures
		else if (Game.player[1].pocket[0]+Game.player[1].pocket[1]+Game.player[1].pocket[2]+Game.player[1].pocket[3]>=3) {
			win_flag = 1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			winner.setVisible(true);
			winner_name.setText("Player "+Game.player[win_flag].getPlayerID()+ "  " + Game.player[win_flag].getPlayerName());
			winner_name.setVisible(true);
			winner_source.setText("You have collected three treatures and seized the win of the war");
			winner_source.setVisible(true);
			StateControl.control(StateControl.State.ENDGAME);
		}/// two towers' HP are zero
		else if (Game.tower[0].getBlood()==0&&Game.tower[1].getBlood()==0) {
			win_flag = -1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			winner_name.setText("Both of you lost the Game!!");
			winner_name.setVisible(true);
			StateControl.control(StateControl.State.ENDGAME);
		}///player1 lost
		else if (Game.tower[0].getBlood()==0){
			win_flag = 1;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			winner.setVisible(true);
			winner_name.setText("Player "+Game.player[win_flag].getPlayerID()+ "  " + Game.player[win_flag].getPlayerName());
			winner_name.setVisible(true);
			winner_source.setText("You have beaten your enemy!! Big success!");
			winner_source.setVisible(true);
			StateControl.control(StateControl.State.ENDGAME);
		}///player2 lost
		else if (Game.tower[1].getBlood()==0){
			win_flag = 0;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			winner.setVisible(true);
			winner_name.setText("Player "+Game.player[win_flag].getPlayerID()+ "  " + Game.player[win_flag].getPlayerName());
			winner_name.setVisible(true);
			winner_source.setText("You have beaten your enemy!! Big success!");
			winner_source.setVisible(true);
			StateControl.control(StateControl.State.ENDGAME);
		}///all rounds are done
		else if (Game.round== Constants.total_round){
			win_flag = 2;
			EndFrame endframe = new EndFrame();
			EndFrame.endframe.setVisible(true);
			statistics.setVisible(true);
			player_1.append("Player "+Game.player[0].getPlayerID()+ "  " + Game.player[0].getPlayerName()+"\n");
			player_1.append("<Camp Name>       "+Game.player[0].getCampName()+"\n");
			player_1.append("<Money>                   "+Game.player[0].getMoney()+"\n");
			player_1.append("<Remaining Soldiers>  "+Game.player[0].getNumSoldier()+"\n");
			player_1.append("<Tower HP>              "+Game.tower[0].getBlood()+"\n");
			player_1.append("<Treasures>    "+Game.player[0].getTreasure() +"\n\n");
			player_1.append(">==Total Point==>        "+CountPoints(Game.player[0],Game.tower[0])+"  Points\n");
			player_1.append("<Money>  x "+ Constants.money_weighted +"          "+Game.player[0].getMoney()+ " *" + Constants.money_weighted +"\n");
			player_1.append("<Rning Soldiers>  x "+ Constants.soldier_weighted +"          "+Game.player[0].getNumSoldier()+ " *" + Constants.soldier_weighted +"\n");
			player_1.append("<Tower HP>  x "+ Constants.tower_hp_weighted +"          "+Game.tower[0].getBlood()+ " *" + Constants.tower_hp_weighted+"\n");
			player_1.append("<Treasures>    ");
			for (int i = 0; i<Constants.total_shop_stuff; i++){
				if (Game.player[0].pocket[i]==1)
				player_1.append(Shop.stuff[i].getName()+"+"+Shop.stuff[i].getPoint()+"  ");
			}
			player_1.append("\n");
			
			player_2.append("Player "+Game.player[1].getPlayerID()+ "  " + Game.player[1].getPlayerName()+"\n");
			player_2.append("<Camp Name>           "+Game.player[1].getCampName()+"\n");
			player_2.append("<Money>               "+Game.player[1].getMoney()+"\n");
			player_2.append("<Remaining Soldiers>  "+Game.player[1].getNumSoldier()+"\n");
			player_2.append("<Tower HP>            "+Game.tower[1].getBlood()+"\n");
			player_2.append("<Treasures>    "+Game.player[1].getTreasure() +"\n\n");
			player_2.append(">==Total Point==>        "+CountPoints(Game.player[1],Game.tower[1])+"  Points\n");
			player_2.append("<Money>  x "+ Constants.money_weighted +"          "+Game.player[0].getMoney()+ " *" + Constants.money_weighted +"\n");
			player_2.append("<Rning Soldiers>  x "+ Constants.soldier_weighted +"          "+Game.player[0].getNumSoldier()+ " *" + Constants.soldier_weighted +"\n");
			player_2.append("<Tower HP>  x "+ Constants.tower_hp_weighted +"          "+Game.tower[0].getBlood()+ " *" + Constants.tower_hp_weighted+"\n");
			player_2.append("<Treasures>    ");
			for (int i = 0; i<Constants.total_shop_stuff; i++){
				if (Game.player[1].pocket[i]==1)
				player_2.append(Shop.stuff[i].getName()+"+"+Shop.stuff[i].getPoint()+"  ");
			}
			player_2.append("\n");
			winner_1.setVisible(true);
			if (CountPoints(Game.player[0],Game.tower[0])>CountPoints(Game.player[1],Game.tower[1]))
				winner_1.setText("Winner is  :   " +"Player "+Game.player[0].getPlayerID()+ "  " + Game.player[0].getPlayerName());
			else if (CountPoints(Game.player[0],Game.tower[0])<CountPoints(Game.player[1],Game.tower[1]))
				winner_1.setText("Winner is  :   " +"Player "+Game.player[1].getPlayerID()+ "  " + Game.player[1].getPlayerName());
			else 
				winner_1.setText("Both of you are Winners!");
			
			StateControl.control(StateControl.State.ENDGAME);
		}
		
		else {
			
		}
	}
	
	public static int CountPoints(Player player, Tower tower){
		int total = 0;
		for(int i =0; i<Constants.total_shop_stuff; i++){
			total = total + player.pocket[i]*Shop.stuff[i].getPoint();
		}
		
		total = total + Math.round(player.getMoney()*Constants.money_weighted + player.getNumSoldier()*Constants.soldier_weighted + tower.getBlood()*Constants.tower_hp_weighted);
		return total;
	}
}