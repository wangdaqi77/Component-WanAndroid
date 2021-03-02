package com.zlx.module_base.module;

import android.app.Application;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.mmkv.MMKV;
import com.zlx.library_db.manager.DbUtil;
import com.zlx.module_base.BaseApplication;
import com.zlx.module_base.base_util.LogUtils;
import com.zlx.module_base.base_util.NeverCrashHelper;

import com.zlx.module_base.loadsir.EmptyCallback;
import com.zlx.module_base.loadsir.ErrorCallback;
import com.zlx.module_base.loadsir.LoadingCallback;

/**
 * Created by zlx on 2020/9/22 14:28
 * Email: 1170762202@qq.com
 * Description:
 */
public class CommonModuleInit  {
    public static void init(Application application) {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(application));
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(application));
        MMKV.initialize(application);
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new EmptyCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();


        DbUtil.getInstance().init(application, "wanandroid");


//        if (LeakCanary.isInAnalyzerProcess(application)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return false;
//        }
//        LeakCanary.install(application);


//        NeverCrashHelper.init((t, e) -> {
//            LogUtils.i(e.getMessage());
//            new Handler(Looper.getMainLooper()).post(() -> {
//                Toast.makeText(application, e.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//        });

    }
}
