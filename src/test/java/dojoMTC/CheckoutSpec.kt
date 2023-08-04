package dojoMTC

import base.BaseTests
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import io.qameta.allure.Allure.*
import org.junit.jupiter.api.*
import qa.model.CheckoutFeatureData
import java.util.regex.Pattern.compile

class CheckoutSpec(val ccfd: CheckoutFeatureData = CheckoutFeatureData()): BaseTests() {
    @BeforeEach
    fun beforeTest() {
        login("standard_user", "secret_sauce")
    }

    @Test
    fun successfull_checkout() {
        step(ccfd.addRemoveItensStep)
        click(ccfd.btnAddBackpack)
        validateText("1")
        click(ccfd.btnAddBikeLight)
        validateText("2")
        text(ccfd.txtBtnRemove).first().click()
        validateText("1")
        click(ccfd.btnAddBackpack)
        step(ccfd.goToShoppingCart)
        click(ccfd.btnShoppingCart)
        assertThat(text(ccfd.txtBtnRemove)).hasCount(2)
        text(ccfd.txtBtnCheckout).first().click()
        step(ccfd.fillCustomerStep)
        fill(ccfd.inputFirstName,ccfd.FirstName)
        fill(ccfd.inputLastName,ccfd.LastName)
        fill(ccfd.inputPostalCode,ccfd.PostalCode)
        text(ccfd.txtBtnContinue, ccfd.tagInput).first().click()
        step(ccfd.checkOrderInfoStep)
        validateText(ccfd.itemTotal,ccfd.txtSubTotal)
        validateText(ccfd.itemTax,ccfd.txtTax)
        validateText(ccfd.itemTotalSomaTax,ccfd.txtTotalSomaTax)
        text(ccfd.txtBtnFinish).first().click()
        step(ccfd.checkoutOKStep)
        assertThat(pw.getByText(ccfd.mensageOrder)).isVisible()
        text(ccfd.txtBtnBackHome).first().click()
        assertThat(pw).hasURL(compile(ccfd.urlInventory))
    }}