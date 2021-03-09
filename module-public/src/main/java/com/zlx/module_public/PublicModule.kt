package com.zlx.module_public


import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.SafeTaskOutputProvider
import com.kunpeng.component.module.task.TaskRegister


@ModuleExecutor
class PublicModule: Module {

    override fun onEvaluate(register: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(taskOutputProvider: SafeTaskOutputProvider, moduleProvider: SafeModuleProvider) {
        // Now can call other module by provider.getModule().
    }
}