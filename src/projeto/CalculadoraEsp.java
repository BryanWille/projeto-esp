/*
 *
 * Programa Criado Por
 * Bryan Wille
 * Pedro Gabriel
 *
 * */
package projeto;

import java.awt.EventQueue;

public class CalculadoraEsp {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EntradaDadosGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}