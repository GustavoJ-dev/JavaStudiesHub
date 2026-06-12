package collections_methods.dev.lpa;

import java.util.*;

/**
 * Classe principal para demonstrar o uso de vários métodos utilitários
 * das classes {@link java.util.Collections} e {@link java.util.Arrays}
 * para manipulação de listas e arrays de {@link Card}.
 * Este arquivo faz parte do Módulo 08, focado em Collections.
 */
public class Main {
    /**
     * Ponto de entrada principal do programa.
     * Demonstra a criação, preenchimento, cópia, ordenação, embaralhamento e manipulação
     * de coleções de cartas utilizando métodos estáticos de {@link java.util.Arrays}
     * e {@link java.util.Collections}, além de {@link java.util.Comparator}.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        // --- Demonstração 1: Criação e impressão de um baralho padrão ---
        // Obtém um baralho completo de 52 cartas usando o método estático de Card.
        List<Card> deck = Card.getStandardDeck();
        // Imprime o baralho no console, formatado em várias linhas.
        Card.printDeck(deck);

        // --- Demonstração 2: Uso de Arrays.fill() ---
        // Cria um array de 13 posições para armazenar cartas.
        Card[] cardArray = new Card[13];
        // Cria uma instância de um Ás de Copas.
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        // Preenche todas as 13 posições do 'cardArray' com a mesma instância do Ás de Copas.
        Arrays.fill(cardArray, aceOfHearts);
        // Imprime o conteúdo do array (convertido para List para usar printDeck), com uma descrição.
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts (Arrays.fill)", 1);

        // --- Demonstração 3: Uso de Collections.fill() em uma lista vazia ---
        // Cria uma nova lista com capacidade inicial de 52, mas que está vazia.
        List<Card> cards = new ArrayList<>(52);
        // Tenta preencher a lista 'cards' com o Ás de Copas.
        // IMPORTANTE: Collections.fill() só substitui elementos existentes.
        // Como 'cards' está vazia neste ponto, esta chamada não adicionará nenhum elemento.
        Collections.fill(cards, aceOfHearts);
        // Imprime a lista (que ainda estará vazia) e seu tamanho.
        System.out.println(cards);
        System.out.println("Cards.size() = " + cards.size());

        // --- Demonstração 4: Uso de Collections.nCopies() com Ás de Copas ---
        // Cria uma lista imutável contendo 13 referências à mesma instância do Ás de Copas.
        // Esta lista tem tamanho fixo e não pode ser modificada (elementos adicionados/removidos).
        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        // Imprime esta lista de 13 Ases de Copas.
        Card.printDeck(acesOfHearts, "Aces of Hearts (Collections.nCopies)", 1);

        // --- Demonstração 5: Uso de Collections.nCopies() com Rei de Paus ---
        // Cria uma instância de um Rei de Paus.
        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        // Cria uma lista imutável contendo 13 referências à mesma instância do Rei de Paus.
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        // Imprime esta lista de 13 Reis de Paus.
        Card.printDeck(kingsOfClubs, "Kings of Clubs (Collections.nCopies)", 1);

        // --- Demonstração 6: Uso de Collections.addAll() ---
        // Adiciona todos os elementos do 'cardArray' (13 Ases de Copas) à lista 'cards'.
        // A lista 'cards' estava vazia, agora terá 13 Ases.
        Collections.addAll(cards, cardArray);
        // Adiciona novamente todos os elementos do 'cardArray' à lista 'cards'.
        // 'cards' agora terá 26 Ases de Copas.
        Collections.addAll(cards, cardArray);
        // Imprime a lista 'cards' após as adições.
        Card.printDeck(cards, "Card Collection with Aces added (Collections.addAll)", 2);

        // --- Demonstração 7: Uso de Collections.copy() ---
        // Copia os elementos da lista 'kingsOfClubs' (13 Reis de Paus) para o início da lista 'cards'.
        // IMPORTANTE: A lista de destino ('cards') deve ter pelo menos o mesmo tamanho da lista de origem ('kingsOfClubs').
        // Os primeiros 13 elementos de 'cards' (que eram Ases) serão substituídos pelos Reis de Paus.
        Collections.copy(cards, kingsOfClubs);
        // Imprime a lista 'cards' após a operação de cópia.
        Card.printDeck(cards, "Card Collection with Kings copied (Collections.copy)", 2);

        // --- Demonstração 8: Uso de List.copyOf() (Java 10+) ---
        // Cria uma nova lista imutável 'cards' que é uma cópia exata de 'kingsOfClubs'.
        // Esta é uma forma concisa de criar uma lista imutável a partir de outra coleção.
        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List.copyOf(kingsOfClubs)", 1);

        // --- Demonstração 9: Re-inicialização e Embaralhamento do Baralho ---
        // Re-inicializa a variável 'deck' com um novo baralho padrão completo.
        // Isso é feito para demonstrar operações de embaralhamento e ordenação em um baralho "limpo".
        deck = Card.getStandardDeck();
        Card.printDeck(deck, "Novo Baralho Padrão", 4);

        // Embaralha aleatoriamente a ordem das cartas no 'deck'.
        Collections.shuffle(deck);
        Card.printDeck(deck, "Baralho Embaralhado (Collections.shuffle)", 4);

        // --- Demonstração 10: Inversão da Ordem do Baralho ---
        // Inverte a ordem dos elementos no 'deck'.
        Collections.reverse(deck);
        Card.printDeck(deck, "Baralho Invertido (Collections.reverse)", 4);

        // --- Demonstração 11: Ordenação Customizada do Baralho ---
        // Cria um Comparator para ordenar as cartas primeiro pelo rank e depois pelo naipe.
        // Card::rank é um method reference para o metodo getRank() implícito do record Card.
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit); // Ordena por naipe se os ranks forem iguais.

        // Ordena o 'deck' usando o Comparator customizado.
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Baralho Ordenado por Rank e Naipe (Collections.sort)", 13);

        // --- Demonstração 12: Inversão do Baralho Ordenado ---
        // Inverte a ordem do baralho que já estava ordenado.
        Collections.reverse(deck);
        Card.printDeck(deck, "Baralho Ordenado Invertido (Collections.reverse)", 13);

        // --- Demonstração 13: Extração de Sublistas ---
        // Cria uma sublista contendo os Reis (assumindo que estão nas posições 4 a 7 após a ordenação).
        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Reis Extraídos (deck.subList)", 1);

        // Cria uma sublista contendo os Dez (assumindo que estão nas posições 16 a 19).
        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Dez Extraídos (deck.subList)", 1);

        // --- Demonstração 14: Busca de Sublista (Collections.indexOfSubList) ---
        // Encontra a primeira ocorrência da sublista 'tens' dentro do 'deck'.
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("Índice da sublista 'tens' no baralho = " + subListIndex);

        // --- Demonstração 15: Verificação de Contenção (List.containsAll) ---
        // Verifica se o 'deck' contém todos os elementos da lista 'tens'.
        System.out.println("O baralho contém todos os 'tens'? = " + deck.containsAll(tens));

        // --- Demonstração 16: Verificação de Disjunção (Collections.disjoint) ---
        // Verifica se as duas coleções não têm nenhum elemento em comum.
        // Compara 'deck' e 'tens'. Como 'tens' é uma sublista de 'deck', eles NÃO são disjuntos.
        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("Baralho e 'tens' são disjuntos? = " + disjoint);

        // Compara 'kings' e 'tens'. Como são grupos de cartas diferentes, eles SÃO disjuntos.
        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("Reis e 'tens' são disjuntos? = " + disjoint2);

        // --- Demonstração 17: Busca Binária (Collections.binarySearch) ---
        // Requer que a lista esteja ordenada. Busca a posição de uma carta específica.
        // O Comparator 'sortingAlgorithm' é usado para guiar a busca.
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("Índice encontrado para o Dez de Copas (binarySearch) = " + foundIndex);


        // Note que indexOf pode não funcionar como esperado para objetos complexos sem equals/hashCode customizados
        // ou se a lista não estiver ordenada da mesma forma.
        System.out.println("Índice encontrado para o Dez de Copas (indexOf) = " + deck.indexOf(tenOfHearts));
        System.out.println("Carta na posição encontrada = " + deck.get(foundIndex));

        // --- Demonstração 18: Substituição de Elementos (Collections.replaceAll) ---
        // Cria uma carta "Dez de Paus" para ser o novo valor.
        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);


        // Substitui todas as ocorrências de 'tenOfHearts' por 'tenOfClubs' no baralho.
        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Linha dos Dez após replaceAll (Corações por Paus)", 1);

        // Tenta substituir novamente, mas agora 'tenOfHearts' não existe mais no baralho.
        // O metodo retorna false se nenhuma substituição for feita.
        if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
            System.out.println("Dez de Copas substituído por Dez de Paus.");
        } else {
            System.out.println("Nenhum Dez de Copas encontrado para substituição.");
        }

        // --- Demonstração 19: Contagem de Frequência (Collections.frequency) ---
        // Conta quantas vezes o "Dez de Paus" aparece no baralho.
        System.out.println("Quantidade de Dez de Paus no baralho = " +
                Collections.frequency(deck, tenOfClubs));

        // --- Demonstração 20: Encontrar Maior e Menor Elemento (Collections.max/min) ---
        // Encontra a "melhor" (maior) carta e a "pior" (menor) carta no baralho
        // usando o 'sortingAlgorithm' para definir o que é "maior" ou "menor".
        System.out.println("Melhor Carta (max) = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Pior Carta (min) = " + Collections.min(deck, sortingAlgorithm));

        // --- Demonstração 21: Nova Ordenação por Naipe e Rank ---
        // Cria um novo Comparator para ordenar primeiro por naipe e depois por rank.
        var sortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        // Ordena o baralho usando este novo Comparator.
        deck.sort(sortBySuit);
        Card.printDeck(deck, "Baralho Ordenado por Naipe, depois Rank", 4);

        // --- Demonstração 22: Rotação de Elementos (Collections.rotate) ---
        // Cria uma cópia da primeira "mão" (13 cartas) do baralho.
        List<Card> copied = new ArrayList<>(deck.subList(0, 13));


        // Rotaciona os elementos da lista 'copied' em 2 posições para a direita.
        Collections.rotate(copied, 2);
        System.out.println("Mão Original (primeiras 13): " + deck.subList(0, 13));
        System.out.println("Mão Rotacionada em +2: " + copied);

        // Rotaciona os elementos da lista 'copied' em 2 posições para a esquerda (-2).
        copied = new ArrayList<>(deck.subList(0, 13)); // Re-inicializa para a original
        Collections.rotate(copied, -2);
        System.out.println("Mão Original (primeiras 13): " + deck.subList(0, 13));
        System.out.println("Mão Rotacionada em -2: " + copied);

        // --- Demonstração 23: Inversão Manual de Sublista ---
        // Cria uma cópia da primeira "mão" (13 cartas).
        copied = new ArrayList<>(deck.subList(0, 13));

        // Inverte manualmente a ordem dos elementos na lista 'copied'.
        for (int i = 0; i < copied.size() / 2; i++) {
            Collections.swap(copied, i, copied.size() - 1 - i);
        }
        System.out.println("Mão Invertida Manualmente: " + copied);

        // --- Demonstração 24: Inversão de Sublista usando Collections.reverse ---
        // Cria uma cópia da primeira "mão" (13 cartas).
        copied = new ArrayList<>(deck.subList(0, 13));


        // Inverte a ordem dos elementos na lista 'copied' usando o metodo utilitário.
        Collections.reverse(copied);
        System.out.println("Mão Invertida (Collections.reverse): " + copied);
    }
}
