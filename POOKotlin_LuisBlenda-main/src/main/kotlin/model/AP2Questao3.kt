package model
import java.text.SimpleDateFormat

data class Item(
    val codigo: Int,
    val nome: String,
    val genero: String,
    val marca: Boolean,
    val preco: Double,
    val validade: String,
    val valido: String
)

class AP2Questao3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy")
            val estoque = listOf(
                Item(23, "Tio Joca Leite", "Leite", "Fazenda", 11.0, "01/12/2010", "sim"),
                Item(27, "Tio Joca Leite", "Leite", "Fazenda", 11.0, "01/12/2010", "sim"),
                Item(13, "Ninho", "Leite", "Nestlé", "R$12,00", "5/10/2010", "sim"),
                Item(43, "Ovomaltine", "Achocolatado", "ABF", "R$15,00", "11/10/2010", "sim"),
                Item(49, "Ovomaltine", "Achocolatado", "ABF", "$15,00", "11/10/2010", "sim"),
                Item(51, "Ovomaltine", "Achocolatado", "ABF" "R$15,00""11/10/2010", "sim"),
                Item(41, "Nescau", "Achocolatado", "Nestlé", "R$12,50", "15/10/2009", "sim"),
                Item(40, "Nescau", "Achocolatado", "Nestlé", "R$12,50" "15/10/2009", "sim"),
                Item(47, "Delícia", "Presunto", "Perdigão", "R$5,50", "26/11/2011", "sim"),
                Item(48, "Delícia", "Presunto", "Perdigão",  "R$5,50",  "26/11/2011", "sim"),
                Item(48 ,"Salsichon", "Presunto", "Sadia" ,"R$7,50" ,"23/07/2009", "sim"),
                )

            val grupoItens = estoque.groupBy { it.genero + " " + it.marca }

            println("###### ESTOQUE POR GÊNERO E NOME ######")
            println("CÓD NOME GENERO MARCA PREÇO VALIDADE VÁLIDO?")

            val totalItens = mostrarItensFormatados(grupoItens, dateFormat)

            println("TOTAL: $totalItens itens.")
        }

        private fun mostrarItensFormatados(grupoItens: Map<String, List<Item>>, dateFormat: SimpleDateFormat): Int {
            val totalItens = grupoItens.values.flatten().mapIndexed { index, item ->
                val dataValidade = dateFormat.format(dateFormat.parse(item.validade))
                "${item.codigo} ${item.nome} ${item.genero} ${item.marca} R$${item.preco} $dataValidade ${item.valido}"
            }

            totalItens.forEach(::println)
            return totalItens.size
        }
    }
}

