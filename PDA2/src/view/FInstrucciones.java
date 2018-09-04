package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;

public class FInstrucciones extends JFrame {


	public FInstrucciones() {
		
		JPanel mainBox = new JPanel();
		JPanel images = new JPanel();
		JPanel intructions = new JPanel();
		mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));
		JLabel instrucciones = new JLabel(("<html>Con el uso de la biblioteca gráfica de Swing. Java se desarrolló la interfaz de usuario para la simulación del autómata de pila.<br>Primero se tiene un frame del menú principal, el cual nos dirige a los frames para la creación de un nuevo autómata,<br>para el uso de un autómata ya creado y para las instrucciones del programa, dando click en los respectivos botones.</html>"));
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