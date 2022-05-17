package componentesGUIPrincipal;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import componentesGUILogin.Config;

public class BotaoPadrao extends JButton {

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
