import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BankAnimation{
	public static Timer timer;
	
	private int origin_bank_xpos;
	private int origin_bank_ypos;
	private int origin_money_xpos;
	private int origin_money_ypos;
	
	public static BufferedImage bank, money1, money2, money3, money4, money5;
	
	private int y_offset1 = 180;
	private int y_offset2 = 180;
	private int y_offset3 = 180;
	private int y_offset4 = 180;
	private int y_offset5 = 180;
	
	public int counter = 0;
	public boolean draw_money1;
	public boolean draw_money2;
	public boolean draw_money3;
	public boolean draw_money4;
	public boolean draw_money5;
	
	public static void main(String[] args) throws InterruptedException {
		BankAnimation bank_animation = new BankAnimation();
		Thread.sleep(1000);
		bank_animation.draw_money1 = true;
		timer.start();
		Thread.sleep(450);
		bank_animation.draw_money2 = true;
		Thread.sleep(450);
		bank_animation.draw_money3 = true;
		Thread.sleep(450);
		bank_animation.draw_money4 = true;
		Thread.sleep(450);
		bank_animation.draw_money5 = true;
	}

	public BankAnimation() {
		super();
		JFrame bankframe = new JFrame("");
		bankframe.setResizable(false);
		bankframe.setSize(640, 512);
		bankframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// bankframe.setLayout(new BorderLayout());
		bankframe.add(new AnimationPane());
		// bankframe.pack();
		bankframe.setLocationRelativeTo(null);
		bankframe.setVisible(true);
	}

	public class AnimationPane extends JPanel {

		
		private int xPos = 0;
		private int direction = 1;

		public AnimationPane() {
			try {
				bank = ImageIO.read(new File("pic/bank.png"));
				money1 = ImageIO.read(new File("pic/money.png"));
				money2 = ImageIO.read(new File("pic/money.png"));
				money3 = ImageIO.read(new File("pic/money.png"));
				money4 = ImageIO.read(new File("pic/money.png"));
				money5 = ImageIO.read(new File("pic/money.png"));
				
				// for positioning use
				origin_bank_xpos = 0;
				origin_bank_ypos = 0;
				origin_money_xpos = (int)Math.round(bank.getWidth()*0.5) - 50;
				origin_money_ypos = bank.getHeight()-money1.getHeight() - 50;
				
				// timer action
				ActionListener timer_action = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							
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
				// timer.start();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			// int y = getHeight() - boat.getHeight();
			
			// draw bank
			g.drawImage(bank, origin_bank_xpos , origin_bank_ypos , this);

			// draw money
			// g.drawImage(money, origin_money_xpos, origin_money_ypos + y_offset, this);
			if( draw_money1 ){
				g.drawImage(money1, origin_money_xpos, origin_money_ypos - 180 + y_offset1, this);
			}

			if( draw_money2 ){
				g.drawImage(money2, origin_money_xpos+60, origin_money_ypos - 180 + y_offset2, this);
			}

			if( draw_money3 ){
				g.drawImage(money2, origin_money_xpos-60, origin_money_ypos - 180 + y_offset3, this);
			}

			if( draw_money4 ){
				g.drawImage(money2, origin_money_xpos+120, origin_money_ypos - 180 + y_offset4, this);
			}

			if( draw_money5 ){
				g.drawImage(money2, origin_money_xpos-120, origin_money_ypos - 180 + y_offset5, this);
			}

		}

	}

}