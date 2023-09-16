import Estoque.Estoque
import carrinho.Carrinho
import model.*

class SupermercadoWeb {
    private val estoque = Estoque()
    private val carrinho = Carrinho()
    private val generos = mutableListOf<Generos>()
    private val produtos = mutableListOf<Produto>()
    private val marcas = mutableListOf<Marca>()
    private var codigoProdutoAtual: Int = 1
    private val carrinhoA = Carrinho()
    private val carrinhoB = Carrinho()

    init {
        iniciaSupermercado()
    }

    fun iniciaSupermercado() {

            for (i in 1..3) {
                val produto = Produto(codigoProdutoAtual++, "Tio Joca", 11.00, Marca(nome = "Fazenda"), Leite("Leite"))
                val dataValidade = Data(30, 12, 2023)
                val item = ItemProduto("codigoLeite1", dataValidade, produto)
                estoque.entraItem(item)
            }

            for (i in 1..2) {
                val produto = Produto(codigoProdutoAtual++, "Ovomaltine", 15.00, Marca(nome = "ABF"), Achocolatado("Achocolatado"))
                val dataValidade = Data(30, 12, 2023)
                val item = ItemProduto("codigoAchocolatado1", dataValidade, produto)
                estoque.entraItem(item)
            }

            for (i in 1..5) {
                val produto = Produto(codigoProdutoAtual++, "Delicia", 5.0, Marca(nome = "Perdigão"), Presunto("Presunto"))
                val dataValidade = Data(30, 12, 2023)
                val item = ItemProduto("codigoPresunto1", dataValidade, produto)
                estoque.entraItem(item)
            }

            for (i in 1..2) {
                val produto = Produto(codigoProdutoAtual++, "Nescau", 12.50, Marca(nome = "Nestlé"), Achocolatado("Achocolatado"))
                val dataValidade = Data(3, 4, 2023)
                val item = ItemProduto("codigoAchocolatado2", dataValidade, produto)
                estoque.entraItem(item)
            }
    }

    fun getMarcas(): List<Marca> {
        return marcas
    }

    fun getProdutos(): List<Produto> {
        return produtos
    }

    fun getEstoque(): Estoque {
        return estoque
    }

    // Função para obter a quantidade de gêneros únicos dos itens no estoque
    fun getQuantidadeDeGenerosUnicos(): Int {
        val generosContados = mutableSetOf<Generos>()

        // Obter todos os itens no estoque
        val itensNoEstoque = estoque.getItens()

        // Percorrer os itens do estoque
        for (item in itensNoEstoque) {
            val genero = item.produto.genero

            // Verificar se o gênero já foi contado
            if (!generosContados.contains(genero)) {
                // Adicionar o gênero ao conjunto de gêneros contados
                generosContados.add(genero)
            }
        }

        // Retornar a quantidade de gêneros únicos
        return generosContados.size
    }

    fun getCodigoProdutoAtual(): Int {
        return codigoProdutoAtual
    }


    fun getCarrinhoA(): Carrinho {
        return carrinhoA
    }

    fun getCarrinhoB(): Carrinho {
        return carrinhoB
    }
}