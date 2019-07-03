package com.github.asergejs.model.enums

enum SearchSortOption {
    RELEVANT("relevant"),
    UPCOMING("upcoming"),
    NEWEST("newest"),
    PRICE_UP("price ↑"),
    PRICE_DOWN("price ↓")

    private String value

    SearchSortOption(String value){
     this.value = value
    }

    String getValue(){
        value
    }
}
