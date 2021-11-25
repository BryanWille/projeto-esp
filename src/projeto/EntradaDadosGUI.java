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
    private static JTextField textField;
    private static JTextField textField_1;

    public EntradaDadosGUI(){
        criarGUI();
    }

    public void criarGUI(){
        JFrame janela = new JFrame("PresP: Entrada de dados");
        janela.setResizable(false);
        janela.setSize(1280,720);
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
        lblNewLabel_1.setBounds(169, 48, 184, 19);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_1.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(90, 104, 343, 20);
        panel_1.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> lista = new ArrayList<Double>();
                String dados = textField.getText();
                String[] dadosSplit = dados.split(" ");
                for(int i = 0; i < dadosSplit.length; i++){
                    lista.add(Double.parseDouble(dadosSplit[i]));
                }
                new Leitura(lista);
                new InterfaceGrafica();
            }
        });
        btnNewButton.setForeground(SystemColor.text);
        btnNewButton.setBounds(216, 162, 95, 25);
        btnNewButton.setBackground(SystemColor.windowText);
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
        panel_1.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("Instru\u00E7\u00F5es: Digite os n\u00FAmeros um por um separados por um espa\u00E7o vazio entre eles.");
        lblNewLabel_2.setBounds(92, 222, 519, 18);
        lblNewLabel_2.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("O programa ir\u00E1 coloc\u00E1-los em ordem e realizar os c\u00E1lculos.");
        lblNewLabel_3.setBounds(90, 242, 362, 18);
        lblNewLabel_3.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblNewLabel_3);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.scrollbar);
        panel_2.setBounds(648, 56, 616, 313);
        janela.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Importar dados:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(277, 49, 116, 14);
        panel_2.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setBounds(171, 101, 314, 20);
        panel_2.add(textField_1);
        textField_1.setColumns(10);

        JCheckBox checkBox = new JCheckBox("Dados separados por espa\u00E7o");
        checkBox.setBounds(237, 201, 196, 23);
        panel_2.add(checkBox);

        JButton btnNewButton_1 = new JButton("Importar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                jfc.setDialogTitle("Escolha o diretório do arquivo de texto: ");
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de texto", "txt", "text");
                jfc.setFileFilter(filtro);

                int returnValue = jfc.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    textField_1.setText(jfc.getSelectedFile().getAbsolutePath());
                    if(checkBox.isSelected()){
                        try {
                            BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                            ArrayList<Double> listaDouble = new ArrayList<>();
                            String linha = bufReader.readLine();
                            String[] linhaSplit = linha.split(" ");
                            for(int i = 0; i < linhaSplit.length; i++){
                                listaDouble.add(Double.parseDouble(linhaSplit[i]));
                            }
                            new Leitura(listaDouble);
                            new InterfaceGrafica();
                            bufReader.close();
                        } catch (IOException ex){
                        ex.printStackTrace();
                    }
                    }else{
                    try {
                        BufferedReader bufReader = new BufferedReader(new FileReader(jfc.getSelectedFile()));
                        ArrayList<Double> listaDouble = new ArrayList<>();
                        double linhaDouble;
                        String linha = bufReader.readLine();
                        while (linha != null) {
                            linhaDouble = Double.parseDouble(linha);
                            listaDouble.add(linhaDouble);
                            linha = bufReader.readLine();
                        }
                        new Leitura(listaDouble);
                        new InterfaceGrafica();
                        bufReader.close();
                    } catch (IOException ex){
                        ex.printStackTrace();
                    }
                }
                }
            }
        });
        btnNewButton_1.setBackground(SystemColor.windowText);
        btnNewButton_1.setForeground(SystemColor.text);
        btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
        btnNewButton_1.setBounds(277, 162, 107, 23);
        panel_2.add(btnNewButton_1);

        JLabel lblNewLabel_5 = new JLabel("Instru\u00E7\u00F5es: Selecione um arquivo .txt presente em seu computador.");
        lblNewLabel_5.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_5.setBounds(150, 231, 421, 14);
        panel_2.add(lblNewLabel_5);

        JLabel lblNewLabel_11 = new JLabel("Por padr\u00E3o, o programa l\u00EA os arquivos .txt linha por linha, caso os dados do arquivo estejam");
        lblNewLabel_11.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_11.setBounds(31, 247, 606, 14);
        panel_2.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("na mesma linha ser\u00E1 necess\u00E1rio marcar a op\u00E7\u00E3o \"Dados separados por espa\u00E7o\".");
        lblNewLabel_12.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_12.setBounds(87, 264, 496, 14);
        panel_2.add(lblNewLabel_12);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.controlShadow);
        panel_3.setBounds(0, 369, 1264, 312);
        janela.getContentPane().add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Configura\u00E7\u00F5es de arredondamento:");
        lblNewLabel_6.setFont(new Font("Serif", Font.BOLD, 20));
        lblNewLabel_6.setBounds(472, 11, 309, 27);
        panel_3.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Arredondar dados:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_7.setBounds(490, 64, 109, 20);
        panel_3.add(lblNewLabel_7);

        JTextPane textPane = new JTextPane();
        textPane.setText("1");
        textPane.setBounds(636, 64, 39, 20);
        panel_3.add(textPane);
        int arredondar = Integer.parseInt(textPane.getText());
        Configuracoes.setArredondamento(arredondar);

        JLabel lblNewLabel_8 = new JLabel("Arredondar dados de classe:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_8.setBounds(472, 120, 154, 20);
        panel_3.add(lblNewLabel_8);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setText("1");
        textPane_1.setBounds(636, 120, 39, 20);
        panel_3.add(textPane_1);
        int arredondarClasse = Integer.parseInt(textPane_1.getText());
        Configuracoes.setArredondamentoClasse(arredondarClasse);

        JLabel lblNewLabel_9 = new JLabel("Instru\u00E7\u00F5es: O padr\u00E3o do programa \u00E9 arredondar para uma casa decimal, portanto o n\u00FAmero 1.");
        lblNewLabel_9.setFont(new Font("Cambria", Font.ITALIC, 15));
        lblNewLabel_9.setBounds(359, 185, 609, 27);
        panel_3.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Caso queria modificar para mais casas decimais, modifique o valor para 2 ou mais.");
        lblNewLabel_10.setFont(new Font("Cambria Math", Font.ITALIC, 15));
        lblNewLabel_10.setBounds(321, 223, 724, 14);
        panel_3.add(lblNewLabel_10);
        janela.setVisible(true);
    }
}
