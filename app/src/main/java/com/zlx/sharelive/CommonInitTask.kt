package com.zlx.sharelive

import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.Task
import com.kunpeng.component.task.TaskExecutor
import com.zlx.module_base.module.CommonModuleInit


class CommonInitTask: Task {
    override fun run(executor: TaskExecutor, provider: SafeModuleProvider) {
        executor.execute(Runnable {
            CommonModuleInit.init(provider.application)
        })
    }
}