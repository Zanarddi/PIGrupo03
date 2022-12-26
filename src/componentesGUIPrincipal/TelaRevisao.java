package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import controle.Main;
import crud.TopicoDAO;
import log.Log;
import modelo.Revisao;
import modelo.Topico;

/**
 * Tela que permite a realização das revisões
 * Apresenta ao usuário diversas perguntas com respostas de multipla escolha
 * 
 * @author Gustavo Zanardi
 *
 */
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
	
	int indicePerguntaMostrada;

	public TelaRevisao() {
		reset();
	}

	@Override
	public void reset() {
		super.reset();
		
		painelCentro.setLayout(new CardLayout());
		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonPanel.setVisible(false);

		setComponents();
		setListeners();
	}

	/**
	 * Inicia, configura e adiciona os componentes na tela
	 */
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
	
	/**
	 * Aciciona listeners aos botões da tela
	 */
	private void setListeners() {
		
		CardLayout clPrincipal = (CardLayout) painelCentro.getLayout();
		CardLayout clPerguntas = (CardLayout) telaRevisao2.painelCentro.getLayout();

		/**
		 * Inicia uma sessão de revisão e distribui as perguntas na tela
		 */
		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Main.login.getLimiteTopicosRevisao() > Main.login.getTopicosRevisados()) {	
					
					revisao = new Revisao();
					
					for (Topico topico : revisao.filaRevisao) {
						// ao adicionar a tela ao cardlayout, o index é o codigo do tópico
						telaRevisao2.painelCentro.add(topico.getTelaPergunta(), "" + topico.getCodigo());
					}

					// quando for feito o show, é preciso buscar o index a partir do tópico que está
					// na fila de estudo, a sequencia que será mostrado é então ditada pela
					// sequencia do array fila estudo

					if (revisao.filaRevisao.isEmpty()) {
						clPrincipal.last(painelCentro);
					}
					else {
					indicePerguntaMostrada = 0;
					clPrincipal.next(painelCentro);	
					}
				}
				if (Main.login.getLimiteTopicosRevisao() <= Main.login.getTopicosRevisados()) {
					clPrincipal.last(painelCentro);
				}
			}
		});

		/**
		 * Listener do botão que navega entre as perguntas
		 */
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (indicePerguntaMostrada == 0) {
					clPrincipal.previous(painelCentro);
				} else if (indicePerguntaMostrada == revisao.filaRevisao.size()-1) {

					indicePerguntaMostrada--;
					clPerguntas.show(telaRevisao2.painelCentro, "" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
				} else if (indicePerguntaMostrada < revisao.filaRevisao.size()-1) {
					indicePerguntaMostrada--;
					clPerguntas.show(telaRevisao2.painelCentro, "" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
				}
				System.out.println(indicePerguntaMostrada);
				System.out.println(revisao.filaRevisao.size());
			}

			
		});

		/**
		 * Listener do botão que navega entre as perguntas
		 */
		btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TopicoDAO topicoDAO = new TopicoDAO();

				if (indicePerguntaMostrada == revisao.filaRevisao.size() - 1) {
					for (Topico t : revisao.filaRevisao) {
						// verifica se o usuário acertou ou não a pergunta
						for (RadioButtonPadrao bt : t.getTelaPergunta().grupoRespostas) {
							if (bt.isSelected()) {
								if (bt.tipo == 1) {
									t.setProficiencia(t.getProficiencia() + 1);
								} else if (bt.tipo == 0) {
									if (t.getProficiencia() > 1) {
										t.setProficiencia(t.getProficiencia() - 1);
									}
								}
							}
						}
						controle.Main.login.setTopicosEstudados(controle.Main.login.getTopicosEstudados() + 1);
					}
					topicoDAO.salvarProficiencia(revisao.filaRevisao);
					Log.finalizarRevisao(Main.login.getCodigo(), revisao.filaRevisao);
					clPrincipal.next(painelCentro);
				} else if (indicePerguntaMostrada == 0) {
					if (revisao.filaRevisao.isEmpty()) {
						clPrincipal.next(painelCentro);
					} else {
						indicePerguntaMostrada++;
						clPerguntas.show(telaRevisao2.painelCentro,
								"" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
					}
				} else if (indicePerguntaMostrada < revisao.filaRevisao.size() - 1) {
					indicePerguntaMostrada++;
					clPerguntas.show(telaRevisao2.painelCentro,
							"" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
				}
			}
		});
		
		/**
		 * Retorna para a tela de beoas vindas
		 */
		btVoltarInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
				clPrincipal.first(painelCentro);
			}
		});
		/**
		 * Inicia a tela de jogar.
		 */
		btJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btJogar.setSelected(true);
				clPrincipal.first(painelCentro);
			}
		});
	}
}
