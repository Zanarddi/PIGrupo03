package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JOptionPane;

import controle.Main;
import controle.Validacao;
import crud.LoginDAO;
import log.Log;

/**
 * Tela onde o usuário pode configurar seus limites de estudo/revisão, e
 * encerrar sua sessão
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaConfiguracao extends TelaPadrao {

	BotaoPadrao btVoltar, btTrocarSenha, btEncerrarSessao, btSalvar;
	PainelTextField tfLimiteTopico, tfLimiteRevisao;
	FrameTrocaSenha frameTrocaSenha;

	public TelaConfiguracao() {
		reset();
	}

	@Override
	public void reset() {
		super.reset();
		setComponents();
		setListeners();
	}
	/**
	 * Adiciona listeners aos botões da tela
	 */
	private void setListeners() {
		/**
		 * Retornar para a tela inicial
		 */
		btVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
			}
		});
		
		/**
		 * Encerrar a sessão e criar um log
		 */
		btEncerrarSessao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.iniciarFrameLogin();
				// ao fechar a janela, criar um log de fin de sessão
		        Log.encerrarSessao(Main.login.getCodigo());
			}
		});
		
		/**
		 * Salva as alterações feitas pelo usuário
		 */
		btSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String limRevisao = tfLimiteRevisao.textField.getText();
				String limEstudo = tfLimiteTopico.textField.getText();

				if (Validacao.verificaInt(limEstudo) && Validacao.verificaInt(limRevisao)) {
					if (Integer.parseInt(limEstudo) >= 0 && Integer.parseInt(limRevisao) >= 0) {
						Main.login.setLimiteTopicosEstudo(Integer.parseInt(limEstudo));
						Main.login.setLimiteTopicosRevisao(Integer.parseInt(limRevisao));
						LoginDAO loginDAO = new LoginDAO();

						JOptionPane.showMessageDialog(null, loginDAO.salvar(Main.login));
						
						Log.alterarLimiteEstudo(Main.login.getCodigo(), limEstudo);
						Log.alterarLimiteRevisao(Main.login.getCodigo(), limRevisao);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Insira valores válidos!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Insira valores válidos!");
				}
			}
		});
		
		/**
		 * Abre uma JFrame para a atualização de senha
		 */
		btTrocarSenha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameTrocaSenha = new FrameTrocaSenha();
				frameTrocaSenha.setVisible(true);
				frameTrocaSenha.btConfirmar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (frameTrocaSenha.pfSenha.getText().equals(Main.login.getSenha())) {
							if (frameTrocaSenha.pfNovaSenha1.getText().equals(frameTrocaSenha.pfNovaSenha2.getText())) {
								if (frameTrocaSenha.pfNovaSenha1.getText().isBlank()) {
									frameTrocaSenha.lbAviso.setText("Senha inválida!");
								} else {
									frameTrocaSenha.lbAviso.setText("salvar");
									Main.login.setSenha(frameTrocaSenha.pfNovaSenha1.getText());
									LoginDAO loginDAO = new LoginDAO();
									loginDAO.salvar(Main.login);
									Log.trocarSenha(Main.login.getCodigo());
									frameTrocaSenha.dispose();
								}
							} else {
								frameTrocaSenha.lbAviso.setText("Valores inválidos");
							}
						} else {
							frameTrocaSenha.lbAviso.setText("Senha incorreta!");
						}
					}
				});
			}
		});
	}

	/**
	 * inicia e adiciona componentes na tela
	 */
	private void setComponents() {
		btSalvar = new BotaoPadrao("Salvar", 0, 0, 130, 40, 24);
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		btTrocarSenha = new BotaoPadrao("Trocar Senha", 0, 0, 180, 40, 24);
		btEncerrarSessao = new BotaoPadrao("Encerrar Sessão", 0, 0, 190, 50, 24);
		btEncerrarSessao.setMargin(new Insets(0, 0, 0, 0));

		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(new LabelPadrao("Configurações", 48));
		painelCentro.add(Box.createVerticalStrut(60));

		tfLimiteTopico = new PainelTextField("Limite de novos tópicos diários:", 120);
		tfLimiteTopico.textField.setText("" + Main.login.getLimiteTopicosEstudo());
		tfLimiteRevisao = new PainelTextField("Limite de revisões diárias:", 120);
		tfLimiteRevisao.textField.setText("" + Main.login.getLimiteTopicosRevisao());

		painelCentro.add(tfLimiteTopico);
		painelCentro.add(Box.createVerticalStrut(10));
		painelCentro.add(tfLimiteRevisao);
		painelCentro.add(Box.createVerticalStrut(15));

		painelCentro.add(btSalvar);
		painelCentro.add(Box.createVerticalStrut(30));
		painelCentro.add(btTrocarSenha);

		buttonPanel.add(btEncerrarSessao);
		buttonPanel.add(btVoltar);

		painelCentro.add(Box.createVerticalStrut(100));
	}
}