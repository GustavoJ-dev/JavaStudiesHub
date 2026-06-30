package pratices.javaLists.challenges.itinerary;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Aplicação interativa de gerenciador de itinerário de viagem.
 *
 * <p>Este programa permite que os usuários naveguem por uma lista de destinos
 * usando um iterador bidirecional. Os usuários podem se mover para frente ou para trás
 * pelo itinerário, visualizar todos os locais e gerenciar seu plano de viagem.</p>
 *
 * <p>Os destinos são automaticamente classificados por distância em ordem crescente.</p>
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Ponto de entrada principal da aplicação de itinerário de viagem.
     *
     * Este metodo
     *
     * Inicializa uma lista de destinos brasileiros ordenados por distância
     * Fornece um menu interativo para o usuário navegar pelo itinerário
     * Usa um ListIterator para permitir travessia bidirecional
     *
     * Ações suportadas
     *
     * (F)orward - Mover para o próximo destino
     * (B)ackwards - Mover para o destino anterior
     * (L)ist - Exibir todos os locais do itinerário
     * (M)enu - Mostrar o menu novamente
     * (Q)uit ou qualquer outra entrada - Sair do programa

     */
    public static void main(String[] args) {

        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place sp = new Place("São Paulo", 1482);

        Place.addPlace(placesToVisit, sp);
        Place.addPlace(placesToVisit, new Place("Rio de Janeiro - RJ", 1360));
        Place.addPlace(placesToVisit, new Place("Rio Grande do sul - RS", 2559));
        Place.addPlace(placesToVisit, new Place("Sergipe - SE", 1552));

        placesToVisit.addFirst(new Place("Paramirim-BA", 0));
        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        boolean quitLoop = false;
        boolean forward = true;

        Place.printMenu();

        while (!quitLoop){

            if (!iterator.hasPrevious()){
                System.out.println("Partida : " + iterator.next());
                forward = true;
            }

            if (!iterator.hasNext()){
                System.out.println("chegada : " + iterator.previous());
                forward = false;
            }

            System.out.println("o Que deseja: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);

            switch (menuItem){

                case "F":
                    System.out.println("Você deseja ir para o proxímo!");
                    if (!forward){
                        forward = true;//ajusta a direcao
                        if (iterator.hasNext()){
                            iterator.next();// se tiver proximo, ele avança
                        }
                    }

                    if (iterator.hasNext()){
                        System.out.println(iterator.next());//imprime o local
                    }

                    break;

                case "B":

                    System.out.println("Você deseja voltar!");
                    if (forward){
                        forward = false;//ajusta a direcao
                        if (iterator.hasPrevious()){
                            iterator.previous();//volta para trás
                        }
                    }

                    if (iterator.hasPrevious()){
                        System.out.println(iterator.previous());//imprime o local
                    }

                    break;

                case "M":
                    Place.printMenu();
                    break;

                case "L":
                    System.out.println(placesToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;
            }


        }

    }
}
