package com.zlx.sharelive;

import android.util.Log;

import com.kunpeng.component.ComponentInitializer;
import com.kunpeng.component.app.AppModule;
import com.kunpeng.component.config.ComponentConfig;
import com.kunpeng.component.log.ILogger;
import com.kunpeng.component.log.Level;
import com.kunpeng.component.module.SafeDependencyApiModuleProvider;
import com.kunpeng.component.module.SelfApiModuleProvider;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.config.ModuleLifecycleConfig;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


/**
 * @date: 2019\3\8 0008
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public class MyApp extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        ComponentConfig config = ComponentConfig.Companion.newConfig(componentConfig -> {
            componentConfig.setLogger((level, s, throwable) -> Log.i("Component", s));
            return null;
        });

        ComponentInitializer.INSTANCE.init(config, new AppModule(this) {
            @Override
            public void onEvaluate(@NotNull SelfApiModuleProvider selfApiModuleProvider) {

            }

            @Override
            public void onExecute(@NotNull SafeDependencyApiModuleProvider safeDependencyApiModuleProvider) {

            }
        });

        ModuleLifecycleConfig.getInstance().initModuleAhead(this);


    }




}
