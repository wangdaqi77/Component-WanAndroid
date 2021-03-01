package com.zlx.module_base.base_util;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zlx.module_base.constant.RouterActivityPath;


public class RouterUtil {

    public static void launchWeb(String webUrl) {
        ARouter.getInstance().build(RouterActivityPath.Web.PAGER_WEB).withString("webUrl", webUrl).navigation();
    }

}
