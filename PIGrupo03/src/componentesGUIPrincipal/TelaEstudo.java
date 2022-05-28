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
		telaEstudar3.add(new JLabel("Tela final estudo"));

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
		});

		TelaTopico.btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CardLayout cl1 = (CardLayout) painelCentro.getLayout();
				CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

				if (indiceTopicoMostrado == 0) {
					indiceTopicoMostrado++;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());

					System.out.println(indiceTopicoMostrado);
					System.out.println(estudo.filaEstudo.size());
				}

				else if (indiceTopicoMostrado == estudo.filaEstudo.size() - 1) {
					cl1.next(painelCentro);
					atualizarBotoes(3);
					indiceTopicoMostrado = 0;
				}

				else if (indiceTopicoMostrado < estudo.filaEstudo.size() - 1) {
					indiceTopicoMostrado++;
					cl2.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
					System.out.println(indiceTopicoMostrado);
					System.out.println(estudo.filaEstudo.size());
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
		
		telaEstudar2.setBorder(new EmptyBorder(50, 0, 0, 50));

		lbNovoTopico1 = new LabelPadrao(
				"Preparamos " + controle.Main.login.getLimiteTopicosEstudo() + " novos tópicos para serem", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO);
		telaEstudar1.painelCentro.add(lbNovoTopico1);

		lbNovoTopico2 = new LabelPadrao("estudados hoje", 40, componentesGUILogin.Config.COR_FONTE_BOTAO);
		telaEstudar1.painelCentro.add(lbNovoTopico2);

		
		atualizarBotoes(1);
		
		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);

		painelCentro.add(telaEstudar1, telaEstudar1.getName());
		painelCentro.add(telaEstudar2, telaEstudar2.getName());
		painelCentro.add(telaEstudar3, telaEstudar3.getName());
	}
	
	public void atualizarBotoes(int tela) {
		buttonPanel.removeAll();
		if (tela == 1) {
			buttonPanel.add(btComecar);
		}
		else if(tela == 2) {
			buttonPanel.add(TelaTopico.btVoltar);
			buttonPanel.add(TelaTopico.btProximo);
		}
		else if(tela ==3) {
			buttonPanel.add(btVoltarInicio);
			buttonPanel.add(btRevisar);
		}
		buttonPanel.repaint();
	}
	
}
