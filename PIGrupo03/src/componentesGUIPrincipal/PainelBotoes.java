package componentesGUIPrincipal;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import controle.Controles;
import controle.Main;
import crud.ValidaAdm;

public class PainelBotoes extends JPanel {

	ButtonGroup bgPainel = new ButtonGroup();

	BotaoPadraoPainel btEstudar = new BotaoPadraoPainel("Estudar", 22);
	BotaoPadraoPainel btRevisar = new BotaoPadraoPainel("Revisar", 22);
	BotaoPadraoPainel btJogar = new BotaoPadraoPainel("Jogar", 22);
	BotaoPadraoPainel btProgresso = new BotaoPadraoPainel("Progresso", 22);
	BotaoPadraoPainel btConfiguracao = new BotaoPadraoPainel("Configura��o", 22);

	PainelBotoes() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(componentesGUILogin.Config.COR_BACKGROUND_ESCURA);
		setPreferredSize(new Dimension(160, 600));
		setMaximumSize(new Dimension(160, 600));
		setMinimumSize(new Dimension(160, 600));
		setBotoes();
	}

	private void setBotoes() {
		if (crud.ValidaAdm.validaAdministrador(Main.login)) {

		} else {
			add(Box.createVerticalStrut(5));
			add(btEstudar);
			add(Box.createVerticalStrut(5));
			add(btRevisar);
			add(Box.createVerticalStrut(5));
			add(btJogar);
			add(Box.createVerticalStrut(5));
			add(btProgresso);
			add(Box.createVerticalStrut(5));
			add(btConfiguracao);

			// adiciona os bot�es ao buttongroup
			adicionarBtGroup(bgPainel, btEstudar, btRevisar, btJogar, btProgresso, btConfiguracao);
		}
	}

	/**
	 * M�todo que adiciona uma quantidade variavel de botoes a um button group
	 * 
	 * @param bg     - button group
	 * @param botoes - botoes a serem adicionados
	 */
	public static void adicionarBtGroup(ButtonGroup bg, BotaoPadraoPainel... botoes) {
		for (BotaoPadraoPainel botao : botoes) {
			bg.add(botao);
		}
	}
}
