package com.zlx.sharelive

import android.util.Log
import com.p2m.core.module.SafeModuleProvider
import com.p2m.core.module.task.TaskOutputProvider
import com.p2m.core.module.task.Task


class BTask : Task<Unit, Unit>() {
    override fun onExecute(taskOutputProvider: TaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("BTask", "执行B任务")
    }
}