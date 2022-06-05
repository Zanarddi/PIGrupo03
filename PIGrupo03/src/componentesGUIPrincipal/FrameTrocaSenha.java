package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import componentesGUILogin.Config;

public class FrameTrocaSenha extends JFrame {

	BotaoPadrao btConfirmar;
	LabelPadrao lbAviso;
	JPasswordField pfSenha, pfNovaSenha1, pfNovaSenha2;
	
	public FrameTrocaSenha() {
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(Config.COR_BACKGROUND_ESCURA);
		this.getRootPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.getRootPane().setBorder(new EmptyBorder(10, 10, 10, 10));
		
		pfSenha = new JPasswordField();
		pfNovaSenha1 = new JPasswordField();
		pfNovaSenha2 = new JPasswordField();
		
		btConfirmar = new BotaoPadrao("Confirmar", 0, 0, 60, 40, 24);
		
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.getRootPane().add(new LabelPadrao("Troca de Senha.", 20), c);
		c.gridy = 1;
		this.getRootPane().add(new LabelPadrao("Senha antiga:", 20, Color.WHITE), c);
		c.gridy = 2;
		this.getRootPane().add(pfSenha, c);
		c.gridy = 3;
		this.getRootPane().add(new LabelPadrao("Senha nova:", 20, Color.WHITE), c);
		c.gridy = 4;
		this.getRootPane().add(pfNovaSenha1, c);
		c.gridy = 5;
		this.getRootPane().add(new LabelPadrao("Repita a nova senha:", 20, Color.WHITE), c);
		c.gridy = 6;
		this.getRootPane().add(pfNovaSenha2, c);
		c.gridy = 7;
		//area rigida que define também a largura da frame
		this.getRootPane().add(Box.createRigidArea(new Dimension(300,10)), c);
		c.gridy = 8;
		lbAviso = new LabelPadrao("", 20, Color.RED);
		this.getRootPane().add(lbAviso, c);
		c.gridy = 9;
		this.getRootPane().add(Box.createVerticalStrut(10), c);
		c.gridy = 10;
		this.getRootPane().add(btConfirmar, c);
		
		this.pack();

	}
}
