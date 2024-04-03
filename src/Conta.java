public class Conta {

    Cliente dono;
    double saldo;
    int numero;
    String agencia;
    double limite;
    Operacao[] operacoes;
    int contador;

    public Conta(Cliente dono, String agencia, int numero, double saldo, double limite) {
        this.dono = dono;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.operacoes = new Operacao[1000];
        this.contador = 0;
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
        System.out.println("Nome do dono da conta: " + this.dono.getNome());
        System.out.println("Número da conta: " + this.numero);
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("Limite: " + this.limite);
    }
    public void imprimirDeposito() {
        for(int i = 0; i < contador; i++)
        System.out.println(this.operacoes[i].tipo+" "+this.operacoes[i].valor);
    }
}
