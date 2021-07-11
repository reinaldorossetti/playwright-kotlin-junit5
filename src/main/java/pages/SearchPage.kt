package pages

import com.microsoft.playwright.ElementHandle
import com.microsoft.playwright.Page
import java.util.stream.Collectors

class SearchPage(private val page: Page) {

    private val locator_searchBar = "#searchBar"
    private val locator_hiddenBooks = "li.ui-screen-hidden"
    private val locator_visibleBooks = "li:not(.ui-screen-hidden)"
    private val locator_visibleBookTitles = "li:not(.ui-screen-hidden) h2"

    fun search(query: String?) {
        clearSearchBar()
        page.fill(locator_searchBar, query)
        val expectedState = Page.WaitForSelectorOptions().setState(Page.WaitForSelectorOptions.State?.ATTACHED)
        page.waitForSelector(locator_hiddenBooks, expectedState)
    }

    fun clearSearchBar() {
        page.fill(locator_searchBar, "")
        val expectedState = Page.WaitForSelectorOptions().setState(Page.WaitForSelectorOptions.State.DETACHED)
        page.waitForSelector(locator_hiddenBooks, expectedState)
    }

    val numberOfVisibleBooks: Int
        get() = page.querySelectorAll(locator_visibleBooks).size
    val visibleBooks: List<String>
        get() = page.querySelectorAll(locator_visibleBookTitles)
            .stream()
            .map { obj: ElementHandle -> obj.innerText() }
            .collect(Collectors.toList())
}