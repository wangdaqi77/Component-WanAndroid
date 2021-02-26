package com.zlx.module_login

import android.app.Activity
import android.content.Intent
import com.kunpeng.component.annotation.api.Launcher
import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.ApiLauncher
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeDependencyApiModuleProvider
import com.kunpeng.component.module.SelfApiModuleProvider
import com.zlx.module_login.activity.LoginAc


@Launcher
class LoginLauncher: ApiLauncher{
    fun startLogin(activity: Activity){
        val intent = Intent(activity, LoginAc::class.java)
        activity.startActivity(intent)
    }
}


@ModuleExecutor
class LoginModule: Module {

    override fun onEvaluate(provider: SelfApiModuleProvider) {
        // Call here when evaluating.

    }

    override fun onExecute(provider: SafeDependencyApiModuleProvider) {
        // Now can call other module.
    }
}