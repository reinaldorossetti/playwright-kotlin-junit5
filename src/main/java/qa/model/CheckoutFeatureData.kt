package qa.model

data class CheckoutFeatureData(
    val Steps_Add_Remove_ItensFromCart: String = "Steps Add And Remove Items From Cart",
    val btnAddBackpack: String = "#add-to-cart-sauce-labs-backpack",
    val btnAddBikeLight: String = "#add-to-cart-sauce-labs-bike-light",
    val Steps_Go_To_ShoppingCart:String = "Steps Go To Shopping Cart",
    val locator_ShoppingCart:String = "#shopping_cart_container",
    val btnShoppingCart:String = "#shopping_cart_container .shopping_cart_badge",
    val Steps_Fill_Customer_Info:String = "Steps Fill customer info and go to step two",
    val inputFirstName:String = "#first-name",
    val inputLastName:String = "#last-name",
    val inputPostalCode:String = "#postal-code",
    val FirstName:String = "Renatinha",
    val LastName:String = "Andrade",
    val PostalCode:String = "2187",
    val Steps_Check_Order_Info_Checkout:String = "Steps Check order info and complete checkout",
    val itemTotal:String = "Item total: \$39.98",
    val itemTax:String = "Tax: \$3.20",
    val itemTotalSomaTax:String = "Total: \$43.18",
    val txtSubTotal:String = ".summary_subtotal_label",
    val txtTax:String = ".summary_tax_label",
    val txtTotalSomaTax:String = "total-label",
    val Steps_Check_Checkout_Successfull:String = "Steps Check checkout successfull",
    val mensageOrder:String = "Thank you for your order!",
    val urlInventory:String = ".*inventory.html",
    val txtBtnRemove:String = "Remove",
    val txtBtnContinue:String = "Continue",
    val txtBtnCheckout:String = "Checkout",
    val txtBtnFinish:String = "Finish",
    val txtBtnBackHome:String = "Back Home",
    val tagInput:String = "input"
)

