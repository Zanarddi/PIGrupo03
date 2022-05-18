package componentesGUIPrincipal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPadrao extends JPanel {

	JPanel buttonPanel;		//painel inferior com botões de navegação
	JPanel painelCentro;	//painel principal das telas
	
	TelaPadrao() {
		setBackground(componentesGUILogin.Config.COR_BACKGROUND);
		this.setLayout(new BorderLayout());
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));	//os botões são dispostos da direita para esquerda
		((FlowLayout) buttonPanel.getLayout()).setHgap(20);
		buttonPanel.setBackground(this.getBackground());
		buttonPanel.setBorder(new EmptyBorder(10, 10, 30, 30));		//cria borda vazia ao redor dos botoes
		add(buttonPanel,BorderLayout.SOUTH);
		
		//painel onde serão colocados os componentes principais das telas
		painelCentro = new JPanel();
		painelCentro.setLayout(new BoxLayout(painelCentro, BoxLayout.Y_AXIS));
		painelCentro.setBackground(this.getBackground());
		painelCentro.setBorder(new EmptyBorder(0, 50, 0, 0));
		this.add(painelCentro, BorderLayout.CENTER);
	}
}
