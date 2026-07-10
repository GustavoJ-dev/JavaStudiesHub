package praticas.store;

import praticas.store.enums.Category;

/**
 * Representa um produto cadastrado no sistema de estoque.
 *
 * Cada produto é identificado por um código SKU, possui um nome,
 * um fabricante e pertence a uma {@link Category}.
 *
 * @param sku código único de identificação (SKU) do produto
 * @param name nome do produto
 * @param mfgr fabricante do produto
 * @param category categoria à qual o produto pertence
 *
 */
public record Product(String sku, String name, String mfgr, Category category) { }
