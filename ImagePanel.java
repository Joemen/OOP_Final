import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class ImagePanel extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private Image image = null;
	private int x_pos;
	private int y_pos;

	public ImagePanel(String image_filename, int x, int y)
	{
		setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// read in image
		x_pos = x;
		y_pos = y;
		File image_png = new File(image_filename);
		Image image = null;
		try {
			image = ImageIO.read(image_png);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    this.image = image;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		 if ( image != null){
	        g.drawImage(image,x_pos,y_pos,null);
		}else{
			System.out.println("image null");
		}
	}
	   
}