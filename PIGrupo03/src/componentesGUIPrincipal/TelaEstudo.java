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

/**
 * GUI por onde o usuário consegue estudar novos topicos
 * 
 * Conta com botões de navegação inferiores para alternar entre telas.
 * Essa tela faz o uso de CardLayout para mostrar os tópicos.
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaEstudo extends TelaPadrao {

	Estudo estudo;

	public static TelaPadrao telaEstudar1;
	public static TelaPadrao telaEstudar2;
	public static TelaPadrao telaEstudar3;

	BotaoPadrao btComecar;
	BotaoPadrao btProximo;
	BotaoPadrao btVoltar;
	BotaoPadrao btRevisar;
	BotaoPadrao btVoltarInicio;

	int indiceTopicoMostrado;

	public TelaEstudo() {

		painelCentro.setLayout(new CardLayout());
		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonPanel.setVisible(false);
		
		setComponents();
		setListeners();
	}

	private void setComponents() {

		telaEstudar1 = new TelaPadrao();
		telaEstudar2 = new TelaPadrao();
		telaEstudar3 = new TelaPadrao();
		
		//componentes da tela de estudo 1
		
		btComecar = new BotaoPadrao("Começar", 0, 0, 150, 50, 24);
		telaEstudar1.buttonPanel.add(btComecar);
		telaEstudar1.painelCentro.add(Box.createVerticalStrut(28));
		telaEstudar1.painelCentro.add(new LabelPadrao("Bem vindo de volta", 36));
		telaEstudar1.painelCentro.add(Box.createVerticalStrut(100));
		telaEstudar1.painelCentro.add(new LabelPadrao(
				"Preparamos " + (Main.login.getLimiteTopicosEstudo() - Main.login.getTopicosEstudados()) + " novos tópicos para serem estudados hoje", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO));

		// componentes da tela de estudo 2
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaEstudar2.buttonPanel.add(btVoltar);
		btProximo = new BotaoPadrao("Próximo", 0, 0, 150, 50, 24);
		telaEstudar2.buttonPanel.add(btProximo);
		telaEstudar2.painelCentro.setBorder(new EmptyBorder(30, 30, 0, 30));
		telaEstudar2.painelCentro.setLayout(new CardLayout());
		
		// componentes da tela de estudo 3
		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		telaEstudar3.buttonPanel.add(btRevisar);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaEstudar3.buttonPanel.add(btVoltarInicio);
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(30));
		telaEstudar3.painelCentro.add(new LabelPadrao("Parabéns!!", 36));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(100));
		telaEstudar3.painelCentro.add(new LabelPadrao("Você atingiu o limite de novos tópicos estudados por hoje.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(90));
		telaEstudar3.painelCentro.add(new LabelPadrao("Não se esqueca de fazer sua revisão.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		
		painelCentro.add(telaEstudar1, telaEstudar1.getName());
		painelCentro.add(telaEstudar2, telaEstudar2.getName());
		painelCentro.add(telaEstudar3, telaEstudar3.getName());
	}
	
	private void setListeners() {
		
		CardLayout clPrincipal = (CardLayout) painelCentro.getLayout();
		CardLayout clTopicos = (CardLayout) telaEstudar2.painelCentro.getLayout();
		
		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Main.login.getLimiteTopicosEstudo() > Main.login.getTopicosEstudados()) {	
					
					estudo = new Estudo();
					
					for (Topico topico : estudo.filaEstudo) {
						// ao adicionar a tela ao cardlayout, o index é o codigo do tópico
						telaEstudar2.painelCentro.add(topico.getTela(), "" + topico.getCodigo());
					}

					// quando for feito o show, é preciso buscar o index a partir do tópico que está
					// na fila de estudo, a sequencia que será mostrado é então ditada pela
					// sequência do array fila estudo

					if (estudo.filaEstudo.isEmpty()) {
						clPrincipal.last(painelCentro);
					}
					else {
					indiceTopicoMostrado = 1;
					clPrincipal.next(painelCentro);	
					}
				}
				if (Main.login.getLimiteTopicosEstudo() <= Main.login.getTopicosEstudados()) {
					clPrincipal.last(painelCentro);
				}

			}
		});

		btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TopicoDAO topicoDAO = new TopicoDAO();

				if (indiceTopicoMostrado == 0) {
					if (estudo.filaEstudo.isEmpty()) {
						clPrincipal.next(painelCentro);
						
					} else {
						
						clTopicos.show(telaEstudar2.painelCentro,
								"" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
						indiceTopicoMostrado++;
						System.out.println("test");
						System.out.println(indiceTopicoMostrado);
						System.out.println(estudo.filaEstudo.size());
						
					}
				}
				else if (indiceTopicoMostrado == estudo.filaEstudo.size()) {
					for (Topico t : estudo.filaEstudo) {
						t.setProficiencia(1);
						controle.Main.login.setTopicosEstudados(controle.Main.login.getTopicosEstudados() + 1);

						System.out.println(controle.Main.login.getTopicosEstudados() + " topicos estudados");
						System.out.println(t.getProficiencia() + " profciencia de " + t.getCodigo());
					}
					
					topicoDAO.salvarProficiencia(estudo.filaEstudo);
					
					clPrincipal.next(painelCentro);
					System.out.println(estudo.filaEstudo.size() + "tamanho da fila de estudo");
				}

				else if (indiceTopicoMostrado < estudo.filaEstudo.size()) {
					indiceTopicoMostrado++;
					clTopicos.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
			}
		});

		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (indiceTopicoMostrado == 1) {
					clPrincipal.previous(painelCentro);
				} else if (indiceTopicoMostrado == estudo.filaEstudo.size()) {

					indiceTopicoMostrado--;
					clTopicos.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				} else if (indiceTopicoMostrado < estudo.filaEstudo.size()) {
					indiceTopicoMostrado--;
					clTopicos.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
				System.out.println(indiceTopicoMostrado);
				System.out.println(estudo.filaEstudo.size());
			}

		});
		btRevisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btRevisar.setSelected(true);
			}
		});

		btVoltarInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
			}
		});
	}
}
