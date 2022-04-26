package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToggleButton;

import componentesGUILogin.Config;


public class BotaoPadraoPainel extends JToggleButton {

	String texto;
	int tamFonte;
	
	/**
	 * Cria um bot�o para ser adicionado no painel da tela principal
	 * @param texto
	 * @param tamFonte
	 */
	BotaoPadraoPainel(String texto, int tamFonte) {
		this.texto = texto;
		this.tamFonte = tamFonte;
		setBounds(0, 0, 150, 100);
		setPreferredSize(Config.DIMENSAO_BOTAO_PAINEL);
		setMaximumSize(Config.DIMENSAO_BOTAO_PAINEL);
		setMinimumSize(Config.DIMENSAO_BOTAO_PAINEL);
		setFont(new Font(Config.FONTE, Font.BOLD, tamFonte));
		setText(texto);
		setBackground(Config.COR_BOTAO);
		setForeground(Color.WHITE);
		setAlignmentX(CENTER_ALIGNMENT);
		setFocusPainted(false);
	}
	
	//sobrescreve clase que altera a cor do bot�o quando pressionado
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (this.isSelected()) {
		    int w = getWidth();
		    int h = getHeight();
		    g.setFont(new Font(Config.FONTE, Font.BOLD, tamFonte));
		    g.setColor(Config.COR_BOTAO_PRESSIONADO); // selected color
		    g.fillRect(0, 0, w, h);
		    g.setColor(Color.WHITE); // selected foreground color
		    g.drawString(texto, (w - g.getFontMetrics().stringWidth(texto))/2 + 1, (h + g.getFontMetrics().getAscent())/2 - 1);
		}
	}
}
