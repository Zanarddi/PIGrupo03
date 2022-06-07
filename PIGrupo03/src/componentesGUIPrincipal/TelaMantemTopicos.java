package componentesGUIPrincipal;

import javax.swing.border.EmptyBorder;

public class TelaMantemTopicos extends TelaPadrao{
	
	TelaAdicionarTopico telaTopicos;
	
	public TelaMantemTopicos() {
		painelCentro.setBorder(new EmptyBorder(20,30,0,0));
		buttonPanel.setVisible(false);
		telaTopicos = new TelaAdicionarTopico();
		painelCentro.add(telaTopicos);
	}
	
	
}
