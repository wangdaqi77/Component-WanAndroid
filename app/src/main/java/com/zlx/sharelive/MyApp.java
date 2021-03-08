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

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void configComponent() {
        ComponentInitializer.with(this)
                .logger((level, msg, throwable) -> {
                    Log.i("Component", msg);
                })
                .onEvaluate(register -> {
                    //register.register(CommonInitTask.class);
                    register.register(
                            DbInitTask.class,
                            MMKVInitTask.class,
                            ViewInitTask.class,
                            ATask.class,
                            BTask.class,
                            CTask.class,
                            DTask.class,
                            ETask.class,
                            FTask.class,
                            GTask.class
                    );

                    // 顺序一定是 G,F,E,D,C,B,A
                    register.find(ATask.class).dependOn(BTask.class);
                    register.find(BTask.class).dependOn(CTask.class);
                    register.find(CTask.class).dependOn(DTask.class);
                    register.find(DTask.class).dependOn(ETask.class);
                    register.find(ETask.class).dependOn(FTask.class);
                    register.find(FTask.class).dependOn(GTask.class);
                })
                .onExecuted(provider -> {
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
