package view;
import java.awt.Color;
import java.awt.Dimension;



import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlPDA;
import entity.Regla;
import entity.Estado;
import entity.PDA;

public class FReglas extends JFrame {

	/**
	 * 
	 */
	public Regla[] reglas;
	private static final long serialVersionUID = 1L;
	public JTextField reglatext;
	private JButton saveButton = new JButton("Save");
	private JButton addButton = new JButton("Add");
	ControlPDA control = new ControlPDA();
	Estado estadoactual;
	Estado estadosiguiente;
	Regla regla;

	PDA pda;

	public FReglas(PDA pda) {
		this.pda = pda;
		JPanel reglas = new JPanel();
		reglatext = new JTextField("Ingrese reglas");
		reglatext.setFont(new Font("Serif", Font.BOLD, 20));
		reglatext.setPreferredSize(new Dimension(300, 50));

		reglatext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reglatext.setText("");
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.crearReglas(pda);

				setVisible(false);
				dispose();
				new FPalabra(pda);
			}
		});

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException {
				try {
					String entrada = reglatext.getText();
					String dividido = entrada.substring(1, entrada.length() - 1);

					String[] parts = dividido.split(",");
					String part1 = parts[0];
					String part2 = parts[1];
					String part3 = parts[2];
					String part4 = parts[3];
					String part50 = parts[4];
					String[] parts50 = part50.split("\\(");

					String part51 = parts50[0];
					String part520 = parts50[1];
					String part52 = part520.substring(0, part520.length() - 1);
					regla = new Regla();
					regla.setLectura(part2);
					regla.setPila(part3);
					regla.setOrden(Integer.parseInt(part51));
					regla.setApilar(part52);

					System.out.println("imprime splits");
					System.out.println(part1 + part2 + part3 + part4 + part51 + part52);
					System.out.println(regla.getOrden());

					System.out.println("pda estados");
					for (int j = 0; j < pda.getEstados().length; j++) {
						System.out.println(pda.getEstados()[j]);
					}

					for (int i = 0; i < pda.getEstados().length; i++) {
						if (pda.getEstados()[i].getEstado().equals(part1)) {
							// Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4,
							// true, false),Integer.parseInt(part51),part52);

							estadoactual = pda.getEstados()[i];
							regla.setEstadoActual(estadoactual);

						}

					}

					for (int i = 0; i < pda.getEstados().length; i++) {
						if (pda.getEstados()[i].getEstado().equals(part4)) {
							// Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4,
							// true, false),Integer.parseInt(part51),part52);

							estadosiguiente = pda.getEstados()[i];
							regla.setEstadoSiguiente(estadosiguiente);

						}
					}
					System.out.println("pruebita estados en regla");

					System.out.println(regla.getEstadoActual().toString());
					System.out.println(regla.getEstadoSiguiente().toString());

					control.reglas.add(regla);
				} catch (Exception e2) {
					reglatext.setText("vuelva a ingresar la regla");
				}
			}
		});

		reglas.add(reglatext);
		reglas.add(addButton);
		reglas.add(saveButton);
		getContentPane().add(reglas);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public String getConjuntoText() {
		return reglatext.getText();
	}

}
