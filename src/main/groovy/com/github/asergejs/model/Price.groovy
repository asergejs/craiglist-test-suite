package com.github.asergejs.model

import groovy.transform.Sortable

@Sortable(excludes = ['${currency}'])
class Price{
    String currency
    long amount
}
