package componentesGUILogin;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controle.Validacao;
import crud.LoginDAO;
import crud.TopicoDAO;
import log.Log;
import modelo.Login;

/**
 * Tela utilizada para o registro de novos usuários.
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaRegistro extends TelaLoginPadrao {

	BotaoPadraoLogin btRegistrar = new BotaoPadraoLogin("Registrar", 18);

	JLabel lbRegistrar = new JLabel("Registrar");
	JLabel lbEmail = new JLabel("Email");
	JLabel lbUsuario = new JLabel("Usuário");
	JLabel lbSenha = new JLabel("Senha");
	JLabel lbRepSenha = new JLabel("Repita a senha");
	JLabel lbLogin1 = new JLabel("Já tem uma conta?");
	JLabel lbLogin2 = new JLabel("Login");

	JTextField tfEmail = new JTextField();
	JTextField tfUsuario = new JTextField();
	JPasswordField tfSenha = new JPasswordField();
	JPasswordField tfRepSenha = new JPasswordField();

	public TelaRegistro() {
		super(Config.DIMENSAO_REGISTRAR);
		setComponents();
		setListeners();
		
	}

	private void criarRegistro(){
		if(Validacao.validaCamposRegistro(tfEmail.getText(), tfUsuario.getText(), tfSenha.getText(), tfRepSenha.getText())) {
			Login l = new Login(tfUsuario.getText(), tfEmail.getText(), tfSenha.getText());
			
			LoginDAO loginDAO = new LoginDAO();
			TopicoDAO topicoDAO = new TopicoDAO();
			ArrayList<Integer> topicos = new ArrayList<Integer>();
			
			JOptionPane.showMessageDialog(null, loginDAO.registrarUsuario(l));
			Log.registroUsuario(l);
			
			topicos = topicoDAO.listarTopicos();
			l = crud.LoginDAO.validarLogin(l.getUsuario(), l.getSenha());
			topicoDAO.inserirProficiencia(topicos, l.getCodigo());
			Log.criarProficiencia(l.getCodigo(), topicos);
		}
	}
	
	private void setListeners() {
		
		btRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				criarRegistro();
			}
		});
		
		
		
		lbLogin2.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) FrameInicial.painelPai.getLayout();
				cardLayout.show(FrameInicial.painelPai, "Login");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
	}
	
	private void setComponents() {
		painelComponentes.setLayout(new BoxLayout(painelComponentes, BoxLayout.Y_AXIS));

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbRegistrar);
		lbRegistrar.setFont(new Font(Config.FONTE, 0, 24));

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

		painelComponentes.add(tfSenha);
		tfSenha.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfSenha.setMinimumSize(new Dimension(195, 22));
		tfSenha.setMaximumSize(new Dimension(195, 22));
		tfSenha.setPreferredSize(new Dimension(195, 22));
		tfSenha.setBackground(Config.COR_BACKGROUND);
		tfSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		painelComponentes.add(lbRepSenha);
		lbRepSenha.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(tfRepSenha);
		tfRepSenha.setAlignmentX(Component.LEFT_ALIGNMENT); // corrige o alinhamento da caixa de texto
		tfRepSenha.setMinimumSize(new Dimension(195, 22));
		tfRepSenha.setMaximumSize(new Dimension(195, 22));
		tfRepSenha.setPreferredSize(new Dimension(195, 22));
		tfRepSenha.setBackground(Config.COR_BACKGROUND);
		tfRepSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // retira a borda do text field

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(btRegistrar);
		btRegistrar.setMinimumSize(new Dimension(195, 25));
		btRegistrar.setMaximumSize(new Dimension(195, 25));
		btRegistrar.setPreferredSize(new Dimension(195, 25));
		btRegistrar.setFocusPainted(false);

		painelComponentes.add(Box.createVerticalGlue());

		painelComponentes.add(lbLogin1);
		lbLogin1.setFont(new Font(Config.FONTE, 0, 12));

		painelComponentes.add(lbLogin2);
		lbLogin2.setFont(new Font(Config.FONTE, 0, 12));
		lbLogin2.setForeground(Config.COR_FONTE_BOTAO_LABEL);
		lbLogin2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		painelComponentes.add(Box.createVerticalGlue());
	}

}
