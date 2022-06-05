package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import controle.Main;
import modelo.Revisao;

public class TelaRevisao extends TelaPadrao {

	Revisao revisao;
	
	public static TelaPadrao telaRevisao1;
	public static TelaPadrao telaRevisao2;
	public static TelaPadrao telaRevisao3;

	BotaoPadrao btComecar;
	BotaoPadrao btProximo;
	BotaoPadrao btVoltar;
	BotaoPadrao btJogar;
	BotaoPadrao btVoltarInicio;

	public TelaRevisao() {

		painelCentro.setLayout(new CardLayout());
		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonPanel.setVisible(false);

		setComponents();
		setListeners();
	}

	private void setComponents() {

		telaRevisao1 = new TelaPadrao();
		telaRevisao2 = new TelaPadrao();
		telaRevisao3 = new TelaPadrao();

		//componentes da tela de revisao 1
		btComecar = new BotaoPadrao("Começar", 0, 0, 150, 50, 24);
		telaRevisao1.buttonPanel.add(btComecar);
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(28));
		telaRevisao1.painelCentro.add(new LabelPadrao("Não desista!", 36));
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(100));
		telaRevisao1.painelCentro.add(new LabelPadrao(
				"Você tem " + (controle.Main.login.getLimiteTopicosRevisao() - Main.login.getTopicosRevisados())
						+ " revisões pendentes!!", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(30));
		telaRevisao1.painelCentro.add(new LabelPadrao("Hora de relembrar", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		//componentes da tela de revisão 2
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaRevisao2.buttonPanel.add(btVoltar);
		btProximo = new BotaoPadrao("Próximo", 0, 0, 150, 50, 24);
		telaRevisao2.buttonPanel.add(btProximo);
		telaRevisao2.painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		telaRevisao2.painelCentro.setLayout(new CardLayout());
		telaRevisao2.painelCentro.add(new TelaPergunta(null));
		
		//componentes da tela de revisão 3
		btJogar = new BotaoPadrao("Jogar", 0, 0, 150, 50, 24);
		telaRevisao3.buttonPanel.add(btJogar);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaRevisao3.buttonPanel.add(btVoltarInicio);
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(28));
		telaRevisao3.painelCentro.add(new LabelPadrao("Parabéns!", 36));
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(100));
		telaRevisao3.painelCentro.add(new LabelPadrao("Você atingiu o limite de revisões por hoje", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(130));
		telaRevisao3.painelCentro.add(new LabelPadrao("Que tal jogar um jogo?", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		
		painelCentro.add(telaRevisao1, telaRevisao1.getName());
		painelCentro.add(telaRevisao2, telaRevisao2.getName());
		painelCentro.add(telaRevisao3, telaRevisao3.getName());

	}
	
	private void setListeners() {
		
		CardLayout clPrincipal = (CardLayout) painelCentro.getLayout();
		CardLayout clTopicos = (CardLayout) telaRevisao2.painelCentro.getLayout();

		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clPrincipal.next(painelCentro);
			}
		});

		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clPrincipal.previous(painelCentro);

			}
		});

		btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clPrincipal.next(painelCentro);
			}
		});
		
		btVoltarInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
				clPrincipal.first(painelCentro);
			}
		});
		btJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btJogar.setSelected(true);
				clPrincipal.first(painelCentro);
			}
		});
	}
}
