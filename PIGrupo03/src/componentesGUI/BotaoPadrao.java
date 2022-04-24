package componentesGUI;

import java.awt.Font;

import javax.swing.JButton;


public class BotaoPadrao extends JButton {
	
	public BotaoPadrao(String titulo, int tamFonte) {
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(titulo);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}

	public BotaoPadrao(String titulo, int x, int y, int altura, int largura, int tamFonte) {
		setBounds(x, y, altura, largura);
		setFont(new Font(Config.FONTE, Font.PLAIN, tamFonte));
		setText(titulo);
		setBackground(Config.COR_BOTAO);
		setForeground(Config.COR_FONTE_BOTAO);
	}	
}
