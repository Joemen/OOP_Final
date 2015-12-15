import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UI {

	private int diameter;
	private int x, y;
	int drawHello = 0;


	public UI() {
		diameter = 10;
		x = 20;
		y = 50;
	}
	public void display(Graphics g) {
		Image background = null,tower_1 = null, money_1 = null , soldier_1 = null;

		try {
			background = ImageIO.read(new File("pic/background.png"));
			tower_1 = ImageIO.read(new File("pic/tower.png"));
			money_1 = ImageIO.read(new File("pic/money_burned.png"));
			soldier_1 = ImageIO.read(new File("pic/soldier.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Font font = new Font("Impact", Font.PLAIN, 12);
		g.setColor(Color.BLUE);
		g.setFont(font);
		// Draw the previously loaded image to Component.
		g.drawImage(background, 0, 0,712, 292, null);



		if(drawHello == 1){
			// draw string money amount			
			setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(205, 173, 0));
			g.drawString(Integer.toString(Game.player1.getMoney()),20,48);

			// draw string Soldier amount		
			setMyfont(g,"Impact", Font.ITALIC, 15 , new Color(46, 139, 87));
			g.drawString(Integer.toString(Game.player1.getNumSoldier()),20,78);


			// draw money sign
			g.drawImage(money_1, 0, 30,15, 21, null);

			

			// draw soldier sign
			g.drawImage(soldier_1,0,60,15, 21, null);

			// draw player name
			setMyfont(g,"TimesRoman", Font.ITALIC, 15,Color.BLACK);
			g.drawString(Game.player1.getPlayerName(),10,20);

			// draw tower sign
			g.drawImage(tower_1, 0, 130,100, 135, null);


		}

	}

	private void setMyfont(Graphics g, String fontType, int fontStyle , int size, Color myColor) {
		Font font ;

		font = new Font(fontType, fontStyle, size);
		g.setFont(font);
		g.setColor(myColor);


	}
	public void moveLeft() {
		x -= 10;
	}

	public void moveRight() {
		x += 10;
	}
	public void grow() {
		diameter += 5;
	}

	public void shrink() {
		diameter -= 5;
	}
}