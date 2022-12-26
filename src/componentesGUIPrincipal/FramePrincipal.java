package componentesGUIPrincipal;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.Main;
import log.Log;
import modelo.Login;

/**
 * Frame principal do programa, onde são mostradas as diversas funcionalidades
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

		// configurações da JFrame
		setTitle("PI Grupo 03");
		setBounds(0, 0, 1016, 639); // valores não "fechados" pois a frame nao acomoda todo o painel
		setLocationRelativeTo(null); // faz a frame inicar no centro da tela
		setResizable(false);
		
		// A operação default para fechar a frame não será dispose, e sim a especificada abaixo (criação do log)
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	// ao fechar a janela, criar um log de fin de sessão
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