package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelPadrao extends JLabel{
	
	public LabelPadrao (String texto, int tamanho, Color cor) {
		setText(texto);
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
		setForeground(cor);
	}
	
	public LabelPadrao (String texto, int tamanho) {
		setText(texto);
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
	}

}
