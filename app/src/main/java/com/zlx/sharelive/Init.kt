package com.zlx.sharelive

import android.app.Application
import android.util.Log
import com.kunpeng.component.ComponentInitializer
import com.kunpeng.component.app.AppModule
import com.kunpeng.component.config.ComponentConfig
import com.kunpeng.component.log.ILogger
import com.kunpeng.component.log.Level
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.SelfModuleProvider

object Init {
    @JvmStatic
    fun init(application: Application){
        val config = ComponentConfig.newConfig {
            logger = object : ILogger {
                override fun log(level: Level, msg: String, throwable: Throwable?) {
                    Log.i("Component", "AutoInitializer -> $msg")
                }
            }
        }

        ComponentInitializer.init(config, object : AppModule(application) {
            override fun onEvaluate(provider: SelfModuleProvider) {
                // Call here when evaluating, only call self by provider.getSelf().
            }

            override fun onExecute(provider: SafeModuleProvider) {
                // Now can call other module by provider.getModule().
            }
        })
    }
}