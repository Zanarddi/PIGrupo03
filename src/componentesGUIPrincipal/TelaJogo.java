package componentesGUIPrincipal;

import javax.swing.Box;

/**
 * 
 * N�o implementado.
 * 
 * @author null
 *
 */
public class TelaJogo extends TelaPadrao{

	public TelaJogo() {
		reset();
	}
	
	@Override
	public void reset() {
		super.reset();
		
		painelCentro.add(Box.createVerticalStrut(200));
		painelCentro.add(new LabelPadrao("Em breve" , 48));
	}
}
