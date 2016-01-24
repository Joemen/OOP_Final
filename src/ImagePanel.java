import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class ImagePanel extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private Image image = null;
	private int x_pos;
	private int y_pos;
	public static JTextArea texttitle;

	public ImagePanel(String image_filename, int x, int y, String name)
	{
		// setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getViewport().setOpaque(false);
		setBorder(new BevelBorder(BevelBorder.RAISED));
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
	    
	    // JPanel panel = new JPanel();
	    // panel.setBackground(Color.YELLOW);
	    // setColumnHeaderView(panel);
	    
	    JPanel textpanel = new JPanel();
	    textpanel.setBackground(new Color(25, 25, 112));
	    textpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
	    textpanel.setPreferredSize(new Dimension(450, 50));
	    textpanel.setBounds(0, 0, 450, 50);
	    // setViewportView(textpanel);
	    setColumnHeaderView(textpanel);
	    // this.add(textpanel);
	    
	    
	    texttitle = new JTextArea();
	    texttitle.setBackground(new Color(25, 25, 112));
	    texttitle.setForeground(new Color(250, 250, 0));
	    texttitle.setFont(new Font("Adobe Garamond Pro", Font.BOLD, 17));
	    texttitle.setText(name);
	    textpanel.add(texttitle);
	    
	   
	   
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