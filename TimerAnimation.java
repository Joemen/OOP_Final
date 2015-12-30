import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class TimerAnimation extends MyApplet{
	public BufferedImage img;
	public int xPos = 0;
	public int yPos = 0;
	public int xPix = 0;
	public int yPix = 0;
	public int xStop = 0;
	public int xOther = 0;

	public Timer timer;
	public int direction = 1;
	public int way;
	public TimerAnimation(){}
	public TimerAnimation(File file,int way){
		try {
			this.img = ImageIO.read(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
		if(way == 1){
			timer = new Timer(40, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					xPos = xPos + (direction*20);				
					if (xPos + img.getWidth() > xOther) {
						xPos = xOther - img.getWidth();
						direction *= -1;
						try {
							if(Game.player[0].getRole().getRoleName()=="Sun"){
								img = ImageIO.read(new File("pic/Sun_r.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Cao"){
								img = ImageIO.read(new File("pic/Cao_r.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Liu"){
								img = ImageIO.read(new File("pic/Liu_r.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Chang"){
								img = ImageIO.read(new File("pic/Chang_r.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Zhao"){
								img = ImageIO.read(new File("pic/Zhao_r.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Chou"){
								img = ImageIO.read(new File("pic/Chou_r.png"));
							}							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else if (xPos < xStop) {						
						timer.stop();
						direction *= -1;
						xPos = 10;
						try {
							if(Game.player[0].getRole().getRoleName()=="Sun"){
								img = ImageIO.read(new File("pic/Sun.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Cao"){
								img = ImageIO.read(new File("pic/Cao.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Liu"){
								img = ImageIO.read(new File("pic/Liu.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Chang"){
								img = ImageIO.read(new File("pic/Chang.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Zhao"){
								img = ImageIO.read(new File("pic/Zhao.png"));
							}
							if(Game.player[0].getRole().getRoleName()=="Chou"){
								img = ImageIO.read(new File("pic/Chou.png"));
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					MainFrame.scrollPane.repaint();
				}

			});
		}
		else if(way==-1){
			timer = new Timer(40, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					xPos = xPos - (direction*20);
					if (xPos + img.getWidth() > MainFrame.scrollPane.getWidth()) {
						xPos = MainFrame.scrollPane.getWidth()- img.getWidth();
						timer.stop();
						try {
							if(Game.player[1].getRole().getRoleName()=="Sun"){
								img = ImageIO.read(new File("pic/Sun_r.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Cao"){
								img = ImageIO.read(new File("pic/Cao_r.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Liu"){
								img = ImageIO.read(new File("pic/Liu_r.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Chang"){
								img = ImageIO.read(new File("pic/Chang_r.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Zhao"){
								img = ImageIO.read(new File("pic/Zhao_r.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Chou"){
								img = ImageIO.read(new File("pic/Chou_r.png"));
							}		
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						xPos = 1100;
						direction *= -1;
					} else if (xPos < xOther + img.getWidth()) {
						try {
							if(Game.player[1].getRole().getRoleName()=="Sun"){
								img = ImageIO.read(new File("pic/Sun.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Cao"){
								img = ImageIO.read(new File("pic/Cao.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Liu"){
								img = ImageIO.read(new File("pic/Liu.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Chang"){
								img = ImageIO.read(new File("pic/Chang.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Zhao"){
								img = ImageIO.read(new File("pic/Zhao.png"));
							}
							if(Game.player[1].getRole().getRoleName()=="Chou"){
								img = ImageIO.read(new File("pic/Chou.png"));
							}		
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						direction *= -1;
					}
					MainFrame.scrollPane.repaint();
				}
			});

		}
		timer.setRepeats(true);
		timer.setCoalesce(true);
	}
	public void setPara(int a,int b,int c,int d,int e,int f,int g){
		xPos = a;
		yPos = b;
		xPix = c;
		yPix = d;	
		xStop = f;
		xOther = g;
	}

	@Override
	public void paintComponent(Graphics g) {   		
		g.drawImage(img, xPos, yPos,this);
	}

}
