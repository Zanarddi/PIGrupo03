package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.border.EmptyBorder;

import controle.Main;
import crud.TopicoDAO;
import log.Log;
import modelo.Estudo;
import modelo.Topico;

/**
 * GUI por onde o usu�rio consegue estudar novos topicos
 * 
 * Conta com bot�es de navega��o inferiores para alternar entre telas.
 * Essa tela faz o uso de CardLayout para mostrar os t�picos.
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
		reset();
	}

	@Override
	public void reset(){
		super.reset();
		
		painelCentro.setLayout(new CardLayout());
		painelCentro.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonPanel.setVisible(false);
		
		setComponents();
		setListeners();
	}
	
	/**
	 * inicia, configura e adiciona componentes na tela
	 */
	private void setComponents() {

		telaEstudar1 = new TelaPadrao();
		telaEstudar2 = new TelaPadrao();
		telaEstudar3 = new TelaPadrao();
		
		//componentes da tela de estudo 1
		
		btComecar = new BotaoPadrao("Come�ar", 0, 0, 150, 50, 24);
		telaEstudar1.buttonPanel.add(btComecar);
		telaEstudar1.painelCentro.add(Box.createVerticalStrut(28));
		telaEstudar1.painelCentro.add(new LabelPadrao("Bem vindo de volta", 36));
		telaEstudar1.painelCentro.add(Box.createVerticalStrut(100));
		telaEstudar1.painelCentro.add(new LabelPadrao(
				"Preparamos " + (Main.login.getLimiteTopicosEstudo() - Main.login.getTopicosEstudados()) + " novos t�picos para serem estudados hoje", 40,
				componentesGUILogin.Config.COR_FONTE_BOTAO));

		// componentes da tela de estudo 2
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaEstudar2.buttonPanel.add(btVoltar);
		btProximo = new BotaoPadrao("Pr�ximo", 0, 0, 150, 50, 24);
		telaEstudar2.buttonPanel.add(btProximo);
		telaEstudar2.painelCentro.setBorder(new EmptyBorder(30, 30, 0, 30));
		telaEstudar2.painelCentro.setLayout(new CardLayout());
		
		// componentes da tela de estudo 3
		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		telaEstudar3.buttonPanel.add(btRevisar);
		btVoltarInicio = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		telaEstudar3.buttonPanel.add(btVoltarInicio);
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(30));
		telaEstudar3.painelCentro.add(new LabelPadrao("Parab�ns!!", 36));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(100));
		telaEstudar3.painelCentro.add(new LabelPadrao("Voc� atingiu o limite de novos t�picos estudados por hoje.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));
		telaEstudar3.painelCentro.add(Box.createVerticalStrut(90));
		telaEstudar3.painelCentro.add(new LabelPadrao("N�o se esqueca de fazer sua revis�o.", 40, componentesGUILogin.Config.COR_FONTE_BOTAO));

		//adiciona as telas no painel principal (cardLayout)
		painelCentro.add(telaEstudar1, telaEstudar1.getName());
		painelCentro.add(telaEstudar2, telaEstudar2.getName());
		painelCentro.add(telaEstudar3, telaEstudar3.getName());
	}
	
	/**
	 * Cria os listeners para os bot�es das telas
	 */
	private void setListeners() {
		
		// Variaveis de cardlayout para facilitar a manipula��o dos mesmos
		CardLayout clPrincipal = (CardLayout) painelCentro.getLayout();				// Layout principal
		CardLayout clTopicos = (CardLayout) telaEstudar2.painelCentro.getLayout();	// Layout onde s�o exibidos os t�picos
		
		/**
		 * Inicia uma sess�o de estudos e distribui os t�picos na tela
		 */
		btComecar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Main.login.getLimiteTopicosEstudo() > Main.login.getTopicosEstudados()) {	
					estudo = new Estudo();
					for (Topico topico : estudo.filaEstudo) {
						// ao adicionar a tela ao cardlayout, o index � o codigo do t�pico
						// adiciona as telas no painel
						telaEstudar2.painelCentro.add(topico.getTela(), "" + topico.getCodigo());
					}

					// quando for feito o show, � preciso buscar o index a partir do t�pico que est�
					// na fila de estudo, a sequencia que ser� mostrado � ent�o ditada pela
					// sequ�ncia do array fila estudo
					
					
					if (estudo.filaEstudo.isEmpty()) {
						// "pula" a tela com os t�picos
						clPrincipal.last(painelCentro);
					}
					else {
					indiceTopicoMostrado = 0;
					clPrincipal.next(painelCentro);	
					clTopicos.first(telaEstudar2.painelCentro);
					}
				}
				//Situa��o onde o usu�rio j� estudou mais do que o limite permite
				if (Main.login.getLimiteTopicosEstudo() <= Main.login.getTopicosEstudados()) {
					clPrincipal.last(painelCentro);
				}
			}
		});

		/**
		 * Listener do bot�o que navega entre os t�picos
		 */
		btProximo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TopicoDAO topicoDAO = new TopicoDAO();

				if (indiceTopicoMostrado == estudo.filaEstudo.size() - 1) {
					for (Topico t : estudo.filaEstudo) {
						t.setProficiencia(1);
						controle.Main.login.setTopicosEstudados(controle.Main.login.getTopicosEstudados() + 1);
					}
					topicoDAO.salvarProficiencia(estudo.filaEstudo);

					Log.finalizarEstudo(Main.login.getCodigo(), estudo.filaEstudo);

					clPrincipal.next(painelCentro);
					System.out.println(estudo.filaEstudo.size() + "tamanho da fila de estudo");
				} else if (indiceTopicoMostrado == 0) {
					if (estudo.filaEstudo.isEmpty()) {
						clPrincipal.next(painelCentro);
					} else {
						indiceTopicoMostrado++;
						clTopicos.show(telaEstudar2.painelCentro,
								"" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
					}
				} else if (indiceTopicoMostrado < estudo.filaEstudo.size() - 1) {
					indiceTopicoMostrado++;
					clTopicos.show(telaEstudar2.painelCentro,
							"" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
			}
		});

		/**
		 * Listener do bot�o que navega entre os t�picos
		 */
		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (indiceTopicoMostrado == 0) {
					clPrincipal.previous(painelCentro);
				} else if (indiceTopicoMostrado == estudo.filaEstudo.size()-1) {
					indiceTopicoMostrado--;
					clTopicos.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				} else if (indiceTopicoMostrado < estudo.filaEstudo.size()-1) {
					indiceTopicoMostrado--;
					clTopicos.show(telaEstudar2.painelCentro, "" + estudo.filaEstudo.get(indiceTopicoMostrado).getCodigo());
				}
			}
		});
		/**
		 * Bot�o que leva para a tela de revis�es
		 */
		btRevisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btRevisar.setSelected(true);
			}
		});

		/**
		 * Retorna para a tela de boas vindas
		 */
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
