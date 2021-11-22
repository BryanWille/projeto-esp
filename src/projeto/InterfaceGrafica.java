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

public class InterfaceGrafica {
    private DadosBrutos db = new DadosBrutos();
    private DadosAgrupados da = new DadosAgrupados();
    private Object[][] dados = da.converterLista(da.getTabela());
    private String[] colunas = { "Classe", "Intervalo de Classe", "Frequencia", "Frequencia Agrupada", "Ponto Medio" };

    private int indexQuartil;
    private int indexDecil;
    private int indexPercentil;

    JFrame frame;
    private JTable table;

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
        frame.setBounds(100, 100, 1171, 585);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("logo.png")));
        frame.setIconImage(img.getImage());

        JLabel lblNewLabel = new JLabel("Distribuicao de Frequencia");
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(null);
        scrollPane.setBounds(178, 8, 745, 147);
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
        dadosAgrupados.setBounds(83, 173, 431, 191);
        panel.add(dadosAgrupados);
        dadosAgrupados.setLayout(null);

        JTextPane textoCoefVarAG = new JTextPane();
        textoCoefVarAG.setBounds(357, 150, 62, 25);
        dadosAgrupados.add(textoCoefVarAG);
        textoCoefVarAG.setEditable(false);
        textoCoefVarAG.setText(String.valueOf(da.getCoeficienteVariacao()));

        JLabel lblCoefVariacao = new JLabel("Coef Variacao");
        lblCoefVariacao.setBounds(263, 154, 90, 14);
        dadosAgrupados.add(lblCoefVariacao);
        lblCoefVariacao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCoefVariacao.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoDesvioAG = new JTextPane();
        textoDesvioAG.setBounds(356, 118, 63, 25);
        dadosAgrupados.add(textoDesvioAG);
        textoDesvioAG.setEditable(false);
        textoDesvioAG.setText(String.valueOf(da.getDesvioPadrao()));

        JLabel lblDesvioPadrao = new JLabel("Desvio Padrao");
        lblDesvioPadrao.setBounds(263, 122, 90, 14);
        dadosAgrupados.add(lblDesvioPadrao);
        lblDesvioPadrao.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDesvioPadrao.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoVarianciaAG = new JTextPane();
        textoVarianciaAG.setBounds(357, 86, 62, 25);
        dadosAgrupados.add(textoVarianciaAG);
        textoVarianciaAG.setEditable(false);
        textoVarianciaAG.setText(String.valueOf(da.getVariancia()));

        JLabel lblVariancia = new JLabel("Variancia");
        lblVariancia.setBounds(291, 90, 62, 14);
        dadosAgrupados.add(lblVariancia);
        lblVariancia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVariancia.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoModaAG = new JTextPane();
        textoModaAG.setBounds(189, 150, 62, 25);
        dadosAgrupados.add(textoModaAG);
        textoModaAG.setEditable(false);
        textoModaAG.setText(String.valueOf(da.getModa()));

        JLabel lblModa = new JLabel("Moda");
        lblModa.setBounds(147, 155, 35, 14);
        dadosAgrupados.add(lblModa);
        lblModa.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModa.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMedianaAG = new JTextPane();
        textoMedianaAG.setBounds(189, 118, 62, 25);
        dadosAgrupados.add(textoMedianaAG);
        textoMedianaAG.setEditable(false);
        textoMedianaAG.setText(String.valueOf(da.getMediana()));

        JLabel lblMediana = new JLabel("Mediana");
        lblMediana.setBounds(134, 124, 49, 14);
        dadosAgrupados.add(lblMediana);
        lblMediana.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMediana.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMediaAG = new JTextPane();
        textoMediaAG.setBounds(189, 86, 62, 25);
        dadosAgrupados.add(textoMediaAG);
        textoMediaAG.setEditable(false);
        textoMediaAG.setText(String.valueOf(da.getMedia()));

        JLabel lblMedia = new JLabel("Media");
        lblMedia.setBounds(147, 92, 35, 14);
        dadosAgrupados.add(lblMedia);
        lblMedia.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoa = new JTextPane();
        textoa.setBounds(43, 150, 62, 25);
        dadosAgrupados.add(textoa);
        textoa.setEditable(false);
        textoa.setText(String.valueOf(da.getAmplitudeClasse()));

        JTextPane textoAmplitude = new JTextPane();
        textoAmplitude.setBounds(43, 118, 62, 25);
        dadosAgrupados.add(textoAmplitude);
        textoAmplitude.setEditable(false);
        textoAmplitude.setText(String.valueOf(da.getAmplitude()));

        JTextPane textoK = new JTextPane();
        textoK.setBounds(43, 86, 62, 25);
        dadosAgrupados.add(textoK);
        textoK.setEditable(false);
        textoK.setText(String.valueOf(da.getK()));

        JLabel lblK = new JLabel("K");
        lblK.setBounds(18, 91, 17, 14);
        dadosAgrupados.add(lblK);
        lblK.setHorizontalAlignment(SwingConstants.RIGHT);
        lblK.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblAmplitude = new JLabel("A");
        lblAmplitude.setBounds(19, 121, 17, 14);
        dadosAgrupados.add(lblAmplitude);
        lblAmplitude.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAmplitude.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lbla = new JLabel("a");
        lbla.setBounds(18, 153, 17, 14);
        dadosAgrupados.add(lbla);
        lbla.setHorizontalAlignment(SwingConstants.RIGHT);
        lbla.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblDispersao = new JLabel("Dispersao");
        lblDispersao.setBounds(334, 46, 108, 32);
        dadosAgrupados.add(lblDispersao);
        lblDispersao.setHorizontalAlignment(SwingConstants.CENTER);
        lblDispersao.setForeground(Color.GRAY);
        lblDispersao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblPosicao = new JLabel("Posicao");
        lblPosicao.setBounds(164, 48, 108, 32);
        dadosAgrupados.add(lblPosicao);
        lblPosicao.setHorizontalAlignment(SwingConstants.CENTER);
        lblPosicao.setForeground(Color.GRAY);
        lblPosicao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblDistribuicao = new JLabel("Distribuicao");
        lblDistribuicao.setBounds(24, 48, 108, 32);
        dadosAgrupados.add(lblDistribuicao);
        lblDistribuicao.setForeground(Color.GRAY);
        lblDistribuicao.setHorizontalAlignment(SwingConstants.CENTER);
        lblDistribuicao.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel labelDadosAgrupados = new JLabel("Dados Agrupados");
        labelDadosAgrupados.setBounds(147, 12, 162, 41);
        dadosAgrupados.add(labelDadosAgrupados);
        labelDadosAgrupados.setFont(new Font("Verdana", Font.BOLD, 16));
        labelDadosAgrupados.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel analiseDados = new JPanel();
        analiseDados.setBorder(new EmptyBorder(0, 0, 0, 0));
        analiseDados.setBounds(107, 365, 407, 136);
        panel.add(analiseDados);
        analiseDados.setLayout(null);

        JLabel labelQuartil = new JLabel("Quartis");
        labelQuartil.setBounds(26, 54, 46, 14);
        analiseDados.add(labelQuartil);
        labelQuartil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelQuartil.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel labelDecil = new JLabel("Decis");
        labelDecil.setBounds(25, 81, 46, 14);
        analiseDados.add(labelDecil);
        labelDecil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelDecil.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel labelPercentil = new JLabel("Percentis");
        labelPercentil.setBounds(12, 110, 62, 14);
        analiseDados.add(labelPercentil);
        labelPercentil.setFont(new Font("Tahoma", Font.PLAIN, 13));
        labelPercentil.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton separatriz = new JButton("Calcular"); // Quartis
        separatriz.setBounds(129, 71, 90, 31);
        analiseDados.add(separatriz);
        separatriz.setFont(new Font("Tahoma", Font.PLAIN, 10));

        JTextPane textoSeparatriz = new JTextPane();
        textoSeparatriz.setBounds(230, 58, 165, 58);
        analiseDados.add(textoSeparatriz);
        textoSeparatriz.setEditable(false);

        JLabel lblIndex = new JLabel("index");
        lblIndex.setBounds(81, 31, 46, 14);
        analiseDados.add(lblIndex);
        lblIndex.setForeground(Color.GRAY);

        JLabel lblAnaliseDeDados = new JLabel("Analise de Dados");
        lblAnaliseDeDados.setBounds(128, -2, 149, 32);
        analiseDados.add(lblAnaliseDeDados);
        lblAnaliseDeDados.setHorizontalAlignment(SwingConstants.CENTER);
        lblAnaliseDeDados.setForeground(Color.DARK_GRAY);
        lblAnaliseDeDados.setFont(new Font("Verdana", Font.BOLD, 16));

        JScrollPane quartisScroll = new JScrollPane();
        quartisScroll.setBounds(82, 53, 34, 20);
        analiseDados.add(quartisScroll);

        Object[] valorQuartil = { "0", "1", "2", "3", "4" };
        JList listaQuartis = new JList(valorQuartil);
        listaQuartis.setValueIsAdjusting(true);
        quartisScroll.setViewportView(listaQuartis);

        JScrollPane decilScroll = new JScrollPane();
        decilScroll.setBounds(82, 80, 34, 20);
        analiseDados.add(decilScroll);

        Object[] valorDecil = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        JList listaDecil = new JList(valorDecil);
        decilScroll.setViewportView(listaDecil);

        JScrollPane percentilScroll = new JScrollPane();
        percentilScroll.setBounds(81, 107, 46, 20);
        analiseDados.add(percentilScroll);

        Object[] valorPercentil = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
                "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
                "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65",
                "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82",
                "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99",
                "100" };

        JList listaPercentil = new JList(valorPercentil);
        percentilScroll.setViewportView(listaPercentil);

        JPanel dadosBrutos = new JPanel();
        dadosBrutos.setBorder(new EmptyBorder(0, 0, 0, 0));
        dadosBrutos.setBounds(669, 227, 431, 238);
        panel.add(dadosBrutos);
        dadosBrutos.setLayout(null);

        JLabel lblDadosBrutos = new JLabel("Dados Brutos");
        lblDadosBrutos.setBounds(147, 0, 162, 41);
        dadosBrutos.add(lblDadosBrutos);
        lblDadosBrutos.setHorizontalAlignment(SwingConstants.CENTER);
        lblDadosBrutos.setFont(new Font("Verdana", Font.BOLD, 16));

        JTextPane textoMediaBR = new JTextPane();
        textoMediaBR.setBounds(114, 82, 62, 25);
        dadosBrutos.add(textoMediaBR);
        textoMediaBR.setText(String.valueOf(db.getMedia()));
        textoMediaBR.setEditable(false);

        JLabel lblMediaBR = new JLabel("Media");
        lblMediaBR.setBounds(72, 88, 35, 14);
        dadosBrutos.add(lblMediaBR);
        lblMediaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMediaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblMedianaBR = new JLabel("Mediana");
        lblMedianaBR.setBounds(59, 120, 49, 14);
        dadosBrutos.add(lblMedianaBR);
        lblMedianaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMedianaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoMedianaBR = new JTextPane();
        textoMedianaBR.setBounds(114, 114, 62, 25);
        dadosBrutos.add(textoMedianaBR);
        textoMedianaBR.setText(String.valueOf(db.getMediana()));
        textoMedianaBR.setEditable(false);

        JTextPane textoModaBR = new JTextPane();
        textoModaBR.setBounds(59, 146, 117, 82);
        dadosBrutos.add(textoModaBR);
        String resultadoModa = "Número(s) moda:";
        for (int i = 0; i < db.getModa().size() - 1; i++) {
            resultadoModa += " " + db.getModa().get(i);
        }
        resultadoModa += " \nrepeticoes: " + db.getModa().get(db.getModa().size() - 1);
        textoModaBR.setText(resultadoModa);
        textoModaBR.setEditable(false);

        JLabel lblModaBR = new JLabel("Moda");
        lblModaBR.setBounds(19, 171, 35, 14);
        dadosBrutos.add(lblModaBR);
        lblModaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoCoefVarBR = new JTextPane();
        textoCoefVarBR.setBounds(282, 146, 62, 25);
        dadosBrutos.add(textoCoefVarBR);
        textoCoefVarBR.setText(String.valueOf(db.getCoeficienteVariacao()));
        textoCoefVarBR.setEditable(false);

        JLabel lblCoefVariacaoBR = new JLabel("Coef Variacao");
        lblCoefVariacaoBR.setBounds(188, 150, 90, 14);
        dadosBrutos.add(lblCoefVariacaoBR);
        lblCoefVariacaoBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCoefVariacaoBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoDesvioBR = new JTextPane();
        textoDesvioBR.setBounds(281, 114, 63, 25);
        dadosBrutos.add(textoDesvioBR);
        textoDesvioBR.setText(String.valueOf(db.getDesvioPadrao()));
        textoDesvioBR.setEditable(false);

        JLabel lblDesvioPadraoBR = new JLabel("Desvio Padrao");
        lblDesvioPadraoBR.setBounds(188, 118, 90, 14);
        dadosBrutos.add(lblDesvioPadraoBR);
        lblDesvioPadraoBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDesvioPadraoBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JTextPane textoVarianciaBR = new JTextPane();
        textoVarianciaBR.setBounds(282, 82, 62, 25);
        dadosBrutos.add(textoVarianciaBR);
        textoVarianciaBR.setText(String.valueOf(db.getVariancia()));
        textoVarianciaBR.setEditable(false);

        JLabel lblVarianciaBR = new JLabel("Variancia");
        lblVarianciaBR.setBounds(216, 86, 62, 14);
        dadosBrutos.add(lblVarianciaBR);
        lblVarianciaBR.setHorizontalAlignment(SwingConstants.RIGHT);
        lblVarianciaBR.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JLabel lblDispersaoBR = new JLabel("Dispersao");
        lblDispersaoBR.setBounds(259, 42, 108, 32);
        dadosBrutos.add(lblDispersaoBR);
        lblDispersaoBR.setHorizontalAlignment(SwingConstants.CENTER);
        lblDispersaoBR.setForeground(Color.GRAY);
        lblDispersaoBR.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel lblPosicaoBR = new JLabel("Posicao");
        lblPosicaoBR.setBounds(89, 44, 108, 32);
        dadosBrutos.add(lblPosicaoBR);
        lblPosicaoBR.setHorizontalAlignment(SwingConstants.CENTER);
        lblPosicaoBR.setForeground(Color.GRAY);
        lblPosicaoBR.setFont(new Font("Verdana", Font.BOLD, 13));

        JLabel infIndex = new JLabel("Clique no index ate ficar azul");
        infIndex.setForeground(Color.GRAY);
        infIndex.setBounds(117, 500, 173, 14);
        panel.add(infIndex);
        textoSeparatriz.setVisible(false);

        ListSelectionListener quartisListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                setIndexQuartil(listaQuartis.getSelectedIndex());
            }
        };
        listaQuartis.addListSelectionListener(quartisListener);

        ListSelectionListener decilListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                setIndexDecil(listaDecil.getSelectedIndex());
            }
        };
        listaDecil.addListSelectionListener(decilListener);

        ListSelectionListener percentilListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                setIndexPercentil(listaPercentil.getSelectedIndex());
                System.out.println(listaPercentil.getSelectedIndex());
            }
        };
        listaPercentil.addListSelectionListener(percentilListener);

        separatriz.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == separatriz) {
                    String texto = "";
                    int quartil = getIndexQuartil();
                    int decil = getIndexDecil();
                    int percentil = getIndexPercentil();

                    System.out.println(quartil + " " + decil + " " + percentil);

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

    }

    public int getIndexQuartil() {
        return indexQuartil;
    }

    public void setIndexQuartil(int indexQuartil) {
        this.indexQuartil = indexQuartil;
    }

    public int getIndexDecil() {
        return indexDecil;
    }

    public void setIndexDecil(int indexDecil) {
        this.indexDecil = indexDecil;
    }

    public int getIndexPercentil() {
        return indexPercentil;
    }

    public void setIndexPercentil(int indexPercentil) {
        this.indexPercentil = indexPercentil;
    }
}
