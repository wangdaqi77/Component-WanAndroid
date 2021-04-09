package com.zlx.module_mine.adapters;

import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.p2m.core.P2M;
import com.p2m.module.api.Web;

import com.zlx.module_mine.R;
import com.zlx.module_mine.bean.OpenSourcePro;

import org.jetbrains.annotations.NotNull;

/**
 * Created by zlx on 2020/9/22 17:11
 * Email: 1170762202@qq.com
 * Description:
 */
public class RvAdapterOpenSourcePro extends BaseQuickAdapter<OpenSourcePro, BaseViewHolder> {

    public RvAdapterOpenSourcePro() {
        super(R.layout.rv_item_open_source_pro);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, OpenSourcePro openSourcePro) {
        baseViewHolder.setText(R.id.tvTitle, openSourcePro.getAuthor())
                .setText(R.id.tvContent, openSourcePro.getContent());
        baseViewHolder.itemView.setOnClickListener(view -> {
            Intent intent = P2M.moduleOf(Web.class).getLauncher().newActivityIntentForWebAc(view.getContext());
            intent.putExtra("webUrl", openSourcePro.getLink());
            view.getContext().startActivity(intent);
        });
    }
}
