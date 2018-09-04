package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import control.ControlPDA;
import entity.Estado;
import entity.PDA;

public class Menu extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JButton nuevoButton= new JButton("Nuevo Automata");
	private JButton antiguoButton = new JButton("Antiguo Automata");
	private JButton instruccionesButton = new JButton("Instrucciones");

	ControlPDA control = new ControlPDA();
	PDA pda;
	Estado estado;

	public Menu() {
		
		nuevoButton.setBackground(new Color(255,102,102));
		nuevoButton.setContentAreaFilled(false);
		nuevoButton.setOpaque(true);
		
		antiguoButton.setBackground(new Color(0,153,0));
		antiguoButton.setContentAreaFilled(false);
		antiguoButton.setOpaque(true);
		
		instruccionesButton.setBackground(new Color(90,0,204));
		instruccionesButton.setContentAreaFilled(false);
		instruccionesButton.setOpaque(true);

		System.out.println("entre");
		Container c = getContentPane();
		c.setBackground(Color.red);
		JPanel menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		JPanel botones = new JPanel();
		
		JPanel titulo = new JPanel();
		JPanel labels = new JPanel();
		JLabel label = new JLabel("BIENVENIDO");
		
		
		botones.setBackground(new Color(255,255,204));
		titulo.setBackground(new Color(255,255,204));
		labels.setBackground(new Color(255,255,204));
		
		menu.setFont(new Font("Serif", Font.BOLD, 20));
		menu.setPreferredSize(new Dimension(400, 200));
		
	
		ImageIcon in=new ImageIcon("C:\\Users\\usuario\\git\\PDA2\\PDA2\\bin\\new-icon1.png"); 
		ImageIcon io=new ImageIcon("C:\\Users\\usuario\\git\\PDA2\\PDA2\\bin\\old1.png"); 
		ImageIcon ii=new ImageIcon("C:\\Users\\usuario\\git\\PDA2\\PDA2\\bin\\ins1.png"); 
        
        JLabel lnew =new JLabel(in); 
        JLabel lold =new JLabel(io); 
        JLabel lins =new JLabel(ii); 

		nuevoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pda = new PDA();
				setVisible(false);
				dispose();
				new FNombre(pda);
			}
		});

		antiguoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new FAntiguo();
			}
		});
		instruccionesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//menu no se cierra?
				new FInstrucciones();
			}
		});
		

		

		titulo.add(label);
		
		botones.add(nuevoButton);
		botones.add(antiguoButton);
		botones.add(instruccionesButton);
		/*labels.add(lnew);
		labels.add(lold);
		labels.add(lins);
		*/
		Box box1 = Box.createHorizontalBox();
		box1.add(Box.createHorizontalGlue());
		box1.add(lnew);
		box1.add(Box.createHorizontalStrut(70));
		box1.add(lold);
		box1.add(Box.createHorizontalStrut(70));
		box1.add(lins);
		box1.add(Box.createHorizontalGlue());
		
		labels.add(box1);
		menu.add(titulo);
		menu.add(labels);
		menu.add(botones);
		


		
		getContentPane().add(menu);
		//getContentPane().setBackground(Color.YELLOW); 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
