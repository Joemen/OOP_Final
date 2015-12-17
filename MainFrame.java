
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class MainFrame {

	public JFrame frame;		

	public static JMenu fileMenu ;
	public static JMenu historyMenu ;	

	public static JMenuBar menuBar;

	public static JTextArea textArea;

	public static MyApplet scrollPane;

	public static JPanel mFrame_panel;
	public static JScrollPane mFrame_scroll ;


	private JMenuItem exitMenuItem;
	private JMenuItem newGameMenuItem;
	private JMenuItem historyMenuItem ;

	public static JButton btnPlayer_1;
	public static JButton btnClear;
	public static JButton btnShake;
	public static JButton btnShake_1;
	private JButton button;

	public MainFrame() {
		initialize();
	}

	private void initialize() {

		//	Basic Frame feature
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(new Rectangle(100, 0, 1736, 700));
		frame.setTitle("Two Camp Game");

		//	Add menuBar
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);		
		//	Add File Option
		fileMenu = new JMenu("File");		
		menuBar.add(fileMenu);
		//	Add History Option
		historyMenu	= new JMenu("History");		
		menuBar.add(historyMenu);

		historyMenuItem = new JMenuItem("History");
		historyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the close file action");

			}
		});
		historyMenu.add(historyMenuItem);

		//	Add newGameMenuItem in File
		newGameMenuItem= new JMenuItem("OpenGame");
		newGameMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewFrame startframe = new NewFrame();
				startframe.startframe.setVisible(true);
			}
		});
		fileMenu.add(newGameMenuItem);		

		//	Add exitMenuItem in File
		exitMenuItem = new JMenuItem("CloseProject");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the close file action");
				frame.dispose();
			}
		});
		fileMenu.add(exitMenuItem);

		mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mFrame_scroll.setPreferredSize(new Dimension(1500, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 1731, 624);
		frame.getContentPane().add(mFrame_scroll);
		
		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(1700, 620));
		mFrame_panel.setBounds(0, 0, 1824, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);

		btnClear =  new JButton("Clear");
		btnClear.setBounds(290, 353, 87, 23);		
		MainFrame.mFrame_panel.add(btnClear);		
		mFrame_panel.add(btnClear);
		
		btnPlayer_1 = new JButton("start");
		btnPlayer_1.setBounds(199, 353, 87, 23);
		mFrame_panel.add(btnPlayer_1);
		MainFrame.mFrame_panel.add(btnPlayer_1);
		
		// upper pane
		scrollPane = new MyApplet();
		scrollPane.readFile();
		mFrame_panel.add(scrollPane);	
		
		btnClear.addActionListener(scrollPane);
		btnPlayer_1.addActionListener(scrollPane);
		
		// lower pane
		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 383, 1712, 208);
		mFrame_panel.add(scrollPane_1);

		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane_1.setViewportView(new JScrollPane(textArea));
		scrollPane_1.setHorizontalScrollBarPolicy(   
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(   
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		textArea.setSelectedTextColor(Color.RED);
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 12) );	
		

		btnShake = new JButton("Shake");
		btnShake.setBounds(10, 353, 87, 23);
		btnShake.addActionListener(scrollPane);
		mFrame_panel.add(btnShake);

		btnShake_1 = new JButton("Shake");
		btnShake_1.setBounds(1626, 345, 87, 23);
		btnShake_1.addActionListener(scrollPane);
		mFrame_panel.add(btnShake_1);
		
		// for action use
		button = new JButton("Action");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You have clicked on the action botton");
				ActionFrame actionframe = new ActionFrame();
				actionframe.actionframe.setVisible(true);
			}
		});
		button.setBounds(99, 353, 87, 23);
		mFrame_panel.add(button);
		
		


	}
}
