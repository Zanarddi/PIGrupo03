package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import modelo.Estudo;
import modelo.Topico;

public class TelaEstudar extends TelaPadrao {

	Estudo estudo;

	static TelaPadrao telaEstudar1;

	LabelPadrao lbBemVindo;
	LabelPadrao lbNovoTopico1;
	LabelPadrao lbNovoTopico2;

	BotaoPadrao btProximo;
	BotaoPadrao btVoltar;

	public TelaEstudar() {
		
		telaEstudar1 = new TelaPadrao();
		
		painelCentro.setLayout(new CardLayout());

		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		

		// o painel de bootes nao sera utilizado neste sub painel
		telaEstudar1.buttonPanel.setVisible(false);

		setComponents();
		setListeners();

	}

	private void setListeners() {
		btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				estudo = new Estudo();

				for (Topico topico : estudo.filaEstudo) {
					topico.criarTela();
					painelCentro.add(topico.getTela(), topico.getCodigo());
				}

				CardLayout cl = (CardLayout) painelCentro.getLayout();
				cl.show(painelCentro, "" + estudo.filaEstudo.get(1).getCodigo());
			}
		});
	}

	private void setComponents() {

		telaEstudar1.painelCentro.add(Box.createVerticalStrut(28));

		lbBemVindo = new LabelPadrao("Bem vindo de volta", 36);
		telaEstudar1.painelCentro.add(lbBemVindo);

		telaEstudar1.painelCentro.add(Box.createVerticalStrut(100));

		lbNovoTopico1 = new LabelPadrao(
				"Preparamos " + controle.Main.login.getLimiteTopicosEstudo() + " novos tópicos para serem", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO);
		telaEstudar1.painelCentro.add(lbNovoTopico1);

		lbNovoTopico2 = new LabelPadrao("estudados hoje", 40, componentesGUILogin.Config.COR_FONTE_BOTAO);
		telaEstudar1.painelCentro.add(lbNovoTopico2);

		painelCentro.add(telaEstudar1, telaEstudar1.getName());

		btProximo = new BotaoPadrao("Começar", 0, 0, 150, 50, 24);
		this.buttonPanel.add(btProximo);
	}
}
