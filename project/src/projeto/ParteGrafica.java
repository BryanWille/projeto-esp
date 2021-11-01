package projeto;

import java.awt.*;
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
        private String[] colunas = {"Distribuição de Frequência", "Frequência", "Frequência Agrupada", "Ponto Médio"};

        public ParteGrafica(){
            janela = new JFrame("PresP");

            ImageIcon img = new ImageIcon(getClass().getResource("img/logo2.png"));
            janela.setIconImage(img.getImage());

            painelTabela = new JPanel();
            painelTabela.setLayout(new BorderLayout());
            this.janela.setSize(1280, 720);
            this.janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);

            this.criarTabela();
            this.criarTitulo();

            this.janela.setVisible(true); //Deixar por último
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
            texto.setText("Programa de Estatística");
            texto.setHorizontalAlignment(SwingConstants.CENTER);
            janela.getContentPane().add(texto, BorderLayout.PAGE_START);

        }


}

