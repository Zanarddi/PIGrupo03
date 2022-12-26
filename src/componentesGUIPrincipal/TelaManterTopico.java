package componentesGUIPrincipal;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import componentesGUILogin.Config;
import crud.TopicoDAO;
import modelo.Topico;
import javax.swing.JScrollPane;

/**
 * Painel onde é são adicionados, editados ou deletados, os tópicos do banco de dados
 * 
 * @author Gustavo Zanardi
 *
 */
public class TelaManterTopico extends JPanel {

	JFrame frameEdicaoPergunta;
	
	TopicoDAO topicoDAO;

	ArrayList<Topico> topicos;

	DefaultTableModel model;
	
	private JTable table;
	private JTextField tfCodigo;
	private JTextField tfOrdem;
	private JTextField tfTitulo;
	JTextArea tfDescricao;
	/**
	 * Create the panel.
	 */
	public TelaManterTopico() {

		setLayout(null);
		setBackground(Config.COR_BACKGROUND);

		topicos = new ArrayList<Topico>();
		topicoDAO = new TopicoDAO();
		
		tfCodigo = new JTextField();
		tfOrdem = new JTextField();
		tfTitulo = new JTextField();
		
		tfDescricao = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		
		JLabel lbCodigoTopico = new JLabel("C\u00F3digo");
		JLabel lbCabecalho = new JLabel("Gerenciamento de T\u00F3picos");
		JLabel lbOrdemTopico = new JLabel("Ordem");
		JLabel lbTituloTopico = new JLabel("T\u00EDtulo");
		JLabel lbDescricaoTopico = new JLabel("Descri\u00E7\u00E3o");
		
		JButton btEditarPerguntas = new JButton("Editar Perguntas");
		JButton btSelecionar = new JButton("Selecionar");
		JButton btSalvar = new JButton("Salvar");
		JButton btDeletar = new JButton("Deletar");
		JButton btNovo = new JButton("Novo");
		model = (DefaultTableModel) table.getModel();
		
		
		lbCodigoTopico.setBounds(10, 49, 46, 14);
		add(lbCodigoTopico);

		tfCodigo.setEditable(false);
		tfCodigo.setBounds(76, 46, 36, 20);
		add(tfCodigo);
		tfCodigo.setColumns(10);

		lbOrdemTopico.setBounds(10, 76, 46, 14);
		add(lbOrdemTopico);
		
		tfOrdem.setColumns(10);
		tfOrdem.setBounds(76, 73, 36, 20);
		add(tfOrdem);
		
		lbTituloTopico.setBounds(10, 104, 46, 14);
		add(lbTituloTopico);
		
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(76, 101, 689, 20);
		add(tfTitulo);
		
		lbDescricaoTopico.setBounds(10, 132, 46, 14);
		add(lbDescricaoTopico);
		
		btSelecionar.setBounds(343, 261, 98, 29);
		add(btSelecionar);

		tfDescricao.setBounds(76, 132, 689, 118);
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
		
		btEditarPerguntas.setBounds(10, 261, 140, 29);
		add(btEditarPerguntas);

		model.addColumn("cod_topico");
		model.addColumn("ordem_topico");
		model.addColumn("titulo_topico");
		model.addColumn("descricao_topico");

		atualizarTabela();

		btSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					tfCodigo.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
					tfOrdem.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 1)));
					tfTitulo.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 2)));
					tfDescricao.setText(String.valueOf(model.getValueAt(table.getSelectedRow(), 3)));
				}

			}
		});
		
		btDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
				    JOptionPane.showConfirmDialog (null, "Você quer excluir o tópico e suas perguntas?","Aviso",dialogButton);
				    if(dialogButton == JOptionPane.YES_OPTION) {
				    	JOptionPane.showMessageDialog(null, topicoDAO.excluir(topicos.get(table.getSelectedRow())));
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
				if (!tfOrdem.getText().isBlank() || !tfTitulo.getText().isBlank() || !tfDescricao.getText().isBlank()) {
					if (!tfOrdem.getText().isEmpty() || !tfTitulo.getText().isEmpty()
							|| !tfDescricao.getText().isEmpty()) {
						if (controle.Validacao.verificaInt(tfOrdem.getText())) {
							if(table.getSelectedRow() != -1) {
							topicos.get(table.getSelectedRow()).setPosicao(Integer.parseInt(tfOrdem.getText()));
							topicos.get(table.getSelectedRow()).setTitulo(tfTitulo.getText());
							topicos.get(table.getSelectedRow()).setExplicacao(tfDescricao.getText());
							JOptionPane.showMessageDialog(null, topicoDAO.salvar(topicos.get(table.getSelectedRow())));
							
							}
							else {
								JOptionPane.showMessageDialog(null, topicoDAO.criarNovo(tfTitulo.getText(), tfDescricao.getText(), Integer.parseInt(tfOrdem.getText())));
							}
							limparCampos();
							atualizarTabela();
						}
					}
				}
			}
		});
		
		btEditarPerguntas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!tfCodigo.getText().isBlank()) {
					if(!tfCodigo.getText().isEmpty()) {
						frameEdicaoPergunta = new JFrame();
						frameEdicaoPergunta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						frameEdicaoPergunta.getContentPane().add(new TelaManterPergunta(Integer.parseInt(tfCodigo.getText())));
						frameEdicaoPergunta.setSize(new Dimension(785, 560));
						frameEdicaoPergunta.setResizable(false);
						frameEdicaoPergunta.setLocationRelativeTo(null);
						frameEdicaoPergunta.setVisible(true);
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
		
		topicos = topicoDAO.get(
				"select cod_topico, ordem_topico, titulo_topico, descricao_topico from topico order by ordem_topico");
		
		for (Topico t : topicos) {
			model.addRow(new Object[] { t.getCodigo(), t.getPosicao(), t.getTitulo(), t.getExplicacao() });
		}
	}
	
	/**limpa os campos do tópico
	 * 
	 */
	private void limparCampos() {
		tfCodigo.setText("");
		tfOrdem.setText("");
		tfTitulo.setText("");
		tfDescricao.setText("");
		table.clearSelection();
	}
}
