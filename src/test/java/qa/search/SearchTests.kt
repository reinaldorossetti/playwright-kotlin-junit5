package qa.search

import io.qameta.allure.Allure.step
import qa.base.BaseTests
import io.qameta.allure.Step
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class SearchTests : BaseTests() {
    @Test
    @Step("Search for exact title")
    @Order(1)
    fun searchForExactTitle() {
        val title = "Agile Testing"
        searchPage.search(title)
        assertEquals(searchPage.numberOfVisibleBooks, 1, "Number of visible books")
        assertTrue(searchPage.visibleBooks.contains(title), "Title of visible book")
    }

    @Test
    @Step("Search for partial title")
    @Order(2)
    fun searchForPartialTitle() {
        step("Dado que estou no site")
        step("Quando fizer a busca do livro")
        step("Então valida o retorno da busca")
        searchPage.search("Test")
        val expectedBooks = listOf(
            "Test Automation in the Real World", "Experiences of Test Automation",
            "Agile Testing", "How Google Tests Software", "Java For Testers"
        )
        assertEquals(searchPage.numberOfVisibleBooks, expectedBooks.size, "Number of visible books")
        assertEquals(searchPage.visibleBooks, expectedBooks, "Titles of visible books")
    }
}