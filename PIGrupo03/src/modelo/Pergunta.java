package modelo;

public class Pergunta {

	private int codigo;
	
	private String descricao;
	private String resCorreta;
	private String res1;
	private String res2;
	private String res3;
	private String res4;
	private String res5;
	

	public Pergunta(int codigo, String descricao, String resCorreta, String res1, String res2, String res3, String res4,
			String res5) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.resCorreta = resCorreta;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.res4 = res4;
		this.res5 = res5;
	}
}
