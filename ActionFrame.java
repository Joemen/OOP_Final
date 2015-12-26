import java.awt.Dimension;
import java.awt.Rectangle;
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

public class ActionFrame{
	// public JComboBox<String> choice;
	// for choice usage
	public static int action_flag;
	// 0 : not yet decide
	// 1 : Construction 
	// 2 : Munition
	// 3 : Bank
	// 4 : Explore
	// 5 : Do Nothing

	public static JFrame actionframe;
	public static JScrollPane mFrame_scroll;
	public static JPanel mFrame_panel;
	public static JComboBox<String> actionchoice;
	public static String currentChoice ;
	
	public static JLabel lblAction;
	// about button
	public static JButton btnOk_1;
	public static JButton btnCancel;
	public static JLabel lblNotice;
	public static JLabel lblalarm;
	
	// in Construction
	public static JLabel lblConstruction1;
	public static JLabel lblConstruction2;
	public static JLabel lblConstruction3;
	public static JComboBox<String> ConstructionCombo;
	
	// in munition
	public static JLabel lblMuntion1 ;
	public static JLabel lblMuntion2 ;
	public static JLabel lblMuntion3 ; 
	public static JComboBox<String> MuntionCombo;
	
	// in bank
	public static JLabel lblBank1;
	public static JLabel lblBank2;
	public static JLabel lblBank3;
	public static JLabel lblBankNum;
	
	// in Explore
	public static JLabel lblExplore1;
	public static JLabel lblExplore2;
	public static JLabel lblExplore3;
	public static JLabel lblExplore4;
	public static JLabel lblExplore5;
	public static JLabel lblExplore6;
	public static JComboBox<String> ExploreCombo;

	// in Abandon
	public static JLabel lblAbandon1;
	
