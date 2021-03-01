package com.zlx.module_mine.fragment

import android.app.Activity
import com.kunpeng.component.dependency
import com.kunpeng.component.module.api.Login
import com.zlx.module_base.database.MMkvHelper

object CheckLogin {
    @JvmStatic
    fun check(activity: Activity): Boolean {
        val userInfo = MMkvHelper.getInstance().userInfo
        return if (userInfo == null) {
            dependency<Login>()
                    .launcher
                    .newActivityIntentForLoginAc(activity)
                    .run { activity.startActivity(this) }
            false
        } else {
            true
        }
    }
}