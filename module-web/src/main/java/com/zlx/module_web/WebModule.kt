package com.zlx.module_web


import com.p2m.annotation.module.ModuleInitializer
import com.p2m.core.module.Module
import com.p2m.core.module.SafeModuleProvider
import com.p2m.core.module.task.TaskOutputProvider
import com.p2m.core.module.task.TaskRegister


@ModuleInitializer
class WebModule: Module {

    override fun onEvaluate(taskRegister: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        // Now can call other module by provider.moduleOf().
    }
}