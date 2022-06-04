package componentesGUIPrincipal;

import javax.swing.Box;

import componentesGUILogin.Config;

public class TelaProgresso extends TelaPadrao {

	PainelTextField desconhecido, iniciante, medio, expert;
	public TelaProgresso() {
		
		desconhecido = new PainelTextField("T�picos desconhecidos:", 190);
		iniciante = new PainelTextField("T�picos lvl. iniciante:", 190);
		medio = new PainelTextField("T�picos lvl. m�dio:", 190);
		expert = new PainelTextField("T�picos lvl. expert:", 190);
		
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
