package com.zlx.module_public;

import android.util.Log;

import com.kunpeng.component.ComponentInitializer;
import com.kunpeng.component.app.AppModule;
import com.kunpeng.component.config.ComponentConfig;
import com.kunpeng.component.module.SafeModuleProvider;
import com.kunpeng.component.module.SelfModuleProvider;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.module.CommonModuleInit;

import org.jetbrains.annotations.NotNull;


/**
 * Created by zlx on 2020/9/30 13:31
 * Email: 1170762202@qq.com
 * Description:
 */
public class PublicApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        configComponent();
    }

    private void configComponent() {

        ComponentConfig config = ComponentConfig.Companion.newConfig(componentConfig -> {
            componentConfig.setLogger((level, s, throwable) -> Log.i("Component", s));
            return null;
        });

        ComponentInitializer.init(config, new AppModule(this) {
            @Override
            public void onEvaluate(@NotNull SelfModuleProvider selfModuleProvider) {
                CommonModuleInit.init(PublicApp.this);
            }

            @Override
            public void onExecute(@NotNull SafeModuleProvider safeApiProvider) {

            }
        });

    }
}
