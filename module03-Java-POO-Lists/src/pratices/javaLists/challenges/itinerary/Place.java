package pratices.javaLists.challenges.itinerary;

import java.util.LinkedList;

/**
 * Representa um local/destino em um itinerário de viagem.
 *
 * <p>Este record encapsula informações sobre um destino de viagem,
 * incluindo seu nome e distância do ponto de partida em quilômetros.
 * Fornece métodos utilitários para gerenciar uma lista de locais em ordem de distância.</p>
 *
 * @param name     O nome do destino
 * @param distance A distância em quilômetros a partir do ponto de partida
 */
record Place(String name, int distance) {
    @Override
    public String toString() {
        return String.format("%s (%d)", name, distance);
    }


    /**
     * Adiciona um local à lista do itinerário em ordem crescente de distância.
     *
     * Este metodo garante que:</p>
     *
     * Nenhum local duplicado seja adicionado (verificado por igualdade de referência exata)
     * Nenhum local com o mesmo nome seja adicionado (verificação insensível a maiúsculas)
     * Os locais sejam mantidos em ordem ordenada por distância (crescente)
     *
     * Se uma duplicata for detectada, uma mensagem será impressa e o local não será adicionado.
     *
     * @param list  A LinkedList à qual o local será adicionado
     * @param place O objeto Place a ser adicionado à lista
     */
    public static void addPlace(LinkedList<Place> list, Place place){

        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }

        for (Place p : list){
            if (p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found Duplicate: " + place);
                return;
            }
        }

        int matchIndex = 0;
        for (var listPlace : list){
            if (place.distance() < listPlace.distance()){
                list.add(matchIndex, place);
                return;
            }

            matchIndex++;
        }

        list.add(place);
    }

    /**
     * Exibe as opções do menu interativo para o usuário.
     *
     * O menu mostra todas as opções de navegação e exibição disponíveis para percorrer
     * a lista de itinerário. Os usuários podem selecionar ações digitando a letra ou palavra.
     */
    public static void printMenu(){
        System.out.println("""
                Available actions (select word or letter)
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }
}
