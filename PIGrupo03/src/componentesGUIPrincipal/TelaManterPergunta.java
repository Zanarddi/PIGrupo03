package componentesGUIPrincipal;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import componentesGUILogin.Config;
import crud.PerguntaDAO;
import modelo.Pergunta;

/**
 * Painel onde é são adicionadas, editadas ou deletadas, as perguntas do banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaManterPergunta extends JPanel {

	JFrame frameEdicaoResposta;
	int codigoTopico;
	PerguntaDAO perguntaDAO;
	ArrayList<Pergunta> perguntas;
	DefaultTableModel model;
	private JTable table;
	private JTextField tfCodigoPergunta;
	private JTextField tfCodigoTopico;
	JTextArea tfDescricao;

	/**
	 * Cria o painel de gerenciamento de perguntas
	 * 
	 * @param codigoTopico - do tópico
	 */
	public TelaManterPergunta(int codigoTopico) {
		
		setLayout(null);
		setBackground(Config.COR_BACKGROUND);

		perguntas = new ArrayList<Pergunta>();
		perguntaDAO = new PerguntaDAO();
		
		tfCodigoPergunta = new JTextField();
		tfCodigoTopico = new JTextField();
		tfCodigoTopico.setEditable(false);
		
		tfDescricao = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		
		JLabel lbCodigoPergunta = new JLabel("C\u00F3digo da Pergunta");
		JLabel lbCabecalho = new JLabel("Gerenciamento de Perguntas");
		JLabel lbOrdemTopico = new JLabel("Codigo do t\u00F3pico");
		JLabel lbDescricaoPergunta = new JLabel("Descri\u00E7\u00E3o");
		
		JButton btEditarRespostas = new JButton("Editar Respostas");
		JButton btSelecionar = new JButton("Selecionar");
		JButton btSalvar = new JButton("Salvar");
		JButton btDeletar = new JButton("Deletar");
		JButton btNovo = new JButton("Novo");
		model = (DefaultTableModel) table.getModel();
		
		this.codigoTopico = codigoTopico;
		tfCodigoTopico.setText("" + codigoTopico);
		
		lbCodigoPergunta.setBounds(10, 49, 114, 14);
		add(lbCodigoPergunta);

		tfCodigoPergunta.setEditable(false);
		tfCodigoPergunta.setBounds(134, 46, 36, 20);
		add(tfCodigoPergunta);
		tfCodigoPergunta.setColumns(10);

		lbOrdemTopico.setBounds(10, 76, 94, 14);
		add(lbOrdemTopico);
		
		tfCodigoTopico.setColumns(10);
		tfCodigoTopico.setBounds(134, 77, 36, 20);
		add(tfCodigoTopico);
		
		lbDescricaoPergunta.setBounds(10, 101, 68, 14);
		add(lbDescricaoPergunta);
		
		btSelecionar.setBounds(343, 261, 98, 29);
		add(btSelecionar);

		tfDescricao.setBounds(88, 104, 677, 118);
		add(tfDescricao);
		
		scrollPane.setBounds(10, 301, 755, 211);
		add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		btSalvar.setBounds(451, 261, 98, 29);
		add(btSalvar);
		
		btDeletar.setBounds(559, 261, 98, 29);
		add(btDeletar);
		
		btNovo.setBounds(667, 261, 98, 29);
		add(btNovo);
		
		lbCabecalho.setBounds(10, 0, 539, 38);
		lbCabecalho.setFont(new Font("ROBOTO", 1, 30));
		add(lbCabecalho);
		
		btEditarRespostas.setBounds(10, 261, 140, 29);
		add(btEditarRespostas);

		model.addColumn("cod_pergunta");
		model.addColumn("descricao_pergunta");

		atualizarTabela();

		btSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					tfCodigoPergunta.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
					tfDescricao.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
				}

			}
		});
		
		btDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    JOptionPane.showConfirmDialog (null, "Você quer excluir a pergunta e suas respostas?","Aviso",dialogButton);
				    if(dialogButton == JOptionPane.YES_OPTION) {
				    	JOptionPane.showMessageDialog(null, perguntaDAO.excluir(perguntas.get(table.getSelectedRow())));
				    	atualizarTabela();
					}
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		btSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfCodigoTopico.getText().isBlank() || !tfDescricao.getText().isBlank()) {
					if (!tfCodigoTopico.getText().isEmpty() || !tfDescricao.getText().isEmpty()) {
						if (controle.Validacao.verificaInt(tfCodigoTopico.getText())) {
							if (table.getSelectedRow() != -1) {
								perguntas.get(table.getSelectedRow()).setDescricao(tfDescricao.getText());;
								perguntas.get(table.getSelectedRow()).setCodigoTopico(Integer.parseInt(tfCodigoTopico.getText()));
								JOptionPane.showMessageDialog(null, perguntaDAO.salvar(perguntas.get(table.getSelectedRow())));
							}
							else {
								JOptionPane.showMessageDialog(null, perguntaDAO.criarNovo(tfDescricao.getText(), Integer.parseInt(tfCodigoTopico.getText())));
							}
							limparCampos();
							atualizarTabela();
						}
					}
				}
			}
		});

		btEditarRespostas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!tfCodigoPergunta.getText().isBlank()) {
					if (!tfCodigoPergunta.getText().isEmpty()) {
						frameEdicaoResposta = new JFrame();
						frameEdicaoResposta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						frameEdicaoResposta.getContentPane()
								.add(new TelaManterResposta(Integer.parseInt(tfCodigoPergunta.getText())));
						frameEdicaoResposta.setSize(new Dimension(785, 560));
						frameEdicaoResposta.setResizable(false);
						frameEdicaoResposta.setLocationRelativeTo(null);
						frameEdicaoResposta.setVisible(true);
					}
				}
			}
		});
	}
	/**
	 * atualiza os valores da tabela, retirando os velhos e adicionando novos
	 * 
	 */
	private void atualizarTabela() {
		int contagemLinhas = model.getRowCount();

		for (int i = contagemLinhas - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		perguntas = perguntaDAO.get(
				"select cod_pergunta, descricao_pergunta from pergunta where cod_topico = " + codigoTopico);
		System.out.println(perguntas.size());

		for (Pergunta p : perguntas) {
			model.addRow(new Object[] { p.getCodigo(), p.getDescricao() });
		}
	}

	/**
	 * limpa os campos do tópico
	 * 
	 */
	private void limparCampos() {
		tfDescricao.setText("");
		table.clearSelection();
	}
}
