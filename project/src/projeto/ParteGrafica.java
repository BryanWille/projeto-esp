package projeto;

import java.awt.GridLayout;
import javax.swing.*;

public class ParteGrafica{
        private DadosAgrupados da = new DadosAgrupados();
        private DadosBrutos db = new DadosBrutos();
        private JFrame janela;
        private JPanel painelTabela;
        private JTable tabela;
        private JScrollPane barraRolagem;
        private Object[][] dados = da.converterLista(da.getTabela());
        private String[] colunas = {"Distribuição de Frequência", "Frequência", "Frequência Agrupada", "Ponto Médio"};

        public ParteGrafica(){
            janela = new JFrame();
            this.janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
            this.janela.setSize(500, 120);
            this.janela.setVisible(true);
            this.criarJanela();
        }

        public void criarJanela(){
            painelTabela = new JPanel();                             //Cria o Painel (Espécie de Grid da Página)
            painelTabela.setLayout(new GridLayout(1, 1)); //Setando Layout
            tabela = new JTable(dados, colunas);                     //Cria Tabla
            barraRolagem = new JScrollPane(tabela);                  //Barra de Rolagem na Tabla
            painelTabela.add(barraRolagem);                          //Adiciona a barra de rolagem no Painel
            janela.getContentPane().add(painelTabela);               //Adiciona o Painel de Fundo a Janela
        }

}

