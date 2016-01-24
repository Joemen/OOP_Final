
public class Clickshake extends Thread{
	
	Clickshake (String name){
		super(name);
	}
	
	public void run(){
		try{
			MainFrame.btnWar.setEnabled(false);
			TotalPrint.printWarStart();
			MainFrame.btnShake.doClick();
			Thread.sleep(4000);
			MainFrame.btnShake_1.doClick();	
			Thread.sleep(4000);
			StateControl.control(StateControl.State.WAREND);
		}
		catch(InterruptedException e){
			
		}
	}
	
	

}
