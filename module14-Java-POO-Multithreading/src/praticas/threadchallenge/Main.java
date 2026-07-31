package praticas.threadchallenge;

/**
 * Thread responsável por imprimir os números ímpares.
 * <p>
 * A thread exibe os números ímpares de 1 a 9, realizando
 * uma pausa de um segundo entre cada impressão. Caso seja
 * interrompida, encerra sua execução.
 * </p>
 */
class OddThread extends Thread {

    /**
     * Executa a rotina da thread.
     * <p>
     * Imprime os números ímpares e aguarda um segundo entre
     * cada iteração.
     * </p>
     */
    @Override
    public void run() {

        for (int i = 1; i < 10; i += 2) {

            System.out.println("OddThread: " + i);

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("OddThread interrompida!");
                break;
            }
        }
    }
}

/**
 * Implementação de {@link Runnable} responsável por
 * imprimir os números pares.
 * <p>
 * A tarefa exibe os números pares de 2 a 8, realizando
 * uma pausa de um segundo entre cada impressão. Caso
 * a thread seja interrompida, sua execução é encerrada.
 * </p>
 */
class EvenRunnable implements Runnable {

    /**
     * Executa a tarefa responsável por imprimir
     * os números pares.
     */
    @Override
    public void run() {

        for (int i = 2; i < 10; i += 2) {

            System.out.println("EvenRunnable: " + i);

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("EvenRunnable interrompida!");
                break;
            }
        }
    }
}

/**
 * Classe principal responsável por demonstrar a criação,
 * execução e interrupção de threads em Java.
 * <p>
 * A aplicação inicia uma thread baseada na classe
 * {@link Thread} e outra baseada na interface
 * {@link Runnable}. Após alguns segundos, a thread
 * responsável pelos números ímpares é interrompida.
 * </p>
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     * <p>
     * Cria e inicia as threads, aguarda dois segundos e
     * interrompe a execução da thread responsável por
     * imprimir os números ímpares.
     * </p>
     */
    public static void main(String[] args) {

        OddThread oddThread = new OddThread();
        Thread evenThread = new Thread(new EvenRunnable());

        oddThread.start();
        evenThread.start();

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        oddThread.interrupt();
    }
}
