package pages

import com.microsoft.playwright.Page
import com.microsoft.playwright.options.WaitForSelectorState

open class PageBase() {
    val stateATTACHED: Page.WaitForSelectorOptions = Page.WaitForSelectorOptions().setState(WaitForSelectorState.ATTACHED)
    val stateDETACHED: Page.WaitForSelectorOptions = Page.WaitForSelectorOptions().setState(WaitForSelectorState.DETACHED)
}
