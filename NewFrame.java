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
	public static JPanel mFrame_panel;
	public static JScrollPane mFrame_scroll ;
	public static String currentChoice ;
	
	public static JButton btnOk;
	public static JButton btncnl ;
	
	public static JLabel label_1;
	public static JLabel label_2;
	public static JLabel label_3;
	
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	
	public static  int num  = 0;
	
	public NewFrame(){
		startframe = new JFrame();
		startframe.setResizable(false);
		startframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startframe.setBounds(new Rectangle(100, 0, 550, 400));
		
		
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
		btnOk.setBounds(84, 309, 111, 31);
		mFrame_panel.add(btnOk);
		
		btncnl = new JButton("Cancel");
		btncnl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentChoice = null;
				startframe.dispose();
			}
		});
		btncnl.setBounds(337, 309, 111, 31);
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
		textField_2.setBounds(334, 174, 136, 29);
		textField_2.setVisible(false);
		mFrame_panel.add(textField_2);
		
		label_2 = new JLabel("Please enter Player2 name: ");
		label_2.setBounds(45, 177, 219, 23);
		label_2.setVisible(false);
		mFrame_panel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(334, 230, 136, 29);
		textField_3.setVisible(false);
		mFrame_panel.add(textField_3);
		
		label_3 = new JLabel("Please enter Player3 name: ");
		label_3.setBounds(45, 233, 219, 23);
		label_3.setVisible(false);
		mFrame_panel.add(label_3);
		
		choice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JComboBox<?> combo = (JComboBox<?>)e.getSource();
                currentChoice = (String)combo.getSelectedItem();
            
                num = Integer.parseInt(currentChoice);
                if(num == 2 ){
                	label_1.setVisible(true);
                	label_2.setVisible(true);
                	textField_1.setVisible(true);
                	textField_2.setVisible(true);
                }                
          			
            }
		});
	
	}
}
