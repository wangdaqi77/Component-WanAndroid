package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.Task
import com.kunpeng.component.module.task.TaskExecutor

class ETask : Task {
    override fun onExecute(provider: SafeModuleProvider) {
        Log.e("ETask", "执行E任务")

    }
}