package base

import com.microsoft.playwright.Browser
import pages.SearchPage
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.BrowserType.LaunchOptions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTests {
    private lateinit var browser: Browser
    protected lateinit var searchPage: SearchPage

    @BeforeAll
    fun setUp() {

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
            .create()
            .chromium()
            .launch(LaunchOptions().setHeadless(false))

        //A single browser tab
        val page = browser.newPage()
        page?.navigate("https://automationbookstore.dev/")
        searchPage = SearchPage(page)
    }

    @AfterAll
    fun tearDown() {
        browser.close()
    }
}