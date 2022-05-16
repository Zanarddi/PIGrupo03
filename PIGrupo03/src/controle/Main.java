package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import componentesGUILogin.TelaInicial;
import componentesGUIPrincipal.TelaPrincipal;
import modelo.Login;

public class Main {

	// duas principais frames do projeto
	public static TelaInicial telaInicial;
	public static TelaPrincipal telaPrincipal;
	
	public static Login login;
	public static int limiteTopicosEstudo;

	public static void main(String[] args) {
		iniciarFrameLogin();
	}
	
	/**
	 * Método que inicia a frame de login (inicial), e fecha a tela principal caso
	 * ela esteja aberta
	 */
	public static void iniciarFrameLogin() {
		telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
		if (telaPrincipal != null)
			telaPrincipal.dispose();
	}

	/**
	 * Método que inicia a frame principal e fecha a tela de login caso ela esteja
	 * aberta
	 * @param usuario - usuario validado
	 * @param senha - senha validada
	 */
	public static void iniciarFramePrincipal() {
		telaPrincipal = new TelaPrincipal(login);
		controle.Main.telaPrincipal.setVisible(true);
		TelaPrincipal.painelBotoes.btEstudar.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					
					//por algum motivo o comando simplesmente nao é executado.
					telaPrincipal.add(TelaPrincipal.painelBotoes.btEstudar.painel);
					
					
					System.out.println("apertado");
					System.out.println(controle.Main.telaPrincipal);
			      } else if(e.getStateChange()==ItemEvent.DESELECTED){
			    	  System.out.println("desapertado");
			      }
				
			}
		});
		
		if (telaInicial != null)
			telaInicial.dispose();
	}
}
