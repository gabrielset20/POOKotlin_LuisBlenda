package Estoque

import model .*

class Estoque {
    private val itens = mutableListOf<ItemProduto>()

    fun entraItem(item: ItemProduto) {
        itens.add(item)
    }

    fun saiItem(item: ItemProduto): ItemProduto? {
        val itemRemovido = itens.find { it.codigoDeBarras == item.codigoDeBarras }
        if (itemRemovido != null) {
            itens.remove(itemRemovido)
        }
        return itemRemovido
    }

    fun getItens(): List<ItemProduto> {
        return itens
    }

    fun qtdItens(): Int {
        return itens.size
    }

    fun removeAllItensVencidos() {
        itens.removeAll { !it.valido() }
    }
}