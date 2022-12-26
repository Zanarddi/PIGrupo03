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
import javax.swing.table.DefaultTableModel;

import componentesGUILogin.Config;
import crud.PerguntaDAO;
import crud.RespostaDAO;
import modelo.Pergunta;
import modelo.Resposta;

/**
 * Painel onde é são adicionadas, editadas ou deletadas, as respostas do banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaManterResposta extends JPanel{

JFrame frameEdicaoResposta;
	
	int codigoPergunta;
	
	RespostaDAO respostaDAO;

	ArrayList<Resposta> respostas;

	DefaultTableModel model;
	
	private JTable table;
	private JTextField tfCodigoPergunta;
	private JTextField tfCodigoResposta;
	JTextArea tfDescricao;
	private JTextField tfTipo;
	/**
	 * Create the panel.
	 */
	public TelaManterResposta(int codigoPergunta) {

		
		
		setLayout(null);
		setBackground(Config.COR_BACKGROUND);

		respostas = new ArrayList<Resposta>();
		respostaDAO = new RespostaDAO();
		
		tfCodigoPergunta = new JTextField();
		tfCodigoResposta = new JTextField();
		tfCodigoResposta.setEditable(false);
		
		tfDescricao = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		
		JLabel lbCodigoPergunta = new JLabel("C\u00F3digo da Pergunta");
		JLabel lbCabecalho = new JLabel("Gerenciamento de Respostas");
		JLabel lbOrdemTopico = new JLabel("Codigo da Resposta");
		JLabel lbDescricaoPergunta = new JLabel("Descri\u00E7\u00E3o");
		JButton btSelecionar = new JButton("Selecionar");
		JButton btSalvar = new JButton("Salvar");
		JButton btDeletar = new JButton("Deletar");
		JButton btNovo = new JButton("Novo");
		model = (DefaultTableModel) table.getModel();
		
		this.codigoPergunta = codigoPergunta;
		tfCodigoPergunta.setText("" + codigoPergunta);
		
		lbCodigoPergunta.setBounds(10, 49, 114, 14);
		add(lbCodigoPergunta);

		tfCodigoPergunta.setEditable(false);
		tfCodigoPergunta.setBounds(146, 46, 36, 20);
		add(tfCodigoPergunta);
		tfCodigoPergunta.setColumns(10);

		lbOrdemTopico.setBounds(10, 76, 126, 14);
		add(lbOrdemTopico);
		
		tfCodigoResposta.setColumns(10);
		tfCodigoResposta.setBounds(146, 73, 36, 20);
		add(tfCodigoResposta);
		
		lbDescricaoPergunta.setBounds(10, 165, 46, 14);
		add(lbDescricaoPergunta);
		
		btSelecionar.setBounds(343, 289, 98, 29);
		add(btSelecionar);

		tfDescricao.setBounds(76, 160, 689, 118);
		add(tfDescricao);
		
		scrollPane.setBounds(10, 329, 755, 183);
		add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		btSalvar.setBounds(451, 289, 98, 29);
		add(btSalvar);
		
		btDeletar.setBounds(559, 289, 98, 29);
		add(btDeletar);
		
		btNovo.setBounds(667, 289, 98, 29);
		add(btNovo);
		
		lbCabecalho.setBounds(10, 0, 539, 38);
		lbCabecalho.setFont(new Font("ROBOTO", 1, 30));
		add(lbCabecalho);
		
		JLabel lblTipoResposta = new JLabel("Tipo de resposta");
		lblTipoResposta.setBounds(10, 101, 114, 14);
		add(lblTipoResposta);
		
		tfTipo = new JTextField();
		tfTipo.setColumns(10);
		tfTipo.setBounds(146, 98, 36, 20);
		add(tfTipo);

		model.addColumn("cod_resposta");
		model.addColumn("descricao_resposta");
		model.addColumn("tipo_resposta");

		atualizarTabela();

		btSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					tfCodigoResposta.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
					tfDescricao.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
					tfTipo.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 2)));
				}

			}
		});
		
		btDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    JOptionPane.showConfirmDialog (null, "Você quer excluir a resposta?","Aviso",dialogButton);
				    if(dialogButton == JOptionPane.YES_OPTION) {
				    	JOptionPane.showMessageDialog(null, respostaDAO.excluir(respostas.get(table.getSelectedRow())));
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
				if (!tfDescricao.getText().isBlank() || !tfTipo.getText().isBlank()) {
					System.out.println("tamo aqui");
					if (!tfDescricao.getText().isEmpty()|| !tfTipo.getText().isEmpty()) {
						System.out.println("tamo aqui");
						if (controle.Validacao.verificaInt(tfCodigoPergunta.getText())) {
							if (table.getSelectedRow() != -1) {
								respostas.get(table.getSelectedRow()).setTipo(Integer.parseInt(tfTipo.getText()));
								respostas.get(table.getSelectedRow()).setDescricao(tfDescricao.getText());
								respostas.get(table.getSelectedRow()).setCodigoPergunta(Integer.parseInt(tfCodigoPergunta.getText()));
								JOptionPane.showMessageDialog(null, respostaDAO.salvar(respostas.get(table.getSelectedRow())));
							}
							else {
								System.out.println("estamos aqui");
								JOptionPane.showMessageDialog(null, respostaDAO.criarNovo(tfDescricao.getText(), Integer.parseInt(tfTipo.getText()), codigoPergunta));
							}
							limparCampos();
							atualizarTabela();
						}
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
		
		respostas = respostaDAO.get(
				"select cod_resposta, descricao_resposta, tipo_resposta from resposta where cod_pergunta = " + codigoPergunta);

		for (Resposta r : respostas) {
			model.addRow(new Object[] { r.getCodigo(), r.getDescricao(), r.getTipo() });
		}
	}
	
	/**limpa os campos do tópico
	 * 
	 */
	private void limparCampos() {

		tfDescricao.setText("");
		tfCodigoResposta.setText("");
		tfTipo.setText("");
		table.clearSelection();
	}

}
