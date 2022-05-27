package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import controle.Main;

/**
 * Painel de navega��o entre telas que utiliza de bot�es do tipo ToggleButton
 * 
 * @author Gustavo Zanardi
 *
 */
public class PainelBotoes extends JPanel {

	public static List<BotaoPadraoPainel> botoes;

	static ButtonGroup bgPainel = new ButtonGroup();

	static BotaoPadraoPainel btEstudar;
	static BotaoPadraoPainel btRevisar;
	static BotaoPadraoPainel btJogar;
	static BotaoPadraoPainel btProgresso;
	static BotaoPadraoPainel btConfiguracao;

	PainelBotoes() {
		btEstudar = new BotaoPadraoPainel("Estudar", 22, new TelaEstudo());
		btRevisar = new BotaoPadraoPainel("Revisar", 22, new TelaRevisao());
		btJogar = new BotaoPadraoPainel("Jogar", 22, new TelaJogo());
		btProgresso = new BotaoPadraoPainel("Progresso", 22, new TelaProgresso());
		btConfiguracao = new BotaoPadraoPainel("Configura��o", 22, new TelaConfiguracao());

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(componentesGUILogin.Config.COR_BACKGROUND_ESCURA);
		setPreferredSize(new Dimension(160, 600));
		setMaximumSize(new Dimension(160, 600));
		setMinimumSize(new Dimension(160, 600));

		botoes = new ArrayList<BotaoPadraoPainel>();
		setBotoes();

		for (BotaoPadraoPainel botao : botoes) {
			botao.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
						cardLayout.show(FramePrincipal.painelPrincipal, botao.texto);
					} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					}

				}
			});
		}
		ItemListener[] a = btRevisar.getItemListeners();
		System.out.println("quantia" + a.length);
	}

	private void setBotoes() {
		//verifica se o usuario � adm ou n�o
		if (crud.LoginDAO.validaAdministrador(Main.login)) {

		} else {
			// adiciona os bot�es no buttongroup e no array de botoes
			adicionarBotoesBG(bgPainel, botoes, btEstudar, btRevisar, btJogar, btProgresso, btConfiguracao);
		}

		// adiciona os botoes no painel
		for (BotaoPadraoPainel botao : botoes) {
			add(Box.createVerticalStrut(5));
			add(botao);
		}
	}

	/**
	 * M�todo que adiciona uma quantidade variavel de botoes em um butto group e a
	 * um array de botoes
	 * 
	 * @param bg           - button group
	 * @param botoesPainel - array de botoes
	 * @param botoes       - botoes a serem adicionados
	 */
	public static void adicionarBotoesBG(ButtonGroup bg, List<BotaoPadraoPainel> botoesPainel,
			BotaoPadraoPainel... botoes) {
		for (BotaoPadraoPainel botao : botoes) {
			bg.add(botao);
			botoesPainel.add(botao);
		}
	}
}
