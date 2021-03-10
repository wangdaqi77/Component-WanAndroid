package com.zlx.module_square


import com.kunpeng.component.annotation.module.ModuleInitializer
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.TaskOutputProvider
import com.kunpeng.component.module.task.TaskRegister


@ModuleInitializer
class SquareModule: Module {

    override fun onEvaluate(register: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        // Now can call other module by provider.getModule().
    }
}