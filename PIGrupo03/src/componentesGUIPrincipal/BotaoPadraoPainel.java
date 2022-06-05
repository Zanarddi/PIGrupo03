package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import componentesGUILogin.Config;

/**
 * Botão padrão utilizado para popular o painel lateral de navegação entre telas
 * do programa principal
 * 
 * @author Gustavo Zanardi
 *
 */
public class BotaoPadraoPainel extends JToggleButton {

	// Inset para mudar margem dos botões, usado para ajustar tamanho dos textos
	static final Insets MARGEM_BOTAO = new Insets(2, 0, 2, 0);

	String texto;
	int tamFonte;

	public TelaPadrao painel;

	/**
	 * Cria um botão para ser adicionado no painel da tela principal
	 * 
	 * @param texto
	 * @param tamFonte
	 */
	BotaoPadraoPainel(String texto, int tamFonte, TelaPadrao painel) {
		this.painel = painel;
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
		setMargin(MARGEM_BOTAO);
	}

	// sobrescreve clase que altera a cor do botão quando pressionado
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
			g.drawString(texto, (w - g.getFontMetrics().stringWidth(texto)) / 2 + 1,
					(h + g.getFontMetrics().getAscent()) / 2 - 1);
		}
	}

	/**
	 * reseta uma tela dependendo do tipo do seu layout e o tipo da tela
	 * 
	 * @param bt - botão presente no painel de botões da lateral esquerda
	 */
	//
	public static void resetaTelaa(BotaoPadraoPainel bt) {
		if (bt.painel.painelCentro.getLayout() instanceof CardLayout) {
			CardLayout cardLayout = (CardLayout) bt.painel.painelCentro.getLayout();
			cardLayout.first(bt.painel.painelCentro);
			if (bt.equals(PainelBotoes.btEstudar)) {
				//TelaEstudo.indiceTopicoMostrado = 0;
			}
		}
	}

}
