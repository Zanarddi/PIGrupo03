package componentesGUILogin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Trata-se de um botão configurável, com um padrão
 * estabelecido para as telas relacionadas ao login
 * 
 * @author Gustavo Zanardi
 *
 */
public class BotaoPadraoLogin extends JButton {

	/**
	 *
	 * @param titulo - Texto do botão
	 * @param tamFonte - Fonte do texto do botão
	 */
	public BotaoPadraoLogin(String titulo, int tamFonte) {
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(titulo);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}

	/**
	 * 
	 * @param texto - do login
	 * @param x - posição x
	 * @param y - posição y
	 * @param altura - do botão
	 * @param largura - do botão
	 * @param tamFonte - do texto do botão
	 */
	public BotaoPadraoLogin(String texto, int x, int y, int altura, int largura, int tamFonte) {
		setBounds(x, y, largura, altura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(texto);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}

	/**
	 * 
	 * @param texto - do login
	 * @param x - posição x
	 * @param y - posição y
	 * @param altura - do botão
	 * @param largura - do botão
	 * @param tamFonte - do texto do botão
	 * @param corFonte - do texto do botão
	 */
	public BotaoPadraoLogin(String texto, int x, int y, int altura, int largura, int tamFonte, Color cor, Color corFonte) {
		setBounds(x, y, largura, altura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(texto);
		setBackground(cor);
		setForeground(corFonte);
	}
}
