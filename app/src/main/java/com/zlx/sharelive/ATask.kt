package com.zlx.sharelive

import android.util.Log
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.SafeTaskOutputProvider
import com.kunpeng.component.module.task.Task


class ATask : Task<Int, String>() {
    override fun onExecute(taskOutputProvider: SafeTaskOutputProvider, moduleProvider: SafeModuleProvider) {
        Log.e("ATask", "执行A任务")
        output = "result $input"
    }
}