package componentesGUIPrincipal;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import componentesGUILogin.Config;

/**
 * Botão padrão para utilização geral nas telas principais da aplicação
 * 
 * @author Gustavo Zanardi
 *
 */
public class BotaoPadrao extends JButton {

	/**
	 * Cria um botão com características específicas
	 * 
	 * @param texto - do botão
	 * @param x - posição x do botão
	 * @param y - posição y do botão
	 * @param largura - do botão
	 * @param altura - do botão
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
