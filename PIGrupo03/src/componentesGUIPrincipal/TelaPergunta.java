package componentesGUIPrincipal;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import modelo.Pergunta;
import modelo.Resposta;

public class TelaPergunta extends TelaPadrao {

	JPanel painelPreto;

	ArrayList<Resposta> respostasCorretas;
	ArrayList<Resposta> respostasErradas;
	
	ArrayList<RadioButtonPadrao> grupoRespostas;
	
	ButtonGroup bg;

	public TelaPergunta(Pergunta p) {
		
		grupoRespostas = new ArrayList<RadioButtonPadrao>();
		respostasCorretas = new ArrayList<Resposta>();
		respostasErradas = new ArrayList<Resposta>();
		bg = new ButtonGroup();
		
		separarRespostas(p);
		setComponents(p);
		
	}

	private void separarRespostas(Pergunta p) {
		for (Resposta r : p.getRespostas()) {
			if (r.getTipo() == 1) {
				respostasCorretas.add(r);
			} else if (r.getTipo() == 0) {
				respostasErradas.add(r);
			}
			Collections.shuffle(respostasCorretas);
			Collections.shuffle(respostasErradas);
		}
	}

	private void setComponents(Pergunta p) {
		
		buttonPanel.setVisible(false);
		painelCentro.setBorder(new EmptyBorder(20, 20, 0, 20));

		//painel preto onde fica a descrição
		painelPreto = new JPanel();
		
		Dimension tamPainelPreto = new Dimension(800, 190);
		painelPreto.setPreferredSize(tamPainelPreto);
		painelPreto.setMaximumSize(tamPainelPreto);
		painelPreto.setMinimumSize(tamPainelPreto);
		
		painelPreto.setBackground(Color.BLACK);
		painelPreto.setBorder(BorderFactory.createLineBorder(componentesGUILogin.Config.COR_BACKGROUND_ESCURA, 5));
		painelPreto.add(new LabelPadrao(p.getDescricao(), 24, Color.WHITE));
		painelPreto.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		painelCentro.add(painelPreto);
		painelCentro.add(Box.createVerticalStrut(20));
		
		grupoRespostas.add(new RadioButtonPadrao(respostasCorretas.get(0).getDescricao(), respostasCorretas.get(0).getTipo()));
		System.out.println(grupoRespostas.get(0).getText());
		for (int i = 0; i < 3; i++) {
			grupoRespostas.add(new RadioButtonPadrao(respostasErradas.get(i).getDescricao(), respostasErradas.get(i).getTipo()));
		}
		Collections.shuffle(grupoRespostas);
		
		for(RadioButtonPadrao bt : grupoRespostas) {
			painelCentro.add(bt);
			bg.add(bt);
		}
		
	}
}
