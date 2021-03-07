package com.zlx.sharelive;

import android.content.Intent;
import android.util.Log;

import com.kunpeng.component.ComponentInitializer;
import com.kunpeng.component.module.api.Mine;

import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.base_manage.ActivityUtil;
import com.zlx.sharelive.activity.MainActivity;

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
        ComponentInitializer.with(this)
                .logger((level, msg, throwable) -> {
                    Log.i("Component", msg);
                })
                .onEvaluate(register -> {
                    //register.register(CommonInitTask.class);
                    register.register(TestTask.class);
                    register.register(DbInitTask.class).dependOn(TestTask.class);
                    register.register(MMKVInitTask.class).dependOn(TestTask.class);
                    register.register(ViewInitTask.class).dependOn(TestTask.class);
                })
                .onExecuted(provider -> {
                    // Can use depend module here.

                    // 语言改变时切换到主界面
                    provider.getModule(Mine.class)
                            .getEvent()
                            .getLanguageChanged()
                            .observeForeverNoSticky((value) -> {
                                String desc = value.getDesc();
                                ActivityUtil.finishAllActivity();
                                Intent intent = new Intent(MyApp.this, MainActivity.class);
                                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                                MyApp.this.startActivity(intent);
                            });
                })
                .await();
    }

}
