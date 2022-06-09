package componentesGUIPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * GUI mostrada ao usuário quando ele faz o login, é como uma página home
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaBemVindo extends TelaPadrao {

	JLabel lbBemVindo;
	JLabel lbEstudo;
	JLabel lbRevisao;
	JButton btEstudar;
	JButton btRevisar;

	public TelaBemVindo() {
		reset();
	}
	
	@Override
	public void reset() {
		super.reset();
		setComponents();
		setListeners();
	}
	
	/**
	 * adiciona os listeners para os botões da tela
	 */
	private void setListeners() {
		btEstudar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btEstudar.setSelected(true);
			}
		});
		btRevisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelBotoes.btRevisar.setSelected(true);
			}
		});
	}
	
	/**
	 * adiciona componestes na tela e muda seu design
	 */
	private void setComponents() {

		lbBemVindo = new LabelPadrao("Bem vindo de volta " + controle.Main.login.getUsuario(), 48, componentesGUILogin.Config.COR_FONTE_BOTAO);
		lbEstudo = new LabelPadrao("Você tem " + controle.Main.login.getLimiteTopicosEstudo() + " novos tópicos para estudar", 36);
		lbRevisao = new LabelPadrao("Você tem " + controle.Main.login.getLimiteTopicosRevisao() + " novas revisões", 36);
		btEstudar = new BotaoPadrao("Estudar", 0, 0, 150, 50, 24);
		btRevisar = new BotaoPadrao("Revisar", 0, 0, 150, 50, 24);
		
		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(lbBemVindo);
		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(lbEstudo);
		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(lbRevisao);
		buttonPanel.add(btEstudar);
		buttonPanel.add(btRevisar);
	}
}
