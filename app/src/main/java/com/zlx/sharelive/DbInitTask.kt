package com.zlx.sharelive

import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.Task
import com.kunpeng.component.task.TaskExecutor
import com.zlx.library_db.manager.DbUtil


class DbInitTask: Task {
    override fun run(executor: TaskExecutor, provider: SafeModuleProvider) {
        executor.execute(Runnable {
            DbUtil.getInstance().init(provider.application, "wanandroid")
        })
    }
}