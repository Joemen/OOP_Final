import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class MyApplet extends JScrollPane implements ActionListener {
	public static UI theBalloon;	// use for graph
	
	public MyApplet(){		
		setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(10, 46, 712, 292);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		MainFrame.btnClear.addActionListener(this);
		MainFrame.btnPlayer_1.addActionListener(this);
		theBalloon = new UI();	// new graph class
		
		StateControl.control(StateControl.State.ORIGIN);
	}
	@Override
	public void actionPerformed(ActionEvent event) {		
		//Execute when button is pressed
		StateControl.action(event);
		
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		theBalloon.display(g);

	}

}