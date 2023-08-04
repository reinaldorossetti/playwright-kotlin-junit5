/*
package search

import base.BaseTests
import io.qameta.allure.Step
import org.junit.jupiter.api.*
import qa.controller.SearchFeature
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class SearchTests() : BaseTests("https://automationbookstore.dev/") {

    // precisa inicializar como variavel da classe para ser visivel em todos os testes.
    private lateinit var searchPage: SearchFeature

    @BeforeEach
    fun beforeTest() {
        // inicializar a SearchPage passando a page instancia.
        searchPage = SearchFeature(page)
    }

    @Test
    @Step("Search for exact title")
    fun searchForExactTitle() {
        val title = "Agile Testing"
        searchPage.search(title)
        assertEquals(searchPage.numberOfVisibleBooks, 1, "Number of visible books")
        assertTrue(searchPage.visibleBooks.contains(title), "Title of visible book")
    }

    @Test
    @Step("Search for partial title")
    fun searchForPartialTitle() {
        searchPage.search("Test")
        val expectedBooks = listOf(
            "Test Automation in the Real World",
            "Experiences of Test Automation",
            "Agile Testing",
            "How Google Tests Software",
            "Java For Testers"
        )
        assertEquals(searchPage.numberOfVisibleBooks, expectedBooks.size, "Number of visible books")
        assertEquals(searchPage.visibleBooks, expectedBooks, "Titles of visible books")
    }
}*/
