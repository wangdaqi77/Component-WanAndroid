package com.zlx.module_login


import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeDependencyApiModuleProvider
import com.kunpeng.component.module.SelfApiModuleProvider


@ModuleExecutor
class LoginModule: Module {

    override fun onEvaluate(provider: SelfApiModuleProvider) {
        // Call here when evaluating.

    }

    override fun onExecute(provider: SafeDependencyApiModuleProvider) {
        // Now can call other module.
    }
}