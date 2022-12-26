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
	 * atualiza o horário atual
	 * 
	 * @return - horário atual
	 */
	private static String getHorario() {
		horarioAtual = Calendar.getInstance();
		return "[" + horarioAtual.getTime() + "] ";
	}

	/**
	 * cria uma mensagem no log indicando que um usuário fez login
	 * 
	 * @param codigoUsuario - código do usuário que fez login
	 */
	public static void novoLogin(int codigoUsuario) {
		String mensagem = " Usuário [" + codigoUsuario + "] fez login.";
		append(mensagem);
	}

	/**
	 * cria uma mensagem no log indicando que um usuário encerrou a sessão
	 * 
	 * @param codigoUsuario - código do usuário que encerrou a sessão
	 */
	public static void encerrarSessao(int codigoUsuario) {
		String mensagem = " Usuário [" + codigoUsuario + "] encerrou a sessão.";
		append(mensagem);

	}

	/**
	 * cria uma nova entrada no log indicando que um usuário alterou seu limite de
	 * estudo
	 * 
	 * @param codigoUsuario
	 * @param limEstudo
	 */
	public static void alterarLimiteEstudo(int codigoUsuario, String limEstudo) {
		String mensagem = " Usuário [" + codigoUsuario + "] alterou seu limite de estudo para [" + limEstudo + "].";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que um usuário alterou seu limite de
	 * revisão
	 * 
	 * @param codigoUsuario
	 * @param limRevisao
	 */
	public static void alterarLimiteRevisao(int codigoUsuario, String limRevisao) {
		String mensagem = " Usuário [" + codigoUsuario + "] alterou seu limite de revisões para [" + limRevisao + "].";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que um novo usuário foi criado
	 * 
	 * @param l - login do usuario criado
	 */
	public static void registroUsuario(Login l) {
		String mensagem = " Usuário [" + l.getCodigo() + "] registrado.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando que foram criadas proficiencias para
	 * os tópicos de um certo usuário
	 * 
	 * @param codigoUsuario - codigo do ususario para o qual foram criadas as
	 *                      proficiencias
	 * @param topicos       - array de números de tópicos que foram criados
	 */
	public static void criarProficiencia(int codigoUsuario, ArrayList<Integer> topicos) {
		String mensagem = " Foram criados [" + topicos.size() + "] novas proficiências para o usuário [" + codigoUsuario
				+ "]";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usuário finalizou o
	 * estudo de n tópicos
	 * 
	 * @param codigoUsuario - usuário que finalizou a sessão de estudos
	 * @param filaEstudo    - array de tópicos que foram estudados
	 */
	public static void finalizarEstudo(int codigoUsuario, ArrayList<Topico> filaEstudo) {
		String mensagem = " Usuário [" + codigoUsuario + "] finalizou uma sessão de estudo de [" + filaEstudo.size()
				+ "] tópicos novos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usuário finalizou a
	 * revisão de n tópicos
	 * 
	 * @param codigoUsuario - usuário que finalizou a sessão de revisão
	 * @param filaEstudo    - array de tópicos que foram revisados
	 */
	public static void finalizarRevisao(int codigoUsuario, ArrayList<Topico> filaRevisao) {
		String mensagem = " Usuário [" + codigoUsuario + "] finalizou uma sessão de revisão de [" + filaRevisao.size()
				+ "] tópicos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usuário alterou sua
	 * senha
	 * 
	 * @param codigoUsuario - codigo do usuario
	 */
	public static void trocarSenha(int codigoUsuario) {
		String mensagem = " Usuário [" + codigoUsuario + "] alterou sua própria senha.";
		append(mensagem);
	}

	/**
	 * Cria um registro de log, podendo receber diferentes tipos de objeto ou ações
	 * 
	 * @param objetoMantido - Pergunta, Resposta ou Tópico que está sendo
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
				mensagem2 = "um tópico.";
			}
			else {
				mensagem2 = "o tópico [" + ((Topico) objetoMantido).getCodigo() + "].";
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
