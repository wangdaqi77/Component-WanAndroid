package com.zlx.module_mine.bean

import com.p2m.annotation.api.ApiUse
import java.util.*

@ApiUse
class LanguageBean {
    var locale: Locale
    var desc: String
    var isPress = false

    constructor(locale: Locale, desc: String) {
        this.locale = locale
        this.desc = desc
    }

    constructor(locale: Locale, desc: String, press: Boolean) {
        this.locale = locale
        this.desc = desc
        isPress = press
    }

}
