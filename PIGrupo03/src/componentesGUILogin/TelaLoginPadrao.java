package componentesGUILogin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Tela usada como base para a criação das telas relacionadas ao login
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaLoginPadrao extends JPanel {

	int largura, altura;
	JPanel painelEscuro = new JPanel();
	JPanel painelClaro = new JPanel();
	JPanel painelBranco = new JPanel();
	JPanel painelComponentes = new JPanel();

	/**
	 * Cria um painel padrão para as telas de login. Permite que se altere o tamanho
	 * do retângulo branco onde ficam os Componentes.
	 * 
	 * @param largura - largura do retângulo branco
	 * @param altura  - altura do retângulo branco
	 */
	public TelaLoginPadrao(Dimension dimPainelBranco) {
		setBounds(0, 0, 1000, 600);
		setLayout(new GridLayout(1, 2));

		// "prepara os paineis antes de adiciona-los à frame
		setPanels(dimPainelBranco);

		add(painelEscuro);
		add(painelClaro);
		painelClaro.setVisible(true);
		painelEscuro.setVisible(true);
	}

	/**
	 * configura o painel à esquerda da frame de login
	 * 
	 * @param dim
	 */
	private void setPanels(Dimension dim) {
		painelEscuro.setBackground(Config.COR_BACKGROUND_ESCURA);
		painelEscuro.setPreferredSize(new Dimension(500, 600));
		painelEscuro.setLayout(new BoxLayout(painelEscuro, BoxLayout.Y_AXIS));

		painelClaro.setBackground(Config.COR_BACKGROUND);
		painelClaro.setPreferredSize(new Dimension(500, 600));

		painelBranco.setBackground(Color.WHITE);
		painelBranco.setMaximumSize(dim);
		painelBranco.setMinimumSize(dim);
		painelBranco.setPreferredSize(dim);

		// organiza o painel branco, colocando o painel com os componentes ao centro
		painelBranco.setLayout(new BoxLayout(painelBranco, BoxLayout.X_AXIS));
		painelBranco.add(Box.createHorizontalGlue());
		painelBranco.add(painelComponentes);
		painelComponentes.setBackground(Color.WHITE);
		painelBranco.add(Box.createHorizontalGlue());

		painelEscuro.add(Box.createVerticalGlue());
		painelEscuro.add(painelBranco);
		painelEscuro.add(Box.createVerticalGlue());
	}

}
