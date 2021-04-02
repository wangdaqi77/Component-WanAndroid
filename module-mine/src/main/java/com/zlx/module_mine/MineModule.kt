package com.zlx.module_mine

import com.kunpeng.component.annotation.api.Event
import com.kunpeng.component.annotation.module.ModuleInitializer
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.TaskOutputProvider
import com.kunpeng.component.module.task.TaskRegister

import com.zlx.module_mine.bean.LanguageBean

@Event
interface MineEvent {
    val languageChanged: LanguageBean
}

@ModuleInitializer
class MineModule: Module {

    override fun onEvaluate(register: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        // Now can call other module by provider.moduleOf().
    }
}