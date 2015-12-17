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
import java.awt.Color;

public class ActionFrame{
	// public JComboBox<String> choice;
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
	
	// in Construction
	public static JLabel lblConstruction1;
	public static JLabel lblConstruction2;
	public static JLabel lblConstruction3;
	
	// in munction
	public static JLabel lblMuntion1 ;
	public static JLabel lblMuntion2 ;
	public static JLabel lblMuntion3 ; 
	
	// in bank
	public static JLabel lblBank1;
	public static JLabel lblBank2;
	public static JLabel lblBank3;
	
	// in Explore
	public static JLabel lblExplore1;
	public static JLabel lblExplore2;
	public static JLabel lblExplore3;

	// in Abandon
	public static JLabel lblAbandon1;
	
	public ActionFrame(){
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
		
		JLabel lblAction = new JLabel("please select the action you want to do : ");
		lblAction.setBounds(60, 27, 262, 16);
		mFrame_panel.add(lblAction);
		
		// abount combox -- selection of action
		actionchoice = new JComboBox<String>();
		actionchoice.setBounds(321, 23, 202, 27);
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
                	lblConstruction1.setVisible(true);
                	lblConstruction2.setVisible(true);
                	lblConstruction3.setVisible(true);
                }
                if(currentChoice.equals("Go To Munitions Factory")){
                	setAllUnVisable();
                	lblMuntion1.setVisible(true);
                	lblMuntion2.setVisible(true);
                	lblMuntion3.setVisible(true);
                }
                if(currentChoice.equals("Go To Bank")){
                	setAllUnVisable();
                	lblBank1.setVisible(true);
                	lblBank2.setVisible(true);
                	lblBank3.setVisible(true);
                } 
                if(currentChoice.equals("Go To Explore")){
                	setAllUnVisable();
                	lblExplore1.setVisible(true);
                	lblExplore2.setVisible(true);
                	lblExplore3.setVisible(true);
                }
                if(currentChoice.equals("Abandon this round")){
                	setAllUnVisable();
                	lblAbandon1.setVisible(true);
                }
            }
		});
		
		
		
		
		// about buttom
		btnOk_1 = new JButton("OK");
		btnOk_1.setBounds(75, 311, 117, 29);
		mFrame_panel.add(btnOk_1);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(350, 311, 117, 29);
		mFrame_panel.add(btnCancel);
		
		lblNotice = new JLabel("Notice : If you press OK and will not be able to change your decision !");
		lblNotice.setForeground(Color.RED);
		lblNotice.setBounds(48, 284, 461, 16);
		mFrame_panel.add(lblNotice);
		

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
		
		// in Muntion : 
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
		
		// in Bamk :
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
		
		lblMuntion1.setVisible(false);
		lblMuntion2.setVisible(false);
		lblMuntion3.setVisible(false);
		
		lblBank1.setVisible(false);
		lblBank2.setVisible(false);
		lblBank3.setVisible(false);
		
		lblExplore1.setVisible(false);
		lblExplore2.setVisible(false);
		lblExplore3.setVisible(false);
		
		lblAbandon1.setVisible(false);
		
	}
}