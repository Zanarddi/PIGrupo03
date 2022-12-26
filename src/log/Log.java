package log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import componentesGUILogin.Config;
import controle.Main;
import modelo.Login;
import modelo.Pergunta;
import modelo.Resposta;
import modelo.Topico;

/**
 * Classe que escreve novas linhas no log do sistema
 * 
 * @author Gustavo Zanardi
 *
 */
public class Log {

	static Calendar horarioAtual;

	/**
	 * Escreve uma nova linha no arquivo de texto do log
	 * 
	 * @param dados - linhas a serem escritas.
	 */
	public static void append(String... dados) {
		try {
			FileWriter fw = new FileWriter(Config.CAMINHO_LOG, true);
			for (String v : dados) {
				fw.append(getHorario() + v + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("erro");
		}
	}

	/**
	 * atualiza o hor�rio atual
	 * 
	 * @return - hor�rio atual
	 */
	private static String getHorario() {
		horarioAtual = Calendar.getInstance();
		return "[" + horarioAtual.getTime() + "] ";
	}

	/**
	 * cria uma mensagem no log indicando que um usu�rio fez login
	 * 
	 * @param codigoUsuario - c�digo do usu�rio que fez login
	 */
	public static void novoLogin(int codigoUsuario) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] fez login.";
		append(mensagem);
	}

	/**
	 * cria uma mensagem no log indicando que um usu�rio encerrou a sess�o
	 * 
	 * @param codigoUsuario - c�digo do usu�rio que encerrou a sess�o
	 */
	public static void encerrarSessao(int codigoUsuario) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] encerrou a sess�o.";
		append(mensagem);

	}

	/**
	 * cria uma nova entrada no log indicando que um usu�rio alterou seu limite de
	 * estudo
	 * 
	 * @param codigoUsuario
	 * @param limEstudo
	 */
	public static void alterarLimiteEstudo(int codigoUsuario, String limEstudo) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] alterou seu limite de estudo para [" + limEstudo + "].";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que um usu�rio alterou seu limite de
	 * revis�o
	 * 
	 * @param codigoUsuario
	 * @param limRevisao
	 */
	public static void alterarLimiteRevisao(int codigoUsuario, String limRevisao) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] alterou seu limite de revis�es para [" + limRevisao + "].";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que um novo usu�rio foi criado
	 * 
	 * @param l - login do usuario criado
	 */
	public static void registroUsuario(Login l) {
		String mensagem = " Usu�rio [" + l.getCodigo() + "] registrado.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que foram criadas proficiencias para
	 * os t�picos de um certo usu�rio
	 * 
	 * @param codigoUsuario - codigo do ususario para o qual foram criadas as
	 *                      proficiencias
	 * @param topicos       - array de n�meros de t�picos que foram criados
	 */
	public static void criarProficiencia(int codigoUsuario, ArrayList<Integer> topicos) {
		String mensagem = " Foram criados [" + topicos.size() + "] novas profici�ncias para o usu�rio [" + codigoUsuario
				+ "]";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio finalizou o
	 * estudo de n t�picos
	 * 
	 * @param codigoUsuario - usu�rio que finalizou a sess�o de estudos
	 * @param filaEstudo    - array de t�picos que foram estudados
	 */
	public static void finalizarEstudo(int codigoUsuario, ArrayList<Topico> filaEstudo) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] finalizou uma sess�o de estudo de [" + filaEstudo.size()
				+ "] t�picos novos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio finalizou a
	 * revis�o de n t�picos
	 * 
	 * @param codigoUsuario - usu�rio que finalizou a sess�o de revis�o
	 * @param filaEstudo    - array de t�picos que foram revisados
	 */
	public static void finalizarRevisao(int codigoUsuario, ArrayList<Topico> filaRevisao) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] finalizou uma sess�o de revis�o de [" + filaRevisao.size()
				+ "] t�picos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio alterou sua
	 * senha
	 * 
	 * @param codigoUsuario - codigo do usuario
	 */
	public static void trocarSenha(int codigoUsuario) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] alterou sua pr�pria senha.";
		append(mensagem);
	}

	/**
	 * Cria um registro de log, podendo receber diferentes tipos de objeto ou a��es
	 * 
	 * @param objetoMantido - Pergunta, Resposta ou T�pico que est� sendo
	 *                      resgistrado o log
	 * @param acao          - 0 para deletar, 1 para inserir e 2 para editar
	 */
	public static void manterObjeto(Object objetoMantido, int acao) {
		String tipo = "";

		String mensagem = " Administrador [" + Main.login.getCodigo() + "] ";
		String mensagem2 = "";

		if (acao == 0) {
			mensagem = mensagem + "deletou ";
		} else if (acao == 1) {
			mensagem = mensagem + "criou ";
		} else if (acao == 2) {
			mensagem = mensagem + "editou ";
		}

		if (objetoMantido instanceof Topico) {
			if(acao == 1) {
				mensagem2 = "um t�pico.";
			}
			else {
				mensagem2 = "o t�pico [" + ((Topico) objetoMantido).getCodigo() + "].";
			}
		} else if (objetoMantido instanceof Pergunta) {
			if(acao == 1) {
				mensagem2 = "uma pergunta.";
			}
			else {
				mensagem2 = "a pergunta [" + ((Pergunta) objetoMantido).getCodigo() + "].";
			}
		} else if (objetoMantido instanceof Resposta) {
			if(acao == 1) {
				mensagem2 = "uma resposta.";
			}
			else {
				mensagem2 = "a resposta [" + ((Resposta) objetoMantido).getCodigo() + "].";
			}
		}
		append(mensagem + mensagem2);
	}
}
