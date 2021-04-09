package com.zlx.module_login;

import android.util.Log;

import com.p2m.core.P2M;


import com.p2m.core.module.SafeModuleProvider;
;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.module.CommonModuleInit;

import org.jetbrains.annotations.NotNull;


/**
 * Created by zlx on 2020/9/30 12:41
 * Email: 1170762202@qq.com
 * Description:
 */
public class LoginApp extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        configP2M();
    }

    private void configP2M() {

        P2M.initializer(this)
                .logger((level, msg, throwable) -> {
                    Log.i("P2M", msg);
                })
                .start();

    }
}
