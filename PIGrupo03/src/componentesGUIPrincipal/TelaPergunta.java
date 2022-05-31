package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import modelo.Pergunta;
import modelo.Resposta;

public class TelaPergunta extends TelaPadrao {

	JPanel painelPreto;

	ArrayList<JRadioButton> btRespostas;
	
	ButtonGroup bg = new ButtonGroup();

	public TelaPergunta(Pergunta p) {

		buttonPanel.setVisible(false);

		painelCentro.setBorder(new EmptyBorder(20, 20, 0, 20));

		painelPreto = new JPanel();
		painelPreto.setBackground(Color.BLACK);
		painelPreto.setBorder(BorderFactory.createLineBorder(componentesGUILogin.Config.COR_BACKGROUND_ESCURA, 5));


		painelCentro.add(painelPreto);
		painelCentro.add(Box.createVerticalStrut(20));
		
		btRespostas = new ArrayList<JRadioButton>();
		for (int i = 0; i < 4; i++) {
			btRespostas.add(new JRadioButton("TESTE"));
			btRespostas.get(i).setBackground(painelCentro.getBackground());
			btRespostas.get(i).setText("<html>" + "TESTE" + i + "</html>");
			btRespostas.get(i).setFont(new Font(componentesGUILogin.Config.FONTE, 0, 24));
			btRespostas.get(i).setForeground(Color.BLACK);
			btRespostas.get(i).setFocusable(false);
			
			bg.add(btRespostas.get(i));
			painelCentro.add(btRespostas.get(i));
		}

	}
}
