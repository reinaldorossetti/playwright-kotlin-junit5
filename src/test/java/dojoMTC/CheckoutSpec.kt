package dojoMTC

import base.BaseTests
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import io.qameta.allure.Allure.*
import org.junit.jupiter.api.*
import qa.model.CheckoutFeatureData
import java.util.regex.Pattern.compile

class CheckoutSpec(): BaseTests() {
    val ccfd: CheckoutFeatureData = CheckoutFeatureData()
    @BeforeEach
    fun beforeTest() {
        login("standard_user", "secret_sauce")
    }

    @Test
    fun successfull_checkout() {
        step(ccfd.Steps_Add_Remove_ItensFromCart)
        click(ccfd.btnAddBackpack)
        validateText("1", ccfd.locator_ShoppingCart)
        click(ccfd.btnAddBikeLight)
        validateText("2", ccfd.locator_ShoppingCart)
        text(ccfd.txtBtnRemove).first().click()
        validateText("1", ccfd.locator_ShoppingCart)
        click(ccfd.btnAddBackpack)

        step(ccfd.Steps_Go_To_ShoppingCart)
        click(ccfd.btnShoppingCart)
        assertThat(text(ccfd.txtBtnRemove)).hasCount(2)

        step(ccfd.Steps_Fill_Customer_Info)
        text(ccfd.txtBtnCheckout).first().click()
        fill(ccfd.inputFirstName,ccfd.FirstName)
        fill(ccfd.inputLastName,ccfd.LastName)
        fill(ccfd.inputPostalCode,ccfd.PostalCode)
        text(ccfd.txtBtnContinue, ccfd.tagInput).first().click()

        step(ccfd.Steps_Check_Order_Info_Checkout)
        validateText(ccfd.itemTotal,ccfd.txtSubTotal)
        validateText(ccfd.itemTax,ccfd.txtTax)
        assertThat(getByDataTest(ccfd.txtTotalSomaTax)).hasText(ccfd.itemTotalSomaTax)
        text(ccfd.txtBtnFinish).first().click()

        step(ccfd.Steps_Check_Checkout_Successfull)
        assertThat(pw.getByText(ccfd.mensageOrder)).isVisible()
        text(ccfd.txtBtnBackHome).first().click()
        assertThat(pw).hasURL(compile(ccfd.urlInventory))
    }}