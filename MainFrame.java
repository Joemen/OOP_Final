
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame {
	
	public JFrame frame;			//	a frame
	public static JMenu fileMenu ;
	public static JMenu historyMenu ;
	public static JMenuItem openFileMenuItem;
	public static JMenuItem openFileMenuItem2;
	public static JMenuItem openFileMenuItem3;
	public JComboBox choice;
	public static JTextArea textArea;
	public static MyApplet scrollPane;
	public static JPanel mFrame_panel;
	public JButton CarParmBtn;
	private JButton button;
	private JButton button_1;
	

	public MainFrame() {
		initialize();
	}
	
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(new Rectangle(100, 0, 736, 700));
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);		
		frame.setTitle("Two Camp Game");
		
		fileMenu = new JMenu("File");		
		menuBar.add(fileMenu);
		
		historyMenu	= new JMenu("History");		
		menuBar.add(historyMenu);
		
		JMenuItem exitMenuItem = new JMenuItem("CloseProject");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the close file action");
				frame.dispose();
			}
		});
		fileMenu.add(exitMenuItem);
		
		JMenuItem historyMenuItem = new JMenuItem("History");
		historyMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the close file action");
				
			}
		});
		historyMenu.add(historyMenuItem);	
		
		JScrollPane mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mFrame_scroll.setPreferredSize(new Dimension(500, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		mFrame_scroll.setBounds(0, 0, 731, 624);
		frame.getContentPane().add(mFrame_scroll);

		mFrame_panel = new JPanel();
		mFrame_panel.setPreferredSize(new Dimension(700, 620));
		mFrame_panel.setBounds(0, 0, 824, 620);
		mFrame_scroll.setViewportView(mFrame_panel);
		mFrame_panel.setLayout(null);
	
		
		
		scrollPane = new MyApplet();				
		mFrame_panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 383, 712, 208);
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
		
		
	}
}
