package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.Task
import com.kunpeng.component.module.task.TaskExecutor

class DTask : Task {
    override fun onExecute(provider: SafeModuleProvider) {
        Log.e("DTask", "执行D任务")

    }
}