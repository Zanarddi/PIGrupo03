package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Dimension;
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
 * Painel de navegação entre telas que utiliza de botões do tipo ToggleButton
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
	static BotaoPadraoPainel btMantemTopico;

	PainelBotoes() {
		btEstudar = new BotaoPadraoPainel("Estudar", 22, new TelaEstudo());
		btRevisar = new BotaoPadraoPainel("Revisar", 22, new TelaRevisao());
		btJogar = new BotaoPadraoPainel("Jogar", 22, new TelaJogo());
		btProgresso = new BotaoPadraoPainel("Progresso", 22, new TelaProgresso());
		btConfiguracao = new BotaoPadraoPainel("Configuração", 22, new TelaConfiguracao());
		btMantemTopico = new BotaoPadraoPainel("Topicos", 22, new TelaGerenciarBanco());
		

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(componentesGUILogin.Config.COR_BACKGROUND_ESCURA);
		setPreferredSize(new Dimension(160, 600));
		setMaximumSize(new Dimension(160, 600));
		setMinimumSize(new Dimension(160, 600));

		botoes = new ArrayList<BotaoPadraoPainel>();
		setBotoes();

		/**
		 * Adiciona os action listeners para os botões,
		 * mostrando a tela correta quando são pressionados os botões
		 */
		for (BotaoPadraoPainel botao : botoes) {
			botao.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
						cardLayout.show(FramePrincipal.painelPrincipal, botao.texto);
						botao.painel.reset();
					} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					}
				}
			});
		}
	}

	/**
	 * popula o painel com os botões
	 * os botões são diferentes para diferentes tipos de usuários
	 */
	private void setBotoes() {
		// verifica se o usuario é adm ou não
		if (Main.login.getTipo() == 1) {
			adicionarBotoesBG(bgPainel, botoes, btMantemTopico);
		} else if (Main.login.getTipo() == 0){
			// adiciona os botões no buttongroup e no array de botoes
			adicionarBotoesBG(bgPainel, botoes, btEstudar, btRevisar, btJogar, btProgresso, btConfiguracao);
		}
		// adiciona os botoes no painel
		for (BotaoPadraoPainel botao : botoes) {
			add(Box.createVerticalStrut(5));
			add(botao);
		}
	}

	/**
	 * Adiciona uma quantidade variavel de botoes em um button group e a
	 * um array de botoes
	 * 
	 * @param bg           - button group
	 * @param botoesPainel - array de botoes
	 * @param botoes       - botoes a serem adicionados
	 */
	private void adicionarBotoesBG(ButtonGroup bg, List<BotaoPadraoPainel> botoesPainel,
			BotaoPadraoPainel... botoes) {
		for (BotaoPadraoPainel botao : botoes) {
			bg.add(botao);
			botoesPainel.add(botao);
		}
	}
}