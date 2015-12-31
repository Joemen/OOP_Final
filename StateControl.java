import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
public class StateControl {
    
    public static enum State{ORIGIN,START,ACTION_1,DEPLOY_1,ACTION_2,DEPLOY_2,WAR,CLEAR,ENDROUND,ENDGAME}
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
                break;
            case ACTION_1:
            	MainFrame.btnPlayer_1.setEnabled(false);
            	MainFrame.actionbutton.setEnabled(true);
				MainFrame.shopbutton.setEnabled(true);
				MainFrame.btnClear.setEnabled(false);
				TotalPrint.printStatus();
				TotalPrint.printRound();
				TotalPrint.printTurn(1);
				TotalPrint.printPressAction();
				break;
            case DEPLOY_1:
            	MainFrame.actionbutton.setEnabled(false);
				MainFrame.shopbutton.setEnabled(false);
				MainFrame.btnFight.setEnabled(true);
				TotalPrint.printPressDeploy();
            	break;
            case ACTION_2:
            	Game.turn++;
            	MainFrame.actionbutton2.setEnabled(true);
            	MainFrame.btnFight.setEnabled(false);
            	MainFrame.shopbutton.setEnabled(true);
            	TotalPrint.print_msg_to_textArea("\n############ round " + Game.round + " ############\n\n", (Game.turn+1)%2);
            	TotalPrint.printTurn(2);
            	TotalPrint.printPressAction();
            	break;
            case DEPLOY_2:
            	MainFrame.actionbutton2.setEnabled(false);
            	MainFrame.btnFight2.setEnabled(true);
            	MainFrame.shopbutton.setEnabled(false);
            	TotalPrint.printPressDeploy();
            	break;
            case WAR:
            	MainFrame.btnFight2.setEnabled(false);
            	MainFrame.btnWar.setEnabled(true);
            	TotalPrint.printPressWar();
            	//drawHello = 1; //to be modify
            	break;
            case CLEAR:
            	MainFrame.btnWar.setEnabled(false);
            	MainFrame.btnClear.setEnabled(true);
            	TotalPrint.printPressClear();
            	break;
            case ENDROUND:
            	Game.round++;
            	StateControl.control(StateControl.State.ACTION_1);
            	break;
            case ENDGAME:
            	MainFrame.actionbutton.setEnabled(false);
            	MainFrame.actionbutton2.setEnabled(false);
            	MainFrame.shopbutton.setEnabled(false);
            	MainFrame.btnFight.setEnabled(false);
            	MainFrame.btnFight2.setEnabled(false);
            	MainFrame.btnWar.setEnabled(false);
            	MainFrame.btnPlayer_1.setEnabled(false);
            	MainFrame.btnClear.setEnabled(false);
            	break;
            	
            	
            default:
                break;
        }
    }
    public static void action(ActionEvent event){
        if(event.getSource() == MainFrame.btnPlayer_1 ){
            System.out.println("You clicked the button player1");
            TotalPrint.clearTextArea();
			TotalPrint.printStart();
            Game.blockmain = false;
            drawHello = 1;
            StateControl.control(StateControl.State.ACTION_1);
        }
        
        else if(event.getSource() == NewFrame.btnOk ){
            if(NewFrame.num == 2 ){
                Game.player[0].setPlayerName(NewFrame.textField_1.getText());
                Game.player[1].setPlayerName(NewFrame.textField_2.getText());               
                drawHello = 0;
            }
            if(NewFrame.currentChoice !=null && NewFrame.player1roleChoice !=null && NewFrame.player2roleChoice !=null && NewFrame.textField_1.getText().length()!=0 && NewFrame.textField_2.getText().length()!=0 ){
                Game.player[0].setRole(NewFrame.player1_role_num);
                Game.player[1].setRole(NewFrame.player2_role_num);
                NewFrame.startframe.dispose();
                TotalPrint.printPressStart();
                MainFrame.scrollPane.readFile();
                StateControl.control(StateControl.State.START);
            }
        }
        else if(event.getSource() == ActionFrame.btnOk_1){
        	drawHello = 1;
        	if(ActionFrame.action_flag == 1&&ActionFrame.ConstructionCombo.getSelectedIndex()!=-1){ // Construction
				ConstructionDep.RepairTower_UI( Game.player[(Game.turn+1)%2], Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1] );
				
			}else if(ActionFrame.action_flag == 2&&ActionFrame.MuntionCombo.getSelectedIndex()!=-1){ // Munition
				MunitionsFactory.BuySoldier_UI(Game.player[(Game.turn+1)%2]);
	
			}else if(ActionFrame.action_flag == 3){ // Bank 
				Game.player[(Game.turn+1)%2].setMoney((int)(Game.player[(Game.turn+1)%2].getMoney()+Math.round(Bank.give_money*Game.player[(Game.turn+1)%2].getRole().getProperty().is_add_money_rate)));
				
			}else if(ActionFrame.action_flag == 4&&ActionFrame.ExploreCombo.getSelectedIndex()!=-1){ // Explore
				Explore.explore_UI(Game.player[(Game.turn+1)%2]);
				
			}else if(ActionFrame.action_flag == 5){ // Nothing to do
				
			}else{
				TotalPrint.print_msg_to_textArea("\n",(Game.turn+1)%2 );
			}
        	if ((ActionFrame.action_flag == 1&&ActionFrame.ConstructionCombo.getSelectedIndex()==-1)||(ActionFrame.action_flag == 2&&ActionFrame.MuntionCombo.getSelectedIndex()==-1)||(ActionFrame.action_flag == 4&&ActionFrame.ExploreCombo.getSelectedIndex()==-1)){ 
        		
        	}
        	else{
			TotalPrint.printAction();
			ActionFrame.actionframe.dispose();
			Game.blockmain = false;
			if ((Game.turn+1)%2 == 0)
				StateControl.control(StateControl.State.DEPLOY_1);
			else if ((Game.turn+1)%2 == 1)
				StateControl.control(StateControl.State.DEPLOY_2);
        	}
        }
        else if(event.getSource() == FightFrame.btnReady){
        	drawHello = 1;
        	int i = -1;
            int j = -1;
            try{
                i = Integer.parseInt(FightFrame.amount_Off.getText());
                j = Integer.parseInt(FightFrame.amount_Def.getText());
            } catch (Exception ex){
                
            }
            if( i>=0 && j>=0 && Game.player[(Game.turn+1)%2].getNumSoldier()-((Number)FightFrame.amount_Off.getValue()).intValue()-((Number)FightFrame.amount_Def.getValue()).intValue()>=0){
                Commander.dispatchArmy_UI(Game.player[(Game.turn+1)%2], Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1]);
                Game.blockmain = false;
                TotalPrint.printPressReady();
                FightFrame.fightframe.dispose();
                if ((Game.turn+1)%2 == 0)
                	StateControl.control(StateControl.State.ACTION_2);
                else if ((Game.turn+1)%2 == 1)
                	StateControl.control(StateControl.State.WAR);
            }
            else if (i<0 || j<0)
            	FightFrame.lblIncorrectInput.setVisible(true);
            else
            	FightFrame.lblalarm.setVisible(true);
            
        }
        else if(event.getSource() == MainFrame.btnShake ){
            drawHello = 2;
            MainFrame.scrollPane.Artanis.timer.start();
            MainFrame.scrollPane.repaint();
            Toaster toasterManager = new Toaster(MainFrame.scrollPane.getLocation().x -150 + MainFrame.scrollPane.getWidth() ,MainFrame.scrollPane.getLocation().y+95 );
            // Show a simple toaster
            toasterManager.showToaster( new ImageIcon( "pic/gif/em17.gif" ), "We are under attack!" );
            
        }
        else if(event.getSource() == MainFrame.btnShake_1 ){
            drawHello = 3;
            MainFrame.scrollPane.Agumon.timer.start();
            MainFrame.scrollPane.repaint();
            Toaster toasterManager = new Toaster(MainFrame.scrollPane.getLocation().x +210 ,MainFrame.scrollPane.getLocation().y+95 );
            // Show a simple toaster
            toasterManager.showToaster( new ImageIcon( "pic/gif/em17.gif" ), "We are under attack!" );
            
        }
        else if(event.getSource() == MainFrame.btnWar){
            TotalPrint.printWarStart();
            Computer.fight_UI(Game.tower[Game.player[(Game.turn+1)%2].getCampNum()-1], Game.tower[Game.player[(Game.turn)%2].getCampNum()-1], Game.player);
            drawHello = 1;
            Game.blockmain = false;
            StateControl.control(StateControl.State.CLEAR);
        }
        else if(event.getSource() == MainFrame.btnClear ){
            Game.blockmain = false;
            drawHello = 1;
            System.out.println("You clicked the button clear");
            try {
				FileWriter fileWritter = new FileWriter("history.txt",true);
			    String myString1 = MainFrame.textArea_1.getText();
			    if(Game.round == 1){
			    	PrintWriter writer = new PrintWriter("history.txt");
			    	writer.print("");
			    	writer.close();
			    	fileWritter.append(myString1 + "\n");
			    }else{
			    	fileWritter.append(myString1 + "\n");
			    }    
			    fileWritter.close();
			} catch (IOException ioe) {
			    ioe.printStackTrace();
			}
			TotalPrint.clearTextArea();
            StateControl.control(StateControl.State.ENDROUND);
        }
        else {
            
        }
    }
}