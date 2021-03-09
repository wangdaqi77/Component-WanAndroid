package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.SafeTaskOutputProvider
import com.kunpeng.component.module.task.Task


class BTask : Task<Unit, Unit>() {
    override fun onExecute(taskOutputProvider: SafeTaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("BTask", "执行B任务")
    }
}