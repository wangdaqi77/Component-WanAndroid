package com.zlx.module_home

import androidx.fragment.app.Fragment
import com.kunpeng.component.annotation.api.Launcher
import com.kunpeng.component.annotation.module.ModuleExecutor
import com.kunpeng.component.module.ApiLauncher
import com.kunpeng.component.module.Module
import com.kunpeng.component.module.SafeDependencyApiModuleProvider
import com.kunpeng.component.module.SelfApiModuleProvider
import com.zlx.module_home.fragment.HomeFg


@Launcher
class HomeLauncher: ApiLauncher{
    fun newHomeFragment(): Fragment {
        return HomeFg()
    }
}


@ModuleExecutor
class HomeModule: Module {

    override fun onEvaluate(provider: SelfApiModuleProvider) {
        // Call here when evaluating.

    }

    override fun onExecute(provider: SafeDependencyApiModuleProvider) {
        // Now can call other module.
    }
}