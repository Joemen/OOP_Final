import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class MyApplet extends JScrollPane implements ActionListener {
	public static UI theBalloon;	// use for graph
	public static JButton btnPlayer_1;
	public static JButton btnClear;
	public MyApplet(){		
		setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(10, 46, 712, 292);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		theBalloon = new UI();		// new graph class
		
		btnClear =  new JButton("Clear");
		btnClear.setBounds(610, 10, 87, 23);		
		MainFrame.mFrame_panel.add(btnClear);
		btnClear.addActionListener(this);
		
		btnPlayer_1 = new JButton("player1");
		btnPlayer_1.setBounds(10, 10, 87, 23);		
		MainFrame.mFrame_panel.add(btnPlayer_1);
		btnPlayer_1.addActionListener(this);
	
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		 //Execute when button is pressed
		if(event.getSource() == btnPlayer_1 ){
			theBalloon.drawHello = 1;
			System.out.println("You clicked the button player1");
		}
		else if(event.getSource() == btnClear ){
			theBalloon.drawHello = 0;
			System.out.println("You clicked the button clear");
		}
		repaint();
	}

	public void paint(Graphics g) {
		theBalloon.display(g);

	}

}