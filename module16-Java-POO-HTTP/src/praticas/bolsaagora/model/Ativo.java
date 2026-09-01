package praticas.bolsaagora.model;

/**
 * Representa um ativo negociado na BolsaAgora.
 *
 * @param codigo código identificador do ativo
 * @param preco preço atual do ativo
 */
public record Ativo(String codigo, Double preco) { }
