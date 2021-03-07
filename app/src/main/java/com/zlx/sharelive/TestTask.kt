package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.Task
import com.kunpeng.component.task.TaskExecutor

class TestTask : Task {
    override fun run(executor: TaskExecutor, provider: SafeModuleProvider) {
        executor.execute(Runnable {
            Log.e("TestTask", "run: 这是一个前置的测试任务")
        })
    }
}