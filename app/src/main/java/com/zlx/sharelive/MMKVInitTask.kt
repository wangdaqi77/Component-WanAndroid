package com.zlx.sharelive

import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.Task
import com.kunpeng.component.task.TaskExecutor
import com.tencent.mmkv.MMKV


class MMKVInitTask: Task {
    override fun run(executor: TaskExecutor, provider: SafeModuleProvider) {
        executor.execute(Runnable {
            MMKV.initialize(provider.application)
        })
    }
}