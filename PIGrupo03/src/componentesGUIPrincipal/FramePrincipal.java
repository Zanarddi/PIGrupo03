package componentesGUIPrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.Main;
import log.Log;
import modelo.Login;

/**
 * Frame principal do programa, onde s�o mostradas as diversas funcionalidades
 * do sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class FramePrincipal extends JFrame {

	public static PainelBotoes painelBotoes;
	public static TelaBemVindo telaBemVindo;
	public static JPanel painelPrincipal;

	public FramePrincipal(Login l) {

		// configura��es da JFrame
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores n�o "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		
		// A opera��o default para fechar a frame n�o ser� dispose, e sim a especificada abaixo (cria��o do log)
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	// ao fechar a janela, criar um log de fin de sess�o
		        Log.encerrarSessao(Main.login.getCodigo());
		        System.exit(0);
		    }
		});
		setLayout(new BorderLayout());
		
		painelBotoes = new PainelBotoes();
		painelPrincipal = new JPanel();
		telaBemVindo = new TelaBemVindo();
		
		painelBotoes.setVisible(true);
		painelPrincipal.setLayout(new CardLayout());
		
		add(painelBotoes, BorderLayout.WEST);
		add(painelPrincipal);
		if(l.getTipo() == 0)
		painelPrincipal.add(telaBemVindo, "telaBemVindo");
		// adiciona os paineis correspondentes dos botoes ao cardlayout
		for (BotaoPadraoPainel botao : PainelBotoes.botoes) {
			painelPrincipal.add(botao.painel, botao.texto);
		}
	}
}