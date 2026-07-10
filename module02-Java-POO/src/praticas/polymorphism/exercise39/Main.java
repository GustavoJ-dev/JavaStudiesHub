package praticas.polymorphism.exercise39;

/**
 * Classe principal para a execução do Exercício 39.
 * Esta classe demonstra os conceitos de encapsulamento e polimorfismo 
 * através da simulação de uma impressora.
 */
public class Main {
    public static void main(String[] args) {
        printer();
    }

    /**
     * Instancia uma impressora (Printer) e realiza uma série de operações,
     * como adicionar toner, verificar a contagem de páginas inicial e
     * realizar impressões parciais, exibindo o status no console.
     */
    public static void printer(){
        Printer printer = new Printer(true, 50);
        System.out.println(printer.addToner(50));
        System.out.println("initial page count = " +printer.getPagesPrinted());
        int pagesPrinted = printer.printPages(4);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());
        pagesPrinted = printer.printPages(2);
        System.out.println("Pages printed was " + pagesPrinted +" new total print count for printer = " +printer.getPagesPrinted());

    }
}
