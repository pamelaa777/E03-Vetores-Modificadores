/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public class Operacao {

    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação d-s*/
    private char tipo;

    /* Valor da operação */
    private double valor;

    static int totalOperacoes=0;

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
        if( tipo =='d' || tipo=='s'){
            this.tipo= tipo;
        }else {
            System.out.println("erro");
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        totalOperacoes ++;
    }
    public char getTipo(){
        return this.tipo;
    }
    public Date getData(){
        return this.data;
    }
    public double getValor(){
        return this.valor;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }


}
