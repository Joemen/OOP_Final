import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;


public class ShopFrame{
	JFrame shopframe;
	JScrollPane mFrame_scroll;
	JPanel mFrame_panel;

	// about label
	public static JLabel lblroundplayer;
	public static JLabel welcomelbl1;
	public static JLabel welcomlbl2;
	public static JLabel noticelbl;

	// about button
	public static JButton btnok;
	public static JButton btnexit;
	
	// about imagepanel
	public static JScrollPane treasure1_pane;
	public static JScrollPane treasure2_pane;
	public static JScrollPane treasure3_pane;
	public static JScrollPane treasure4_pane;
	public static ButtonGroup choice;
	public static JRadioButton rdbtnthreasure1; 
	public static JRadioButton rdbtnthreasure2; 
	public static JRadioButton rdbtnthreasure3; 
	public static JRadioButton rdbtnthreasure4;

	// about stuff
	

	public ShopFrame(){
		shopframe = new JFrame();
		shopframe.setResizable(false);
		shopframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopframe.setBounds(new Rectangle(100, 0, 700, 700));
		shopframe.setTitle("Start Your Action");
			
		mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mFrame_scroll.setPreferredSize(new Dimension(500, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 731, 624);
		shopframe.getContentPane().add(mFrame_scroll);
			
		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(700, 620));
		mFrame_panel.setBounds(0, 0, 824, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);
		
		// about label
		Player player_this_round = Game.player[ (Game.turn+1)%2 ];
		String roundplayer = new String("");
		roundplayer += "round : " + Game.round + "    player : " + player_this_round.getPlayerName() 
					+ "    money : " + player_this_round.getMoney();
		lblroundplayer = new JLabel("" + roundplayer);
		lblroundplayer.setForeground(Color.BLUE);
		lblroundplayer.setBounds(44, 6, 441, 16);
		mFrame_panel.add(lblroundplayer);
		
		welcomelbl1 = new JLabel("Welcome to the shop!");
		welcomelbl1.setBounds(44, 27, 148, 16);
		mFrame_panel.add(welcomelbl1);
		
		welcomlbl2 = new JLabel("Here is the place that can buy treasure to get more point for your camp !");
		welcomlbl2.setBounds(44, 49, 472, 16);
		mFrame_panel.add(welcomlbl2);
		
		noticelbl = new JLabel("One can buy at most in a round ! Press OK and make your decision.\n");
		noticelbl.setFont(new Font("Monotype Sorts", Font.PLAIN, 13));
		noticelbl.setForeground(Color.RED);
		noticelbl.setBounds(253, 589, 441, 16);
		mFrame_panel.add(noticelbl);
		
		// about button
		btnok = new JButton("OK");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = getSelectedButtonText(choice);
				System.out.println( temp );
				if(temp != null){
					Player player_this_turn = Game.player[(Game.turn+1)%2];
					int money = player_this_turn.getMoney();
					if( temp.equals("$" +Game.shop.stuff[0].price + "  " + Game.shop.stuff[0].point + " points")){
						player_this_turn.setMoney( money - Game.shop.stuff[0].getPrice());
						Game.shop.stuff_sold_out[0] = true;
						TotalPrint.print_msg_to_textArea("Buy " + Game.shop.stuff[0].getName() + " Success!\n", (Game.turn+1)%2);
						TotalPrint.print_msg_to_textArea( player_this_turn.getPlayerName() + " now have $" 
												+ player_this_turn.getMoney() + "\n", (Game.turn+1)%2);
						player_this_turn.buyTreasure(0);
					}else if(temp.equals("$" +Game.shop.stuff[1].price + "  " + Game.shop.stuff[1].point + " points")){
						player_this_turn.setMoney( money - Game.shop.stuff[1].getPrice());
						Game.shop.stuff_sold_out[1] = true;
						TotalPrint.print_msg_to_textArea("Buy " + Game.shop.stuff[1].getName() + " Success!\n", (Game.turn+1)%2);
						TotalPrint.print_msg_to_textArea( player_this_turn.getPlayerName() + " now have $" 
												+ player_this_turn.getMoney() + "\n", (Game.turn+1)%2);
						player_this_turn.buyTreasure(1);
					}else if(temp.equals("$" +Game.shop.stuff[2].price + "  " + Game.shop.stuff[2].point + " points")){
						player_this_turn.setMoney( money - Game.shop.stuff[2].getPrice());
						Game.shop.stuff_sold_out[2] = true;
						TotalPrint.print_msg_to_textArea("Buy " + Game.shop.stuff[2].getName() + " Success!\n", (Game.turn+1)%2);
						TotalPrint.print_msg_to_textArea( player_this_turn.getPlayerName() + " now have $" 
												+ player_this_turn.getMoney() + "\n", (Game.turn+1)%2);
						player_this_turn.buyTreasure(2);
					}else if(temp.equals("$" +Game.shop.stuff[3].price + "  " + Game.shop.stuff[3].point + " points")){
						player_this_turn.setMoney( money - Game.shop.stuff[3].getPrice());
						Game.shop.stuff_sold_out[3] = true;
						TotalPrint.print_msg_to_textArea("Buy " + Game.shop.stuff[3].getName() + " Success!\n", (Game.turn+1)%2);
						TotalPrint.print_msg_to_textArea( player_this_turn.getPlayerName() + " now have $" 
												+ player_this_turn.getMoney() + "\n", (Game.turn+1)%2);
						player_this_turn.buyTreasure(3);
					}else{
						System.out.println("get treasure name error");
						System.exit(1);
					}
				}
				shopframe.dispose();
			}
		});
		btnok.setBounds(345, 617, 117, 29);
		mFrame_panel.add(btnok);
		
		btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopframe.dispose();
			}
		});
		btnexit.setBounds(538, 617, 117, 29);
		mFrame_panel.add(btnexit);
		
		Stuff treasure;
		String treasure_name;
		int treasure_price;
		int treasure_point;
		String rdbtuname = new String("");
		// treasure1 
		treasure = Game.shop.getStuff(0);
		treasure_name = treasure.getName()  + "              ";
		treasure_price = treasure.getPrice();
		treasure_point = treasure.getPoint();
		rdbtuname = "$" +treasure_price + "  " + treasure_point + " points";
		treasure1_pane = new ImagePanel("pic/treasure1.png", 20, 45, treasure_name);
		treasure1_pane.setBounds(44, 91, 182, 191);
		mFrame_panel.add(treasure1_pane);
		
		rdbtnthreasure1 = new JRadioButton(rdbtuname);
		rdbtnthreasure1.setBounds(65, 290, 156, 23);
		mFrame_panel.add(rdbtnthreasure1);
		
		// treasure 2
		treasure = Game.shop.getStuff(1);
		treasure_name = treasure.getName()  + "        " ;
		treasure_price = treasure.getPrice();
		treasure_point = treasure.getPoint();
		rdbtuname = "$" +treasure_price + "  " + treasure_point + " points";
		treasure2_pane = new ImagePanel("pic/shan_kuo_ting.png", 12, 68, treasure_name);
		treasure2_pane.setBounds(262, 91, 182, 191);
		mFrame_panel.add(treasure2_pane);
		
		rdbtnthreasure2 = new JRadioButton(rdbtuname);
		rdbtnthreasure2.setBounds(289, 290, 141, 23);
		mFrame_panel.add(rdbtnthreasure2);
		
		// treasure 3
		treasure = Game.shop.getStuff(2);
		treasure_name = treasure.getName()  + "            " ;
		treasure_price = treasure.getPrice();
		treasure_point = treasure.getPoint();
		rdbtuname = "$" +treasure_price + "  " + treasure_point + " points";
		treasure3_pane = new ImagePanel("pic/Spring_Fall.png", 20, 70, treasure_name);
		treasure3_pane.setBounds(480, 91, 182, 191);
		mFrame_panel.add(treasure3_pane);
		
		rdbtnthreasure3 = new JRadioButton(rdbtuname);
		rdbtnthreasure3.setBounds(500, 290, 141, 23);
		mFrame_panel.add(rdbtnthreasure3);

		// treasure 4
		treasure = Game.shop.getStuff(3);
		treasure_name = treasure.getName()  + "                  " ;
		treasure_price = treasure.getPrice();
		treasure_point = treasure.getPoint();
		rdbtuname = "$" +treasure_price + "  " + treasure_point + " points";
		treasure4_pane = new ImagePanel("pic/bow.png", 15, 65, treasure_name);
		treasure4_pane.setBounds(44, 324, 182, 191);
		mFrame_panel.add(treasure4_pane);
		
		rdbtnthreasure4 = new JRadioButton(rdbtuname);
		rdbtnthreasure4.setBounds(65, 524, 141, 23);
		mFrame_panel.add(rdbtnthreasure4);
		

		choice = new ButtonGroup();
		choice.add(rdbtnthreasure1);
		choice.add(rdbtnthreasure2);
		choice.add(rdbtnthreasure3);
		choice.add(rdbtnthreasure4);
		
		
		shopframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        String choice = null;
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                choice = button.getText();
            }
        }

        return choice;
    }
	
	public static void setMoneyNotEnough(Player player){
		setAllEnable();
		int money = player.getMoney();
		int i;
		
		if(Game.shop.stuff_sold_out[0] )
			rdbtnthreasure1.setEnabled(false);
		if(Game.shop.stuff_sold_out[1])
			rdbtnthreasure2.setEnabled(false);
		if(Game.shop.stuff_sold_out[2])
			rdbtnthreasure3.setEnabled(false);
		if(Game.shop.stuff_sold_out[3])
			rdbtnthreasure4.setEnabled(false);
	
		for(i =0; i<Game.shop.stuff_acc; i++){
			if(money < Game.shop.stuff[i].price){
				if(i == 0){
					rdbtnthreasure1.setEnabled(false);
				}else if(i == 1){
					rdbtnthreasure2.setEnabled(false);
				}else if( i == 2){
					rdbtnthreasure3.setEnabled(false);
				}else if(i == 3 ){
					rdbtnthreasure4.setEnabled(false);
				}else{
					///// nothing
				}
			}
		}
	}
	
	public static void setAllEnable(){
		rdbtnthreasure1.setEnabled(true);
		rdbtnthreasure2.setEnabled(true);
		rdbtnthreasure3.setEnabled(true);
		rdbtnthreasure4.setEnabled(true);
	}
}