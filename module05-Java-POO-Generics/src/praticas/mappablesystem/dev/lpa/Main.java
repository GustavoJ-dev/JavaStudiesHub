package praticas.mappablesystem.dev.lpa;

import praticas.mappablesystem.dev.lpa.model.Rivers;
import praticas.mappablesystem.dev.lpa.model.TouristPoint;
import praticas.mappablesystem.dev.lpa.util.Layer;

/**
 * Classe principal para demonstração do sistema de mapeamento.
 * Cria e renderiza diferentes tipos de elementos mapeáveis (pontos turísticos e rios)
 * organizados em camadas.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Criação e Renderização da Camada de Pontos Turísticos
        printHeader("Pontos Turísticos");
        var touristPoints = new TouristPoint[]{
                new TouristPoint("Christ the Redeemer", "-22.951944,-43.210556"),
                new TouristPoint("Mount Everest", "27.98937,86.9258"),
                new TouristPoint("Grand Canyon", "36.106944,-112.111389")
        };

        Layer<TouristPoint> touristPointLayer = new Layer<>(touristPoints);
        touristPointLayer.renderLayer();

        // 2. Criação e Renderização da Camada de Rios
        printHeader("Rios do Mundo");
        var initialRivers = new Rivers[]{ //
                new Rivers("Amazon", "-3.16714,-60.034354", "-4.442,-3.200,-60.000"), // Ajustado para exemplo
                new Rivers("Nile", "24.64282,32.79240", "30.0444,31.2357") // Ajustado para exemplo
        };

        Layer<Rivers> riversLayer = new Layer<>(initialRivers); // Corrigido de Rivers para River

        // Adicionando mais rios à camada existente
        riversLayer.addElement(
                new Rivers("Tigris", "39.8730,43.72496", "37.9158,40.2364", "35.4681,44.3922"),
                new Rivers("Tiete", "-22.11743,-48.75427", "-23.5505,-46.6333")
        );

        riversLayer.renderLayer();
    }

    /**
     * Imprime um cabeçalho estilizado no console para facilitar a leitura.
     * @param title O título da seção a ser exibido.
     */
    private static void printHeader(String title) {
        String separator = "=".repeat(50);
        System.out.println("\n" + separator);
        System.out.println(title.toUpperCase());
        System.out.println(separator);
    }
}
