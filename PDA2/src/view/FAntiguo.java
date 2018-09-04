package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

public class FAntiguo extends JFrame {

	private String nombre;

	public FAntiguo() {
		this.nombre = "";
		this.setTitle("Escoger un PDA");
		JComboBox<String> buscar;
		JButton buscarButton = new JButton("Seleccionar");

		buscarButton.setBackground(new Color(0, 153, 0));
		buscarButton.setContentAreaFilled(false);
		buscarButton.setOpaque(true);
		JLabel label1 = new JLabel("BUSCAR AUTOMATA");
		JLabel label2 = new JLabel("Selecciona automata:");
		JPanel antiguos = new JPanel();
		JPanel buscarpanel = new JPanel();
		JPanel botones = new JPanel();
		JPanel labels = new JPanel();
		antiguos.setPreferredSize(new Dimension(400, 200));
		antiguos.setLayout(new BoxLayout(antiguos, BoxLayout.PAGE_AXIS));
		antiguos.setBackground(new Color(255, 255, 204));
		buscarpanel.setBackground(new Color(255, 255, 204));
		botones.setBackground(new Color(255, 255, 204));
		labels.setBackground(new Color(255, 255, 204));

		labels.setLayout(new GridLayout(2, 0));

		buscar = new JComboBox<String>();
		buscar.setFont(new Font("Serif", Font.BOLD, 30));

		buscar.setPreferredSize(new Dimension(275, 50));
		buscarButton.setEnabled(false);
		LeerEscribirPDA c = new LeerEscribirPDA();
		String[] aux = c.listarPDA();
		for (int i = 0; i < aux.length; i++) {
			buscar.addItem(aux[i]);
		}

		buscar.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent ie) {
				// TODO Auto-generated method stub
				JComboBox<String> nomb = (JComboBox<String>) ie.getSource();
				System.out.println(nomb.getSelectedItem().toString());
				nombre = nomb.getSelectedItem().toString();
				buscarButton.setEnabled(true);
			}

		});

		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PDA nuevo = c.leerPDA(nombre);
				new PilaIU(nuevo);

				// timer.start();

				setVisible(false);
				dispose();

			}
		});

		buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// buscar.setText("");

			}
		});
		buscarpanel.add(buscar);
		botones.add(buscarButton);
		labels.add(label1);
		labels.add(label2);
		antiguos.add(labels);
		antiguos.add(buscarpanel);
		antiguos.add(botones);

		getContentPane().add(antiguos);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
