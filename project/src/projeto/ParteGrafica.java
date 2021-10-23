package projeto;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ParteGrafica{
        DadosAgrupados db = new DadosAgrupados();
        JFrame janela;
        JPanel painelFundo;
        JTable tabela;
        JScrollPane barraRolagem;

        Object[][] dados = db.converterLista(db.getTabela(), db.getPontoMedioClasse());

        String[] colunas = {"Distribuição de Frequência", "Frequência", "Ponto Médio"};

        public void criaJanela(){
            janela = new JFrame();                                  //Cria a Janela
            painelFundo = new JPanel();                             //Cria o Painel (Espécie de Grid da Página)
            painelFundo.setLayout(new GridLayout(1, 1));   //Setando Layout
            tabela = new JTable(dados, colunas);                    //Cria Tabla
            barraRolagem = new JScrollPane(tabela);                 //Barra de Rolagem na Tabla
            painelFundo.add(barraRolagem);                          //Adiciona a barra de rolagem no Painel
            janela.getContentPane().add(painelFundo);               //Adiciona o Painel de Fundo a Janela
            janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);  //Quando Clica no X fecha
            janela.setSize(500, 120);                   //Define o Tamanho
            janela.setVisible(true);                                //Seta visibilidade
        }

}

