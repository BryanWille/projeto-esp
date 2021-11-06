package projeto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.EmptyBorder;

public class InterfaceGrafica {
	private DadosAgrupados da = new DadosAgrupados();
	private Object[][] dados = da.converterLista(da.getTabela());
	private String[] colunas = { "Classe", "Intervalo de Classe", "Frequencia", "Frequencia Agrupada", "Ponto Medio" };

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("PresP");
		frame.setResizable(false);
		frame.setBounds(100, 100, 1171, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("logo.png")));
		frame.setIconImage(img.getImage());

		JLabel lblNewLabel = new JLabel("Trabalho de Estat\u00EDstica");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(178, 8, 745, 177);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(scrollPane);

		
		table = new JTable(dados, colunas);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(170);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		TableColumn primeiraColuna = table.getColumnModel().getColumn(0);
		TableColumn segundaColuna = table.getColumnModel().getColumn(1);
		TableColumn terceiraColuna = table.getColumnModel().getColumn(2);
		TableColumn quartaColuna = table.getColumnModel().getColumn(3);
		TableColumn quintaColuna = table.getColumnModel().getColumn(4);
		primeiraColuna.setMaxWidth(70);
		
		DefaultTableCellRenderer alinharCelula = new DefaultTableCellRenderer();
		alinharCelula.setHorizontalAlignment(SwingConstants.CENTER);
		primeiraColuna.setCellRenderer(alinharCelula);
		segundaColuna.setCellRenderer(alinharCelula);
		terceiraColuna.setCellRenderer(alinharCelula);
		quartaColuna.setCellRenderer(alinharCelula);
		quintaColuna.setCellRenderer(alinharCelula);
		
		scrollPane.setViewportView(table);

		JLabel labelQuartil = new JLabel("Quartis");
		labelQuartil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelQuartil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelQuartil.setBounds(65, 419, 46, 14);
		panel.add(labelQuartil);

		JLabel labelDecil = new JLabel("Decis");
		labelDecil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDecil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelDecil.setBounds(64, 448, 46, 14);
		panel.add(labelDecil);

		JLabel labelPercentil = new JLabel("Percentis");
		labelPercentil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelPercentil.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPercentil.setBounds(49, 480, 62, 14);
		panel.add(labelPercentil);

		JTextPane textoQuartis = new JTextPane();
		textoQuartis.setBounds(120, 416, 35, 20);
		panel.add(textoQuartis);

		JTextPane textoDecis = new JTextPane();
		textoDecis.setBounds(120, 447, 35, 20);
		panel.add(textoDecis);

		JTextPane textoPercentis = new JTextPane();
		textoPercentis.setBounds(120, 478, 35, 20);
		panel.add(textoPercentis);

		JButton separatriz = new JButton("Calcular"); // Quartis
		separatriz.setFont(new Font("Tahoma", Font.PLAIN, 10));
		separatriz.setBounds(167, 440, 90, 31);
		panel.add(separatriz);
		
		JTextPane textoSeparatriz = new JTextPane();
		textoSeparatriz.setBounds(268, 427, 165, 58);
		textoSeparatriz.setEditable(false);
		textoSeparatriz.setVisible(false);
		panel.add(textoSeparatriz);
		
		JLabel labelDadosAgrupados = new JLabel("Dados Agrupados");
		labelDadosAgrupados.setFont(new Font("Verdana", Font.BOLD, 16));
		labelDadosAgrupados.setHorizontalAlignment(SwingConstants.CENTER);
		labelDadosAgrupados.setBounds(146, 176, 162, 41);
		panel.add(labelDadosAgrupados);
		
		JLabel lblIndex = new JLabel("index");
		lblIndex.setForeground(Color.GRAY);
		lblIndex.setBounds(120, 396, 46, 14);
		panel.add(lblIndex);
		
		JLabel lblDadosBrutos = new JLabel("Dados Brutos");
		lblDadosBrutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosBrutos.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDadosBrutos.setBounds(791, 188, 162, 41);
		panel.add(lblDadosBrutos);
		
		JLabel lblAmplitude = new JLabel("A");
		lblAmplitude.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmplitude.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAmplitude.setBounds(27, 307, 17, 14);
		panel.add(lblAmplitude);
		
		JTextPane textoAmplitude = new JTextPane();
		textoAmplitude.setEditable(false);
		textoAmplitude.setBounds(49, 290, 62, 25);
		textoAmplitude.setText(String.valueOf(da.getAmplitude()));
		panel.add(textoAmplitude);
		
		JTextPane textoK = new JTextPane();
		textoK.setEditable(false);
		textoK.setBounds(49, 258, 62, 25);
		textoK.setText(String.valueOf(da.getK()));
		panel.add(textoK);
		
		JLabel lblK = new JLabel("K");
		lblK.setHorizontalAlignment(SwingConstants.RIGHT);
		lblK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblK.setBounds(26, 277, 17, 14);
		panel.add(lblK);
		
		JLabel lbla = new JLabel("a");
		lbla.setHorizontalAlignment(SwingConstants.RIGHT);
		lbla.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbla.setBounds(26, 339, 17, 14);
		panel.add(lbla);
		
		JTextPane textoa = new JTextPane();
		textoa.setEditable(false);
		textoa.setBounds(49, 322, 62, 25);
		textoa.setText(String.valueOf(da.getAmplitudeClasse()));
		panel.add(textoa);
		
		JLabel lblMedia = new JLabel("Media");
		lblMedia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMedia.setBounds(153, 264, 35, 14);
		panel.add(lblMedia);
		
		JTextPane textoMediaAG = new JTextPane();
		textoMediaAG.setEditable(false);
		textoMediaAG.setBounds(195, 258, 62, 25);
		textoMediaAG.setText(String.valueOf(da.getMedia()));
		panel.add(textoMediaAG);
		
		JTextPane textoMedianaAG = new JTextPane();
		textoMedianaAG.setEditable(false);
		textoMedianaAG.setBounds(195, 290, 62, 25);
		textoMedianaAG.setText(String.valueOf(da.getMediana()));
		panel.add(textoMedianaAG);
		
		JLabel lblModa = new JLabel("Moda");
		lblModa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModa.setBounds(153, 327, 35, 14);
		panel.add(lblModa);
		
		JTextPane textoModaAG = new JTextPane();
		textoModaAG.setEditable(false);
		textoModaAG.setBounds(195, 322, 62, 25);
		textoModaAG.setText(String.valueOf(da.getModa()));
		panel.add(textoModaAG);
		
		JLabel lblVariancia = new JLabel("Variancia");
		lblVariancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVariancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVariancia.setBounds(306, 263, 62, 14);
		panel.add(lblVariancia);
		
		JTextPane textoVarianciaAG = new JTextPane();
		textoVarianciaAG.setEditable(false);
		textoVarianciaAG.setBounds(379, 258, 62, 25);
		textoVarianciaAG.setText(String.valueOf(da.getVariancia()));
		panel.add(textoVarianciaAG);
		
		JTextPane textoDesvioAG = new JTextPane();
		textoDesvioAG.setEditable(false);
		textoDesvioAG.setBounds(378, 290, 63, 25);
		textoDesvioAG.setText(String.valueOf(da.getDesvioPadrao()));
		panel.add(textoDesvioAG);
		
		JLabel lblDesvioPadrao = new JLabel("Desvio Padrao");
		lblDesvioPadrao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDesvioPadrao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesvioPadrao.setBounds(278, 295, 90, 14);
		panel.add(lblDesvioPadrao);
		
		JLabel lblCoefVariacao = new JLabel("Coef Variacao");
		lblCoefVariacao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoefVariacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCoefVariacao.setBounds(278, 327, 90, 14);
		panel.add(lblCoefVariacao);
		
		JTextPane textoCoefVarAG = new JTextPane();
		textoCoefVarAG.setEditable(false);
		textoCoefVarAG.setBounds(379, 322, 62, 25);
		textoCoefVarAG.setText(String.valueOf(da.getCoeficienteVariacao()));
		panel.add(textoCoefVarAG);
		
		JLabel lblMediana = new JLabel("Mediana");
		lblMediana.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMediana.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMediana.setBounds(138, 298, 49, 14);
		panel.add(lblMediana);
		
		JLabel lblDistribuicao = new JLabel("Distribuicao");
		lblDistribuicao.setForeground(Color.GRAY);
		lblDistribuicao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistribuicao.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDistribuicao.setBounds(22, 214, 108, 32);
		panel.add(lblDistribuicao);
		
		JLabel lblPosicao = new JLabel("Posicao");
		lblPosicao.setHorizontalAlignment(SwingConstants.CENTER);
		lblPosicao.setForeground(Color.GRAY);
		lblPosicao.setFont(new Font("Verdana", Font.BOLD, 13));
		lblPosicao.setBounds(169, 214, 108, 32);
		panel.add(lblPosicao);
		
		JLabel lblDispersao = new JLabel("Dispersao");
		lblDispersao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDispersao.setForeground(Color.GRAY);
		lblDispersao.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDispersao.setBounds(358, 214, 108, 32);
		panel.add(lblDispersao);
		
		JLabel lblAnaliseDeDados = new JLabel("Analise de Dados");
		lblAnaliseDeDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnaliseDeDados.setForeground(Color.GRAY);
		lblAnaliseDeDados.setFont(new Font("Verdana", Font.BOLD, 13));
		lblAnaliseDeDados.setBounds(149, 362, 149, 32);
		panel.add(lblAnaliseDeDados);
		
		separatriz.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == separatriz) {
					String texto = "";
					String quartil = textoQuartis.getText();
					String decil = textoDecis.getText();
					String percentil = textoPercentis.getText();
					
					texto = "Quartil: " + (quartil.length() == 0  ? "nao informado" : String.valueOf(da.calcularSeparatriz(4, Integer.parseInt(quartil))));
					texto += "\nDecil: " + (decil.length() == 0  ? "nao informado" : String.valueOf(da.calcularSeparatriz(10, Integer.parseInt(decil))));
					texto += "\nPercentil: " + (percentil.length() == 0  ? "nao informado" : String.valueOf(da.calcularSeparatriz(100, Integer.parseInt(percentil))));;
					
					
					textoSeparatriz.setText(texto);
					textoSeparatriz.setVisible(true);
				}

			}
		});

	}
}
