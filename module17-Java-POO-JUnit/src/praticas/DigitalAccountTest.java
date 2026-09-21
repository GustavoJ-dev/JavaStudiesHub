package praticas;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DigitalAccountTest {

    @Test
    public void depositar(){

        DigitalAccount marina = new DigitalAccount("Marina", 1000, DigitalAccount.TIPO_CORRENTE);

        double saldo = marina.depositar(500, true);

        Assertions.assertEquals(1500, saldo, 0.00);

        System.out.println("Teste aprovado");
    }

    @Test
    public void getSaldo(){


    }

}