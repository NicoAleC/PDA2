package view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FInstrucciones extends JFrame {


	public FInstrucciones() {
		
		JPanel mainBox = new JPanel();
		JPanel images = new JPanel();
		JPanel intructions = new JPanel();
		mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
		JLabel instrucciones = new JLabel(("<html>Con el uso de la biblioteca gr�fica de Swing. Java se desarroll� la interfaz de usuario para la simulaci�n del aut�mata de pila.<br>Primero se tiene un frame del men� principal, el cual nos dirige a los frames para la creaci�n de un nuevo aut�mata,<br>para el uso de un aut�mata ya creado y para las instrucciones del programa, dando click en los respectivos botones.</html>"));
		ImageIcon in=new ImageIcon("resource\\menu.png");
		JLabel lin = new JLabel(in);
		intructions.add(instrucciones);
		images.add(lin);
		mainBox.add(instrucciones);
		mainBox.add(images);
		
		getContentPane().add(mainBox);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}