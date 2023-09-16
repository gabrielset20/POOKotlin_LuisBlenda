import java.text.SimpleDateFormat
import java.util.*

data class Item(
    val codigo: Int,
    val nome: String,
    val genero: String,
    val marca: String,
    val preco: Double,
    val validade: Date,
    val valido: Boolean
)

class AP2Questao4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val estoque = listOf(
                Item(23, "Tio Joca Leite", "Leite", "Fazenda", 11.0, dateFormat.parse("01/12/2022"), true),
                Item(27, "Tio Joca Leite", "Leite", "Fazenda", 11.0, dateFormat.parse("01/12/2022"), true),
                Item(13, "Ninho", "Leite", "Nestlé", 12.0, dateFormat.parse("05/10/2023"), true),
                Item(43, "Ovomaltine Achocolatado", "Achocolatado", "ABF", 15.0, dateFormat.parse("11/10/2021"), false),
                Item(49, "Ovomaltine Achocolatado", "Achocolatado", "ABF", 15.0, dateFormat.parse("11/10/2022"), false),
                Item(51, "Ovomaltine Achocolatado", "Achocolatado", "ABF", 15.0, dateFormat.parse("11/10/2023"), true)
            )

            var itensValidos = 0
            var itensVencidos = 0

            for (item in estoque) {
                if (item.valido) {
                    val hoje = Date()
                    if (item.validade.after(hoje)) {
                        itensValidos++
                    } else {
                        itensVencidos++
                    }
                } else {
                    itensVencidos++
                }
            }

            val totalItens = estoque.size
            val somaItens = itensValidos + itensVencidos

            println("Quantidade de Itens Válidos (não vencidos): $itensValidos")
            println("Quantidade de Itens Vencidos: $itensVencidos")
            println("Total de Itens no Estoque: $totalItens")
            println("A soma dos Itens Válidos e Vencidos é igual ao Total de Itens no Estoque: ${somaItens == totalItens}")
        }
    }
}
