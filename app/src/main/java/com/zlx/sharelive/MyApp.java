package com.zlx.sharelive;

import android.content.Intent;
import android.util.Log;

import com.kunpeng.component.ComponentInitializer;
import com.kunpeng.component.ModuleEx;
import com.kunpeng.component.app.AppModule;
import com.kunpeng.component.config.ComponentConfig;
import com.kunpeng.component.module.SafeModuleProvider;
import com.kunpeng.component.module.SelfModuleProvider;
import com.kunpeng.component.module.api.Mine;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.mmkv.MMKV;
import com.zlx.library_db.manager.DbUtil;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.base_manage.ActivityUtil;

import com.zlx.module_base.loadsir.EmptyCallback;
import com.zlx.module_base.loadsir.ErrorCallback;
import com.zlx.module_base.loadsir.LoadingCallback;
import com.zlx.module_base.module.CommonModuleInit;
import com.zlx.sharelive.activity.MainActivity;

import org.jetbrains.annotations.NotNull;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


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
                CommonModuleInit.init(MyApp.this);
            }

            @Override
            public void onExecute(@NotNull SafeModuleProvider safeApiProvider) {
                // 语言改变时切换到主界面
                safeApiProvider.getModule(Mine.class)
                        .getEvent()
                        .getLanguageChanged()
                        .observeForeverNoSticky((value) -> {
                            String desc = value.getDesc();
                            ActivityUtil.finishAllActivity();
                            Intent intent = new Intent(MyApp.this, MainActivity.class);
                            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                            MyApp.this.startActivity(intent);
                        });
            }
        });

    }

}
