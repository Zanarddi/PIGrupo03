package componentesGUILogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * Tela para a recuperação de senha dos usuários.
 * 
 * Não foi implementado.
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaRecSenha extends TelaLoginPadrao {

	BotaoPadraoLogin btEnvEmail = new BotaoPadraoLogin("Enviar Email", 18);
	BotaoPadraoLogin btVoltar = new BotaoPadraoLogin("Voltar", 18);

	JLabel lbRecSenha = new JLabel("Recuperar Senha");
	JLabel lbEmail = new JLabel("Email");
	JLabel lbDescricao1 = new JLabel("Enviaremos um email com");
	JLabel lbDescricao2 = new JLabel("a sua nova senha.");
	JLabel lbDescricao3 = new JLabel("Se não receber nada, confira sua");
	JLabel lbDescricao4 = new JLabel("caixa de spam.");

	JTextField tfEmail = new JTextField();


	public TelaRecSenha() {
		super(Config.DIMENSAO_REC_SENHA);
		setComponents();

		btVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) FrameInicial.painelPai.getLayout();
				cardLayout.show(FrameInicial.painelPai, "Login");
			}
		});
	}

	private void setComponents() {
		painelComponentes.setLayout(new BoxLayout(painelComponentes, BoxLayout.Y_AXIS));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbRecSenha);
		lbRecSenha.setFont(new Font(Config.FONTE, 0, 24));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbEmail);
		lbEmail.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(tfEmail);
		tfEmail.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfEmail.setMinimumSize(new Dimension(195, 22));
		tfEmail.setMaximumSize(new Dimension(195, 22));
		tfEmail.setPreferredSize(new Dimension(195, 22));
		tfEmail.setBackground(Config.COR_BACKGROUND);
		tfEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(btEnvEmail);
		btEnvEmail.setMinimumSize(new Dimension(195, 25));
		btEnvEmail.setMaximumSize(new Dimension(195, 25));
		btEnvEmail.setPreferredSize(new Dimension(195, 25));
		btEnvEmail.setFocusPainted(false);

		painelComponentes.add(lbDescricao1);
		lbDescricao1.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(lbDescricao2);
		lbDescricao2.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(lbDescricao3);
		lbDescricao3.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(lbDescricao4);
		lbDescricao4.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(btVoltar);
		btVoltar.setMinimumSize(new Dimension(85, 25));
		btVoltar.setMaximumSize(new Dimension(85, 25));
		btVoltar.setPreferredSize(new Dimension(85, 25));
		btVoltar.setFocusPainted(false);

		painelComponentes.add(Box.createVerticalGlue());
	}
}
