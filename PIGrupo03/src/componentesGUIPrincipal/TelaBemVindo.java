package componentesGUIPrincipal;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaBemVindo extends TelaPadrao {

	JLabel lbBemVindo;
	JLabel lbEstudo;
	JLabel lbRevisao;
	JButton btEstudar;
	JButton btRevisar;

	public TelaBemVindo() {
		super();
		setComponents();
	}

	private void setComponents() {

		painelCentro.add(Box.createVerticalStrut(40));
		
		lbBemVindo = new LabelPadrao("Bem vindo de volta " + controle.Main.login.getUsuario(), 48,
				componentesGUILogin.Config.COR_FONTE_BOTAO);
		painelCentro.add(lbBemVindo);

		painelCentro.add(Box.createVerticalStrut(40));
		
		lbEstudo = new LabelPadrao(
				"Você tem " + controle.Main.login.getLimiteTopicosEstudo() + " novos tópicos para estudar", 36);
		painelCentro.add(lbEstudo);

		painelCentro.add(Box.createVerticalStrut(40));
		
		lbRevisao = new LabelPadrao("Você tem " + controle.Main.login.getLimiteTopicosRevisao() + " novas revisões",
				36);
		painelCentro.add(lbRevisao);

		btEstudar = new BotaoPadrao("Estudar", 0, 0, 150, 50, 24);
		buttonPanel.add(btEstudar);

		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		buttonPanel.add(btRevisar);
	}
}
