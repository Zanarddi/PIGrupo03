package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	BotaoPadrao btComecar;
	BotaoPadrao btProximo;
	BotaoPadrao btVoltar;

	List<String> topicos = new ArrayList<String>();
	int indiceTopicoMostrado = 1;

	public TelaEstudo() {

		telaEstudar1 = new TelaPadrao();

		telaEstudar2 = new TelaPadrao();
		telaEstudar2.painelCentro.setLayout(new CardLayout());
		telaEstudar2.painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));

		telaEstudar3 = new TelaPadrao();
		telaEstudar3.add(new JLabel("Tela final estudo"));

		painelCentro.setLayout(new CardLayout());

		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));

		// o painel de botoes nao sera utilizado neste sub painel
		telaEstudar1.buttonPanel.setVisible(false);

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
					topicos.add("" + topico.getCodigo());
				}

				CardLayout cl = (CardLayout) painelCentro.getLayout();

				// quando for feito o show, é preciso buscar o index a partir do tópico que está
				// na fila de estudo, a sequencia que será mostrado é então ditada pela
				// sequência do array fila estudo
				// esse é o primeiro tópico
				cl.next(painelCentro);

				buttonPanel.remove(btComecar);
				buttonPanel.add(TelaTopico.btVoltar);
				buttonPanel.add(TelaTopico.btProximo);

			}
		});

		TelaTopico.btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CardLayout cl1 = (CardLayout) painelCentro.getLayout();
				CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

				if (indiceTopicoMostrado < topicos.size()) {
					cl2.next(telaEstudar2.painelCentro);
				}
				if (indiceTopicoMostrado == topicos.size()) {
					cl1.next(painelCentro);
				}
				if (indiceTopicoMostrado == 0) {

				}
				System.out.println(indiceTopicoMostrado);
				System.out.println(topicos.size());
			}
		});

		TelaTopico.btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl1 = (CardLayout) painelCentro.getLayout();
				CardLayout cl2 = (CardLayout) telaEstudar2.painelCentro.getLayout();

				if (indiceTopicoMostrado < topicos.size()) {
					cl2.previous(telaEstudar2.painelCentro);
				}
				if (indiceTopicoMostrado == topicos.size()) {
					cl1.previous(painelCentro);
				}
				if (indiceTopicoMostrado == 0) {
					cl1.previous(painelCentro);
				}

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
		painelCentro.add(telaEstudar2, telaEstudar2.getName());
		painelCentro.add(telaEstudar3, telaEstudar3.getName());

		btComecar = new BotaoPadrao("Começar", 0, 0, 150, 50, 24);
		this.buttonPanel.add(btComecar);
	}
}
