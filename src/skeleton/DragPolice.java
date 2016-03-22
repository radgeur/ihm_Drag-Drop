package skeleton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class DragPolice {
	
	JFrame frame;
	JLabel label;
	JFormattedTextField text1;
	JFormattedTextField text2;

	public DragPolice(){
		//création de la frame
		frame = new JFrame("Drag Police");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Récupération du container et spécification de son layout
		Container pane = frame.getContentPane();
		BoxLayout layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
		pane.setLayout(layout);
		
		//Création et ajout des différents éléments au container
		label = new JLabel("IHM");
		label.setTransferHandler(new TransfertCouleur());
		
		label.addMouseMotionListener(new MouseMotionListener(){

			public void mouseDragged(MouseEvent e) {
				label.getTransferHandler().exportAsDrag(label, e, TransferHandler.COPY);
			}

			public void mouseMoved(MouseEvent e) {}
			
		});
		text1 = new JFormattedTextField("Master 1 info");
		text1.setFont(new Font("TimesRoman",Font.ITALIC, 12));
		text1.setTransferHandler(new TransferHandler("text"));
		
		text1.addMouseMotionListener(new MouseMotionListener(){

			public void mouseDragged(MouseEvent e) {
				text1.getTransferHandler().exportAsDrag(text1, e, TransferHandler.COPY);
			}

			public void mouseMoved(MouseEvent e) {}
			
		});
		text2 = new JFormattedTextField("Université Lille 1");
				
		pane.add(label);
		pane.add(text1);
		pane.add(text2);
		
		//modifications de la frame
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String[] args){
		new DragPolice();
	}
	
}
