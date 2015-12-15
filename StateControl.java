import java.awt.event.ActionEvent;


public class StateControl {	
	
	public static enum State{ORIGIN,START}
	
	public static void control(State state){
		switch(state){
		case ORIGIN:
			MainFrame.btnClear.setVisible(false);
			MainFrame.btnPlayer_1.setVisible(false);
			
			break;
		case START:
			MainFrame.btnClear.setVisible(true);
			MainFrame.btnPlayer_1.setVisible(true);
			UI.drawHello = 0;
			break;
		default:
			
			break;		
		}		
	}
	public static void action(ActionEvent event){
		if(event.getSource() == MainFrame.btnPlayer_1 ){
			MyApplet.theBalloon.drawHello = 1;
			System.out.println("You clicked the button player1");
		}
		else if(event.getSource() == MainFrame.btnClear ){
			MyApplet.theBalloon.drawHello = 0;
			System.out.println("You clicked the button clear");
			//MainFrame.mFrame_panel;
		}
		else if(event.getSource() == NewFrame.btnOk ){
			System.out.println(NewFrame.currentChoice);
			if(NewFrame.num == 2 ){
				Game.player1.setPlayerName(NewFrame.textField_1.getText());
				Game.player2.setPlayerName(NewFrame.textField_2.getText());
				System.out.println("player1 name: " + NewFrame.textField_1.getText());
				System.out.println("player2 name: " + NewFrame.textField_2.getText());
			}
			if(NewFrame.currentChoice !=null && NewFrame.textField_1.getText().length()!=0 && NewFrame.textField_2.getText().length()!=0 ){
				NewFrame.startframe.dispose();
				StateControl.control(StateControl.State.START);
			}
		}
		
	}
}
