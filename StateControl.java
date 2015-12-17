import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
public class StateControl {	

	public static enum State{ORIGIN,START}
	static int drawHello = -1;	// Global Variable for State Control
	public static void control(State state){
		switch(state){
		case ORIGIN:
			MainFrame.btnClear.setVisible(false);
			MainFrame.btnPlayer_1.setVisible(false);
			break;
		case START:
			MainFrame.btnClear.setVisible(true);
			MainFrame.btnPlayer_1.setVisible(true);
			drawHello = 0;
			break;
		default:

			break;		
		}		
	}
	public static void action(ActionEvent event){
		if(event.getSource() == MainFrame.btnPlayer_1 ){
			drawHello = 1;
			System.out.println("You clicked the button player1");
		}
		else if(event.getSource() == MainFrame.btnClear ){
			drawHello = 0;
			System.out.println("You clicked the button clear");			
		}
		else if(event.getSource() == NewFrame.btnOk ){
			if(NewFrame.num == 2 ){
				Game.player[0].setPlayerName(NewFrame.textField_1.getText());
				Game.player[1].setPlayerName(NewFrame.textField_2.getText());				
			}
			if(NewFrame.currentChoice !=null && NewFrame.textField_1.getText().length()!=0 && NewFrame.textField_2.getText().length()!=0 ){
				NewFrame.startframe.dispose();
				StateControl.control(StateControl.State.START);
			}
		}
		else if(event.getSource() == MainFrame.btnShake ){
			drawHello = 2;
			MainFrame.scrollPane.tower_11.timer.start();
			MainFrame.scrollPane.repaint();
			Toaster toasterManager = new Toaster(MainFrame.scrollPane.getLocation().x -150 + MainFrame.scrollPane.getWidth() ,MainFrame.scrollPane.getLocation().y+100,MainFrame.scrollPane.getLocation().y+100 );
			// Show a simple toaster
			toasterManager.showToaster( new ImageIcon( "pic/gif/em17.gif" ), "We are under attack!" );

		}
		else if(event.getSource() == MainFrame.btnShake_1 ){
			drawHello = 3;
			MainFrame.scrollPane.tower_22.timer.start();
			MainFrame.scrollPane.repaint();
			Toaster toasterManager = new Toaster(MainFrame.scrollPane.getLocation().x +210 ,MainFrame.scrollPane.getLocation().y+100,MainFrame.scrollPane.getLocation().y+100 );
			// Show a simple toaster
			toasterManager.showToaster( new ImageIcon( "pic/gif/em17.gif" ), "We are under attack!" );

		}
		else {

		}
	}
}
