package com.zlx.sharelive

import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.module.task.Task
import com.kunpeng.component.module.task.TaskExecutor
import com.zlx.library_db.manager.DbUtil


class DbInitTask: Task {
    override fun onExecute(provider: SafeModuleProvider) {
        DbUtil.getInstance().init(provider.application, "wanandroid")
    }
}