package com.zlx.module_mine.fragment

import android.app.Activity
import com.kunpeng.component.module.api.Login
import com.kunpeng.component.moduleOf
import com.zlx.module_base.database.MMkvHelper

object CheckLogin {
    @JvmStatic
    fun check(activity: Activity): Boolean {
        val userInfo = MMkvHelper.getInstance().userInfo
        return if (userInfo == null) {
            val intent = moduleOf(Login::class.java) { launcher.newActivityIntentForLoginAc(activity) }
            activity.startActivity(intent)
            false
        } else {
            true
        }
    }
}