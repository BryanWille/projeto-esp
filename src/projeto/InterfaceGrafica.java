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
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InterfaceGrafica {
    private DadosBrutos db = new DadosBrutos(DadosBrutos.getIndexRound());
    private DadosAgrupados da = new DadosAgrupados(DadosAgrupados.getIndexRound(),DadosAgrupados.getIndexRoundClasse());
    private Object[][] dados = da.converterLista(da.getTabela());
    private String[] colunas = { "Classe", "Intervalo de Classe", "Frequencia", "Frequencia Agrupada", "Ponto Medio" };

    JFrame frame;
    private JTable table;

    public String criarListaRol(ArrayList<Double> lista) {
        String listaRol = "";
        for(int i = 0; i < lista.size(); i++) {
            listaRol += lista.get(i) +", ";
        }
        listaRol = listaRol.substring(0, listaRol.lastIndexOf(", "));
        return listaRol;
    }

    /**
     * Launch the application.
     */

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
        frame.setBounds(100, 100, 1216, 629);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("logo.png")));
        frame.setIconImage(img.getImage());

        JLabel mainLabel = new JLabel("PresP ");
        mainLabel.setForeground(new Color(0, 0, 128));
        mainLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(mainLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(null);
        scrollPane.setBounds(28, 47, 745, 205);
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

        JPanel dadosAgrupados = new JPanel();
        dadosAgrupados.setBorder(new EmptyBorder(0, 0, 0, 0));
        dadosAgrupados.setBounds(28, 341, 502, 179);
        panel.add(dadosAgrupados);
        dadosAgrupados.setLayout(null);

        JTextPane textoCoefVarAG = new JTextPane();
        textoCoefVarAG.setBounds(398, 140, 100, 25);
        dadosAgrupados.add(textoCoefVarAG);
        textoCoefVarAG.setEditable(false);
        textoCoefVarAG.setText(String.valueOf(da.getCoeficienteVariacao()));

        JLabel lblCoefVariacao = new JLabel("Coef Variacao");
        lblCoefVariacao.setBounds(304, 144, 90, 14);
        dadosAgrupados.add(lblCoefVariacao);
        lblCoefVariacao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCoefVariacao.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoDesvioAG = new JTextPane();
        textoDesvioAG.setBounds(397, 108, 101, 25);
        dadosAgrupados.add(textoDesvioAG);
        textoDesvioAG.setEditable(false);
        textoDesvioAG.setText(String.valueOf(da.getDesvioPadrao()));

        JLabel lblDesvioPadrao = new JLabel("Desvio Padrao");
        lblDesvioPadrao.setBounds(304, 112, 90, 14);
        dadosAgrupados.add(lblDesvioPadrao);
        lblDesvioPadrao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDesvioPadrao.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoVarianciaAG = new JTextPane();
        textoVarianciaAG.setBounds(398, 76, 100, 25);
        dadosAgrupados.add(textoVarianciaAG);
        textoVarianciaAG.setEditable(false);
        textoVarianciaAG.setText(String.valueOf(da.getVariancia()));

        JLabel lblVariancia = new JLabel("Variancia");
        lblVariancia.setBounds(332, 80, 62, 14);
        dadosAgrupados.add(lblVariancia);
        lblVariancia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVariancia.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoModaAG = new JTextPane();
        textoModaAG.setBounds(198, 140, 100, 25);
        dadosAgrupados.add(textoModaAG);
        textoModaAG.setEditable(false);
        textoModaAG.setText(String.valueOf(da.getModa()));

        JLabel lblModa = new JLabel("Moda");
        lblModa.setBounds(156, 145, 35, 14);
        dadosAgrupados.add(lblModa);
        lblModa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModa.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMedianaAG = new JTextPane();
        textoMedianaAG.setBounds(198, 108, 100, 25);
        dadosAgrupados.add(textoMedianaAG);
        textoMedianaAG.setEditable(false);
        textoMedianaAG.setText(String.valueOf(da.getMediana()));

        JLabel lblMediana = new JLabel("Mediana");
        lblMediana.setBounds(143, 114, 49, 14);
        dadosAgrupados.add(lblMediana);
        lblMediana.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMediana.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMediaAG = new JTextPane();
        textoMediaAG.setBounds(198, 76, 100, 25);
        dadosAgrupados.add(textoMediaAG);
        textoMediaAG.setEditable(false);
        textoMediaAG.setText(String.valueOf(da.getMedia()));

        JLabel lblMedia = new JLabel("Media");
        lblMedia.setBounds(156, 82, 35, 14);
        dadosAgrupados.add(lblMedia);
        lblMedia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoa = new JTextPane();
        textoa.setBounds(31, 140, 100, 25);
        dadosAgrupados.add(textoa);
        textoa.setEditable(false);
        textoa.setText(String.valueOf(da.getAmplitudeClasse()));

        JTextPane textoAmplitude = new JTextPane();
        textoAmplitude.setBounds(31, 108, 100, 25);
        dadosAgrupados.add(textoAmplitude);
        textoAmplitude.setEditable(false);
        textoAmplitude.setText(String.valueOf(da.getAmplitude()));

        JTextPane textoK = new JTextPane();
        textoK.setBounds(31, 76, 100, 25);
        dadosAgrupados.add(textoK);
        textoK.setEditable(false);
        textoK.setText(String.valueOf(da.getK()));

        JLabel lblK = new JLabel("K");
        lblK.setBounds(6, 81, 17, 14);
        dadosAgrupados.add(lblK);
        lblK.setHorizontalAlignment(SwingConstants.RIGHT);
        lblK.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblAmplitude = new JLabel("A");
        lblAmplitude.setBounds(7, 111, 17, 14);
        dadosAgrupados.add(lblAmplitude);
        lblAmplitude.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAmplitude.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lbla = new JLabel("a");
        lbla.setBounds(6, 143, 17, 14);
        dadosAgrupados.add(lbla);
        lbla.setHorizontalAlignment(SwingConstants.RIGHT);
        lbla.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblDispersao = new JLabel("Dispersao");
        lblDispersao.setBounds(390, 36, 108, 32);
        dadosAgrupados.add(lblDispersao);
        lblDispersao.setHorizontalAlignment(SwingConstants.CENTER);
        lblDispersao.setForeground(Color.GRAY);
        lblDispersao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblPosicao = new JLabel("Posicao");
        lblPosicao.setBounds(190, 36, 108, 32);
        dadosAgrupados.add(lblPosicao);
        lblPosicao.setHorizontalAlignment(SwingConstants.CENTER);
        lblPosicao.setForeground(Color.GRAY);
        lblPosicao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblDistribuicao = new JLabel("Distribuicao");
        lblDistribuicao.setBounds(25, 38, 108, 32);
        dadosAgrupados.add(lblDistribuicao);
        lblDistribuicao.setForeground(Color.GRAY);
        lblDistribuicao.setHorizontalAlignment(SwingConstants.CENTER);
        lblDistribuicao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel labelDadosAgrupados = new JLabel("Dados Agrupados");
        labelDadosAgrupados.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
        labelDadosAgrupados.setBounds(148, 2, 162, 41);
        dadosAgrupados.add(labelDadosAgrupados);
        labelDadosAgrupados.setFont(new Font("Verdana", Font.BOLD, 16));
        labelDadosAgrupados.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel analiseDados = new JPanel();
        analiseDados.setBorder(new EmptyBorder(0, 0, 0, 0));
        analiseDados.setBounds(817, 60, 371, 207);
        panel.add(analiseDados);
        analiseDados.setLayout(null);

        JLabel labelQuartil = new JLabel("Quartis");
        labelQuartil.setBounds(18, 56, 46, 14);
        analiseDados.add(labelQuartil);
        labelQuartil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelQuartil.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel labelDecil = new JLabel("Decis");
        labelDecil.setBounds(117, 57, 46, 14);
        analiseDados.add(labelDecil);
        labelDecil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelDecil.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel labelPercentil = new JLabel("Percentis");
        labelPercentil.setBounds(215, 57, 62, 14);
        analiseDados.add(labelPercentil);
        labelPercentil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelPercentil.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton separatriz = new JButton("Calcular"); // Quartis
        separatriz.setBounds(139, 92, 90, 31);
        analiseDados.add(separatriz);
        separatriz.setFont(new Font("Tahoma", Font.PLAIN, 10));

        JLabel lblIndex = new JLabel("index");
        lblIndex.setBounds(73, 36, 46, 14);
        analiseDados.add(lblIndex);
        lblIndex.setForeground(Color.GRAY);

        JLabel lblAnaliseDeDados = new JLabel("Analise de Dados");
        lblAnaliseDeDados.setBounds(110, -1, 149, 32);
        analiseDados.add(lblAnaliseDeDados);
        lblAnaliseDeDados.setHorizontalAlignment(SwingConstants.CENTER);
        lblAnaliseDeDados.setForeground(Color.DARK_GRAY);
        lblAnaliseDeDados.setFont(new Font("Verdana", Font.BOLD, 16));


        JComboBox comboBoxQuartil = new JComboBox();
        comboBoxQuartil.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
        comboBoxQuartil.setBounds(73, 54, 46, 19);
        analiseDados.add(comboBoxQuartil);

        JComboBox comboBoxDecil = new JComboBox();
        comboBoxDecil.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBoxDecil.setBounds(168, 55, 46, 19);
        analiseDados.add(comboBoxDecil);

        JComboBox comboBoxPercentil = new JComboBox();
        comboBoxPercentil.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
        comboBoxPercentil.setBounds(284, 55, 46, 19);
        analiseDados.add(comboBoxPercentil);

        JTextPane textoSeparatriz = new JTextPane();
        textoSeparatriz.setFont(new Font("Dialog", Font.PLAIN, 13));
        textoSeparatriz.setBounds(72, 139, 230, 63);
        analiseDados.add(textoSeparatriz);
        textoSeparatriz.setEditable(false);

        JLabel lblIndex_1 = new JLabel("index");
        lblIndex_1.setForeground(Color.GRAY);
        lblIndex_1.setBounds(169, 38, 46, 14);
        analiseDados.add(lblIndex_1);

        JLabel lblIndex_1_1 = new JLabel("index");
        lblIndex_1_1.setForeground(Color.GRAY);
        lblIndex_1_1.setBounds(284, 36, 46, 14);
        analiseDados.add(lblIndex_1_1);
        textoSeparatriz.setVisible(false);

        JPanel dadosBrutos = new JPanel();
        dadosBrutos.setBorder(new EmptyBorder(0, 0, 0, 0));
        dadosBrutos.setBounds(678, 326, 431, 238);
        panel.add(dadosBrutos);
        dadosBrutos.setLayout(null);

        JLabel lblDadosBrutos = new JLabel("Dados Brutos");
        lblDadosBrutos.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
        lblDadosBrutos.setBounds(147, 0, 162, 41);
        dadosBrutos.add(lblDadosBrutos);
        lblDadosBrutos.setHorizontalAlignment(SwingConstants.CENTER);
        lblDadosBrutos.setFont(new Font("Verdana", Font.BOLD, 16));

        JTextPane textoMediaBR = new JTextPane();
        textoMediaBR.setBounds(67, 75, 100, 25);
        dadosBrutos.add(textoMediaBR);
        textoMediaBR.setText(String.valueOf(db.getMedia()));
        textoMediaBR.setEditable(false);

        JLabel lblMediaBR = new JLabel("Media");
        lblMediaBR.setBounds(25, 81, 35, 14);
        dadosBrutos.add(lblMediaBR);
        lblMediaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMediaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblMedianaBR = new JLabel("Mediana");
        lblMedianaBR.setBounds(12, 113, 49, 14);
        dadosBrutos.add(lblMedianaBR);
        lblMedianaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMedianaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMedianaBR = new JTextPane();
        textoMedianaBR.setBounds(67, 107, 100, 25);
        dadosBrutos.add(textoMedianaBR);
        textoMedianaBR.setText(String.valueOf(db.getMediana()));
        textoMedianaBR.setEditable(false);

        JTextPane textoModaBR = new JTextPane();
        textoModaBR.setBounds(67, 139, 100, 82);
        dadosBrutos.add(textoModaBR);
        String resultadoModa = "Número(s) moda:";
        for (int i = 0; i < db.getModa().size() - 1; i++) {
            resultadoModa += " " + db.getModa().get(i);
        }
        resultadoModa += " \nrepeticoes: " + db.getModa().get(db.getModa().size() - 1);
        textoModaBR.setText(resultadoModa);
        textoModaBR.setEditable(false);

        JLabel lblModaBR = new JLabel("Moda");
        lblModaBR.setBounds(25, 169, 35, 14);
        dadosBrutos.add(lblModaBR);
        lblModaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoCoefVarBR = new JTextPane();
        textoCoefVarBR.setBounds(291, 139, 120, 25);
        dadosBrutos.add(textoCoefVarBR);
        textoCoefVarBR.setText(String.valueOf(db.getCoeficienteVariacao()));
        textoCoefVarBR.setEditable(false);

        JLabel lblCoefVariacaoBR = new JLabel("Coef Variacao");
        lblCoefVariacaoBR.setBounds(197, 143, 90, 14);
        dadosBrutos.add(lblCoefVariacaoBR);
        lblCoefVariacaoBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCoefVariacaoBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoDesvioBR = new JTextPane();
        textoDesvioBR.setBounds(290, 107, 121, 25);
        dadosBrutos.add(textoDesvioBR);
        textoDesvioBR.setText(String.valueOf(db.getDesvioPadrao()));
        textoDesvioBR.setEditable(false);

        JLabel lblDesvioPadraoBR = new JLabel("Desvio Padrao");
        lblDesvioPadraoBR.setBounds(197, 111, 90, 14);
        dadosBrutos.add(lblDesvioPadraoBR);
        lblDesvioPadraoBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDesvioPadraoBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoVarianciaBR = new JTextPane();
        textoVarianciaBR.setBounds(291, 75, 120, 25);
        dadosBrutos.add(textoVarianciaBR);
        textoVarianciaBR.setText(String.valueOf(db.getVariancia()));
        textoVarianciaBR.setEditable(false);

        JLabel lblVarianciaBR = new JLabel("Variancia");
        lblVarianciaBR.setBounds(225, 79, 62, 14);
        dadosBrutos.add(lblVarianciaBR);
        lblVarianciaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVarianciaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblDispersaoBR = new JLabel("Dispersao");
        lblDispersaoBR.setBounds(283, 35, 108, 32);
        dadosBrutos.add(lblDispersaoBR);
        lblDispersaoBR.setHorizontalAlignment(SwingConstants.CENTER);
        lblDispersaoBR.setForeground(Color.GRAY);
        lblDispersaoBR.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblPosicaoBR = new JLabel("Posicao");
        lblPosicaoBR.setBounds(59, 35, 108, 32);
        dadosBrutos.add(lblPosicaoBR);
        lblPosicaoBR.setHorizontalAlignment(SwingConstants.CENTER);
        lblPosicaoBR.setForeground(Color.GRAY);
        lblPosicaoBR.setFont(new Font("Verdana", Font.BOLD, 13));

        JTextPane textoSomaTotal = new JTextPane();
        textoSomaTotal.setText("462.0");
        textoSomaTotal.setEditable(false);
        textoSomaTotal.setBounds(467, 264, 62, 25);
        panel.add(textoSomaTotal);
        textoSomaTotal.setText(String.valueOf(db.getSomaTotal()));

        JLabel somaTotalLabel = new JLabel("Soma Total");
        somaTotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        somaTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        somaTotalLabel.setBounds(392, 270, 71, 14);
        panel.add(somaTotalLabel);

        JTextPane textoQuantElementos = new JTextPane();
        textoQuantElementos.setText("462.0");
        textoQuantElementos.setEditable(false);
        textoQuantElementos.setBounds(659, 264, 62, 25);
        textoQuantElementos.setText(String.valueOf(da.getFrequenciaTotal()));
        panel.add(textoQuantElementos);

        JLabel lblQuantElementos = new JLabel("Quant. Elementos");
        lblQuantElementos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblQuantElementos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblQuantElementos.setBounds(549, 268, 104, 14);
        panel.add(lblQuantElementos);

        JLabel createdBy = new JLabel("Criado por: Bryan Wille e Pedro Gabriel");
        createdBy.setForeground(Color.GRAY);
        createdBy.setBounds(24, 538, 231, 16);
        panel.add(createdBy);

        JLabel lblDistr = new JLabel("Tabela de Distribuicao de Frequencia");
        lblDistr.setHorizontalAlignment(SwingConstants.CENTER);
        lblDistr.setForeground(Color.DARK_GRAY);
        lblDistr.setFont(new Font("Verdana", Font.BOLD, 16));
        lblDistr.setBounds(229, 12, 366, 32);
        panel.add(lblDistr);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.GRAY);
        panel_1.setForeground(Color.BLACK);
        panel_1.setBounds(-3, 313, 1200, 2);
        panel.add(panel_1);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(587, 314, 2, 250);
        panel.add(panel_1_1);
        panel_1_1.setForeground(Color.BLACK);
        panel_1_1.setBackground(Color.GRAY);

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setForeground(Color.BLACK);
        panel_1_1_1.setBackground(Color.GRAY);
        panel_1_1_1.setBounds(800, -1, 2, 316);
        panel.add(panel_1_1_1);

        JPanel panel_1_2 = new JPanel();
        panel_1_2.setForeground(Color.BLACK);
        panel_1_2.setBackground(Color.GRAY);
        panel_1_2.setBounds(0, 1, 1200, 2);
        panel.add(panel_1_2);

        JLabel labelRol = new JLabel("Dados em Rol:");
        labelRol.setHorizontalAlignment(SwingConstants.RIGHT);
        labelRol.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelRol.setBounds(60, 268, 84, 14);
        panel.add(labelRol);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(148, 257, 235, 40);
        panel.add(scrollPane_2);

        JTextArea textAreaDadosRol = new JTextArea();
        scrollPane_2.setViewportView(textAreaDadosRol);
        textAreaDadosRol.setText(this.criarListaRol(Leitura.getLista()));

        separatriz.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == separatriz) {
                    String texto = "";
                    int quartil = comboBoxQuartil.getSelectedIndex()+1;
                    int decil = comboBoxDecil.getSelectedIndex()+1;
                    int percentil = comboBoxPercentil.getSelectedIndex()+1;


                    texto = "Quartil: "
                            + (quartil == 0 ? "nao informado" : String.valueOf(da.calcularSeparatriz(4, quartil)));
                    texto += "\nDecil: "
                            + (decil == 0 ? "nao informado" : String.valueOf(da.calcularSeparatriz(10, decil)));
                    texto += "\nPercentil: " + (percentil == 0 ? "nao informado"
                            : String.valueOf(da.calcularSeparatriz(100, percentil)));
                    ;

                    textoSeparatriz.setText(texto);
                    textoSeparatriz.setVisible(true);
                }

            }
        });
        frame.setVisible(true);
    }
}



