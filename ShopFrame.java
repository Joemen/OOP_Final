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

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;


public class ShopFrame{
	JFrame shopframe;
	JScrollPane mFrame_scroll;
	JPanel mFrame_panel;

	// about label
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
	public static JRadioButton rdbtnthreasure1; 
	public static JRadioButton rdbtnthreasure2; 
	public static JRadioButton rdbtnthreasure3; 
	public static JRadioButton rdbtnthreasure4; 

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
		// treasure1 
		treasure = Game.shop.getStuff(0);
		treasure_name = treasure.getName();
		treasure_price = treasure.getPrice();
		treasure1_pane = new ImagePanel("pic/treasure1.png", 20, 25);
		treasure1_pane.setBounds(44, 91, 182, 191);
		mFrame_panel.add(treasure1_pane);
		
		rdbtnthreasure1 = new JRadioButton(treasure_name + "  $" +treasure_price);
		rdbtnthreasure1.setBounds(65, 290, 141, 23);
		mFrame_panel.add(rdbtnthreasure1);
		
		// treasure 2
		treasure2_pane = new ImagePanel("pic/treasure1.png", 20, 25);
		treasure2_pane.setBounds(262, 91, 182, 191);
		mFrame_panel.add(treasure2_pane);
		
		rdbtnthreasure2 = new JRadioButton("treasure1  $120");
		rdbtnthreasure2.setBounds(285, 290, 141, 23);
		mFrame_panel.add(rdbtnthreasure2);
		
		// treasure 3
		treasure3_pane = new ImagePanel("pic/treasure1.png", 20, 25);
		treasure3_pane.setBounds(480, 91, 182, 191);
		mFrame_panel.add(treasure3_pane);
		
		rdbtnthreasure3 = new JRadioButton("treasure1  $120");
		rdbtnthreasure3.setBounds(500, 290, 141, 23);
		mFrame_panel.add(rdbtnthreasure3);

		// treasure 4
		treasure4_pane = new ImagePanel("pic/treasure1.png", 20, 25);
		treasure4_pane.setBounds(44, 324, 182, 191);
		mFrame_panel.add(treasure4_pane);
		
		rdbtnthreasure4 = new JRadioButton("treasure1  $120");
		rdbtnthreasure4.setBounds(65, 524, 141, 23);
		mFrame_panel.add(rdbtnthreasure4);
		
		ButtonGroup choice = new ButtonGroup();
		choice.add(rdbtnthreasure1);
		choice.add(rdbtnthreasure2);
		choice.add(rdbtnthreasure3);
		choice.add(rdbtnthreasure4);
		
		shopframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
	}
}