import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;


public class HistoryFrame{
	public static JFrame historyframe;
	public static JScrollPane mFrame_scroll;
	public static JTextArea historyTextArea;
	
	public HistoryFrame(int lr){
		historyframe = new JFrame();
		historyframe.setResizable(false);
		historyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		historyframe.setBounds(new Rectangle(100, 0, 450, 600));
		if(lr == 0){
			historyframe.setTitle("History(Left)");
		}else{ // right
			historyframe.setTitle("History(Right)");
		}
		
		
		mFrame_scroll = new JScrollPane();
		mFrame_scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mFrame_scroll.setPreferredSize(new Dimension(1000, 2));
		mFrame_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		mFrame_scroll.setBounds(0, 0, 1231, 624);
		historyframe.getContentPane().add(mFrame_scroll);
		
		historyTextArea = new JTextArea();
		historyTextArea.setLineWrap(true);
		historyTextArea.setEditable(false);
		mFrame_scroll.setViewportView(new JScrollPane(historyTextArea));
		mFrame_scroll.setHorizontalScrollBarPolicy(   
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		mFrame_scroll.setVerticalScrollBarPolicy(   
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		historyTextArea.setSelectedTextColor(Color.RED);
		historyTextArea.setFont(new Font("Arial", Font.PLAIN, 12) );
		
		historyframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public void printHistoryLeft(){
		
		try
        {
            FileReader reader = new FileReader( "History_Left.txt" );
            BufferedReader br = new BufferedReader( reader );
            historyTextArea.read( br, null );
            br.close();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
	}
	
	public void printHistoryRight(){
		try
        {
            FileReader reader = new FileReader( "History_Right.txt" );
            BufferedReader br = new BufferedReader( reader );
            historyTextArea.read( br, null );
            br.close();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
}