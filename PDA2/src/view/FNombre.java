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
import entity.Pila;

public class FNombre extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public JTextField nombrepda;

	private JButton saveButton = new JButton("Guardar");
	private JLabel titulo = new JLabel("INGRESE UN NOMBRE");
	ControlPDA control = new ControlPDA();
	PDA pda;

	public FNombre(PDA pda) {
		this.pda = pda;

		Pila pila = new Pila();
		pda.setPila(pila);
		JPanel nombre = new JPanel();
		nombre.setLayout(new BoxLayout(nombre, BoxLayout.PAGE_AXIS));
		nombrepda = new JTextField("Ingrese el nombre del Automata");
		nombrepda.setFont(new Font("Serif", Font.BOLD, 15));
		nombrepda.setPreferredSize(new Dimension(300, 30));

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pda.setNombre(nombrepda.getText());
				new FConjuntos(pda);
				setVisible(false);
				dispose();

			}
		});

		nombrepda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombrepda.setText("");

			}
		});
		JPanel botones = new JPanel();
		JPanel titulos = new JPanel();
		
		titulos.add(titulo);
		botones.add(nombrepda);
		botones.add(saveButton);
		
		nombre.add(titulos);
		nombre.add(botones);
		
		getContentPane().add(nombre);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}