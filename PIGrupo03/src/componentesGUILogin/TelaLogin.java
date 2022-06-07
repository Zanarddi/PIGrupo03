package componentesGUILogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import modelo.Login;

/**
 * Tela de login, com campos para a realização do login. Permite a navegação
 * entre as telas de registro e recuperação de senha
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaLogin extends TelaLoginPadrao {

	BotaoPadraoLogin btLogin = new BotaoPadraoLogin("Login", 18);

	JTextField tfUsuario = new JTextField();

	JPasswordField tfSenha = new JPasswordField();

	JLabel lbvalidaLogin = new JLabel("");
	JLabel lbLogin = new JLabel("Login");
	JLabel lbUsuario = new JLabel("Usuário");
	JLabel lbSenha = new JLabel("Senha");
	JLabel lbRecSenha = new JLabel("Esqueci minha senha");
	JLabel lbCadastrar1 = new JLabel("Ainda não tem uma conta?");
	JLabel lbCadastrar2 = new JLabel("Cadastrar");

	public TelaLogin() {
		super(Config.DIMENSAO_LOGIN);
		setComponents();
		setListeners();
	}

	private void setListeners() {
		// adiciona um mouseListener para a label de recuperação de senha
		lbRecSenha.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) FrameInicial.painelPai.getLayout();
				cardLayout.show(FrameInicial.painelPai, "Recuperar");
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		// adiciona um mouseListener para a label de cadastro
		lbCadastrar2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) FrameInicial.painelPai.getLayout();
				cardLayout.show(FrameInicial.painelPai, "Registrar");
			}
			// por se tratar de uma interface, todos os metodos devem ser implementados
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		btLogin.addActionListener(new ActionListener() {
			/**
			 * ao clicar no botão de logar, verifica se os campos estão preenchidos, caso
			 * não estejam, emite um aviso em forma de label para o usuario
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//apenas para teste
				/*
				Login l = crud.LoginDAO.validarLogin("zanardi", "1234");
				if (l != null) {
					controle.Main.login = l;
					controle.Main.iniciarFramePrincipal();
				}
				*/
				
				if (validarCampos()) {
					//valida as credenciais passadas pelo usuario
					Login l = crud.LoginDAO.validarLogin(tfUsuario.getText(), tfSenha.getText());
					if (l != null) {
						controle.Main.login = l;
						controle.Main.iniciarFramePrincipal();
					} else {
						//label muda para uma mensagem de aviso em caso de login inválido
						lbvalidaLogin.setForeground(Color.RED);
						lbvalidaLogin.setText("Usuário ou senha errados");
					}
				} else {
					//label muda para uma mensagem de aviso em caso de login inválido
					lbvalidaLogin.setForeground(Color.RED);
					lbvalidaLogin.setText("Campos inválidos");
				}
				
				
			}
		});
	}
	
	/**
	 * método que adiciona e organiza os componentes no painel de componentes
	 */
	private void setComponents() {
		painelComponentes.setLayout(new BoxLayout(painelComponentes, BoxLayout.Y_AXIS));

		lbLogin.setFont(new Font(Config.FONTE, 0, 24));

		lbUsuario.setFont(new Font(Config.FONTE, 0, 12));

		tfUsuario.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfUsuario.setMinimumSize(new Dimension(195, 22));
		tfUsuario.setMaximumSize(new Dimension(195, 22));
		tfUsuario.setPreferredSize(new Dimension(195, 22));
		tfUsuario.setBackground(Config.COR_BACKGROUND);
		tfUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		lbSenha.setFont(new Font(Config.FONTE, 0, 12));

		tfSenha.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfSenha.setMinimumSize(new Dimension(195, 22));
		tfSenha.setMaximumSize(new Dimension(195, 22));
		tfSenha.setPreferredSize(new Dimension(195, 22));
		tfSenha.setBackground(Config.COR_BACKGROUND);
		tfSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		btLogin.setMinimumSize(new Dimension(195, 25));
		btLogin.setMaximumSize(new Dimension(195, 25));
		btLogin.setPreferredSize(new Dimension(195, 25));
		btLogin.setFocusPainted(false);
		
		lbRecSenha.setFont(new Font(Config.FONTE, 0, 12));
		lbRecSenha.setForeground(Config.COR_FONTE_BOTAO_LABEL);
		lbRecSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // muda o cursor ao passar pelo componente

		lbCadastrar1.setFont(new Font(Config.FONTE, 0, 12));

		lbCadastrar2.setFont(new Font(Config.FONTE, 0, 12));
		lbCadastrar2.setForeground(Config.COR_FONTE_BOTAO_LABEL);
		lbCadastrar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		painelComponentes.add(Box.createVerticalGlue());
		painelComponentes.add(lbLogin);
		painelComponentes.add(Box.createVerticalGlue());
		painelComponentes.add(lbUsuario);
		painelComponentes.add(tfUsuario);
		painelComponentes.add(lbSenha);
		painelComponentes.add(tfSenha);
		painelComponentes.add(Box.createVerticalGlue());
		painelComponentes.add(btLogin);
		painelComponentes.add(lbvalidaLogin);
		painelComponentes.add(Box.createVerticalGlue());
		painelComponentes.add(lbRecSenha);
		painelComponentes.add(Box.createVerticalGlue());
		painelComponentes.add(lbCadastrar1);
		painelComponentes.add(lbCadastrar2);
		painelComponentes.add(Box.createVerticalGlue());
	}
	/**
	 * verifica se os campos da tela de login foram preenchidos
	 * 
	 * @return - true para preenchimento correto e false para preenchimento
	 *         incorreto
	 */
	private boolean validarCampos() {
		boolean ret;
		if (tfUsuario.getText().isBlank() || tfSenha.getText().isBlank()) {
			ret = false;
		} else if (tfUsuario.getText().isEmpty() || tfSenha.getText().isEmpty()) {
			ret = false;
		} else {
			ret = true;
		}
		return ret;
	}
}
