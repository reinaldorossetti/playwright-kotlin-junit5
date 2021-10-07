package base

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import pages.SearchPage
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.nio.file.Paths


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTests {

    private lateinit var browser: Browser
    protected lateinit var searchPage: SearchPage
    protected lateinit var page: Page

    @AfterEach @Attachment(type = "image/png")
    fun takeScreen() {
        page.screenshot(Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")))
        val initialFile = File("./screenshot.png")
        val targetStream: InputStream = FileInputStream(initialFile)
        Allure.addAttachment("screenshot.png", targetStream);
    }

    @BeforeAll
    fun setUp() {

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
            .create().chromium().launch(LaunchOptions().setHeadless(false))

        //A single browser tab
        page = browser.newPage()
        page.navigate("https://automationbookstore.dev/")
        searchPage = SearchPage(page)
    }

    @AfterAll
    fun tearDown() {
        browser.close()
    }
}