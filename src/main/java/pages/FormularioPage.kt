package pages

import com.microsoft.playwright.Page
import java.util.Arrays

class FormularioPage(private val page: Page) {


    fun pegarValorFakerCaptch(){
        val texto = page.textContent("[class*=captcha_question]")
        val arrayText = texto.split(" ") as MutableList<String>
        val simbolo = "[^-*+]".toRegex().replace(texto, "")
        println(arrayText)
        when (simbolo) {
            "+" -> println(somaTest(arrayText))
            else -> {
                println("simbolo não mapeado")
            }
        }
    }

    fun somaTest(arrayList: MutableList<String>): Int {
        var soma = 0
        arrayList.forEach { soma += it.toIntOrNull() ?: 0 }
        page.fill("[name=\"et_pb_contact_captcha_1\"]", soma.toString())
        return soma
    }
}