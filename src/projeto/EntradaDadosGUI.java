package projeto;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class EntradaDadosGUI {
    private DadosAgrupados da;
    private DadosBrutos db;
    private JTextField textField_1;

    public EntradaDadosGUI(){
        criarGUI();
    }

    public void criarGUI(){
        JFrame janela = new JFrame("PresP: Entrada de dados");
        janela.setResizable(false);
        janela.setSize(1263,655);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setLayout(null);

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("logo.png")));
        janela.setIconImage(img.getImage());

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.activeCaption);
        panel.setBounds(0, 0, 1264, 55);
        janela.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Calculadora de dados estat\u00EDsticos");
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.scrollbar);
        panel_1.setBounds(0, 56, 648, 313);
        janela.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Inserir dados manualmente:");
        lblNewLabel_1.setBounds(218, 55, 242, 19);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel_1.add(lblNewLabel_1);

        JButton enviarButton = new JButton("Enviar");

        enviarButton.setForeground(SystemColor.text);
        enviarButton.setBounds(474, 128, 109, 31);
        enviarButton.setBackground(SystemColor.windowText);
        enviarButton.setFont(new Font("Verdana", Font.BOLD, 12));
        panel_1.add(enviarButton);

        JLabel lblNewLabel_2 = new JLabel("Instru\u00E7\u00F5es: Digite os n\u00FAmeros um por um separados por um espa\u00E7o vazio entre eles.");
        lblNewLabel_2.setBounds(62, 191, 519, 18);
        lblNewLabel_2.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("O programa ir\u00E1 coloc\u00E1-los em ordem e realizar os c\u00E1lculos.");
        lblNewLabel_3.setBounds(136, 211, 362, 18);
        lblNewLabel_3.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_3);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(93, 127, 343, 31);
        panel_1.add(scrollPane);

        JTextPane textField = new JTextPane();
        scrollPane.setViewportView(textField);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.scrollbar);
        panel_2.setBounds(648, 56, 596, 313);
        janela.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Importar arquivo de Texto:");
        lblNewLabel_4.setForeground(Color.BLACK);
        lblNewLabel_4.setBackground(Color.DARK_GRAY);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_4.setBounds(212, 62, 227, 14);
        panel_2.add(lblNewLabel_4);

        JCheckBox checkBoxDadosSeparados = new JCheckBox("Dados separados por espa\u00E7o");
        checkBoxDadosSeparados.setBounds(301, 135, 202, 23);
        panel_2.add(checkBoxDadosSeparados);

        JButton importarButton = new JButton("Importar");

        importarButton.setBackground(SystemColor.windowText);
        importarButton.setForeground(SystemColor.text);
        importarButton.setFont(new Font("Verdana", Font.BOLD, 12));
        importarButton.setBounds(136, 126, 126, 36);
        panel_2.add(importarButton);

        JLabel lblNewLabel_5 = new JLabel("Instru\u00E7\u00F5es: Selecione um arquivo .txt presente em seu computador.");
        lblNewLabel_5.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_5.setBounds(104, 195, 421, 14);
        panel_2.add(lblNewLabel_5);

        JLabel lblNewLabel_11 = new JLabel("Por padr\u00E3o, o programa l\u00EA os arquivos .txt linha por linha, caso os dados do arquivo estejam");
        lblNewLabel_11.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_11.setBounds(21, 212, 576, 14);
        panel_2.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("na mesma linha ser\u00E1 necess\u00E1rio marcar a op\u00E7\u00E3o \"Dados separados por espa\u00E7o\".");
        lblNewLabel_12.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_12.setBounds(68, 230, 496, 14);
        panel_2.add(lblNewLabel_12);

        textField_1 = new JTextField();
        textField_1.setBackground(new Color(192, 192, 192));
        textField_1.setVisible(false);
        textField_1.setBounds(269, 101, 86, 20);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.controlShadow);
        panel_3.setBounds(0, 369, 1254, 252);
        janela.getContentPane().add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Configura\u00E7\u00F5es de arredondamento:");
        lblNewLabel_6.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_6.setBounds(790, 57, 309, 27);
        panel_3.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Arredondar dados:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_7.setBounds(863, 106, 106, 20);
        panel_3.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Arredondar dados de classe:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_8.setBounds(810, 137, 154, 20);
        panel_3.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Instru\u00E7\u00F5es: O padr\u00E3o do programa \u00E9 arredondar para uma casa decimal, portanto o n\u00FAmero 1.");
        lblNewLabel_9.setFont(new Font("Cambria", Font.ITALIC, 15));
        lblNewLabel_9.setBounds(612, 168, 609, 27);
        panel_3.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Caso queria modificar para mais casas decimais, modifique o valor para 2 ou mais.");
        lblNewLabel_10.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_10.setBounds(654, 194, 517, 14);
        panel_3.add(lblNewLabel_10);

        JRadioButton padraoBrasileiroCheck = new JRadioButton("Dados padr\u00E3o brasileiro");
        padraoBrasileiroCheck.setBounds(128, 106, 203, 23);
        panel_3.add(padraoBrasileiroCheck);

        JRadioButton padraoAmericanoCheck = new JRadioButton("Dados padr\u00E3o americano");
        padraoAmericanoCheck.setBounds(128, 131, 203, 23);
        panel_3.add(padraoAmericanoCheck);

        ButtonGroup group = new ButtonGroup();
        group.add(padraoBrasileiroCheck);
        group.add(padraoAmericanoCheck);

        padraoBrasileiroCheck.setSelected(true);

        JLabel lblNewLabel_20 = new JLabel("Ex: 1.234,56");
        lblNewLabel_20.setBounds(337, 110, 80, 14);
        panel_3.add(lblNewLabel_20);

        JLabel lblNewLabel_21 = new JLabel("Ex: 1,235.56");
        lblNewLabel_21.setBounds(337, 136, 76, 14);
        panel_3.add(lblNewLabel_21);

        JLabel lblNewLabel_6_1 = new JLabel("Padr\u00E3o de Dados");
        lblNewLabel_6_1.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_6_1.setBounds(193, 57, 154, 27);
        panel_3.add(lblNewLabel_6_1);

        JComboBox comboBoxRA = new JComboBox();
        comboBoxRA.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
        comboBoxRA.setSelectedIndex(2);
        comboBoxRA.setBounds(974, 106, 39, 22);
        panel_3.add(comboBoxRA);

        JComboBox comboBoxRC = new JComboBox();
        comboBoxRC.setModel(new DefaultComboBoxModel(new String[] {"Padr\u00E3o", "1", "2", "3", "4"}));
        comboBoxRC.setSelectedIndex(0);
        comboBoxRC.setBounds(974, 137, 70, 22);
        panel_3.add(comboBoxRC);

        JLabel lblNewLabel_2_1 = new JLabel("Instru\u00E7\u00F5es: No brasil separamos as casas decimais com virgula, j\u00E1 em outros paises ");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_2_1.setBounds(14, 173, 519, 18);
        panel_3.add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("como nos EUA \u00E9 separado por ponto, ent\u00E3o selecione qual padr\u00E3o sera utilizado");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_2_1_1.setBounds(10, 190, 519, 18);
        panel_3.add(lblNewLabel_2_1_1);

        importarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                jfc.setDialogTitle("Escolha o diretório do arquivo de texto: ");
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de texto", "txt", "text");
                jfc.setFileFilter(filtro);

                int returnValue = jfc.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    textField_1.setText(jfc.getSelectedFile().getAbsolutePath());
                    if(padraoBrasileiroCheck.isSelected()){
                        if(checkBoxDadosSeparados.isSelected()){
                            try {
                                BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                                ArrayList<Double> listaDouble = new ArrayList<>();
                                String linha = bufReader.readLine();
                                String[] linhaSplit = linha.split(" ");
                                for(int i = 0; i < linhaSplit.length; i++){
                                    linhaSplit[i] = linhaSplit[i].replace(".","");
                                    linhaSplit[i] = linhaSplit[i].replace(",",".");
                                    listaDouble.add(Double.parseDouble(linhaSplit[i]));
                                }
                                arredondarEInicializar(bufReader, listaDouble, comboBoxRA, comboBoxRC);
                            } catch (IOException ex){
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                                ArrayList<Double> listaDouble = new ArrayList<>();
                                double linhaDouble;
                                String linha = bufReader.readLine();
                                linha = linha.replace(".","");
                                linha = linha.replace(",",".");
                                while (linha != null) {
                                    linhaDouble = Double.parseDouble(linha);
                                    listaDouble.add(linhaDouble);
                                    linha = bufReader.readLine();
                                    if(linha == null){
                                        break;
                                    }
                                    linha = linha.replace(".","");
                                    linha = linha.replace(",",".");
                                }

                                arredondarEInicializar(bufReader, listaDouble, comboBoxRA, comboBoxRC);
                            } catch (IOException ex){
                                ex.printStackTrace();
                            }
                        }
                    }else{
                        if(checkBoxDadosSeparados.isSelected()){
                            try {
                                BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                                ArrayList<Double> listaDouble = new ArrayList<>();
                                String linha = bufReader.readLine();
                                String[] linhaSplit = linha.split(" ");
                                for(int i = 0; i < linhaSplit.length; i++){
                                    linhaSplit[i] = linhaSplit[i].replace(",","");
                                    listaDouble.add(Double.parseDouble(linhaSplit[i]));
                                }

                                arredondarEInicializar(bufReader, listaDouble, comboBoxRA, comboBoxRC);
                            } catch (IOException ex){
                                ex.printStackTrace();
                            }
                        }else{
                            try {
                                BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                                ArrayList<Double> listaDouble = new ArrayList<>();
                                double linhaDouble;
                                String linha = bufReader.readLine();
                                linha = linha.replace(",","");
                                while (linha != null) {
                                    linhaDouble = Double.parseDouble(linha);
                                    listaDouble.add(linhaDouble);
                                    linha = bufReader.readLine();
                                    if(linha == null){
                                        break;
                                    }
                                    linha = linha.replace(",","");
                                }

                                arredondarEInicializar(bufReader, listaDouble, comboBoxRA, comboBoxRC);
                            } catch (IOException ex){
                                ex.printStackTrace();
                            }
                        }

                    }

                }
            }
        });

        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> lista = new ArrayList<Double>();
                String dados = textField.getText();
                String[] dadosSplit = dados.split(" ");
                if (padraoBrasileiroCheck.isSelected()){
                    for(int i = 0; i < dadosSplit.length; i++){
                        dadosSplit[i] = dadosSplit[i].replace(".","");
                        dadosSplit[i] = dadosSplit[i].replace(",",".");
                        lista.add(Double.parseDouble(dadosSplit[i]));
                    }
                }else{
                    for(int i = 0; i < dadosSplit.length; i++){
                        dadosSplit[i] = dadosSplit[i].replace(",","");
                        lista.add(Double.parseDouble(dadosSplit[i]));
                    }
                }

                int arredondar = comboBoxRA.getSelectedIndex();
                int arredondarClasse = comboBoxRC.getSelectedIndex();

                new Leitura(lista);
                new DadosAgrupados(arredondar);
                new DadosBrutos(arredondar);
                new InterfaceGrafica();
            }
        });

        janela.setVisible(true);
    }

    private void arredondarEInicializar(BufferedReader bufReader, ArrayList<Double> listaDouble, JComboBox comboBoxRA, JComboBox comboBoxRC) throws IOException {
        System.out.println(listaDouble);
        int arredondar = comboBoxRA.getSelectedIndex();
        int arredondarClasse = comboBoxRC.getSelectedIndex();
        DadosBrutos.setIndexRound(arredondar);
        DadosAgrupados.setIndexRound(arredondar);
        DadosAgrupados.setIndexRoundClasse(arredondarClasse);

        new Leitura(listaDouble);
        new InterfaceGrafica();
        bufReader.close();
    }
}
