package skeleton;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class MyTransfertHandler extends TransferHandler{
	
	public MyTransfertHandler(){
		super();
	}
	
	
	public int getSourceActions(JComponent c){
		return COPY_OR_MOVE;
	}
	
	protected Transferable createTransferable(JComponent c){
		/*Class classe = c.getClass();
		switch(classe.getName()){
			case "JLabel" :
				return new StringSelection(((JLabel)c).getText());
			case "JFormattedTextField":
				return new StringSelection(((JFormattedTextField)c).getText());
			default:
				return null;
		}*/
		return new StringSelection(((JLabel)c).getText());
	}
	
	public void exportDone(JComponent c, Transferable t, int action) {
		if(action == MOVE){
			((JLabel)c).setText("");
		}
		/*if (action == MOVE) {
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
		}*/
	}
	
	public boolean importData(TransferSupport support) {
		if(!support.isDrop())
			return false;
		
		if(!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			System.out.println("Drop non supporté");
			return false;
		}
		
		JLabel label = (JLabel) support.getComponent();
		
		Transferable t = support.getTransferable();
		
		String data;
		try {
			data = (String) t.getTransferData(DataFlavor.stringFlavor);
		} catch (Exception e) {
			return false;
		}
		
		label.setText(label.getText() + data);
		
		return true;
			
	}


	public boolean canImport(TransferSupport support) {
		return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
}
