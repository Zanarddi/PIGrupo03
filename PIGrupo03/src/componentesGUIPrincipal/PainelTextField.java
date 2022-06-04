package componentesGUIPrincipal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;

import componentesGUILogin.Config;

/**
 * Classe de criação de um conjunto label e textfield, utilizado para telas que
 * buscam apresentar texto ou configurar atributos do usuário
 * 
 * @author Gustavo Zanardi
 *
 */
public class PainelTextField extends JPanel {

	LabelPadrao label;
	JTextField textField;

	public PainelTextField(String texto) {

		setAlignmentX(Component.LEFT_ALIGNMENT);
		setPreferredSize(new Dimension(850, 40));
		setMaximumSize(new Dimension(850, 40));
		setMinimumSize(new Dimension(850, 40));
		setBackground(Config.COR_BACKGROUND);

		label = new LabelPadrao(texto, 38, Config.COR_FONTE_BOTAO);
		label.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));

		textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		textField.setPreferredSize(new Dimension(245, 35));
		textField.setMaximumSize(new Dimension(245, 35));
		textField.setMinimumSize(new Dimension(245, 35));
		textField.setFont(new Font(componentesGUILogin.Config.FONTE, 0, 32));
		textField.setBorder(BorderFactory.createEmptyBorder(0, 20, 5, 20));

		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.WEST);
		this.add(textField, BorderLayout.CENTER);
		this.add(Box.createHorizontalStrut(125), BorderLayout.EAST);

	}

}
