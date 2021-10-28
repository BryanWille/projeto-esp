package projeto;

public class Configuracoes {
    private int arredondamento;

    public Configuracoes(){
        this(2);
    }

    public Configuracoes(int arredondamento){
        this.setArredondamento(2);
    }

    public double arredondar(double numero){
        double decimal = Math.pow(10, this.getArredondamento());
        return Math.round(numero * decimal) / decimal;
    }

    public int getArredondamento(){return this.arredondamento;}
    public void setArredondamento(int arredondamento){
        this.arredondamento = arredondamento;
    }
}
