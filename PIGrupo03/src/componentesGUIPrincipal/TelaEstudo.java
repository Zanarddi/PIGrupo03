package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import controle.Main;
import crud.TopicoDAO;
import modelo.Estudo;
import modelo.Topico;

public class TelaEstudo extends TelaPadrao {

	Estudo estudo = new Estudo();;

	static TelaPadrao telaEstudar1, telaEstudar2, telaEstudar3;

	LabelPadrao lbBemVindo;
	LabelPadrao lbNovoTopico1;
	LabelPadrao lbNovoTopico2;
	static BotaoPadrao btComecar = new BotaoPadrao("Começar", 0, 0, 150, 50, 24);;
	BotaoPadrao btRevisar;
	BotaoPadrao btVoltarInicio;

	static int indiceTopicoMostrado = 0;

	public TelaEstudo() {

		telaEstudar1 = new TelaPadrao();

		telaEstudar2 = new TelaPadrao();
		telaEstudar2.painelCentro.setLayout(new CardLayout());

		telaEstudar3 = new TelaPadrao();

		// o painel de botoes nao sera utilizado nestes sub paineis
		telaEstudar1.buttonPanel.setVisible(false);
		telaEstudar2.buttonPanel.setVisible(false);
		telaEstudar3.buttonPanel.setVisible(false);

		painelCentro.setLayout(new CardLayout());
		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));

		setComponents();
		setListeners();

	}

	private void setListeners() {
		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Main.login.getLimiteTopicosEstudo() > Main.login.getTopicosEstudados()) {	
					
					estudo.atualizarFilaEstudo();

					for (Topico topico : estudo.filaEstudo) {
						topico.criarTela();
						// ao adicionar a tela ao cardlayout, o index é o codigo do tópico
						telaEstudar2.painelCentro.add(topico.getTela(), "" + topico.getCodigo());
					}

					CardLayout cl = (CardLayout) painelCentro.getLayout();
					CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

					// quando for feito o show, é preciso buscar o index a partir do tópico que está
					// na fila de estudo, a sequencia que será mostrado é então ditada pela
					// sequência do array fila estudo

					cl.next(painelCentro);

					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());

					atualizarBotoes(2);
					
				}
				if (Main.login.getLimiteTopicosEstudo() <= Main.login.getTopicosEstudados()) {

					CardLayout cl = (CardLayout) painelCentro.getLayout();
					cl.last(painelCentro);
					atualizarBotoes(3);
					
				}

			}
		});

		TelaTopico.btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TopicoDAO topicoDAO = new TopicoDAO();
				
				CardLayout cl1 = (CardLayout) painelCentro.getLayout();
				CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

				if (indiceTopicoMostrado == 0) {
					indiceTopicoMostrado++;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());

				}
				else if (indiceTopicoMostrado == estudo.filaEstudo.size() - 1) {
					indiceTopicoMostrado = 0;
					for (Topico t : estudo.filaEstudo) {
						t.setProficiencia(1);
						controle.Main.login.setTopicosEstudados(controle.Main.login.getTopicosEstudados() + 1);

						System.out.println(controle.Main.login.getTopicosEstudados() + " topicos estudados");
						System.out.println(t.getProficiencia() + " profciencia de " + t.getCodigo());
						
						//utilizar quando o banco for implementado
						//topicoDAO.salvarProficiencia(t);
					}
					estudo.filaEstudo.clear();
					telaEstudar2.painelCentro.removeAll();
					cl1.next(painelCentro);
					atualizarBotoes(3);
					System.out.println(estudo.filaEstudo.size() + "tamanho da fila de estudo");
				}

				else if (indiceTopicoMostrado < estudo.filaEstudo.size() - 1) {
					indiceTopicoMostrado++;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
			}
		});

		TelaTopico.btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl1 = (CardLayout) painelCentro.getLayout();
				CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

				if (indiceTopicoMostrado == 0) {
					cl1.previous(painelCentro);
					atualizarBotoes(1);
				} else if (indiceTopicoMostrado == estudo.filaEstudo.size() - 1) {

					indiceTopicoMostrado--;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				} else if (indiceTopicoMostrado < estudo.filaEstudo.size() - 1) {
					indiceTopicoMostrado--;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
				System.out.println(indiceTopicoMostrado);
				System.out.println(estudo.filaEstudo.size());
			}

		});
		btRevisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btRevisar.setSelected(true);
				atualizarBotoes(1);
			}
		});

		btVoltarInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
				atualizarBotoes(1);
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
		
		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		
		atualizarBotoes(1);
		
		telaEstudar2.setBorder(new EmptyBorder(50, 0, 0, 50));

		telaEstudar3.painelCentro.add(Box.createVerticalStrut(30));
		telaEstudar3.painelCentro.add(new LabelPadrao("Parabéns!!", 36));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(100));
		telaEstudar3.painelCentro.add(new LabelPadrao("Você atingiu o limite de novos tópicos", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaEstudar3.painelCentro.add(new LabelPadrao("estudados por hoje.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(90));
		telaEstudar3.painelCentro.add(new LabelPadrao("Não se esqueca de fazer sua revisão.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		painelCentro.add(telaEstudar1, telaEstudar1.getName());
		painelCentro.add(telaEstudar2, telaEstudar2.getName());
		painelCentro.add(telaEstudar3, telaEstudar3.getName());
	}

	public void atualizarBotoes(int tela) {
		buttonPanel.removeAll();
		if (tela == 1) {
			buttonPanel.add(btComecar);
		} else if (tela == 2) {
			buttonPanel.add(TelaTopico.btVoltar);
			buttonPanel.add(TelaTopico.btProximo);
		} else if (tela == 3) {
			buttonPanel.add(btVoltarInicio);
			buttonPanel.add(btRevisar);
		}
		buttonPanel.repaint();
	}

}
