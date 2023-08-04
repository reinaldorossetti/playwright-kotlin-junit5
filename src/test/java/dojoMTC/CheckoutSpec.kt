package dojoMTC

import base.BaseTests
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import io.qameta.allure.Allure.*
import org.junit.jupiter.api.*
import java.util.regex.Pattern

class CheckoutSpec(): BaseTests() {
    @BeforeEach
    fun beforeTest() { login("standard_user", "secret_sauce") }

    @Test
    fun successfull_checkout() {
        step("add and remove items from cart")
        click("#add-to-cart-sauce-labs-backpack")
        validateText("1")
        click("#add-to-cart-sauce-labs-bike-light")
        validateText("2")
        text("Remove").first().click()
        validateText("1")
        click("#add-to-cart-sauce-labs-backpack")
        step("ago to cart")
        click("#shopping_cart_container .shopping_cart_badge")
        assertThat(text("Remove")).hasCount(2)
        text("Checkout").first().click()
        step("fill customer info and go to step two")
        fill("#first-name","Renatinha")
        fill("#last-name","Andrade")
        fill("#postal-code","2187")
        text("Continue", "input").first().click()
        step("check order info and complete checkout")
        validateText("Item total: \$39.98",".summary_subtotal_label")
        validateText("Tax: \$3.20",".summary_tax_label")
        validateText("Total: \$43.18",".summary_info_label.summary_total_label")
        text("Finish").first().click()
        step("check checkout successfull")
        assertThat(pw.getByText("Thank you for your order!")).isVisible()
        text("Back Home").first().click()
        assertThat(pw).hasURL(Pattern.compile(".*inventory.html"))
    }}