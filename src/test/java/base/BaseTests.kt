package base

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType.LaunchOptions
import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTests(open var url: String="https://www.saucedemo.com") {
    private lateinit var browser: Browser
    open lateinit var pw: Page

    fun click(type: String) { pw.locator(type).click() }
    fun validateText(text:String,locator:String="#shopping_cart_container") {
        assertThat(pw.locator(locator)).hasText(text)}
    fun text(text: String, tag:String="button"): Locator {return pw.locator("${tag}:has-text(\"${text}\")")}
    fun fill(locator:String, value: String) {pw.locator(locator).fill(value)}

    @BeforeAll
    fun setUp() {

        //Open a browser (supports Chromium (Chrome, Edge), Firefox, and Webkit (Safari))
        browser = Playwright
            .create()
            .chromium()
            .launch(LaunchOptions().setHeadless(true))

        //A single browser tab
        pw = browser.newPage()
        pw.navigate(url)
    }

    fun login(userName: String, password: String){
        pw.getByPlaceholder("Username").fill(userName)
        pw.getByPlaceholder("Password").fill(password);
        pw.getByText("Login").click();
    }

    @AfterAll
    fun tearDown() {
        val path = Paths.get("./screenshots/screenshotAfterTest.png")
        pw.screenshot(Page.ScreenshotOptions()
            .setPath(path))
        //Allure.addAttachment("My attachment", Files.newInputStream(Paths.get("screenshots/screenshotAfterTest.png")))
        Allure.addAttachment("Screenshot", Files.newInputStream(path))

        browser.close()
    }

}