package qa.controller

import com.microsoft.playwright.ElementHandle
import com.microsoft.playwright.Page
import qa.model.SearchData
import qa.controller.core.GlobalFunctions
import java.util.stream.Collectors

class SearchFeature(private val page: Page): GlobalFunctions(page) {

    private val searchData = SearchData()

    fun search(query: String) {
        clearSearchBar()
        page.apply {
            fill(searchData.searchBarElem, query)
            waitForSelector(searchData.hiddenBooksElem, stateATTACHED)
        }
    }

    fun clearSearchBar() {
        page.fill(searchData.searchBarElem, "")
        page.waitForSelector(searchData.hiddenBooksElem, stateDETACHED)
    }

    val numberOfVisibleBooks: Int get() = page.querySelectorAll(searchData.visibleBooksElem).size

    val visibleBooks: List<String>
        get() = page.querySelectorAll(searchData.visibleBookTitlesElem)
            .stream()
            .map { obj: ElementHandle -> obj.innerText() }
            .collect(Collectors.toList())
}