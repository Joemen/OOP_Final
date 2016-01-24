
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import javax.swing.JButton;


public class FactoryMunition{
	public static JFrame factoryFrame;
	
	public BankAnimationPane bankanimatepane;
	
	public static Timer timer;
	
	private int origin_bank_xpos;
	private int origin_bank_ypos;
	private int origin_money_ypos;
	private int origin_money_xpos;
	
	public static BufferedImage bank;
	public static BufferedImage money1;
	

	private int y_offset1 = 180;
	private int y_offset2 = 180;
	private int y_offset3 = 180;
	private int y_offset4 = 180;
	private int y_offset5 = 180;
	
	int money;
	int soldier;
	public int counter = 0;
	public boolean draw_money1;
	public boolean draw_money2;
	public boolean draw_money3;
	public boolean draw_money4;
	public boolean draw_money5;
	
	
	public static void main(String[] args){
		new FactoryMunition(10);
	}
	
	
	public FactoryMunition(int money) {
		// super();
		factoryFrame = new JFrame("");
		factoryFrame.setResizable(false);
		factoryFrame.setSize(640, 312);
		factoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// bankframe.setLayout(new BorderLayout());
		
		BankAnimationPane bankanimatepane = new BankAnimationPane(money);
		factoryFrame.getContentPane().add(bankanimatepane);
		
		JPanel panel = new JPanel();
		factoryFrame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				factoryFrame.dispose();
			}
		});
		panel.add(btnNewButton);
		// bankframe.pack();
		
		// bankframe.setLocationRelativeTo(null);
		timer.start();
		factoryFrame.setVisible(true);
		if(money == 0 ){
			this.money = (int)Math.round(MunitionsFactory.price[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.soldier = (int)Math.round(MunitionsFactory.add_soldier[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate);
		}
		else if(money == 1 ){
			this.money = (int)Math.round(MunitionsFactory.price[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.soldier = (int)Math.round(MunitionsFactory.add_soldier[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate);
		}
		else if(money == 2 ){
			this.money = (int)Math.round(MunitionsFactory.price[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.soldier = (int)Math.round(MunitionsFactory.add_soldier[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_soldier_generate);
		}
	}
	
	public class BankAnimationPane extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public BankAnimationPane(final int printmoney) {
			try {
				bank = ImageIO.read(new File("pic/tower.png"));
				money1 = ImageIO.read(new File("pic/hero.png"));
				
				
				// for positioning use
				origin_bank_xpos = 500;
				origin_bank_ypos = 0;
				origin_money_ypos = (int)Math.round(bank.getHeight()*0.5) - 35;
				origin_money_xpos = bank.getWidth() - money1.getWidth() +320;
				
				// timer action
				ActionListener timer_action = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							if(counter == 0){
								System.out.println("timer start");
								draw_money1 = true;
							}else if( counter == 10){
								draw_money2 = true;
							}else if( counter == 20){
								draw_money3 = true;
							}else if( counter == 30){
								draw_money4 = true;
							}else if( counter == 40){
								draw_money5 = true;
							}
							
							if(counter <= 10){
								y_offset1 = (int)Math.round((1.8)*(counter-10)*(counter-10)) ;
								y_offset2 = 180;
								y_offset3 = 180;
								y_offset4 = 180;
								y_offset5 = 180;
							}else if( counter <= 20){
								y_offset1 = (int)Math.round((1.8)*(counter-10)*(counter-10)) ;
								y_offset2 = (int)Math.round((1.8)*(counter-20)*(counter-20)) ;
								y_offset3 = 180;
								y_offset4 = 180;
								y_offset5 = 180;
							}else if(counter <= 30){
								y_offset1 = 180 ;
								y_offset2 = (int)Math.round((1.8)*(counter-20)*(counter-20)) ;
								y_offset3 = (int)Math.round((1.8)*(counter-30)*(counter-30)) ;
								y_offset4 = 180;
								y_offset5 = 180;
							}else if(counter <= 40){
								y_offset1 = 180 ;
								y_offset2 = 180 ;
								y_offset3 = (int)Math.round((1.8)*(counter-30)*(counter-30)) ;
								y_offset4 = (int)Math.round((1.8)*(counter-40)*(counter-40)) ;	
								y_offset5 = 180;
							}else if( counter <= 50){
								y_offset1 = 180 ;
								y_offset2 = 180 ;
								y_offset3 = 180 ;
								y_offset4 = (int)Math.round((1.8)*(counter-40)*(counter-40)) ;	
								y_offset5 = (int)Math.round((1.8)*(counter-50)*(counter-50)) ;	
							}else if( counter <= 60){
								y_offset1 = 180 ;
								y_offset2 = 180 ;
								y_offset3 = 180 ;
								y_offset4 = 180 ;
								y_offset5 = (int)Math.round((1.8)*(counter-50)*(counter-50)) ;
							}else if( counter <= 65){
								y_offset1 = 180 ;
								y_offset2 = 180 ;
								y_offset3 = 180 ;
								y_offset4 = 180 ;
								y_offset5 = 180 ;
							}else{
								System.out.println("Timer Stop");
								timer.stop();
									
							}
							repaint();
							counter ++;
							}
				};
				
				timer = new Timer(40, timer_action);
				timer.setRepeats(true);
				timer.setCoalesce(true);
			} catch (IOException ex) {
				System.out.println("error in BankAnimationPane");
			}
		}
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			// System.out.println("printing");
			
			
			// draw bank
			

			// draw money
			// g.drawImage(money, origin_money_xpos, origin_money_ypos + y_offset, this);
			if( draw_money1 ){
				g.drawImage(money1, origin_money_xpos+ y_offset1/2 ,origin_money_ypos  , this);
				
			}
			if( draw_money2 ){
				g.drawImage(money1, origin_money_xpos+ y_offset2/8 ,origin_money_ypos, this);
			}

			if( draw_money3 ){
				g.drawImage(money1,origin_money_xpos+ y_offset3 -20 ,origin_money_ypos, this);
			}

			if( draw_money4 ){
				g.drawImage(money1, origin_money_xpos+ y_offset4 -40 ,origin_money_ypos, this);
			}

			if( draw_money5 ){
				g.drawImage(money1, origin_money_xpos+ y_offset5 -60 ,origin_money_ypos, this);
			}
			g.drawImage(bank, origin_bank_xpos , origin_bank_ypos , this);
			setMyfont(g,"Impact", Font.ITALIC, 30 , new Color(220, 20, 60));
	        g.drawString("$" +Integer.toString(money)+" for " + Integer.toString(soldier)+" soldiers",30,150);
	        

		}
	}	
	
	private void setMyfont(Graphics g, String fontType, int fontStyle , int size, Color myColor) {
        Font font = new Font(fontType, fontStyle, size);
        g.setFont(font);
        g.setColor(myColor);
    }	

}