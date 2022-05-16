package componentesGUIPrincipal;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	List<BotaoPadraoPainel> botoesPainel;

	ButtonGroup bgPainel = new ButtonGroup();

	BotaoPadraoPainel btEstudar;
	BotaoPadraoPainel btRevisar;
	BotaoPadraoPainel btJogar;
	BotaoPadraoPainel btProgresso;
	BotaoPadraoPainel btConfiguracao;

	PainelBotoes() {
		btEstudar = new BotaoPadraoPainel("Estudar", 22, new TelaEstudar());
		btRevisar = new BotaoPadraoPainel("Revisar", 22, new TelaRevisar());
		btJogar = new BotaoPadraoPainel("Jogar", 22, new TelaJogar());
		btProgresso = new BotaoPadraoPainel("Progresso", 22, new TelaProgresso());
		btConfiguracao = new BotaoPadraoPainel("Configuração", 22, new TelaConfiguracao());

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(componentesGUILogin.Config.COR_BACKGROUND_ESCURA);
		setPreferredSize(new Dimension(160, 600));
		setMaximumSize(new Dimension(160, 600));
		setMinimumSize(new Dimension(160, 600));

		botoesPainel = new ArrayList<BotaoPadraoPainel>();
		setBotoes();
		
		for(BotaoPadraoPainel botao : botoesPainel) {
			botao.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed (ActionEvent e) {
					System.out.println(botao.getText());
					controle.Main.telaPrincipal.painelPrincipal.add(botao.painel);
					System.out.println(controle.Main.telaPrincipal.getContentPane().getComponentCount());
				}
			});
		}
	}

	private void setBotoes() {
		if (crud.LoginDAO.validaAdministrador(Main.login)) {

		} else {
			// adiciona os botões no buttongroup e no array de botoes
			adicionarBotoesBG(bgPainel, botoesPainel, btEstudar, btRevisar, btJogar, btProgresso, btConfiguracao);
		}

		// adiciona os botoes no painel
		for (BotaoPadraoPainel botao : botoesPainel) {
			add(Box.createVerticalStrut(5));
			add(botao);
		}
	}

	/**
	 * Método que adiciona uma quantidade variavel de botoes em um butto group e a
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
