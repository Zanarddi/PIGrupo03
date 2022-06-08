package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

import componentesGUILogin.Config;

/**
 * RadioButton padr�o, utilizado para o controle de respostas na revis�o Conta
 * com um texto e um tipo, que determina se a resposta � correta ou errada
 * 
 * @author Gustavo Zanardi
 *
 */
public class RadioButtonPadrao extends JRadioButton {

	String texto;

	int tipo;

	/**
	 * cria um radiobutton para respostas
	 * 
	 * @param texto - do radiobutton
	 * @param tipo  - de resposta, 0 para errado e 1 para certo
	 */
	public RadioButtonPadrao(String texto, int tipo) {
		this.texto = texto;
		this.tipo = tipo;

		setBackground(Config.COR_BACKGROUND);
		setText("<html>" + texto + "</html>");
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, 24));
		setForeground(Color.BLACK);
		setFocusable(false);
	}
}
