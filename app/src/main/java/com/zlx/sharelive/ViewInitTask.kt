package com.zlx.sharelive

import android.content.Context
import com.kingja.loadsir.core.LoadSir
import com.kunpeng.component.module.SafeModuleProvider
import com.kunpeng.component.task.Task
import com.kunpeng.component.task.TaskExecutor
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.zlx.module_base.loadsir.EmptyCallback
import com.zlx.module_base.loadsir.ErrorCallback
import com.zlx.module_base.loadsir.LoadingCallback


class ViewInitTask: Task {
    override fun run(executor: TaskExecutor, provider: SafeModuleProvider) {
        executor.executeOnMain(Runnable {
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context?, layout: RefreshLayout? -> ClassicsHeader(provider.application) }
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context: Context?, layout: RefreshLayout? -> ClassicsFooter(provider.application) }
            LoadSir.beginBuilder()
                    .addCallback(ErrorCallback())
                    .addCallback(LoadingCallback())
                    .addCallback(EmptyCallback())
                    .setDefaultCallback(LoadingCallback::class.java)
                    .commit()

        })
    }
}