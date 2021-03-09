package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.SafeTaskOutputProvider
import com.kunpeng.component.module.task.Task


class CTask : Task<Unit, Unit>() {
    override fun onExecute(taskOutputProvider: SafeTaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("CTask", "执行C任务")
    }
}