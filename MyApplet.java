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
	public static TimerAnimation Artanis = null ,Agumon = null ;
	public static Image background = null , money_1 = null, money_2 = null, soldier_1 = null, soldier_2 = null,
			tower_1, tower_2;
	public static File background_png , money_png, tower_png , soldier_png;

	public MyApplet(){		
		setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(10, 16, 1212, 325);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		StateControl.control(StateControl.State.ORIGIN);
		background_png = new File("pic/background.png");
		money_png = new File("pic/money_burned.png");
		tower_png = new File("pic/tower.png");
		soldier_png = new File("pic/soldier.png");
	}
	public void readFile(){
		try {
			background = ImageIO.read(background_png);
			money_1 = ImageIO.read(money_png);
			money_2 = ImageIO.read(money_png);
			soldier_1 = ImageIO.read(soldier_png);
			soldier_2 = ImageIO.read(soldier_png);
			tower_1 = ImageIO.read(tower_png);
			tower_2 = ImageIO.read(tower_png);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	Time Animation
		Artanis = new TimerAnimation(new File("pic/Artanis.png"),1);
		Artanis.setPara(10, 160,100, 135,1,10,1000);

		Agumon = new TimerAnimation(new File("pic/Agumon.png"),-1);
		Agumon.setPara(1100, 130, 100, 135,-1,0,110);
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
		g.drawImage(background, 0, 0,1212, 325, null);
		if(StateControl.drawHello == 1){
			g.drawImage(Artanis.img, 10, 160, null);
			g.drawImage(Agumon.img, 1100, 130, null);
		}
		else if(StateControl.drawHello == 2){			
			//	player1				
			Artanis.paintComponent(g);
			// draw tower sign
			g.drawImage(Agumon.img, 1100, 130, null);

		}
		else if(StateControl.drawHello == 3){
			Agumon.paintComponent(g);
			// draw tower sign
			g.drawImage(Artanis.img, 10, 160, null);
		}
		g.drawImage(tower_1, 110, 50, null);
		g.drawImage(tower_2, 1000, 50, null);
		
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
		g.drawString(Integer.toString(Game.player[1].getMoney()),1180,48);

		// draw string Soldier amount		
		setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(46, 139, 87));
		g.drawString(Integer.toString(Game.player[1].getNumSoldier()),1180,78);

		// draw money sign
		g.drawImage(money_2, 1160, 30, 15, 21, null);			

		// draw soldier sign
		g.drawImage(soldier_2, 1160, 60, 15, 21, null);

		// draw player name
		setMyfont(g,"TimesRoman", Font.ITALIC, 15,Color.BLACK);
		g.drawString(Game.player[1].getPlayerName(),1170,20);
	}

	private void setMyfont(Graphics g, String fontType, int fontStyle , int size, Color myColor) {
		Font font = new Font(fontType, fontStyle, size);
		g.setFont(font);
		g.setColor(myColor);
	}
}