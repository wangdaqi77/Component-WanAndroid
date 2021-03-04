package com.zlx.module_mine;

import android.util.Log;

import com.kunpeng.component.ComponentInitializer;


import com.kunpeng.component.module.SafeModuleProvider;
;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.module.CommonModuleInit;

import org.jetbrains.annotations.NotNull;


/**
 * Created by zlx on 2020/9/30 13:31
 * Email: 1170762202@qq.com
 * Description:
 */
public class MineApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        configComponent();
    }

    private void configComponent() {
        ComponentInitializer.with(this)
                .logger((level, msg, throwable) -> {
                    Log.i("Component", msg);
                })
                .await();

    }
}
