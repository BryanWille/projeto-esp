package projeto;

import projeto.EntradaDados;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;


public class EntradaDadosGUI {
    private JFrame janela;
    private JTextField jTxtDados;
    private JTextField jTxtDados1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JButton importarButton;
    private JButton enviarButton;
    private Scanner keyb;

    public EntradaDadosGUI(){
        criarGUI();
    }

    public void criarGUI(){
        janela = new JFrame("Entrada de dados");
        janela.setSize(1280,720);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        janela.getContentPane().setLayout(gridBagLayout);
        criarLabelImportar();
        criarLabelManualmente();
        criarjTxtDados();
        criarjTxtDados1();
        criarEnviarButton();
        criarImportarButton();
        criarConfiguracoesLabel();
        criarLabelArredondarClasse();
        criarLabelArredondarDados();
        criarTextpane1();
        criarTextpane2();
        janela.setVisible(true);
    }

    private void criarLabelImportar(){
        lblNewLabel_1 = new JLabel("Importar:");
        lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 2;
        janela.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
    }

    private void criarjTxtDados() {
        jTxtDados = new JTextField();
        GridBagConstraints gbc_jTxtDados = new GridBagConstraints();
        gbc_jTxtDados.insets = new Insets(0, 0, 5, 5);
        gbc_jTxtDados.fill = GridBagConstraints.HORIZONTAL;
        gbc_jTxtDados.gridx = 4;
        gbc_jTxtDados.gridy = 2;
        janela.getContentPane().add(jTxtDados, gbc_jTxtDados);
        jTxtDados.setColumns(10);
    }

    private void criarImportarButton(){
        importarButton = new JButton("Importar");
        importarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                jfc.setDialogTitle("Escolha o diretório do arquivo de texto: ");
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de texto", "txt", "text");
                jfc.setFileFilter(filtro);

                int returnValue = jfc.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    jTxtDados.setText(jfc.getSelectedFile().getAbsolutePath());
                    try {
                        Leitura.setKeyb(keyb = new Scanner(jfc.getSelectedFile()));
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    new InterfaceGrafica();
                }
            }
        });

        GridBagConstraints gbc_importarButton = new GridBagConstraints();
        gbc_importarButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_importarButton.insets = new Insets(0, 0, 5, 5);
        gbc_importarButton.gridx = 6;
        gbc_importarButton.gridy = 2;
        janela.getContentPane().add(importarButton, gbc_importarButton);
    }

    private void criarLabelManualmente(){
        lblNewLabel_2 = new JLabel("Manualmente (Separar n\u00FAmeros com espa\u00E7o):");
        lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 1;
        gbc_lblNewLabel_2.gridy = 9;
        janela.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
    }

    private void criarjTxtDados1() {
        jTxtDados1 = new JTextField();
        GridBagConstraints gbc_jTxtDados1 = new GridBagConstraints();
        gbc_jTxtDados1.insets = new Insets(0, 0, 5, 5);
        gbc_jTxtDados1.fill = GridBagConstraints.HORIZONTAL;
        gbc_jTxtDados1.gridx = 4;
        gbc_jTxtDados1.gridy = 9;
        janela.getContentPane().add(jTxtDados1, gbc_jTxtDados1);
        jTxtDados1.setColumns(10);
    }

    private void criarEnviarButton() {
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EntradaDados entradaDados = new EntradaDados();

                entradaDados.setDados(jTxtDados.getText());

                try {
                    JOptionPane.showMessageDialog(null, entradaDados.criarDadosTxtManual());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                jTxtDados.setText("");
                new InterfaceGrafica();
            }
        });
        GridBagConstraints gbc_enviarButton = new GridBagConstraints();
        gbc_enviarButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_enviarButton.insets = new Insets(0, 0, 5, 5);
        gbc_enviarButton.gridx = 6;
        gbc_enviarButton.gridy = 9;
        janela.getContentPane().add(enviarButton, gbc_enviarButton);
    }

    private void criarConfiguracoesLabel() {
        lblNewLabel_3 = new JLabel("Configura\u00E7\u00F5es de arredondamento:");
        lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 15));
        lblNewLabel_3.setForeground(Color.BLACK);
        lblNewLabel_3.setBackground(Color.WHITE);
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_3.gridwidth = 8;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 13;
        gbc_lblNewLabel_3.gridy = 12;
        janela.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
    }

    private void criarLabelArredondarClasse(){
        JLabel lblNewLabel_4 = new JLabel("Arredondar classe:");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.gridwidth = 3;
        gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 13;
        gbc_lblNewLabel_4.gridy = 13;
        janela.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
    }

    private void criarTextpane1(){
        JTextPane textPane = new JTextPane();
        textPane.setText("10");
        int arredondamentoClasse = Integer.parseInt(textPane.getText());
        Configuracoes.setArredondamentoClasse(arredondamentoClasse);
        GridBagConstraints gbc_textPane = new GridBagConstraints();
        gbc_textPane.gridwidth = 2;
        gbc_textPane.insets = new Insets(0, 0, 5, 5);
        gbc_textPane.fill = GridBagConstraints.HORIZONTAL;
        gbc_textPane.gridx = 16;
        gbc_textPane.gridy = 13;
        janela.getContentPane().add(textPane, gbc_textPane);
    }

    private void criarLabelArredondarDados(){
        JLabel lblNewLabel_5 = new JLabel("Arredondar dados:");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.gridwidth = 3;
        gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 13;
        gbc_lblNewLabel_5.gridy = 14;
        janela.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
    }

    private void criarTextpane2(){
        JTextPane textPane_1 = new JTextPane();
        textPane_1.setText("10");
        int arredondamento = Integer.parseInt(textPane_1.getText());
        Configuracoes.setArredondamento(arredondamento);
        GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
        gbc_textPane_1.gridwidth = 2;
        gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
        gbc_textPane_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textPane_1.gridx = 16;
        gbc_textPane_1.gridy = 14;
        janela.getContentPane().add(textPane_1, gbc_textPane_1);
    }
}
