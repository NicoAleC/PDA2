package view;

import java.awt.Color;
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
	private JButton saveButton = new JButton("Siguiente >");
	private JButton addButton = new JButton("Añadir +");
	private JLabel titulo = new JLabel("INGRESE LOS ESTADOS");
	private JPanel verificador = new JPanel();
	
	public boolean eeinicial = false;
	public boolean eefinal = false;
	private Estado estado;
	
	
	ImageIcon in=new ImageIcon("resource\\check.png");
	JLabel lin = new JLabel(in);

	public FConjuntos(PDA pda) {

		ControlPDA control = new ControlPDA();
		JLabel inicial = new JLabel("Es un Estado Inicial");
		JLabel ffinal = new JLabel("Es un Estado Final");
		JLabel verificacion = new JLabel("Estado Añadido Correctamente");
		lin.setVisible(false);
		verificacion.setVisible(false);
		saveButton.setBackground(new Color(255,102,102));
		saveButton.setContentAreaFilled(false);
		saveButton.setOpaque(true);
		
		addButton.setBackground(new Color(255,102,102));
		addButton.setContentAreaFilled(false);
		addButton.setOpaque(true);

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
		mainBox.setPreferredSize(new Dimension(900, 200));
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
				lin.setVisible(true);
				verificacion.setVisible(true);
				Timer t = new Timer(500, new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	lin.setVisible(false);
						verificacion.setVisible(false);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
		        einicial.setSelected(false);
		        efinal.setSelected(false);
		    }
			
		});

		conjunto.addMouseListener(new MouseAdapter() {
		  
		  @Override public void mouseClicked(MouseEvent e) { conjunto.setText("");
		  einicial.setSelected(false); efinal.setSelected(false); } });
		 

		conjuntos.add(conjunto);
		conjuntos.add(inicial);
		conjuntos.add(einicial);
		conjuntos.add(ffinal);
		conjuntos.add(efinal);
		conjuntos.add(addButton);
		conjuntos.add(saveButton);
		
		verificador.add(lin);
		verificador.add(verificacion);

		titulos.add(titulo);
		
		mainBox.add(titulo);
		mainBox.add(conjuntos);
		mainBox.add(verificador);
		

		
		getContentPane().add(mainBox);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
