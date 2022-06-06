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

/**
 * Tela onde o usu�rio pode configurar seus limites de estudo/revis�o, e encerrar sua sess�o
 * @author Gustavo Zanardi
 *
 */
public class TelaConfiguracao extends TelaPadrao {

	BotaoPadrao btVoltar, btTrocarSenha, btEncerrarSessao, btSalvar;
	PainelTextField tfLimiteTopico, tfLimiteRevisao;
	FrameTrocaSenha frameTrocaSenha;

	public TelaConfiguracao() {
		setComponents();
		setListeners();
	}

	private void setListeners() {

		btVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) FramePrincipal.painelPrincipal.getLayout();
				cardLayout.show(FramePrincipal.painelPrincipal, "telaBemVindo");
				PainelBotoes.bgPainel.clearSelection();
			}
		});
		
		btEncerrarSessao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.iniciarFrameLogin();
			}
		});
		
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
					}
					else {
						JOptionPane.showMessageDialog(null, "Insira valores v�lidos!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Insira valores v�lidos!");
				}
			}
		});
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
									frameTrocaSenha.lbAviso.setText("Senha inv�lida!");
								} else {
									frameTrocaSenha.lbAviso.setText("salvar");
									Main.login.setSenha(frameTrocaSenha.pfNovaSenha1.getText());
									LoginDAO loginDAO = new LoginDAO();
									loginDAO.salvar(Main.login);
									frameTrocaSenha.dispose();
								}
							} else {
								frameTrocaSenha.lbAviso.setText("Valores inv�lidos");
							}
						} else {
							frameTrocaSenha.lbAviso.setText("Senha incorreta!");
						}

					}
				});

			}
		});

	}

	private void setComponents() {
		btSalvar = new BotaoPadrao("Salvar", 0, 0, 130, 40, 24);
		btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);
		btTrocarSenha = new BotaoPadrao("Trocar Senha", 0, 0, 180, 40, 24);
		btEncerrarSessao = new BotaoPadrao("Encerrar Sess�o", 0, 0, 190, 50, 24);
		btEncerrarSessao.setMargin(new Insets(0, 0, 0, 0));

		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(new LabelPadrao("Configura��es", 48));
		painelCentro.add(Box.createVerticalStrut(60));

		tfLimiteTopico = new PainelTextField("Limite de novos t�picos di�rios:", 120);
		tfLimiteTopico.textField.setText("" + Main.login.getLimiteTopicosEstudo());
		tfLimiteRevisao = new PainelTextField("Limite de revis�es di�rias:", 120);
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
