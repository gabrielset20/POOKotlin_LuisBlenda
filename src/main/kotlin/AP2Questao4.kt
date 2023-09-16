
class AP2Questao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val supermercado = SupermercadoWeb()

            // Obter todos os itens no estoque
            val itensNoEstoque = supermercado.getEstoque().getItens()

            // Inicializar contadores
            var itensValidos = 0
            var itensVencidos = 0

            // Percorrer os itens no estoque
            for (item in itensNoEstoque) {
                if (item.valido()) {
                    // Item válido (não vencido)
                    itensValidos++
                } else {
                    // Item vencido
                    itensVencidos++
                }
            }

            // Calcular o total de itens no estoque
            val totalItensNoEstoque = itensNoEstoque.size

            // Verificar se a soma dos itens válidos e vencidos é igual ao total de itens no estoque
            val somaItens = itensValidos + itensVencidos
            val resultadoVerificacao = if (somaItens == totalItensNoEstoque) "Sim" else "Não"

            // Exibir os resultados na tela
            println("Itens válidos (não vencidos): $itensValidos")
            println("Itens vencidos: $itensVencidos")
            println("Total de itens no estoque: $totalItensNoEstoque")
            println("A soma de itens válidos e vencidos é igual ao total de itens no estoque? $resultadoVerificacao")
        }
    }
}

fun main() {
    AP2Questao4.main(emptyArray())
}
