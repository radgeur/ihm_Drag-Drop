package skeleton;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class MyTransfertHandler extends TransferHandler{
	
	public MyTransfertHandler(){
		super();
	}
	
	
	public int getSourceActions(JComponent c){
		return COPY;
	}
	
	protected Transferable createTransferable(JComponent c){
		Class classe = c.getClass();
		switch(classe.getName()){
			case "JLabel" :
				return new StringSelection(((JLabel)c).getText());
			case "JFormattedTextField":
				return new StringSelection(((JFormattedTextField)c).getText());
			default:
				return null;
		}
	}
	
	public void exportDone(JComponent c, Transferable t, int action) {
		if (action == COPY) {
			switch(classe.getName()){
			case "JLabel" :
				((JLabel)c).setText(t.get);
				break;
			case "JFormattedTextField":
				((JFormattedTextField)c).setText();
				break;
			default:
				break;
		}
		}
	}
}
