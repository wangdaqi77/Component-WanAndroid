package com.zlx.sharelive

import android.util.Log
import com.p2m.core.module.SafeModuleProvider
import com.p2m.core.module.task.TaskOutputProvider
import com.p2m.core.module.task.Task


class ATask : Task<Int, String>() {
    override fun onExecute(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("ATask", "执行A任务")
        output = "result $input"
    }
}