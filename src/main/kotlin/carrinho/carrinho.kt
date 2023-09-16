package carrinho

import model.ItemProduto
import Estoque.Estoque
import model.Produto

class Carrinho {
    private val itensDeProduto = mutableListOf<ItemProduto>()

    fun adicionaItem(item: ItemProduto, estoque: Estoque) {
        if (item.valido()) {
            estoque.saiItem(item)?.let {
                itensDeProduto.add(it)
            }
        }
    }

    fun removeItem(item: ItemProduto, estoque: Estoque) {
        if (itensDeProduto.contains(item)) {
            itensDeProduto.remove(item)
            estoque.entraItem(item)
        }
    }

    fun totalAPagar(): Double {
        return itensDeProduto.sumByDouble{ it.produto.preco }
    }

    fun getItens(): List<ItemProduto> {
        return itensDeProduto
    }

    fun getQuantidade(item: ItemProduto): Int {
        return itensDeProduto.count { it == item }
    }
}