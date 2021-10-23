package projeto;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ParteGrafica extends DadosAgrupados { //
        JFrame janela;
        JPanel painelFundo;
        JTable tabela;
        JScrollPane barraRolagem;

        Object[][] dados = this.converterLista(this.getTabela());

        String[] colunas = {"Frequência", "", "Agrupada", "Frequência"};

        public void criaJanela(){
            janela = new JFrame();
            painelFundo = new JPanel();
            painelFundo.setLayout(new GridLayout(10, 10));
            tabela = new JTable(dados, colunas);
            //barraRolagem = new JScrollPane(tabela);
            //painelFundo.add(barraRolagem);
            janela.getContentPane().add(painelFundo);
            //janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
            janela.setSize(500, 120);
            janela.setVisible(true);
        }

}

