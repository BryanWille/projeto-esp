package projeto;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EntradaDados {
    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    private String dados;

    public String criarDadosTxtManual() throws IOException {

        String[] dadosSplit = dados.split(" ");
        FileWriter fw = new FileWriter("dados.txt");
        PrintWriter pw = new PrintWriter(fw);
        for(int i = 0; i < dadosSplit.length; i++) {
            pw.println(dadosSplit[i]);
        }
        Scanner keyb;
        Leitura.setKeyb(keyb = new Scanner(EntradaDados.class.getResourceAsStream("dados.txt")));
        pw.flush();
        pw.close();
        fw.close();

        return "Sucesso!";
    }

}