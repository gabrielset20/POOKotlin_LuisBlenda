package model

class ItemProduto(val codigoDeBarras: String, val dataValidade: Data, val produto: Produto) {
    fun valido(): Boolean {
        val dataAtual = Data.dataHoje()
        return dataValidade.depois(dataAtual)
    }
}
