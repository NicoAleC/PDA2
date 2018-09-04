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

public class FConjuntos extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public JTextField conjunto;
	public JTextField nombrepda;
	private JCheckBox einicial = new JCheckBox();
	private JCheckBox efinal = new JCheckBox();
	private JButton saveButton = new JButton("Guardar");
	private JButton addButton = new JButton("Añadir");
	private JLabel titulo = new JLabel("Ingrese las reglas");
	public boolean eeinicial = false;
	public boolean eefinal = false;
	ControlPDA control = new ControlPDA();
	PDA pda;
	Estado estado;
	JLabel inicial = new JLabel("Es un Estado Inicial");
	JLabel ffinal = new JLabel("Es un Estado Final");

	public FConjuntos(PDA pda) {
		this.pda = pda;

		System.out.println(pda.getNombre());

		Pila pila = new Pila();
		pda.setPila(pila);

		System.out.println("entre");
		JPanel conjuntos = new JPanel();
		conjunto = new JTextField("");
		conjunto.setFont(new Font("Serif", Font.BOLD, 20));
		conjunto.setPreferredSize(new Dimension(300, 50));

		JPanel titulos = new JPanel();

		JPanel mainBox = new JPanel();
		mainBox.setLayout(new BoxLayout(mainBox, BoxLayout.PAGE_AXIS));

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!control.estados.isEmpty()) {
					control.crearEstados(pda);
					// timer.start();
					new FReglas(pda);
					setVisible(false);
					dispose();
				} else {
					conjunto.setText("ingresar un estado");
				}
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (einicial.isSelected()) {
					eeinicial = true;
					eefinal = false;
				} else if (efinal.isSelected()) {
					eeinicial = false;
					eefinal = true;
				} else {
					eeinicial = false;
					eefinal = false;
				}

				estado = new Estado(conjunto.getText(), eeinicial, eefinal);

				String soy = "";
				if (estado.isInicial() == true) {
					soy = "inicial";
				} else if (estado.isAcept() == true) {
					soy = "final";
				} else if (estado.isAcept() == false && estado.isInicial() == false) {
					soy = "nada";
				}

				System.out.println("soy estado" + estado.getEstado() + " Soy " + soy);
				control.estados.add(estado);

			}
		});

		/*
		 * conjunto.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { conjunto.setText("");
		 * einicial.setSelected(false); efinal.setSelected(false); } });
		 */

		conjuntos.add(conjunto);
		conjuntos.add(inicial);
		conjuntos.add(einicial);
		conjuntos.add(ffinal);
		conjuntos.add(efinal);
		conjuntos.add(addButton);
		conjuntos.add(saveButton);

		titulos.add(titulo);

		mainBox.add(titulo);
		mainBox.add(conjuntos);
		getContentPane().add(mainBox);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
