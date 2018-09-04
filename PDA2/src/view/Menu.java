package view;

import java.awt.Component;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
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

	private JButton nuevoButton = new JButton("Nuevo Automata");
	private JButton antiguoButton = new JButton("Antiguo Automata");

	ControlPDA control = new ControlPDA();
	PDA pda;
	Estado estado;

	public Menu() {

		System.out.println("entre");
		
		JPanel menu = new JPanel();
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		JPanel botones = new JPanel();
		JPanel titulo = new JPanel();
		JLabel label = new JLabel("BIENVENIDO");
		menu.setFont(new Font("Serif", Font.BOLD, 20));
		menu.setPreferredSize(new Dimension(350, 100));

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

		titulo.add(label);
		botones.add(nuevoButton);
		botones.add(antiguoButton);
		menu.add(titulo);
		menu.add(botones);
		getContentPane().add(menu);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
