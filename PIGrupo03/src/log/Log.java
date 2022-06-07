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
	 * cria uma nova entrada no log indicando que foram criadas proficiencias para os
	 * t�picos de um certo usu�rio
	 * 
	 * @param codigoUsuario - codigo do ususario para o qual foram criadas as proficiencias
	 * @param topicos - array de n�meros de t�picos que foram criados
	 */
	public static void criarProficiencia(int codigoUsuario, ArrayList<Integer> topicos) {
		String mensagem = " Foram criados [" + topicos.size() + "] novas profici�ncias para o usu�rio [" + codigoUsuario + "]";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio finalizou o estudo de n t�picos
	 * 
	 * @param codigoUsuario - usu�rio que finalizou a sess�o de estudos
	 * @param filaEstudo - array de t�picos que foram estudados
	 */
	public static void finalizarEstudo(int codigoUsuario, ArrayList<Topico> filaEstudo) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] finalizou uma sess�o de estudo de [" + filaEstudo.size() + "] t�picos novos.";
		append(mensagem);
	}
	
	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio finalizou a revis�o de n t�picos
	 * 
	 * @param codigoUsuario - usu�rio que finalizou a sess�o de revis�o
	 * @param filaEstudo - array de t�picos que foram revisados
	 */
	public static void finalizarRevisao(int codigoUsuario, ArrayList<Topico> filaRevisao) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] finalizou uma sess�o de revis�o de [" + filaRevisao.size() + "] t�picos.";
		append(mensagem);
	}

	/**
	 * cria uma nova entrada no log indicando um determinado usu�rio alterou sua senha
	 * @param codigoUsuario - codigo do usuario
	 */
	public static void trocarSenha(int codigoUsuario) {
		String mensagem = " Usu�rio [" + codigoUsuario + "] alterou sua pr�pria senha.";
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
			tipo = "t�pico";
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
		String mensagem = " Administrador [" + Main.login.getCodigo() + "] " + acaoTomada + " sua pr�pria senha.";
		append(mensagem);
	}
}

