package projeto;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class ParteGrafica{
        private DadosAgrupados da = new DadosAgrupados();
        private DadosBrutos db = new DadosBrutos();
        private JLabel texto;
        private JFrame janela;
        private JPanel painelTabela;
        private JTable tabela;
        private JScrollPane barraRolagem;
        private Object[][] dados = da.converterLista(da.getTabela());
        private String[] colunas = {"Distribuicao de Frequencia", "Frequencia", "Frequencia Agrupada", "Ponto Medio"};

        public ParteGrafica(){
            janela = new JFrame("PresP");

            //ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/logo.png")));
            //janela.setIconImage(img.getImage());

            painelTabela = new JPanel();
            painelTabela.setLayout(new BorderLayout());
            this.janela.setSize(1280, 720);
            this.janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);

            this.criarTabela();
            this.criarTitulo();
            this.criarSeparatriz();

            this.janela.setVisible(true); //Deixar por ultimo
        }

        public void criarTabela(){
            tabela = new JTable(dados, colunas);
            barraRolagem = new JScrollPane(tabela);
            painelTabela.add(barraRolagem);
            janela.getContentPane().add(painelTabela, BorderLayout.CENTER);
        }

        public void criarTitulo(){
            texto = new JLabel();
            texto.setFont(new Font("Serif", Font.PLAIN, 25));
            texto.setText("Programa de Estatistica");
            texto.setHorizontalAlignment(SwingConstants.CENTER);
            janela.getContentPane().add(texto, BorderLayout.PAGE_START);

        }

        public void criarSeparatriz(){
            Object[] separatrizes = {"Quartis", "Percentis", "Decis"};
            JList lista = new JList(separatrizes);
            lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            lista.setLayoutOrientation(JList.VERTICAL_WRAP);
            lista.setVisibleRowCount(-1);
            JScrollPane listScroller = new JScrollPane(lista);
            listScroller.setPreferredSize(new Dimension(250, 100));
            janela.getContentPane().add(lista, BorderLayout.SOUTH);
        }


}

