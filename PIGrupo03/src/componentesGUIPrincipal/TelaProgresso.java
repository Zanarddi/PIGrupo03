package componentesGUIPrincipal;

import javax.swing.Box;

import componentesGUILogin.Config;

public class TelaProgresso extends TelaPadrao {

	PainelTextField desconhecido, iniciante, medio, expert;
	public TelaProgresso() {
		
		desconhecido = new PainelTextField("Tópicos desconhecidos:", 190);
		iniciante = new PainelTextField("Tópicos lvl. iniciante:", 190);
		medio = new PainelTextField("Tópicos lvl. médio:", 190);
		expert = new PainelTextField("Tópicos lvl. expert:", 190);
		
		painelCentro.add(Box.createVerticalStrut(40));
		painelCentro.add(new LabelPadrao("Veja seu progresso", 48));
		painelCentro.add(Box.createVerticalStrut(60));
		painelCentro.add(desconhecido);
		painelCentro.add(Box.createVerticalStrut(20));
		painelCentro.add(iniciante);
		painelCentro.add(Box.createVerticalStrut(20));
		painelCentro.add(medio);
		painelCentro.add(Box.createVerticalStrut(20));
		painelCentro.add(expert);
		
	}
}
