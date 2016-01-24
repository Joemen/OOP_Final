
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.BorderLayout;


public class ConstructAnimation{
	public static JFrame constructFrame;
	
	public BankAnimationPane constructanimatepane;
	
	public static Timer timer;
	
	private int origin_bank_xpos;
	private int origin_bank_ypos;
	private int origin_money_xpos;
	private int origin_money_ypos;
	public int money;
	public int repair;
	public static BufferedImage tower;
	//public static BufferedImage worker;
	
	public static Image worker;  
	public static Image worker1;
	
	public static void main(String[] args){
		new ConstructAnimation(10);
	}
	
	
	public ConstructAnimation(int money) {
		// super();
		constructFrame = new JFrame("");
		constructFrame.setResizable(false);
		constructFrame.setSize(640, 412);
		constructFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// bankframe.setLayout(new BorderLayout());
		if(money == 0 ){
			this.money = (int)Math.round(ConstructionDep.fee[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.repair = (int)Math.round(ConstructionDep.ser_func[0]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate);
		}
		else if(money == 1 ){
			this.money = (int)Math.round(ConstructionDep.fee[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.repair = (int)Math.round(ConstructionDep.ser_func[1]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate);
		}
		else if(money == 2 ){
			this.money = (int)Math.round(ConstructionDep.fee[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_discount);
			this.repair = (int)Math.round(ConstructionDep.ser_func[2]*Game.player[(Game.turn+1)%2].getRole().getProperty().is_tower_repair_rate);
		}
		BankAnimationPane bankanimatepane = new BankAnimationPane(money);
		constructFrame.getContentPane().add(bankanimatepane);
		
		JPanel panel = new JPanel();
		constructFrame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				constructFrame.dispose();
			}
		});
		panel.add(btnNewButton);
		// bankframe.pack();
		
		// bankframe.setLocationRelativeTo(null);
		constructFrame.setVisible(true);
		
	}
	
	public class BankAnimationPane extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public BankAnimationPane(final int printmoney) {
			try {
				tower = ImageIO.read(new File("pic/tower.png"));
				worker = new ImageIcon("pic/worker.gif").getImage();
				worker1 = new ImageIcon("pic/worker1.gif").getImage();
				// timer action
				ActionListener timer_action = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							
				//		System.out.println("Timer Stop");
				//		timer.stop();
				//		new NotifyFrame("You've got $" + printmoney + " from the bank", constructFrame);	
							
						repaint();
							
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
			g.drawImage(worker, 350 , 175, 100 , 100 , this);
			
			
			g.drawImage(worker1, 160 , 175, 100 , 100 , this);
			
			// draw bank
			g.drawImage(tower, 250 , 52 , this);
			
			setMyfont(g,"Impact", Font.ITALIC, 30 , new Color(220, 20, 60));
	        g.drawString("$" +Integer.toString(money)+" for blood " + Integer.toString(repair),210,320);
	        setMyfont(g,"Impact", Font.ITALIC, 30 , new Color(46, 139, 87));
	        g.drawString("Under Construction",200,40);

		}
	}	
	private void setMyfont(Graphics g, String fontType, int fontStyle , int size, Color myColor) {
        Font font = new Font(fontType, fontStyle, size);
        g.setFont(font);
        g.setColor(myColor);
    }	


}