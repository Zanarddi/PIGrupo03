package componentesGUIPrincipal;

import java.awt.CardLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controle.Main;
import controle.Validacao;
import crud.LoginDAO;

public class TelaConfiguracao extends TelaPadrao{

	BotaoPadrao btVoltar, btTrocarSenha, btEncerrarSessao, btSalvar;
	PainelTextField tfLimiteTopico, tfLimiteRevisao;
	
	public TelaConfiguracao(){
		
		setComponents();
		setListeners();
	}
	
	private void setListeners(){
		
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
				
				if(Validacao.verificaInt(limEstudo) && Validacao.verificaInt(limRevisao)) {
					if(Integer.parseInt(limEstudo) >= 0 && Integer.parseInt(limRevisao) >=0) {
						Main.login.setLimiteTopicosEstudo(Integer.parseInt(limEstudo));
						Main.login.setLimiteTopicosRevisao(Integer.parseInt(limRevisao));
						System.out.println(Main.login.getLimiteTopicosEstudo());
						System.out.println(Main.login.getLimiteTopicosRevisao());
						LoginDAO loginDAO = new LoginDAO();
						
						JOptionPane.showMessageDialog(null, loginDAO.salvar(Main.login));
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Insira valores válidos!");
				}
			}
		});
		btTrocarSenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				frame.setVisible(true);
				
			}
		});
		
	}
	
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
