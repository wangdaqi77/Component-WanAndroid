package com.zlx.module_mine

import com.p2m.annotation.api.Event
import com.p2m.annotation.module.ModuleInitializer
import com.p2m.core.module.Module
import com.p2m.core.module.SafeModuleProvider
import com.p2m.core.module.task.TaskOutputProvider
import com.p2m.core.module.task.TaskRegister

import com.zlx.module_mine.bean.LanguageBean

@Event
interface MineEvent {
    val languageChanged: LanguageBean
}

@ModuleInitializer
class MineModule: Module {

    override fun onEvaluate(taskRegister: TaskRegister) {
        // Call here when evaluating.
    }

    override fun onExecuted(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        // Now can call other module by provider.moduleOf().
    }
}