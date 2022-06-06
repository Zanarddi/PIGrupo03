package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import controle.CalculoProficiencia;
import controle.Main;
import crud.TopicoDAO;
import modelo.Estudo;
import modelo.Revisao;
import modelo.Topico;

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
		btComecar = new BotaoPadrao("Come�ar", 0, 0, 150, 50, 24);
		telaRevisao1.buttonPanel.add(btComecar);
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(28));
		telaRevisao1.painelCentro.add(new LabelPadrao("N�o desista!", 36));
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(100));
		telaRevisao1.painelCentro.add(new LabelPadrao(
				"Voc� tem " + (controle.Main.login.getLimiteTopicosRevisao() - Main.login.getTopicosRevisados())
						+ " revis�es pendentes!!", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaRevisao1.painelCentro.add(Box.createVerticalStrut(30));
		telaRevisao1.painelCentro.add(new LabelPadrao("Hora de relembrar", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		//componentes da tela de revis�o 2
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaRevisao2.buttonPanel.add(btVoltar);
		btProximo = new BotaoPadrao("Pr�ximo", 0, 0, 150, 50, 24);
		telaRevisao2.buttonPanel.add(btProximo);
		telaRevisao2.painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		telaRevisao2.painelCentro.setLayout(new CardLayout());
		
		//componentes da tela de revis�o 3
		btJogar = new BotaoPadrao("Jogar", 0, 0, 150, 50, 24);
		telaRevisao3.buttonPanel.add(btJogar);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaRevisao3.buttonPanel.add(btVoltarInicio);
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(28));
		telaRevisao3.painelCentro.add(new LabelPadrao("Parab�ns!", 36));
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(100));
		telaRevisao3.painelCentro.add(new LabelPadrao("Voc� atingiu o limite de revis�es por hoje", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaRevisao3.painelCentro.add(Box.createVerticalStrut(130));
		telaRevisao3.painelCentro.add(new LabelPadrao("Que tal jogar um jogo?", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		
		painelCentro.add(telaRevisao1, telaRevisao1.getName());
		painelCentro.add(telaRevisao2, telaRevisao2.getName());
		painelCentro.add(telaRevisao3, telaRevisao3.getName());

	}
	
	private void setListeners() {
		
		CardLayout clPrincipal = (CardLayout) painelCentro.getLayout();
		CardLayout clPerguntas = (CardLayout) telaRevisao2.painelCentro.getLayout();

		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Main.login.getLimiteTopicosRevisao() > Main.login.getTopicosRevisados()) {	
					
					revisao = new Revisao();
					
					for (Topico topico : revisao.filaRevisao) {
						// ao adicionar a tela ao cardlayout, o index � o codigo do t�pico
						telaRevisao2.painelCentro.add(topico.getTelaPergunta(), "" + topico.getCodigo());
					}

					// quando for feito o show, � preciso buscar o index a partir do t�pico que est�
					// na fila de estudo, a sequencia que ser� mostrado � ent�o ditada pela
					// sequ�ncia do array fila estudo

					if (revisao.filaRevisao.isEmpty()) {
						clPrincipal.last(painelCentro);
					}
					else {
					indicePerguntaMostrada = 1;
					clPrincipal.next(painelCentro);	
					}
				}
				if (Main.login.getLimiteTopicosRevisao() <= Main.login.getTopicosRevisados()) {
					clPrincipal.last(painelCentro);
				}

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

				TopicoDAO topicoDAO = new TopicoDAO();

				if (indicePerguntaMostrada == 0) {
					if (revisao.filaRevisao.isEmpty()) {
						clPrincipal.next(painelCentro);
					} else {

						clPerguntas.show(telaRevisao2.painelCentro,
								"" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
						indicePerguntaMostrada++;
						System.out.println(indicePerguntaMostrada);
						System.out.println(revisao.filaRevisao.size());

					}
				} else if (indicePerguntaMostrada == revisao.filaRevisao.size()) {
					for (Topico t : revisao.filaRevisao) {
						// verifica se o usu�rio acertou ou n�o a pergunta
						for (RadioButtonPadrao bt : t.getTelaPergunta().grupoRespostas) {
							if (bt.isSelected()) {
								if (bt.tipo == 1) {
									t.setProficiencia(t.getProficiencia() + 1);
									JOptionPane.showMessageDialog(null, "Certo");
								} else if (bt.tipo == 0) {
									if (t.getProficiencia() > 1) {
										t.setProficiencia(t.getProficiencia() - 1);
									}
									JOptionPane.showMessageDialog(null, "Errado");
								}
							}
						}

						controle.Main.login.setTopicosEstudados(controle.Main.login.getTopicosEstudados() + 1);

						System.out.println(controle.Main.login.getTopicosEstudados() + " topicos estudados");
						System.out.println(t.getProficiencia() + " profciencia de " + t.getCodigo());
					}

					topicoDAO.salvarProficiencia(revisao.filaRevisao);
					
					clPrincipal.next(painelCentro);
					System.out.println(revisao.filaRevisao.size() + "tamanho da fila de revisao");
				}
				else if (indicePerguntaMostrada < revisao.filaRevisao.size()) {
					indicePerguntaMostrada++;
					clPerguntas.show(telaRevisao2.painelCentro, "" + revisao.filaRevisao.get(indicePerguntaMostrada).getCodigo());
				}		
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
