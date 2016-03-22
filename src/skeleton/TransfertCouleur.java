package skeleton;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class TransfertCouleur extends TransferHandler{
	
	TransfertCouleur(){	}
	
	public int getSourceActions(JComponent c) { return COPY;}
	
	public Transferable createrTransferable(JComponent c){
		Color color = c.getForeground();
		return new TransferableCouleur(color.getRed(), color.getGreen(), color.getBlue());
	}
	
	public boolean canImport(TransferSupport info) {
		DataFlavor df[] = info.getDataFlavors();
		for(int i=0;i<df.length;i++) {
			if(df[i].equals(TransferableCouleur.couleurFlavor)) return true;
			if(df[i].equals(DataFlavor.stringFlavor));
		}
		return false;
	}

}
