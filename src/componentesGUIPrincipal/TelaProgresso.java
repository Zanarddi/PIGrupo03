package componentesGUIPrincipal;

import javax.swing.Box;

import controle.Main;
import crud.TopicoDAO;

/**
 * Tela que mostra a contagem de tópicos do usuário por nível de proficiência
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaProgresso extends TelaPadrao {

	PainelTextField desconhecido, iniciante, medio, expert;
	public TelaProgresso() {
		reset();
	}
	
	@Override
	public void reset() {
		super.reset();
		
		setComponents();
	}
	
	private void setComponents(){
		desconhecido = new PainelTextField("Tópicos desconhecidos:", 190);
		desconhecido.textField.setEditable(false);
		iniciante = new PainelTextField("Tópicos lvl. iniciante:", 190);
		iniciante.textField.setEditable(false);
		medio = new PainelTextField("Tópicos lvl. médio:", 190);
		medio.textField.setEditable(false);
		expert = new PainelTextField("Tópicos lvl. expert:", 190);
		expert.textField.setEditable(false);
		
		contarTopicos();
		
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
	
	/**
	 * Envia query para o banco, retornando a contagem de tópicos de acordo com a proficiência do usuário
	 */
	private void contarTopicos() {
		TopicoDAO topicoDAO = new TopicoDAO();
		int codigo = Main.login.getCodigo();
		String sql = "select count(*) from proficiencia where proficiencia in (0) and cod_usuario = "+codigo;
		desconhecido.textField.setText("" + topicoDAO.contarTopicos(sql));
		sql = "select count(*) from proficiencia where proficiencia in (1,2,3) and cod_usuario ="+codigo;
		iniciante.textField.setText("" + topicoDAO.contarTopicos(sql));
		sql = "select count(*) from proficiencia where proficiencia in (4,5,6) and cod_usuario ="+codigo;
		medio.textField.setText("" + topicoDAO.contarTopicos(sql));
		sql = "select count(*) from proficiencia where proficiencia in (7,8,9) and cod_usuario ="+codigo;
		expert.textField.setText("" + topicoDAO.contarTopicos(sql));
	}
}
