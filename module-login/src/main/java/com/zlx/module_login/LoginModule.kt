package com.zlx.module_login


import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.SelfModuleProvider


@ModuleExecutor
class LoginModule: Module {

    override fun onEvaluate(provider: SelfModuleProvider) {
        // Call here when evaluating, only call self by provider.getSelf().
    }

    override fun onExecute(provider: SafeModuleProvider) {
        // Now can call other module by provider.getModule().
    }
}