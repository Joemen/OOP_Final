import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NotifyFrame extends JFrame{
		
	private static final long serialVersionUID = 1L;
	
	public String labelword;
	
	// element in this frame
	public JLabel notifylabel;
	public JButton btnOK;
	
	/**
	 * @wbp.parser.constructor
	 */
	public NotifyFrame(String labelword){
		init(labelword);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		System.out.println("running NotifyFrame");
		runframe();
	}

	public NotifyFrame(String labelword, JFrame frame_want_to_close){
		init(labelword);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame_want_to_close.dispose();
			}
		});	
		runframe();
	}

	public void init(String labelword){
		new JFrame();
		this.setSize(300, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(SystemColor.window);

		btnOK = new JButton("OK");
		btnOK.setBackground(SystemColor.desktop);
		btnOK.setBounds(98, 150, 87, 23);
		getContentPane().add( btnOK );

		notifylabel = new JLabel(labelword);
		notifylabel.setFont(new Font("Apple Braille", Font.PLAIN, 18));
		notifylabel.setBounds(18, 79, 264, 23);
		getContentPane().add(notifylabel);
	}

	public void runframe(){
		setVisible(true);
	}
}