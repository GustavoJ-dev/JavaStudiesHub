package praticas;

public class DigitalAccount {

    public static final int TIPO_CORRENTE = 1;
    public static final int TIPO_POUPANCA = 2;

    private String titular;
    private double saldo;
    private int tipoConta;

    public DigitalAccount(String titular, double saldo, int tipoConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }

    public double depositar(double valor, boolean viaAgencia){
        this.saldo += valor;
        return this.saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isContaCorrente(){
        return tipoConta == TIPO_CORRENTE;
    }
}
