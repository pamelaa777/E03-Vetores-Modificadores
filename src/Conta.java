public class Conta {

    private Cliente dono;
    private double saldo;
    private int numero;
    private double limite;
    private String agencia;
    private Operacao[] operacoes;
    private int contador;

    static int totalContas = 0;

    public Conta(Cliente dono, String agencia, int numero, double saldo, double limite) {
        this.dono = dono;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.operacoes = new Operacao[1000];
        this.contador = 0;
        totalContas++;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public Cliente getDono(){
        return dono;
    }
    public void setDono( Cliente dono){
        this.dono = dono ;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setLimite(double limite) {
        if( limite < 0) {
            this.limite = 0;
        }else {
            this.limite = limite;
        }

    }

    boolean depositar(double valor) {
        if (valor > 0.0) {

            this.operacoes[contador]= new Operacao('d', valor);
            contador ++;
            this.saldo += valor;
            return true;
        } else {
            return false;
        }
    }


    boolean sacar(double valor) {
        if (valor > 0.0 && (valor + this.limite) <= (this.saldo + this.limite)) {
            this.operacoes[contador] = new Operacao('s', valor);
            contador++;
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }


    boolean transferir(Conta contaDestino, double valor) {
        boolean saqueRealizado = this.sacar(valor);
        if (saqueRealizado) {
            boolean depositoRealizado = contaDestino.depositar(valor);
            return depositoRealizado;
        } else {
            return false;
        }
    }

    public void imprimir() {
        System.out.println("Nome do dono da conta: " + this.dono.nome);
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }
    public void imprimirExtrato() {
        for(int i = 0; i < contador; i++)
        System.out.println(this.operacoes[i].getData()+" "+this.operacoes[i].getTipo()+" "+this.operacoes[i].getValor());
    }
}