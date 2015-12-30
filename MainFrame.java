
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
	
	public static JMenuBar menuBar;
	
	public static JMenu fileMenu ;
	public static JMenu historyMenu ;	

	public static JTextArea textArea_1;
	public static JTextArea textArea_2;

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
	public static JButton actionbutton;
	public static JButton actionbutton2;
	public static JButton btnFight;
	public static JButton btnFight2;
	public static JButton btnWar;
    public static JButton shopbutton;

	public MainFrame() {
		initialize();
	}

	private void initialize() {

		//	Basic Frame feature
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(new Rectangle(100, 0, 1236, 700));
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
				HistoryFrame historyframe = new HistoryFrame();
				historyframe.printHistory();
				historyframe.historyframe.setVisible(true);

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
		mFrame_scroll.setPreferredSize(new Dimension(1000, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 1231, 624);
		frame.getContentPane().add(mFrame_scroll);
		
		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(1700, 620));
		mFrame_panel.setBounds(0, 0, 1324, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);

		btnClear =  new JButton("Clear");
		btnClear.setBounds(457, 353, 87, 23);		
		MainFrame.mFrame_panel.add(btnClear);
		MainFrame.btnClear.setEnabled(false);
		mFrame_panel.add(btnClear);
		
		btnPlayer_1 = new JButton("start");
		btnPlayer_1.setBounds(372, 353, 87, 23);
		mFrame_panel.add(btnPlayer_1);
		MainFrame.mFrame_panel.add(btnPlayer_1);
		
		// upper pane
		scrollPane = new MyApplet();
		//scrollPane.readFile();
		mFrame_panel.add(scrollPane);	
		
		btnClear.addActionListener(scrollPane);
		btnPlayer_1.addActionListener(scrollPane);
		
		// lower pane
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 383, 550, 208);
		mFrame_panel.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(670, 383, 550, 208);
		mFrame_panel.add(scrollPane_2);

		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(new JScrollPane(textArea_1));
		scrollPane_1.setHorizontalScrollBarPolicy(   
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(   
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		textArea_1.setSelectedTextColor(Color.RED);
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 12) );	
		
		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setEditable(false);
		scrollPane_2.setViewportView(new JScrollPane(textArea_2));
		scrollPane_2.setHorizontalScrollBarPolicy(   
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setVerticalScrollBarPolicy(   
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		textArea_2.setSelectedTextColor(Color.RED);
		textArea_2.setFont(new Font("Arial", Font.PLAIN, 12) );	
		

		btnShake = new JButton("Shake");
		btnShake.setBounds(10, 353, 87, 23);
		btnShake.addActionListener(scrollPane);
		mFrame_panel.add(btnShake);

		btnShake_1 = new JButton("Shake");
		btnShake_1.setBounds(1124, 353, 87, 23);
		btnShake_1.addActionListener(scrollPane);
		mFrame_panel.add(btnShake_1);
		
		// for action use
		actionbutton = new JButton("Action");
		actionbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You have clicked on the action botton");
				ActionFrame actionframe = new ActionFrame();
				actionframe.actionframe.setVisible(true);
			}
		});
		actionbutton.setBounds(99, 353, 87, 23);
		actionbutton.setEnabled(false);
		mFrame_panel.add(actionbutton);
		
		actionbutton2 = new JButton("Action");
		actionbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("You have clicked on the action2 botton");
				ActionFrame actionframe = new ActionFrame();
				actionframe.actionframe.setVisible(true);
			}
		});
		actionbutton2.setEnabled(false);
		actionbutton2.setBounds(937, 353, 87, 23);
		mFrame_panel.add(actionbutton2);
        // for shop use
        shopbutton = new JButton("shop");
        shopbutton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("You have clicked on the shop botton");
            ShopFrame shopframe = new ShopFrame();
            ShopFrame.setMoneyNotEnough(Game.player[(Game.turn+1)%2]);
        	shopframe.shopframe.setVisible(true);
        }
        });
        shopbutton.setBounds(714, 350, 93, 29);
        MainFrame.shopbutton.setEnabled(false);
        mFrame_panel.add(shopbutton);
        
		
		// for fight use ===================HuangYuNien===================================================================jedijedijedimaster
		
		btnFight = new JButton("Deploy");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the Fight botton");
				FightFrame fightframe = new FightFrame();
				fightframe.fightframe.setVisible(true);
			}
		});
		btnFight.setBounds(189, 353, 87, 23);
		btnFight.setEnabled(false);
		mFrame_panel.add(btnFight);
		
		btnFight2 = new JButton("Deploy");
		btnFight2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the Fight2 botton");
				FightFrame fightframe = new FightFrame();
				fightframe.fightframe.setVisible(true);
			}
		});
		btnFight2.setBounds(1025, 353, 87, 23);
		btnFight2.setEnabled(false);
		mFrame_panel.add(btnFight2);
		
		// about war
		btnWar = new JButton("WAR!!");
		btnWar.setForeground(new Color(0, 0, 255));
		btnWar.setBackground(new Color(255, 0, 0));
		btnWar.setBounds(556, 347, 117, 35);
		btnWar.setEnabled(false);
		btnWar.addActionListener(scrollPane);
		mFrame_panel.add(btnWar);

	}
}
