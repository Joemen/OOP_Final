import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class NewFrame {

	public static JFrame startframe;
	public JComboBox<String> choice;
	public JComboBox<String> player1_role;
	public JComboBox<String> player2_role;
	public static JPanel mFrame_panel;
	public static JScrollPane mFrame_scroll ;
	public static String currentChoice ;
	public static String player1roleChoice;
	public static String player2roleChoice;
	
	
	public static JButton btnOk;
	public static JButton btncnl ;
	
	public static JLabel label_1;
	public static JLabel label_2;
	public static JLabel label_3;
	public static JLabel label_4;
	public static JLabel Label_1_0;
	public static JLabel Label_1_1;
	public static JLabel Label_1_2;
	public static JLabel Label_1_3;
	public static JLabel Label_1_4;
	public static JLabel Label_1_5;
	public static JLabel Label_2_0;
	public static JLabel Label_2_1;
	public static JLabel Label_2_2;
	public static JLabel Label_2_3;
	public static JLabel Label_2_4;
	public static JLabel Label_2_5;
	
	static JTextField textField_1;
	static JTextField textField_2;
	
	public static  int num  = 0;
	public static  int player1_role_num = -1;
	public static  int player2_role_num = -1;

	
	public NewFrame(){
		startframe = new JFrame();
		startframe.setResizable(false);
		startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startframe.setBounds(new Rectangle(100, 0, 700 , 600));
		
		mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mFrame_scroll.setPreferredSize(new Dimension(500, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 731, 624);
		startframe.getContentPane().add(mFrame_scroll);

		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(550, 400));
		mFrame_panel.setBounds(0, 0, 824, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the number of players");
		lblPleaseSelectThe.setBounds(35, 46, 274, 23);
		mFrame_panel.add(lblPleaseSelectThe);
		
		//=======================================================
		
		choice = new JComboBox<String>();
		choice.setBounds(334, 43, 166, 29);
		mFrame_panel.add(choice);
	
		choice.addItem("2"); 		
		choice.setSelectedItem(null);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(MainFrame.scrollPane);
		/*		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(currentChoice);
				if(num == 2 ){
					Game.player1.setPlayerName(textField_1.getText());
					Game.player2.setPlayerName(textField_2.getText());
					System.out.println("player1 name: " + textField_1.getText());
					System.out.println("player2 name: " + textField_2.getText());
				}
				if(currentChoice !=null && textField_1.getText().length()!=0 && textField_2.getText().length()!=0 ){
					startframe.dispose();
					StateControl.control(StateControl.State.START);
				}
			}
		});
		*/
		btnOk.setBounds(85, 500, 111, 31);
		mFrame_panel.add(btnOk);
		
		btncnl = new JButton("Cancel");
		btncnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentChoice = null;
				player1roleChoice =null;
				player2roleChoice =null;
				startframe.dispose();
			}
		});
		btncnl.setBounds(340, 500, 111, 31);
		mFrame_panel.add(btncnl);
		
		label_1 = new JLabel("Please enter Player1 name: ");
		label_1.setBounds(45, 114, 227, 23);
		label_1.setVisible(false);
		mFrame_panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 111, 136, 29);
		textField_1.setVisible(false);
		mFrame_panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(334, 296, 136, 29);
		textField_2.setVisible(false);
		mFrame_panel.add(textField_2);
		
		label_2 = new JLabel("Please enter Player2 name: ");
		label_2.setBounds(45, 299, 219, 23);
		label_2.setVisible(false);
		mFrame_panel.add(label_2);
		
		label_3 = new JLabel("Please choose Player1's role:");
		label_3.setBounds(45, 199, 227, 15);
		label_3.setVisible(false);
		mFrame_panel.add(label_3);
		
		label_4 = new JLabel("Please choose Player2's role:");
		label_4.setBounds(45, 391, 227, 15);
		label_4.setVisible(false);
		mFrame_panel.add(label_4);
		
		//=============================JEDIJEDI=======master==================================================
		
		player1_role = new JComboBox<String>();
		player1_role.setBounds(334, 196, 52, 29);
		player1_role.setVisible(false);
		mFrame_panel.add(player1_role);
		
		player1_role.addItem("0");
		player1_role.addItem("1"); 	
		player1_role.addItem("2"); 	
		player1_role.addItem("3"); 	
		player1_role.addItem("4"); 	
		player1_role.addItem("5"); 	
		player1_role.setSelectedItem(null);
		
		Label_1_0 = new JLabel("Liu:Good at tower repair");
		Label_1_0.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_0);
		Label_1_0.setVisible(false);
		
		Label_1_1 = new JLabel("Sun:Good at gaining money");
		Label_1_1.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_1);
		Label_1_1.setVisible(false);
		
		Label_1_2 = new JLabel("Cao:Good at building army");
		Label_1_2.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_2);
		Label_1_2.setVisible(false);
		
		Label_1_3 = new JLabel("Zhao:Good at tower repair and building army");
		Label_1_3.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_3);
		Label_1_3.setVisible(false);
		
		Label_1_4 = new JLabel("Chou:Good at gaining money and save money");
		Label_1_4.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_4);
		Label_1_4.setVisible(false);
		
		Label_1_5 = new JLabel("Chang:Good at building army and gaining money");
		Label_1_5.setBounds(392, 210, 300, 15);
		mFrame_panel.add(Label_1_5);
		Label_1_5.setVisible(false);
		
		player2_role = new JComboBox<String>();
		player2_role.setBounds(334, 388, 52, 29);
		mFrame_panel.add(player2_role);
		player2_role.setVisible(false);
		player2_role.addItem("0");
		player2_role.addItem("1"); 	
		player2_role.addItem("2"); 	
		player2_role.addItem("3"); 	
		player2_role.addItem("4"); 	
		player2_role.addItem("5"); 	
		player2_role.setSelectedItem(null);
		
		Label_2_0 = new JLabel("Liu:Good at tower repair");
		Label_2_0.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_0);
		Label_2_0.setVisible(false);
		
		Label_2_1 = new JLabel("Sun:Good at gaining money");
		Label_2_1.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_1);
		Label_2_1.setVisible(false);
		
		Label_2_2 = new JLabel("Cao:Good at building army");
		Label_2_2.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_2);
		Label_2_2.setVisible(false);
		
		Label_2_3 = new JLabel("Zhao:Good at tower repair and building army");
		Label_2_3.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_3);
		Label_2_3.setVisible(false);
		
		Label_2_4 = new JLabel("Chou:Good at gaining money and save money");
		Label_2_4.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_4);
		Label_2_4.setVisible(false);
		
		Label_2_5 = new JLabel("Chang:Good at building army and gaining money");
		Label_2_5.setBounds(392, 402, 300, 15);
		mFrame_panel.add(Label_2_5);
		Label_2_5.setVisible(false);
		
		choice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<?> combo = (JComboBox<?>)e.getSource();
                currentChoice = (String)combo.getSelectedItem();
            
                num = Integer.parseInt(currentChoice);
                if(num == 2 ){
                	label_1.setVisible(true);
                	label_2.setVisible(true);
                	label_3.setVisible(true);
                	label_4.setVisible(true);
                	textField_1.setVisible(true);
                	textField_2.setVisible(true);
                	player1_role.setVisible(true);
                	player2_role.setVisible(true);
                }                
          			
            }
		});
		
		player1_role.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<?> combo = (JComboBox<?>)e.getSource();
				player1roleChoice = (String)combo.getSelectedItem();
            
                player1_role_num = Integer.parseInt(player1roleChoice);
                if(player1_role_num == 0 ){
                	set1UnVisable();
                	Label_1_0.setVisible(true);
                }
                else if(player1_role_num == 1){
                	set1UnVisable();
                	Label_1_1.setVisible(true);
                }
                else if(player1_role_num == 2){
                	set1UnVisable();
                	Label_1_2.setVisible(true);
                }
                else if(player1_role_num == 3){
                	set1UnVisable();
                	Label_1_3.setVisible(true);
                }
                else if(player1_role_num == 4){
                	set1UnVisable();
                	Label_1_4.setVisible(true);
                }
                else if(player1_role_num == 5){
                	set1UnVisable();
                	Label_1_5.setVisible(true);
                }
            }
		});
		
		player2_role.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<?> combo = (JComboBox<?>)e.getSource();
				player2roleChoice = (String)combo.getSelectedItem();
            
                player2_role_num = Integer.parseInt(player2roleChoice);
                if(player2_role_num == 0 ){
                	set2UnVisable();
                	Label_2_0.setVisible(true);
                }
                else if(player2_role_num == 1){
                	set2UnVisable();
                	Label_2_1.setVisible(true);
                }
                else if(player2_role_num == 2){
                	set2UnVisable();
                	Label_2_2.setVisible(true);
                }
                else if(player2_role_num == 3){
                	set2UnVisable();
                	Label_2_3.setVisible(true);
                }
                else if(player2_role_num == 4){
                	set2UnVisable();
                	Label_2_4.setVisible(true);
                }
                else if(player2_role_num == 5){
                	set2UnVisable();
                	Label_2_5.setVisible(true);
                }
            }
		});
	
	}
	
	public static void set1UnVisable(){
		
		Label_1_0.setVisible(false);
		Label_1_1.setVisible(false);
		Label_1_2.setVisible(false);
		Label_1_3.setVisible(false);
		Label_1_4.setVisible(false);
		Label_1_5.setVisible(false);
	}
	public static void set2UnVisable(){
		
		Label_2_0.setVisible(false);
		Label_2_1.setVisible(false);
		Label_2_2.setVisible(false);
		Label_2_3.setVisible(false);
		Label_2_4.setVisible(false);
		Label_2_5.setVisible(false);
		
	}
	
}
