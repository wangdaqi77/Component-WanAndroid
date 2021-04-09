package com.zlx.sharelive

import android.util.Log
import com.p2m.core.module.SafeModuleProvider
import com.p2m.core.module.task.TaskOutputProvider
import com.p2m.core.module.task.Task


class CTask : Task<Unit, Unit>() {
    override fun onExecute(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("CTask", "执行C任务")
    }
}