import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RulePanel extends JPanel{
	public static JPanel rulepanel;
	
	public static JButton btnOK;
	public RulePanel(){
		
		init();
		repaint();
	}

	public void init(){
		
		setSize(800, 600);
		setLayout(null);
		
		btnOK = new JButton("OK\n");
		btnOK.setBounds(616, 544, 115, 20);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OriginalFrame.pressOK();
			}
		});
		add(btnOK);
		
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont( new Font("TimesRoman", Font.BOLD, 20) ); 
        g.drawString("Welcome to 2015-2016 NTU FOOP Final -- [ Game Name ]", 50, 50);
    }
}