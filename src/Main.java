public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789.10", "Rua ABC, 123", 30, 'm');
        Conta conta = new Conta(cliente, "222-2", 1234, 2000, 20000);
        Conta conta2 = new Conta(cliente, "222-2", 1234, 2000, 20000);

        conta.depositar(2000);
        conta.sacar(100);
        conta.depositar(2000);
        conta.sacar(100);
        conta.transferir(conta2, 200);

        System.out.println("Informações da conta:");
        conta.imprimir();

        conta.imprimirExtrato();

        int media = Operacao.totalOperacoes/Conta.totalContas;

        System.out.println("media:" +media);


    }
}
