package praticas.interfaces.exercise47;

import praticas.interfaces.exercise47.linkedList.MyLinkedList;
import praticas.interfaces.exercise47.util.Node;
import praticas.interfaces.exercise47.searchTree.SearchTree;

/**
 * Classe principal para demonstração de estruturas de dados avançadas.
 * 
 * DataStructures é uma classe utilitária que fornece exemplos práticos de uso
 * de duas estruturas de dados principais: Árvore de Busca Binária e Lista Encadeada.
 * Cada metodo de teste (tree() e linkedList()) demonstra operações completas incluindo
 * inserção, remoção, busca e validação de duplicatas para cada estrutura.
 *
 */
public class DataStructures {

    /**
     * Metodo principal que orquestra a execução de testes.
     * 
     * Executa sequencialmente os testes de árvore e lista encadeada, separados
     * por um divisor visual de 100 caracteres para melhor legibilidade na saída.
     *
     */
    public static void main(String[] args) {

        tree();
        System.out.println("_".repeat(100));
        linkedList();
    }

    /**
     * Demonstra operações de Árvore de Busca Binária.
     * 
     * Este metodo testa todas as operações principais de uma árvore binária de busca:
     * - Inserção de múltiplos elementos para construir a árvore;
     * - Teste de rejeição de duplicatas;
     * - Remoção de folha (nó sem filhos);
     * - Remoção de nó com apenas um filho;
     * - Remoção de nó com dois filhos (caso complexo);
     * - Remoção da raiz (reconstrução da árvore);
     * - Tentativa de remoção de elemento inexistente.
     * 
     * A visualização em árvore é exibida após cada operação para validar a integridade
     * da estrutura.
     */
    public static void tree(){

        SearchTree tree = new SearchTree(null);

        // Inserções
        tree.addItem(new Node("50"));
        tree.addItem(new Node("25"));
        tree.addItem(new Node("75"));
        tree.addItem(new Node("10"));
        tree.addItem(new Node("30"));
        tree.addItem(new Node("60"));
        tree.addItem(new Node("80"));
        tree.addItem(new Node("5"));
        tree.addItem(new Node("15"));
        tree.addItem(new Node("27"));
        tree.addItem(new Node("55"));
        tree.addItem(new Node("65"));

        System.out.println("=== ÁRVORE ORIGINAL ===");
        tree.printTree();

        // Teste de duplicata
        System.out.println("\n=== TESTE DE DUPLICATA ===");
        tree.addItem(new Node("25"));
        tree.printTree();

        // Remover folha
        System.out.println("\n=== REMOVENDO FOLHA (15) ===");
        tree.removeItem(new Node("15"));
        tree.printTree();

        // Remover nó com apenas filho esquerdo
        System.out.println("\n=== REMOVENDO NÓ COM UM FILHO (60) ===");
        tree.removeItem(new Node("60"));
        tree.printTree();

        // Remover nó com dois filhos
        System.out.println("\n=== REMOVENDO NÓ COM DOIS FILHOS (25) ===");
        tree.removeItem(new Node("25"));
        tree.printTree();

        // Remover a raiz
        System.out.println("\n=== REMOVENDO A RAIZ (50) ===");
        tree.removeItem(new Node("50"));
        tree.printTree();

        // Remover elemento inexistente
        System.out.println("\n=== REMOVENDO ELEMENTO INEXISTENTE (999) ===");
        tree.removeItem(new Node("999"));
        tree.printTree();

        // Árvore final
        System.out.println("\n=== ÁRVORE FINAL ===");
        tree.printTree();
    }

    /**
     * Demonstra operações de Lista Encadeada Duplamente Ligada.
     * 
     * Este metodo testa todas as operações principais de uma lista encadeada:
     * - Comportamento com lista vazia;
     * - Inserção de múltiplos elementos em ordem;
     * - Teste de rejeição de duplicatas;
     * - Remoção do primeiro elemento;
     * - Remoção de elemento do meio;
     * - Remoção do último elemento;
     * - Tentativa de remoção de elemento inexistente;
     * - Remoção completa de todos os elementos.
     * 
     * A lista é exibida (em ordem) após cada operação para validar a integridade
     * da estrutura e a ordem dos elementos.
     */
    public static void linkedList() {

        MyLinkedList list = new MyLinkedList(null);

        // ===============================
        // Lista vazia
        // ===============================
        System.out.println("=== LISTA VAZIA ===");
        list.printLinkedList();

        // ===============================
        // Inserção
        // ===============================
        System.out.println("\n=== INSERINDO ===");

        list.addItem(new Node("5"));
        list.addItem(new Node("3"));
        list.addItem(new Node("7"));
        list.addItem(new Node("1"));
        list.addItem(new Node("9"));
        list.addItem(new Node("4"));
        list.addItem(new Node("6"));
        list.addItem(new Node("8"));

        list.printLinkedList();

        // ===============================
        // Duplicata
        // ===============================
        System.out.println("\n=== DUPLICATA ===");

        if (!list.addItem(new Node("5"))) {
            System.out.println("5 já existe.");
        }

        // ===============================
        // Remover primeiro
        // ===============================
        System.out.println("\n=== REMOVENDO PRIMEIRO (1) ===");

        list.removeItem(new Node("1"));
        list.printLinkedList();

        // ===============================
        // Remover elemento do meio
        // ===============================
        System.out.println("\n=== REMOVENDO MEIO (5) ===");

        list.removeItem(new Node("5"));
        list.printLinkedList();

        // ===============================
        // Remover último
        // ===============================
        System.out.println("\n=== REMOVENDO ÚLTIMO (9) ===");

        list.removeItem(new Node("9"));
        list.printLinkedList();

        // ===============================
        // Remover inexistente
        // ===============================
        System.out.println("\n=== REMOVENDO INEXISTENTE (20) ===");

        if (!list.removeItem(new Node("20"))) {
            System.out.println("20 não encontrado.");
        }

        // ===============================
        // Remover todos
        // ===============================
        System.out.println("\n=== REMOVENDO TODOS ===");

        list.removeItem(new Node("3"));
        list.removeItem(new Node("4"));
        list.removeItem(new Node("6"));
        list.removeItem(new Node("7"));
        list.removeItem(new Node("8"));

        list.printLinkedList();
    }

}
