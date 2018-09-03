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

	EnPilas pilafunc;

	JPanel dibujopila;
	JScrollPane scrollPane;
	JPanel reglaestado;
	PDA pda;
	JPanel preglas;
	JPanel pestados;
	protected JTextArea textArea;
	protected JTextArea textArea2;
	JTextField[][] treglas;
	JTextField[][] testados;
	JLabel[] lreglas;
	JLabel[] lestados;
	LeerEscribirPDA c = new LeerEscribirPDA();
	private static final long serialVersionUID = 1L;
	public JTextField conjunto;

	private JButton simularButton = new JButton("Simular");
	private JButton guardarButton = new JButton("Guardar");
	private JButton editButton = new JButton("Edit");
	
	Box box;
	

	public PilaIU(PDA pda) {
		this.pda = pda;
		
		
		
		preglas = new JPanel();
		pestados = new JPanel();
		preglas.setLayout(new GridLayout(pda.getReglas().length, 0));
		pestados.setLayout(new GridLayout(pda.getEstados().length, 0));

		reglaestado = new JPanel();

		dibujopila = new JPanel(null);

		scrollPane = new JScrollPane(pilafunc,

				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

		);

		dibujopila.setPreferredSize(new Dimension(400, 400));

		scrollPane.setBounds(30, 50, 300, 300);

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
		box1.add(Box.createVerticalGlue());
		box.add(box1);
		box.add(Box.createHorizontalStrut(20));

		box.add(pestados);

		box.add(Box.createHorizontalGlue());

		reglaestado.setLayout(new BoxLayout(reglaestado, BoxLayout.Y_AXIS));

		reglaestado.add(box);

		add(reglaestado, BorderLayout.NORTH);
		add(dibujopila, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		simularButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			

				System.out.println("imprimir estados pda");
				for (int j = 0; j < pda.getEstados().length; j++) {
					System.out.println(pda.getEstados()[j]);
				}

				System.out.println("imprimir reglas pda");
				for (int j = 0; j < pda.getReglas().length; j++) {
					System.out.println(pda.getReglas()[j]);
				}
				

				System.out.println("\nleemos el archivo creado");

				PDA nuevo = c.leerPDA(pda.getNombre());
				System.out.println(nuevo.toString() + "\n" + pda.toString());
				System.out.println(nuevo.toString().equals(pda.toString()));
				ControlPDA con = new ControlPDA();
				System.out.println("recursividad:");

				con.reiniciarPDA(pda);
				System.out.println(con.simularAutomata(pda, "a", 0));
				con.reiniciarPDA(pda);

				System.out.println(con.simularAutomata(pda, "b", 0));
				con.reiniciarPDA(pda);

				// deberia dibujar!
				pilafunc = new EnPilas(pda.getPila());

				dibujopila.remove(scrollPane);
				scrollPane = new JScrollPane(pilafunc,

						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,

						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED

				);

				dibujopila.setPreferredSize(new Dimension(400, 400));

				scrollPane.setBounds(30, 50, 300, 300);

				dibujopila.add(scrollPane);

				dibujopila.revalidate();

				dibujopila.repaint();

			}
		});
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
					guardarButton.setEnabled(true);
					editButton.setEnabled(false);
					

					//LeerEscribirPDA c = new LeerEscribirPDA();
					c.borrarPDA(pda.getNombre());

					remove(reglaestado);
					reglaestado = new JPanel();
					preglas = new JPanel();
					pestados = new JPanel();
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
					box1.add(Box.createVerticalGlue());
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
					guardarButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							editButton.setEnabled(true);
							guardarButton.setEnabled(false);
							
					
					System.out.println("trato de guardar");
					//editButton.setText("Edit");
					remove(reglaestado);
					
					reglaestado = new JPanel();
					
					preglas = new JPanel();
					pestados = new JPanel();
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
						String estadoactual=treglas[i][0].getText();
						String lectura=treglas[i][1].getText();
						String p=treglas[i][2].getText();
						String estadosig=treglas[i][3].getText();
						String orden=treglas[i][4].getText();
						String apilar=treglas[i][5].getText();
						Regla regla= new Regla();
						regla.setLectura(lectura);
						regla.setPila(p);
						regla.setOrden(Integer.parseInt(orden));
						regla.setApilar(apilar);
						for(int j=0;j<control.estados.size();j++) {
				        	if(control.estados.get(j).getEstado().equals(estadoactual)) {
				        	//Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4, true, false),Integer.parseInt(part51),part52);
				        	   
				        		Estado actual=control.estados.get(j);
				        		
				        		
				        		regla.setEstadoActual(actual);
				        	
				        	}
				        	
				        	
				        	}
				        	
				        	for(int z=0;z<control.estados.size();z++) {
					        	if(control.estados.get(z).getEstado().equals(estadosig)) {
					        	//Regla regla= new Regla(control.estados.get(i),part2,part3,new Estado(part4, true, false),Integer.parseInt(part51),part52);
					        	   
					        		
					        		Estado siguiente=control.estados.get(z);
					        		regla.setEstadoSiguiente(siguiente);
					        	
					        	}
					        	}
						
						
						
						control.reglas.add(regla);

						//Estado estado = new Estado(testados[i][0].getText(), einicial, efinal);
						//control.estados.add(estado);

					}


					
					//pda.setNombre(auxiliar.getNombre());
					Pila pila = new Pila();
					pda.setPila(pila);
					control.crearEstados(pda);
					control.crearReglas(pda);
					
					
					
					
					// PDA pda = new PDA("Ejemplo", estados, pila, reglas);
					
					c.crearPDA(pda);
					//new PilaIU(pda);
					
			
					
					

				

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
					box1.add(Box.createVerticalGlue());
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

	}

}