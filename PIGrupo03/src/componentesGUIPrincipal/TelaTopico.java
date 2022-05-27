package componentesGUIPrincipal;

import javax.swing.JLabel;

public class TelaTopico extends TelaPadrao {

	static BotaoPadrao btProximo = new BotaoPadrao("Próximo", 0, 0, 150, 50, 24);
	static BotaoPadrao btVoltar = new BotaoPadrao("Voltar", 0, 0, 150, 50, 24);

	public TelaTopico(String titulo, String tema, String explicacao) {
		add(new JLabel(titulo));
	}

	private void setListeners() {

	}

	private void setComponents() {
		
		this.buttonPanel.add(btProximo);
		this.buttonPanel.add(btVoltar);
		
	}

}
