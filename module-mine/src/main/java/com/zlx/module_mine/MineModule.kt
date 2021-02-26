package com.zlx.module_mine

import androidx.fragment.app.Fragment
import com.kunpeng.component.annotation.api.Launcher
import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.ApiLauncher
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeDependencyApiModuleProvider
import com.kunpeng.component.module.SelfApiModuleProvider
import com.zlx.module_mine.fragment.MineFg


@Launcher
class MineLauncher: ApiLauncher{
    fun newMineFragment(): Fragment {
        return MineFg()
    }
}


@ModuleExecutor
class MineModule: Module {

    override fun onEvaluate(provider: SelfApiModuleProvider) {
        // Call here when evaluating.

    }

    override fun onExecute(provider: SafeDependencyApiModuleProvider) {
        // Now can call other module.
    }
}