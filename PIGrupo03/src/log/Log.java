package log;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import componentesGUILogin.Config;
import controle.Main;
import modelo.Login;
import modelo.Pergunta;
import modelo.Resposta;
import modelo.Topico;

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
	 * cria uma nova entrada no log indicando que foram criadas proficiencias para os
	 * tópicos de um certo usuário
	 * 
	 * @param codigoUsuario - codigo do ususario para o qual foram criadas as proficiencias
	 * @param topicos - array de números de tópicos que foram criados
	 */
	public static void criarProficiencia(int codigoUsuario, ArrayList<Integer> topicos) {
		String mensagem = " Foram criados [" + topicos.size() + "] novas proficiências para o usuário [" + codigoUsuario + "]";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usuário finalizou o estudo de n tópicos
	 * 
	 * @param codigoUsuario - usuário que finalizou a sessão de estudos
	 * @param filaEstudo - array de tópicos que foram estudados
	 */
	public static void finalizarEstudo(int codigoUsuario, ArrayList<Topico> filaEstudo) {
		String mensagem = " Usuário [" + codigoUsuario + "] finalizou uma sessão de estudo de [" + filaEstudo.size() + "] tópicos novos.";
		append(mensagem);
	}
	
	/**
	 * cria uma nova entrada no log indicando um determinado usuário finalizou a revisão de n tópicos
	 * 
	 * @param codigoUsuario - usuário que finalizou a sessão de revisão
	 * @param filaEstudo - array de tópicos que foram revisados
	 */
	public static void finalizarRevisao(int codigoUsuario, ArrayList<Topico> filaRevisao) {
		String mensagem = " Usuário [" + codigoUsuario + "] finalizou uma sessão de revisão de [" + filaRevisao.size() + "] tópicos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usuário alterou sua senha
	 * @param codigoUsuario - codigo do usuario
	 */
	public static void trocarSenha(int codigoUsuario) {
		String mensagem = " Usuário [" + codigoUsuario + "] alterou sua própria senha.";
		append(mensagem);
	}
	
	/**
	 * 
	 * @param codigoTopico
	 * @param acao
	 */
	public static void manterTopico(Object objetoMantido, int acao) {
		int codObjeto;
		String tipo = "";
		String acaoTomada = "";
		
		if (objetoMantido instanceof Topico) {
			codObjeto = ((Topico) objetoMantido).getCodigo();
			tipo = "tópico";
		} else if (objetoMantido instanceof Pergunta) {
			codObjeto = ((Pergunta) objetoMantido).getCodigo();
			tipo = "pergunta";
		} else if (objetoMantido instanceof Resposta) {
			codObjeto = ((Resposta) objetoMantido).getCodigo();
			tipo = "resposta";
		}
		
		if(acao == 0) {
			acaoTomada = "deletou";
		} else if(acao == 1) {
			acaoTomada = "criou";
		} else if(acao == 1) {
			acaoTomada = "editou";
		}
		String mensagem = " Administrador [" + Main.login.getCodigo() + "] " + acaoTomada + " sua própria senha.";
		append(mensagem);
	}
}

