package model

class Data(private var dia: Int, private var mes: Int, private var ano: Int) {

    fun setData(dia: Int, mes: Int, ano: Int) {
        if (dataValida(dia, mes, ano)) {
            this.dia = dia
            this.mes = mes
            this.ano = ano
        }
    }

    fun getNome(): String {
        return "$dia/$mes/$ano"
    }

    fun antes(outraData: Data): Boolean {
        return (ano < outraData.ano) || (ano == outraData.ano && mes < outraData.mes) ||
                (ano == outraData.ano && mes == outraData.mes && dia < outraData.dia)
    }

    fun setNome(nome: String) {
        val partes = nome.split("/")
        if (partes.size == 3) {
            val novoDia = partes[0].toIntOrNull()
            val novoMes = partes[1].toIntOrNull()
            val novoAno = partes[2].toIntOrNull()

            if (novoDia != null && novoMes != null && novoAno != null && dataValida(novoDia, novoMes, novoAno)) {
                dia = novoDia
                mes = novoMes
                ano = novoAno
            }
        }
    }

    fun depois(outraData: Data): Boolean {
        return !antes(outraData) && !igual(outraData)
    }

    fun igual(outraData: Data): Boolean {
        return (ano == outraData.ano) && (mes == outraData.mes) && (dia == outraData.dia)
    }

    companion object {
        fun dataHoje(): Data {
            val hoje = java.time.LocalDate.now()
            return Data(hoje.dayOfMonth, hoje.monthValue, hoje.year)
        }

        fun fromString(dataString: String): Data {
            val partes = dataString.split("/")
            if (partes.size != 3) {
                throw IllegalArgumentException("Formato de data inválido. Use o formato DD/MM/AAAA.")
            }
            val dia = partes[0].toInt()
            val mes = partes[1].toInt()
            val ano = partes[2].toInt()
            return Data(dia, mes, ano)
        }
    }

    val getDia: Int
        get() = dia

    val getMes: Int
        get() = mes

    val getAno: Int
        get() = ano

    private fun dataValida(dia: Int, mes: Int, ano: Int): Boolean {
        return true
    }
}
