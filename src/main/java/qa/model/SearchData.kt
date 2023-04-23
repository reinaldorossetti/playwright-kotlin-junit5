package qa.model

data class SearchData (
    val searchBarElem: String = "#searchBar",
    val hiddenBooksElem: String = "li.ui-screen-hidden",
    val visibleBooksElem: String = "li:not(.ui-screen-hidden)",
    val visibleBookTitlesElem: String = "li:not(.ui-screen-hidden) h2"
)
