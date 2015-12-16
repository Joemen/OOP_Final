import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;


public class MyApplet extends JScrollPane implements ActionListener {
	public static TimerAnimation tower_1 = null ,tower_2 = null ;
	public static Image background = null , money_1 = null, money_2 = null, soldier_1 = null, soldier_2 = null;

	public MyApplet(){		
		setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(10, 46, 712, 292);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		MainFrame.btnClear.addActionListener(this);
		MainFrame.btnPlayer_1.addActionListener(this);
		StateControl.control(StateControl.State.ORIGIN);
	}
	public void readFile(){
		try {
			background = ImageIO.read(new File("pic/background.png"));
			money_1 = ImageIO.read(new File("pic/money_burned.png"));
			money_2 = ImageIO.read(new File("pic/money_burned.png"));
			soldier_1 = ImageIO.read(new File("pic/soldier.png"));
			soldier_2 = ImageIO.read(new File("pic/soldier.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	Time Animation
		tower_1 = new TimerAnimation(new File("pic/tower.png"),1);
		tower_1.setPara(10, 50,100, 135,1,10,600);

		tower_2 = new TimerAnimation(new File("pic/tower.png"),-1);
		tower_2.setPara(600, 50, 100, 135,-1,0,10);
	}
	@Override
	public void actionPerformed(ActionEvent event) {		
		//Execute when button is pressed
		StateControl.action(event);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		display(g);
	}


	public void display(Graphics g) {	
		// Draw the previously loaded image to Component.
		if(StateControl.drawHello == -1 || StateControl.drawHello == 0)
			return ;			
		g.drawImage(background, 0, 0,712, 292, null);
		if(StateControl.drawHello == 1){
			g.drawImage(tower_1.img, 10, 50, null);
			g.drawImage(tower_2.img, 600, 50, null);
		}
		else if(StateControl.drawHello == 2){			
			//	player1				
			tower_1.paintComponent(g);
			// draw tower sign
			g.drawImage(tower_2.img, 600, 50, null);

		}
		else if(StateControl.drawHello == 3){
			tower_2.paintComponent(g);
			// draw tower sign
			g.drawImage(tower_1.img, 10, 50, null);
		}

		// draw string money amount			
		setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(205, 173, 0));
		g.drawString(Integer.toString(Game.player[0].getMoney()),30,48);

		// draw string Soldier amount		
		setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(46, 139, 87));
		g.drawString(Integer.toString(Game.player[0].getNumSoldier()),30,78);

		// draw money sign
		g.drawImage(money_1, 10, 30,15, 21, null);			

		// draw soldier sign
		g.drawImage(soldier_1,10,60,15, 21, null);

		// draw player name
		setMyfont(g,"TimesRoman", Font.ITALIC, 15,Color.BLACK);
		g.drawString(Game.player[0].getPlayerName(),20,20);

		//	player2
		setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(205, 173, 0));
		g.drawString(Integer.toString(Game.player[1].getMoney()),680,48);

		// draw string Soldier amount		
		setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(46, 139, 87));
		g.drawString(Integer.toString(Game.player[1].getNumSoldier()),680,78);

		// draw money sign
		g.drawImage(money_2, 660, 30, 15, 21, null);			

		// draw soldier sign
		g.drawImage(soldier_2, 660, 60, 15, 21, null);

		// draw player name
		setMyfont(g,"TimesRoman", Font.ITALIC, 15,Color.BLACK);
		g.drawString(Game.player[1].getPlayerName(),670,20);
	}

	private void setMyfont(Graphics g, String fontType, int fontStyle , int size, Color myColor) {
		Font font = new Font(fontType, fontStyle, size);
		g.setFont(font);
		g.setColor(myColor);
	}
}