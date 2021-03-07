package com.zlx.module_web


import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.TaskRegister


@ModuleExecutor
class WebModule: Module {

    override fun onEvaluate(register: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(provider: SafeModuleProvider) {
        // Now can call other module by provider.getModule().
    }
}