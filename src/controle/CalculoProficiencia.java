package controle;

import modelo.Topico;

/**
 * Classe que calcula a proficiencia de um usuário em um determinado tópico
 * 
 * @author Gustavo Zanardi
 *
 */
public class CalculoProficiencia {

	public static int calcularProficiencia(Topico t) {
		int proficiencia = t.getProficiencia();
		int dias = 0;
		switch (proficiencia) {
		case 1:
			dias = 1; break;
		case 2:
			dias = 2; break;
		case 3:
			dias = 5; break;
		case 4:
			dias = 7; break;
		case 5:
			dias = 14; break;
		case 6:
			dias = 21; break;
		case 7:
			dias = 30; break;
		case 8:
			dias = 60; break;
		case 9:
			dias = 100; break;
		}

		return dias;
	}
}
