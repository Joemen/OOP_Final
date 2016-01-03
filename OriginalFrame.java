import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OriginalFrame{
	public static JFrame frame;
	public static OriginalPane originalpane;
	public static RulePanel rulepanel;
	// Constructor
	/*
	public static void main(String[] args){
		new OriginalFrame();
	}
	*/
	public OriginalFrame(){
		frame = new JFrame("");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// bankframe.setLayout(new BorderLayout());
		
		originalpane = new OriginalPane();
		frame.getContentPane().add(originalpane);
		// bankframe.pack();
		
		// bankframe.setLocationRelativeTo(null);
		// timer.start();
		frame.addWindowListener( 
	      new java.awt.event.WindowAdapter() 
	      {
	        public void windowClosing( java.awt.event.WindowEvent e ) 
	        {
	          frame.dispose() ;
	          Game.blockmain = false;
	        }
	      });
		frame.setVisible(true);
	}
	
	public void animationDone(){
		rulepanel = new RulePanel();
		frame.getContentPane().remove(originalpane);
		frame.repaint();
		frame.getContentPane().add(rulepanel);
		frame.getRootPane().setDefaultButton( rulepanel.btnOK );
	}
	
	public static void pressOK(){
		frame.dispose();
		Game.blockmain = false;
		
	}
	
	///////////////////////// Second class ////////////////////////////
	public class OriginalPane extends JPanel{
		public Timer timer;
		public boolean animation_done = false;
		public boolean word1animation_done = false;
		private static final long serialVersionUID = 1L;
		Random r = new Random();
		public int counter = 0;
		public int colortype = 0;
		private float alpha = 0f;
		public ArrayList<Circle> circles;
		
		public Color color1 = Color.YELLOW;
		public Color color2 = new Color(190, 0, 0);
		public Color color3 = new Color(0, 0, 150);
		public Color wordcolor = Color.YELLOW; 

		class Circle{
			public int radius;
			private int centerx, centery;
			public Color color;
			public Circle(){
				centerx = r.nextInt(800);
				centery = r.nextInt(600);
				radius = r.nextInt(5);
				if(colortype == 2 || counter >= 40){
            		// color = new Color(65, 0, 0);
            		color = color3;
            		
            	}else if( colortype == 1 || (counter >= 20 && counter < 40) ){
            		color = color1;
            	}else{
            		color = color2;
            	}
            	colortype = (colortype+1)%3;
			}
			
			void expand(){
				radius += 3;
			}	
		}

		public OriginalPane(){	
			super();
			init_timer();
			setBackground(color3);
			circles = new ArrayList<Circle>();
			circles.add( new Circle() );
			timer.start();

		}


		////***************** function call ****************///
		 
		 protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            if(!animation_done){
				
				int i;
				for(i=0; i<circles.size(); i++){
					Circle c = circles.get(i) ;
					g.setColor(c.color);
					if(c!=null)
						g.fillOval( c.centerx-c.radius, c.centery-c.radius, 2*c.radius, 2*c.radius );
				}
			}else if( !word1animation_done){ // animation done
				// setBackground(new Color(65, 0, 0));
				setBackground(color3);
				Graphics2D g2d = (Graphics2D) g;
				RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHints(rh);
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
				
				g2d.setFont( new Font("TimesRoman", Font.BOLD, 75) ); 
				g2d.setColor(wordcolor);
				g2d.drawString("FOOP Final", 50, 300);
			}else{
				// setBackground(new Color(65, 0, 0));
				setBackground(color3);
				Graphics2D g2d = (Graphics2D) g;
				RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHints(rh);
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
				
				g2d.setFont( new Font("TimesRoman", Font.BOLD, 50) ); 
				g2d.setColor(wordcolor);
				g2d.drawString("豆腐金鋼隊 之 對戰桌遊", 120, 400);
				
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
				g2d.setFont( new Font("TimesRoman", Font.BOLD, 75) ); 
				g2d.setColor(wordcolor);
				g2d.drawString("FOOP Final", 50, 300);
			}
	    }

		// update circle
		public void updateAnimation(){
			circles.add(new Circle());
			int i;
			for(i=0; i<circles.size(); i++){
				Circle c = circles.get(i);
				if(c != null)
					c.expand();
			}
		}

		// use for fade in fade out
		public void updateAlpha(){
			if( alpha < 0.98f )
				alpha += 0.02f;
		}	

		// initialize timer
		public void init_timer(){
			ActionListener timer_action = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   	counter ++;
                   	if( counter <= 125){
                   		updateAnimation();
                   	}else if( counter <= 175){
                   		updateAlpha();
                   		animation_done = true;
                   	}else if( counter <= 250){
                   		updateAlpha();
                   		if(counter == 176){
                   			word1animation_done = true;
                   			alpha = 0;
                   		}
                   	}else{
                   		timer.stop();
                   		animationDone();
                   	}
                    repaint();

                }
            };
			
			timer = new Timer(30, timer_action);
		}


	}
}