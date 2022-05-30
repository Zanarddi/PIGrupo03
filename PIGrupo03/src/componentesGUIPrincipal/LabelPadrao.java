package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * label padrão utilizada nas telas principais do programa
 * 
 * @author Gustavo Zanardi
 *
 */
public class LabelPadrao extends JLabel{
	
	public LabelPadrao (String texto, int tamanho, Color cor) {
		
		//htm para quebrar o texto
		setText("<html>"+ texto +"</html>");
		
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
		setForeground(cor);
	}
	
	public LabelPadrao (String texto, int tamanho) {
		setText(texto);
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
	}

}
