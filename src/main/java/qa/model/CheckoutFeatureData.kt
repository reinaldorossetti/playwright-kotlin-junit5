package qa.model

data class CheckoutFeatureData(
    val addRemoveItensStep: String = "Add And Remove Items From Cart",
    val btnAddBackpack: String = "#add-to-cart-sauce-labs-backpack",
    val btnAddBikeLight: String = "#add-to-cart-sauce-labs-bike-light",
    val goToShoppingCart:String = "Go To Shopping Cart",
    val btnShoppingCart:String = "#shopping_cart_container .shopping_cart_badge",
    val fillCustomerStep:String = "fill customer info and go to step two",
    val inputFirstName:String = "#first-name",
    val inputLastName:String = "#last-name",
    val inputPostalCode:String = "#postal-code",
    val FirstName:String = "Renatinha",
    val LastName:String = "Andrade",
    val PostalCode:String = "2187",
    val checkOrderInfoStep:String = "check order info and complete checkout",
    val itemTotal:String = "Item total: \$39.98",
    val itemTax:String = "Tax: \$3.20",
    val itemTotalSomaTax:String = "Total: \$43.18",
    val txtSubTotal:String = ".summary_subtotal_label",
    val txtTax:String = ".summary_tax_label",
    val txtTotalSomaTax:String = ".summary_info_label.summary_total_label",
    val checkoutOKStep:String = "check checkout successfull",
    val mensageOrder:String = "Thank you for your order!",
    val urlInventory:String = ".*inventory.html",
    val txtBtnRemove:String = "Remove",
    val txtBtnContinue:String = "Continue",
    val txtBtnCheckout:String = "Checkout",
    val txtBtnFinish:String = "Finish",
    val txtBtnBackHome:String = "Back Home",
    val tagInput:String = "input"
)

