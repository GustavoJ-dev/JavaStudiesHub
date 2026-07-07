package pratices.interfaces.challenge.mapJSON;

/**
 * Classe principal que demonstra o uso do sistema de mapeamento com pontos de interesse
 * brasileiros reais mapeados como no Google Maps.
 * 
 * <p>Exemplo de pontos mapeáveis brasileiros:
 * <ul>
 *   <li>Cristo Redentor - Rio de Janeiro (ENTERTAINMENT)</li>
 *   <li>Estádio Maracanã - Rio de Janeiro (SPORTS)</li>
 *   <li>MASP - São Paulo (ENTERTAINMENT)</li>
 *   <li>Palácio do Planalto - Brasília (GOVERNMENT)</li>
 *   <li>Redes de infraestrutura (água, energia, gás, fibra)</li>
 * </ul>
 * 
 * @author Sistema de Mapeamento
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal que executa demonstração do sistema de mapeamento.
     * Mapeia pontos de interesse brasileiros reais e suas infraestruturas.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        
        System.out.println("\n=== PONTOS DE INTERESSE DO BRASIL ===\n");
        
        // Edifícios e Atrações Principais
        Building cristoRedentor = new Building("Cristo Redentor - Rio de Janeiro", TipoUso.ENTRETENIMENTO);
        Mappable.mapIt(cristoRedentor);
        
        Building masp = new Building("MASP - São Paulo", TipoUso.ENTRETENIMENTO);
        Mappable.mapIt(masp);
        
        Building maracana = new Building("Estádio Maracanã - Rio de Janeiro", TipoUso.ESPORTES);
        Mappable.mapIt(maracana);
        
        Building planalto = new Building("Palácio do Planalto - Brasília", TipoUso.GOVERNO);
        Mappable.mapIt(planalto);
        
        Building apart = new Building("Cobertura Leblon - Rio de Janeiro", TipoUso.RESIDENCIAL);
        Mappable.mapIt(apart);
        
        System.out.println("\n=== INFRAESTRUTURAS DE UTILIDADE ===\n");
        
        // Linhas de Utilidade
        UtilityLine agua = new UtilityLine("Adutora Cantareira - São Paulo", TipoUtilidade.AGUA);
        Mappable.mapIt(agua);
        
        UtilityLine eletricidade = new UtilityLine("Linha de Transmissão 500kV - Rio de Janeiro", TipoUtilidade.ELETRICIDADE);
        Mappable.mapIt(eletricidade);
        
        UtilityLine gas = new UtilityLine("Gasoduto Bolívia-Brasil - Mato Grosso", TipoUtilidade.GAS);
        Mappable.mapIt(gas);
        
        UtilityLine fibra = new UtilityLine("Fibra Óptica Br Telecom - Eixo SP-RJ", TipoUtilidade.FIBRA_OPTICA);
        Mappable.mapIt(fibra);
    }
}
