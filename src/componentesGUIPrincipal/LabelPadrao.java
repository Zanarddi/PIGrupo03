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
	
	/**
	 * cria uma label com cor personalizada.
	 * @param texto - String com o texto da label
	 * @param tamanho - da fonte
	 * @param cor - do texto
	 */
	public LabelPadrao (String texto, int tamanho, Color cor) {
		//htm para quebrar o texto
		setText("<html>"+ texto +"</html>");
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
		setForeground(cor);
	}
	/**
	 * cria uma label com cor padrão (preto).
	 * @param texto - string com o texto da label
	 * @param tamanho - tamanho da fonte
	 */
	public LabelPadrao (String texto, int tamanho) {
		setText("<html>"+ texto +"</html>");
		setFont(new Font(componentesGUILogin.Config.FONTE, 0, tamanho));
	}
}