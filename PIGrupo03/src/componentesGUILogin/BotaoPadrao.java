package componentesGUILogin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * Classe que herda de JButton.
 * Trata-se de um botão configurável, com um padrão
 * estabelecido para as telas relacionadas ao login
 * 
 * @author Gustavo Zanardi
 *
 */
public class BotaoPadrao extends JButton {

	public BotaoPadrao(String titulo, int tamFonte) {
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(titulo);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}

	public BotaoPadrao(String texto, int x, int y, int altura, int largura, int tamFonte) {
		setBounds(x, y, altura, largura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(texto);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}

	public BotaoPadrao(String texto, int x, int y, int altura, int largura, int tamFonte, Color cor, Color corFonte) {
		setBounds(x, y, altura, largura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(texto);
		setBackground(cor);
		setForeground(corFonte);
	}
}
