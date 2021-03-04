package com.zlx.module_square


import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider



@ModuleExecutor
class SquareModule: Module {

    override fun onEvaluate() {
        // Call here when evaluating.
    }

    override fun onExecute(provider: SafeModuleProvider) {
        // Now can call other module by provider.getModule().
    }
}