	public ActionFrame(){
		action_flag = 0;

		actionframe = new JFrame();
		actionframe.setResizable(false);
		actionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		actionframe.setBounds(new Rectangle(100, 0, 550, 400));
		actionframe.setTitle("Start Your Action");
			
		mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mFrame_scroll.setPreferredSize(new Dimension(500, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 731, 624);
		actionframe.getContentPane().add(mFrame_scroll);
			
		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(700, 620));
		mFrame_panel.setBounds(0, 0, 824, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);
		
		Player player_this_round = Game.player[(Game.turn+1)%2];
		String roundplayer = new String("");
		String moneyarmyblood = new String("");
		roundplayer += "round : " + Game.round + "    player : " + player_this_round.getPlayerName() ;
		moneyarmyblood = "  Money : " + player_this_round.getMoney() 
						+ "     Army : "  + player_this_round.getNumSoldier() 
						+"     Tower : "+Game.tower[player_this_round.getCampNum()-1].getBlood();
		JLabel label_roundplayer = new JLabel(roundplayer);
		JLabel label_moneyarmyblood = new JLabel(moneyarmyblood);
		label_roundplayer.setForeground(Color.BLUE);
		label_roundplayer.setBounds(21, 6, 262, 16);
		mFrame_panel.add(label_roundplayer);
		label_moneyarmyblood.setForeground(Color.BLUE);
		label_moneyarmyblood.setBounds(230, 6, 300, 16);
		mFrame_panel.add(label_moneyarmyblood);

		JLabel lblAction = new JLabel("please select the action you want to do : ");
		lblAction.setBounds(60, 27, 262, 16);
		mFrame_panel.add(lblAction);
		
		// about combobox -- selection of action
		actionchoice = new JComboBox<String>();
		actionchoice.setBounds(321, 23, 221, 27);
		mFrame_panel.add(actionchoice);
		
		
		actionchoice.addItem("Construction Department"); 		
		actionchoice.addItem("Go To Munitions Factory");
		actionchoice.addItem("Go To Bank"); 
		actionchoice.addItem("Go To Explore"); 
		actionchoice.addItem("Abandon this round"); 
		actionchoice.setSelectedItem(null);		
		
		constructAllElement();
		
		actionchoice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<?> combo = (JComboBox<?>)e.getSource();
                currentChoice = (String)combo.getSelectedItem();
                
                System.out.println("Action choice = " + currentChoice);
                
                if(currentChoice.equals("Construction Department")){
                	setAllUnVisable();
                	action_flag = 1;
                	lblConstruction1.setVisible(true);
                	lblConstruction2.setVisible(true);
                	lblConstruction3.setVisible(true);
                	ConstructionCombo.setVisible(true);
                }
                
                if(currentChoice.equals("Go To Munitions Factory")){
                	setAllUnVisable();
                	action_flag = 2;
                	lblMuntion1.setVisible(true);
                	lblMuntion2.setVisible(true);
                	lblMuntion3.setVisible(true);
                	MuntionCombo.setVisible(true);
                }
                if(currentChoice.equals("Go To Bank")){
                	setAllUnVisable();
                	action_flag = 3;
                	lblBank1.setVisible(true);
                	lblBank2.setVisible(true);
                	lblBank3.setVisible(true);
                	lblBankNum.setVisible(true);
                } 
                if(currentChoice.equals("Go To Explore")){
                	setAllUnVisable();
                	action_flag = 4;
                	lblExplore1.setVisible(true);
                	lblExplore2.setVisible(true);
                	lblExplore3.setVisible(true);
                	lblExplore4.setVisible(true);
            		lblExplore5.setVisible(true);
            		lblExplore6.setVisible(true);
            		ExploreCombo.setVisible(true);

                }
                if(currentChoice.equals("Abandon this round")){
                	setAllUnVisable();
                	action_flag = 5;
                	lblAbandon1.setVisible(true);
                }
            }
		});
		
		
		// about button
		btnOk_1 = new JButton("OK");
		btnOk_1.setBounds(75, 311, 117, 29);
		mFrame_panel.add(btnOk_1);
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int len;
				Player player_now = Game.player[(Game.turn+1)%2];
				if( action_flag == 1){ // Construction
					ConstructionDep.RepairTower_UI( Game.player[(Game.turn+1)%2], Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1] );
					
				}else if(action_flag == 2){ // Munition
					MunitionsFactory.BuySoldier_UI(Game.player[(Game.turn+1)%2]);
		
				}else if(action_flag == 3){ // Bank 
					Game.player[(Game.turn+1)%2].setMoney((int)(Game.player[(Game.turn+1)%2].getMoney()+Math.round(Bank.give_money*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_money_rate)));
					MainFrame.textArea.append("The player [ " + player_now.getPlayerName() 
														+ " ] choose [ Go To Bank ]\n");
					MainFrame.textArea.append("and have [ " + player_now.getMoney()
														+ " ] (+ "+Math.round(Bank.give_money*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_money_rate)+") dollar(s) now !\n");
				}else if(action_flag == 4){ // Explore
					Explore.explore_UI(Game.player[(Game.turn+1)%2]);
					
				}else if(action_flag == 5){ // Nothing to do
					MainFrame.textArea.append("The player [ " + player_now.getPlayerName() 
														+ " ] choose [Do Nothing]\n");
				}else{
					/*System.out.println("action_flag number error");
					System.exit(1);*/
					//maybe ask again
					MainFrame.textArea.append("The player [ " + player_now.getPlayerName() 
					+ " ] choose [Do Nothing]\n");
				}
				len = MainFrame.textArea.getDocument().getLength();
				MainFrame.textArea.setCaretPosition(len);
				
				actionframe.dispose();
				Game.blockmain = false;
				
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(350, 311, 117, 29);
		mFrame_panel.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action_flag = 0;
				actionframe.dispose();
			}
		});
		
		lblNotice = new JLabel("Notice : If you press OK and will not be able to change your decision !");
		lblNotice.setForeground(Color.RED);
		lblNotice.setBounds(48, 284, 461, 16);
		mFrame_panel.add(lblNotice);
		
		lblalarm = new JLabel("Not enough $$");
		lblalarm.setForeground(Color.RED);
		lblalarm.setBounds(420, 179, 291, 27);
		lblalarm.setVisible(false);
		mFrame_panel.add(lblalarm);
		
		ConstructionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.player[(Game.turn+1)%2].getMoney()-Math.round(ConstructionDep.fee[ConstructionCombo.getSelectedIndex()]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)<0){
					btnOk_1.setEnabled(false);
					lblalarm.setVisible(true);
				}
				else {
					btnOk_1.setEnabled(true);
					lblalarm.setVisible(false);
				}
					
			}});
			
		MuntionCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Game.player[(Game.turn+1)%2].getMoney()-Math.round(MunitionsFactory.price[MuntionCombo.getSelectedIndex()]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)<0){
					btnOk_1.setEnabled(false);
					lblalarm.setVisible(true);
				}
				else {
					btnOk_1.setEnabled(true);
					lblalarm.setVisible(false);
				}
					
			}});
			
		// when press x 
		actionframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void constructAllElement(){
		// in Construction Department
		lblConstruction1 = new JLabel("Welcom to Construction Department !!");
		lblConstruction1.setBounds(60, 82, 300, 16);
		lblConstruction1.setVisible(false);
		mFrame_panel.add(lblConstruction1);
		
		lblConstruction2 = new JLabel("Here is the place to repair your tower");
		lblConstruction2.setBounds(60, 110, 300, 16);
		lblConstruction2.setVisible(false);
		mFrame_panel.add(lblConstruction2);
		
		lblConstruction3 = new JLabel("Please select the action you want:");
		lblConstruction3.setBounds(60, 137, 300, 16);
		lblConstruction3.setVisible(false);
		mFrame_panel.add(lblConstruction3);
		
		ConstructionCombo = new JComboBox<String>();
		ConstructionCombo.setBounds(119, 179, 291, 27);
		ConstructionCombo.setVisible(false);
		mFrame_panel.add(ConstructionCombo);
		// have to be changed for player property
		String construnctionchoice1 = new String("$"+Math.round(ConstructionDep.fee[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for blood "+Math.round(ConstructionDep.ser_func[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate));
		String construnctionchoice2 = new String("$"+Math.round(ConstructionDep.fee[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for blood "+Math.round(ConstructionDep.ser_func[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate));
		String construnctionchoice3 = new String("$"+Math.round(ConstructionDep.fee[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for blood "+Math.round(ConstructionDep.ser_func[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate));
		
		ConstructionCombo.addItem(construnctionchoice1); 
		ConstructionCombo.addItem(construnctionchoice2); 
		ConstructionCombo.addItem(construnctionchoice3); 
		ConstructionCombo.setSelectedItem(null);
		
		// in Munition : 
		lblMuntion1 = new JLabel("Welcom to Munitions Factory !!");
		lblMuntion1.setBounds(60, 82, 300, 16);
		lblMuntion1.setVisible(false);
		mFrame_panel.add(lblMuntion1);
		
		lblMuntion2 = new JLabel("Here is the place to stronger your army");
		lblMuntion2.setBounds(60, 110, 300, 16);
		lblMuntion2.setVisible(false);
		mFrame_panel.add(lblMuntion2);
		
		lblMuntion3 = new JLabel("Please select the action you want:");
		lblMuntion3.setBounds(60, 137, 300, 16);
		lblMuntion3.setVisible(false);
		mFrame_panel.add(lblMuntion3);
		
		MuntionCombo = new JComboBox<String>();
		MuntionCombo.setBounds(119, 179, 291, 27);
		MuntionCombo.setVisible(false);
		mFrame_panel.add(MuntionCombo);
		// have to be changed for player property
		String muntionchoice1 = new String("$"+Math.round(MunitionsFactory.price[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for "+Math.round(MunitionsFactory.add_soldier[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate)+" soldiers");
		String muntionchoice2 = new String("$"+Math.round(MunitionsFactory.price[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for "+Math.round(MunitionsFactory.add_soldier[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate)+" soldiers");
		String muntionchoice3 = new String("$"+Math.round(MunitionsFactory.price[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount)+" for "+Math.round(MunitionsFactory.add_soldier[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate)+" soldiers");
		
		MuntionCombo.addItem(muntionchoice1); 
		MuntionCombo.addItem(muntionchoice2); 
		MuntionCombo.addItem(muntionchoice3); 
		MuntionCombo.setSelectedItem(null);
		
		// in Bank :
		lblBank1 = new JLabel("Welcom to Bank !!");
		lblBank1.setBounds(60, 82, 300, 16);
		lblBank1.setVisible(false);
		mFrame_panel.add(lblBank1);
		
		lblBank2 = new JLabel("Choose this action, and the Bank will give you some money.");
		lblBank2.setBounds(60, 110, 400, 16);
		lblBank2.setVisible(false);
		mFrame_panel.add(lblBank2);
		
		lblBank3 = new JLabel("Please press OK if you decide to take this action.");
		lblBank3.setBounds(60, 137, 400, 16);
		lblBank3.setVisible(false);
		mFrame_panel.add(lblBank3);
		
		lblBankNum = new JLabel("You can get $$ "+Math.round(Bank.give_money*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_money_rate));
		lblBankNum.setBounds(119, 179, 500, 27);
		lblBankNum.setVisible(false);
		mFrame_panel.add(lblBankNum);
		
		// in Explore :
		lblExplore1 = new JLabel("Welcom to Explore !!");
		lblExplore1.setBounds(60, 82, 300, 16);
		lblExplore1.setVisible(false);
		mFrame_panel.add(lblExplore1);
		
		lblExplore2 = new JLabel("You can choose action and get suprise happen!");
		lblExplore2.setBounds(60, 110, 400, 16);
		lblExplore2.setVisible(false);
		mFrame_panel.add(lblExplore2);
		
		lblExplore3 = new JLabel("Please select the action you want:");
		lblExplore3.setBounds(60, 137, 300, 16);
		lblExplore3.setVisible(false);
		mFrame_panel.add(lblExplore3);
		
		lblExplore4 = new JLabel("expeditionary : to explore and may get some soldiers\n !");
		lblExplore4.setBounds(98, 210, 362, 16);
		lblExplore4.setVisible(false);
		mFrame_panel.add(lblExplore4);
		
		lblExplore5 = new JLabel("steal money : to find the treasure and may get some money !");
		lblExplore5.setBounds(98, 230, 401, 16);
		lblExplore5.setVisible(false);		
		mFrame_panel.add(lblExplore5);
		
		lblExplore6 = new JLabel("spy : to have more win rate against your enemy !");
		lblExplore6.setBounds(98, 250, 312, 16);
		lblExplore6.setVisible(false);
		mFrame_panel.add(lblExplore6);
		
		ExploreCombo = new JComboBox<String>();
		ExploreCombo.setBounds(119, 179, 291, 27);
		ExploreCombo.setVisible(false);
		mFrame_panel.add(ExploreCombo);
		// have to be changed for player property
		String explorechoice1 = new String("expeditionary");
		String explorechoice2 = new String("steal money");
		String explorechoice3 = new String("spy");
		
		ExploreCombo.addItem(explorechoice1); 
		ExploreCombo.addItem(explorechoice2); 
		ExploreCombo.addItem(explorechoice3); 
		ExploreCombo.setSelectedItem(null);
		
		
		// in Abandon
		lblAbandon1 = new JLabel("Good Luck To You !!!!");
		lblAbandon1.setBounds(60, 110, 400, 16);
		lblAbandon1.setVisible(false);
		mFrame_panel.add(lblAbandon1);
	}
	
	public static void setAllUnVisable(){
		lblConstruction1.setVisible(false);
		lblConstruction2.setVisible(false);
		lblConstruction3.setVisible(false);
		ConstructionCombo.setVisible(false);
		
		lblMuntion1.setVisible(false);
		lblMuntion2.setVisible(false);
		lblMuntion3.setVisible(false);
		MuntionCombo.setVisible(false);
		
		lblBank1.setVisible(false);
		lblBank2.setVisible(false);
		lblBank3.setVisible(false);
		lblBankNum.setVisible(false);
		
		lblExplore1.setVisible(false);
		lblExplore2.setVisible(false);
		lblExplore3.setVisible(false);
		lblExplore4.setVisible(false);
		lblExplore5.setVisible(false);
		lblExplore6.setVisible(false);
		ExploreCombo.setVisible(false);
		
		lblAbandon1.setVisible(false);
		lblalarm.setVisible(false);
		
	}
}