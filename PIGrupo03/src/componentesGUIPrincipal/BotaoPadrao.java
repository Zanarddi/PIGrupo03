package componentesGUIPrincipal;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import componentesGUILogin.Config;

/**
 * Bot�o padr�o para utiliza��o geral nas telas principais da aplica��o
 * 
 * @author Gustavo Zanardi
 *
 */
public class BotaoPadrao extends JButton {

	/**
	 * Cria um bot�o com caracter�sticas espec�ficas
	 * 
	 * @param texto - do bot�o
	 * @param x - posi��o x do bot�o
	 * @param y - posi��o y do bot�o
	 * @param largura - do bot�o
	 * @param altura - do bot�o
	 * @param tamFonte - do texto
	 */
	public BotaoPadrao(String texto, int x, int y, int largura, int altura, int tamFonte) {
		setBounds(x, y, largura, altura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
		setText(texto);
		setMinimumSize(new Dimension(largura, altura));
		setMaximumSize(new Dimension(largura, altura));
		setPreferredSize(new Dimension(largura, altura));
	}
}
