package componentesGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TelaLogin extends TelaLoginPadrao {

	BotaoPadrao btLogin = new BotaoPadrao("Login", 18);

	JTextField tfUsuario = new JTextField();

	JPasswordField jpfSenha = new JPasswordField();

	JLabel lbLogin = new JLabel("Login");
	JLabel lbUsuario = new JLabel("Usuário");
	JLabel lbSenha = new JLabel("Senha");
	JLabel lbRecSenha = new JLabel("Esqueci minha senha");
	JLabel lbCadastrar1 = new JLabel("Ainda não tem uma conta?");
	JLabel lbCadastrar2 = new JLabel("Cadastrar");

	public TelaLogin() {
		super(Config.DIMENSAO_LOGIN);
		setComponents();

		// adiciona um mouseListener para a label de recuperação de senha
		lbRecSenha.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) TelaInicial.painelPai.getLayout();
				cardLayout.show(TelaInicial.painelPai, "Recuperar");
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

		// adiciona um mouseListener para a label de cadastro
		lbCadastrar2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) TelaInicial.painelPai.getLayout();
				cardLayout.show(TelaInicial.painelPai, "Registrar");
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
	}

	/**
	 * metodo que adiciona e organiza os componentes no painel de componentes
	 */
	private void setComponents() {
		painelComponentes.setLayout(new BoxLayout(painelComponentes, BoxLayout.Y_AXIS));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbLogin);
		lbLogin.setFont(new Font(Config.FONTE, 0, 24));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbUsuario);
		lbUsuario.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(tfUsuario);
		tfUsuario.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfUsuario.setMinimumSize(new Dimension(195, 22));
		tfUsuario.setMaximumSize(new Dimension(195, 22));
		tfUsuario.setPreferredSize(new Dimension(195, 22));
		tfUsuario.setBackground(Config.COR_BACKGROUND);
		tfUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		painelComponentes.add(lbSenha);
		lbSenha.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(jpfSenha);
		jpfSenha.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		jpfSenha.setMinimumSize(new Dimension(195, 22));
		jpfSenha.setMaximumSize(new Dimension(195, 22));
		jpfSenha.setPreferredSize(new Dimension(195, 22));
		jpfSenha.setBackground(Config.COR_BACKGROUND);
		jpfSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(btLogin);
		btLogin.setMinimumSize(new Dimension(195, 25));
		btLogin.setMaximumSize(new Dimension(195, 25));
		btLogin.setPreferredSize(new Dimension(195, 25));
		btLogin.setFocusPainted(false);

		painelComponentes.add(Box.createVerticalGlue());
		
		painelComponentes.add(lbRecSenha);
		lbRecSenha.setFont(new Font(Config.FONTE, 0, 12));
		lbRecSenha.setForeground(Config.COR_FONTE_BOTAO_LABEL);
		lbRecSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // muda o cursor ao passar pelo componente

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbCadastrar1);
		lbCadastrar1.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(lbCadastrar2);
		lbCadastrar2.setFont(new Font(Config.FONTE, 0, 12));
		lbCadastrar2.setForeground(Config.COR_FONTE_BOTAO_LABEL);
		lbCadastrar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		painelComponentes.add(Box.createVerticalGlue());
	}
}
