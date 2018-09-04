package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class EnPila extends JPanel {
		boolean puntero=false;
		
		String text;

		public EnPila(boolean  puntero, String text) {
			this.puntero=puntero;
			
			this.text=text;
			JLabel label= new JLabel (text);
			add(label);
		
			setPreferredSize(new Dimension(20 , 10));
			setBorder(new LineBorder(Color.BLACK));
		
		}

	}