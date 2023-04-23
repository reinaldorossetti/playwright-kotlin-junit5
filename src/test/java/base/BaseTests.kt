package base

import com.microsoft.playwright.Browser
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTests(open var url: String) {
    private lateinit var browser: Browser
    open lateinit var page: Page
    @BeforeAll
    fun setUp() {

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
            .create()
            .chromium()
            .launch(LaunchOptions().setHeadless(false))

        //A single browser tab
        page = browser.newPage()
        page.navigate(url)
    }

    @AfterAll
    fun tearDown() {
        browser.close()
    }
}