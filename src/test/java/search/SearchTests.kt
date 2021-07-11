package search

import base.BaseTests
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
}