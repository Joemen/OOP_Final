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
					xPos = xPos + (direction*10);				
					if (xPos + img.getWidth() > xOther) {
						xPos = xOther - img.getWidth();
						direction *= -1;						
					} else if (xPos < xStop) {						
						timer.stop();
						direction *= -1;
						xPos = 10;
					}
					MainFrame.scrollPane.repaint();
				}

			});
		}
		else if(way==-1){
			timer = new Timer(40, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					xPos = xPos - (direction*10);
					if (xPos + img.getWidth() > MainFrame.scrollPane.getWidth()) {
						xPos = MainFrame.scrollPane.getWidth()- img.getWidth();
						timer.stop();
						xPos = 600;
						direction *= -1;
					} else if (xPos < xOther + img.getWidth()) {
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