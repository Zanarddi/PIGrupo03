package componentesGUIPrincipal;

import java.awt.CardLayout;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

public class TelaEstudar extends TelaPadrao {

	TelaPadrao telaEstudar1;
	LabelPadrao lbBemVindo;
	LabelPadrao lbNovoTopico1;
	LabelPadrao lbNovoTopico2;

	public TelaEstudar() {
		painelCentro.setLayout(new CardLayout());

		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		telaEstudar1 = new TelaPadrao();

		lbBemVindo = new LabelPadrao("Bem vindo de volta", 36);
		lbNovoTopico1 = new LabelPadrao(
				"Preparamos " + controle.Main.login.getLimiteTopicosEstudo() + " novos tópicos para serem", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO);
		lbNovoTopico2 = new LabelPadrao("estudados hoje", 40, componentesGUILogin.Config.COR_FONTE_BOTAO);

		telaEstudar1.painelCentro.add(Box.createVerticalStrut(28));

		telaEstudar1.painelCentro.add(lbBemVindo);

		telaEstudar1.painelCentro.add(Box.createVerticalStrut(100));

		telaEstudar1.painelCentro.add(lbNovoTopico1);
		
		telaEstudar1.painelCentro.add(lbNovoTopico2);

		painelCentro.add(telaEstudar1, telaEstudar1.getName());

	}
}
