package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.Task
import com.kunpeng.component.module.task.TaskExecutor

class GTask : Task {
    override fun onExecute(provider: SafeModuleProvider) {
        Log.e("GTask", "执行G任务")

    }
}