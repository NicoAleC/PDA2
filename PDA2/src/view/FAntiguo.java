package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.LeerEscribirPDA;
import entity.Estado;
import entity.PDA;
import entity.Pila;

public class FAntiguo extends JFrame {

	String nombre;

	private JComboBox<String> buscar;
	private JButton buscarButton = new JButton("Buscar");

	public FAntiguo() {

		System.out.println("entre");
		JPanel antiguos = new JPanel();
		buscar = new JComboBox<String>();
		buscar.setFont(new Font("Serif", Font.BOLD, 20));
		buscar.setPreferredSize(new Dimension(300, 50));
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
			}
			
		});

		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PDA nuevo = c.leerPDA(nombre);
				new FPalabra(nuevo);

				// timer.start();

				setVisible(false);
				dispose();

			}
		});

		buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//buscar.setText("");

			}
		});

		antiguos.add(buscar);
		antiguos.add(buscarButton);

		getContentPane().add(antiguos);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
