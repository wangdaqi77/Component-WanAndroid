package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.Task
import com.kunpeng.component.module.task.TaskExecutor

class CTask : Task {
    override fun onExecute(provider: SafeModuleProvider) {
        Log.e("CTask", "执行C任务")

    }
}