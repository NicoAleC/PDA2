package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import control.ControlPDA;
import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;
import entity.Regla;

public class PilaIU extends JFrame {

	private EnPilas pilafunc;

	private JPanel dibujopila;
	private JScrollPane scrollPane;
	private JPanel reglaestado;
	private PDA pda;
	private JPanel preglas;
	private JPanel pestados;

	private JTextField[][] treglas;
	private JTextField[][] testados;
	private JTextField palabra;
	private JLabel[] lreglas;
	private JLabel[] lestados;
	private static final long serialVersionUID = 1L;
	public JTextField conjunto;

	private Box box;
	private String palabras;
	private JPanel dibujos;
	private JPanel titulo;
	private JPanel mensaje;

	public PilaIU(PDA pda) {

		this.pda = pda;

		LeerEscribirPDA c = new LeerEscribirPDA();
		JButton simularButton = new JButton("Simular");
		JButton guardarButton = new JButton("Guardar");
		JButton editButton = new JButton("Edit");
		JButton volverMenuButton = new JButton("Menu Principal");
		JLabel aceptado = new JLabel("La cadena es aceptada");
		JLabel rechazado = new JLabel("La cadena es rechazada");

		rechazado.setVisible(false);
		aceptado.setVisible(false);

		simularButton.setBackground(new Color(255, 102, 102));
		simularButton.setContentAreaFilled(false);
		simularButton.setOpaque(true);

		guardarButton.setBackground(new Color(255, 102, 102));
		guardarButton.setContentAreaFilled(false);
		guardarButton.setOpaque(true);

		editButton.setBackground(new Color(255, 102, 102));
		editButton.setContentAreaFilled(false);
		editButton.setOpaque(true);

		volverMenuButton.setBackground(new Color(255, 102, 102));
		volverMenuButton.setContentAreaFilled(false);
		volverMenuButton.setOpaque(true);

		titulo = new JPanel();
		titulo.setBackground(new Color(255, 255, 204));
		JLabel label1 = new JLabel("SIMULADOR");

		palabra = new JTextField("Inserte Palabra");
		palabra.setFont(new Font("Serif", Font.BOLD, 20));
		palabra.setPreferredSize(new Dimension(100, 50));

		preglas = new JPanel();
		pestados = new JPanel();
		dibujos = new JPanel();
		dibujos.setPreferredSize(new Dimension(200, 200));
		mensaje = new JPanel();

		preglas.setBackground(new Color(255, 255, 204));
		pestados.setBackground(new Color(255, 255, 204));

		preglas.setLayout(new GridLayout(pda.getReglas().length, 0));
		pestados.setLayout(new GridLayout(pda.getEstados().length, 0));
		// dibujos.setLayout(new GridLayout(1,1));

		reglaestado = new JPanel();
		reglaestado.setBackground(new Color(255, 255, 204));

		dibujopila = new JPanel(null);

		scrollPane = new JScrollPane(dibujos,

				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

		);

		dibujopila.setPreferredSize(new Dimension(300, 300));

		scrollPane.setBounds(0, 0, 300, 300);

		dibujopila.add(scrollPane);

		lreglas = new JLabel[pda.getReglas().length];
		for (int j = 0; j < pda.getReglas().length; j++) {
			lreglas[j] = new JLabel(pda.getReglas()[j].toString());

		}

		for (int j = 0; j < lreglas.length; j++) {
			preglas.add(lreglas[j]);

		}

		lestados = new JLabel[pda.getEstados().length];
		for (int j = 0; j < pda.getEstados().length; j++) {
			lestados[j] = new JLabel(pda.getEstados()[j].toString());

		}

		for (int j = 0; j < lestados.length; j++) {
			pestados.add(lestados[j]);

		}

		guardarButton.setEnabled(false);
		box = Box.createHorizontalBox();

		box.add(Box.createHorizontalGlue());

		box.add(preglas);

		box.add(Box.createHorizontalStrut(20));

		Box box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalGlue());
		box1.add(editButton);
		box1.add(Box.createVerticalStrut(20));
		box1.add(simularButton);
		box1.add(Box.createVerticalStrut(20));
		box1.add(guardarButton);
		box1.add(Box.createVerticalStrut(20));
		box1.add(volverMenuButton);
		box1.add(Box.createVerticalStrut(20));
		box1.add(palabra);
		box1.add(Box.createVerticalGlue());
		box1.add(aceptado);
		box1.add(rechazado);
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));

		box.add(pestados);

		box.add(Box.createHorizontalGlue());

		reglaestado.setLayout(new BoxLayout(reglaestado, BoxLayout.Y_AXIS));

		reglaestado.add(box);
		titulo.add(label1);

		add(titulo, BorderLayout.NORTH);
		add(reglaestado, BorderLayout.CENTER);
		add(dibujopila, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		simularButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				aceptado.setVisible(false);
				rechazado.setVisible(false);

				ControlPDA con = new ControlPDA();
				con.reiniciarPDA(pda);
				PDA.pilas.clear();

				boolean tieneFinal = false;
				for (int i = 0; i < pda.getEstados().length; i++) {
					if (pda.getEstados()[i].isAcept()) {
						tieneFinal = true;
					}
				}
				if (tieneFinal) {
					if (con.simularAutomataF(pda, palabra.getText())) {
						aceptado.setVisible(true);
					} else {
						rechazado.setVisible(true);
					}

				} else {
					if (con.simularAutomataP(pda, palabra.getText())) {
						aceptado.setVisible(true);
					} else {
						rechazado.setVisible(true);
					}
				}

				dibujopila.remove(scrollPane);
				dibujopila.setPreferredSize(new Dimension(300, 300));
				dibujos = new JPanel();

				dibujos.setPreferredSize(new Dimension(300, 400));
				try {
				dibujos.setLayout(new GridLayout(0, PDA.pilas.size()));
				} catch (Exception e1) {
					rechazado.setVisible(true);
				}
				for (int i = 0; i < PDA.pilas.size(); i++) {
					dibujos.add(new EnPilas(PDA.pilas.get(i).toString()));

				}

				scrollPane = new JScrollPane(dibujos,

						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

				);

				scrollPane.setBounds(0, 0, 300, 300);

				dibujopila.add(scrollPane);

				dibujopila.revalidate();

				dibujopila.repaint();

			}
		});
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				guardarButton.setEnabled(true);
				editButton.setEnabled(false);

				// LeerEscribirPDA c = new LeerEscribirPDA();
				c.borrarPDA(pda.getNombre());

				remove(reglaestado);

				reglaestado = new JPanel();
				reglaestado.setBackground(new Color(255, 255, 204));

				preglas = new JPanel();
				preglas.setBackground(new Color(255, 255, 204));
				pestados = new JPanel();
				pestados.setBackground(new Color(255, 255, 204));
				preglas.setLayout(new GridLayout(pda.getReglas().length, 6));
				pestados.setLayout(new GridLayout(pda.getEstados().length, 3));

				testados = new JTextField[lestados.length][3];

				for (int row = 0; row < lestados.length; row++) {

					JTextField text1 = new JTextField(pda.getEstados()[row].getEstado());
					JTextField text2 = new JTextField(Boolean.toString(pda.getEstados()[row].isInicial()));
					JTextField text3 = new JTextField(Boolean.toString(pda.getEstados()[row].isAcept()));
					testados[row][0] = text1;
					testados[row][1] = text2;
					testados[row][2] = text3;

				}

				treglas = new JTextField[lreglas.length][6];
				for (int row = 0; row < lreglas.length; row++) {

					JTextField text1 = new JTextField(pda.getReglas()[row].getEstadoActual().getEstado());
					JTextField text2 = new JTextField(pda.getReglas()[row].getLectura());
					JTextField text3 = new JTextField(pda.getReglas()[row].getPila());
					JTextField text4 = new JTextField(pda.getReglas()[row].getEstadoSiguiente().getEstado());
					JTextField text5 = new JTextField(String.valueOf(pda.getReglas()[row].getOrden()));
					JTextField text6 = new JTextField(pda.getReglas()[row].getApilar());
					treglas[row][0] = text1;
					treglas[row][1] = text2;
					treglas[row][2] = text3;
					treglas[row][3] = text4;
					treglas[row][4] = text5;
					treglas[row][5] = text6;

				}

				for (int i = 0; i < lreglas.length; i++) {
					for (int j = 0; j < 6; j++) {
						preglas.add(treglas[i][j]);

					}
				}

				for (int i = 0; i < lestados.length; i++) {
					for (int j = 0; j < 3; j++) {
						pestados.add(testados[i][j]);

					}
				}

				box = Box.createHorizontalBox();

				box.add(Box.createHorizontalGlue());

				box.add(preglas);

				box.add(Box.createHorizontalStrut(20));

				Box box1 = Box.createVerticalBox();
				box1.add(Box.createVerticalGlue());
				box1.add(editButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(simularButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(guardarButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(volverMenuButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(palabra);
				box1.add(Box.createVerticalGlue());
				box1.add(aceptado);
				box1.add(rechazado);
				box.add(box1);
				box.add(Box.createHorizontalStrut(20));

				box.add(pestados);

				box.add(Box.createHorizontalGlue());

				reglaestado.setLayout(new BoxLayout(reglaestado, BoxLayout.Y_AXIS));

				reglaestado.add(box);

				add(reglaestado, BorderLayout.CENTER);

				revalidate();

				repaint();

			}
		});
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton.setEnabled(true);
				guardarButton.setEnabled(false);

				remove(reglaestado);

				reglaestado = new JPanel();
				reglaestado.setBackground(new Color(255, 255, 204));
				preglas = new JPanel();
				preglas.setBackground(new Color(255, 255, 204));
				pestados = new JPanel();
				pestados.setBackground(new Color(255, 255, 204));
				preglas.setLayout(new GridLayout(pda.getReglas().length, 0));
				pestados.setLayout(new GridLayout(pda.getEstados().length, 0));

				ControlPDA control = new ControlPDA();

				for (int i = 0; i < testados.length; i++) {
					boolean einicial = false;
					boolean efinal = false;
					if (testados[i][1].getText().equals("true")) {
						einicial = true;
						efinal = false;
					} else if (testados[i][2].getText().equals("true")) {
						einicial = false;
						efinal = true;
					} else {
						einicial = false;
						efinal = false;
					}

					Estado estado = new Estado(testados[i][0].getText(), einicial, efinal);
					control.estados.add(estado);

				}

				for (int i = 0; i < treglas.length; i++) {
					String estadoactual = treglas[i][0].getText();
					String lectura = treglas[i][1].getText();
					String p = treglas[i][2].getText();
					String estadosig = treglas[i][3].getText();
					String orden = treglas[i][4].getText();
					String apilar = treglas[i][5].getText();
					Regla regla = new Regla();
					regla.setLectura(lectura);
					regla.setPila(p);
					regla.setOrden(Integer.parseInt(orden));
					regla.setApilar(apilar);
					for (int j = 0; j < control.estados.size(); j++) {
						if (control.estados.get(j).getEstado().equals(estadoactual)) {
							// Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4,
							// true, false),Integer.parseInt(part51),part52);

							Estado actual = control.estados.get(j);

							regla.setEstadoActual(actual);

						}

					}

					for (int z = 0; z < control.estados.size(); z++) {
						if (control.estados.get(z).getEstado().equals(estadosig)) {
							// Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4,
							// true, false),Integer.parseInt(part51),part52);

							Estado siguiente = control.estados.get(z);
							regla.setEstadoSiguiente(siguiente);

						}
					}

					control.reglas.add(regla);

					// Estado estado = new Estado(testados[i][0].getText(), einicial, efinal);
					// control.estados.add(estado);

				}

				// pda.setNombre(auxiliar.getNombre());
				Pila pila = new Pila();
				pda.setPila(pila);
				control.crearEstados(pda);
				control.crearReglas(pda);

				// PDA pda = new PDA("Ejemplo", estados, pila, reglas);

				c.crearPDA(pda);
				// new PilaIU(pda);

				lreglas = new JLabel[pda.getReglas().length];
				for (int j = 0; j < pda.getReglas().length; j++) {
					lreglas[j] = new JLabel(pda.getReglas()[j].toString());

				}

				for (int j = 0; j < lreglas.length; j++) {
					preglas.add(lreglas[j]);

				}

				lestados = new JLabel[pda.getEstados().length];
				for (int j = 0; j < pda.getEstados().length; j++) {
					lestados[j] = new JLabel(pda.getEstados()[j].toString());

				}

				for (int j = 0; j < lestados.length; j++) {
					pestados.add(lestados[j]);

				}

				box = Box.createHorizontalBox();

				box.add(Box.createHorizontalGlue());

				box.add(preglas);

				box.add(Box.createHorizontalStrut(20));

				Box box1 = Box.createVerticalBox();
				box1.add(Box.createVerticalGlue());
				box1.add(editButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(simularButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(guardarButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(volverMenuButton);
				box1.add(Box.createVerticalStrut(20));
				box1.add(palabra);
				box1.add(Box.createVerticalGlue());
				box1.add(aceptado);
				box1.add(rechazado);
				box.add(box1);
				box.add(Box.createHorizontalStrut(20));

				box.add(pestados);

				box.add(Box.createHorizontalGlue());
				reglaestado.setLayout(new BoxLayout(reglaestado, BoxLayout.Y_AXIS));

				reglaestado.add(box);

				add(reglaestado, BorderLayout.NORTH);

				revalidate();

				repaint();

			}
		});

		volverMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new Menu();
			}
		});

		palabra.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				palabra.setText("");
			}
		});

	}

}
