package com.zlx.module_square.activity;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kunpeng.component.ModuleEx;
import com.kunpeng.component.annotation.api.Launcher;
import com.kunpeng.component.module.api.Web;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;
import com.zlx.module_base.adapters.RvAdapterArticleList;
import com.zlx.module_base.base_ac.BaseAc;

import com.zlx.module_network.api1.livedata.BaseObserver;
import com.zlx.module_network.api1.livedata.BaseObserverCallBack;
import com.zlx.module_network.bean.ApiResponse;
import com.zlx.module_base.base_api.res_data.ArticleBean;
import com.zlx.module_base.base_api.res_data.ArticleListRes;
import com.zlx.module_base.base_api.util.ApiUtil;
import com.zlx.module_network.util.LogUtil;
import com.zlx.module_square.R;
import com.zlx.module_square.R2;
import com.zlx.widget.CustomItemDecoration;

import java.util.List;

import butterknife.BindView;

/**
 * FileName: SquareListAc
 * Created by zlx on 2020/9/18 14:47
 * Email: 1170762202@qq.com
 * Description:广场列表
 */
@Launcher
public class SquareListAc extends BaseAc implements OnRefreshLoadMoreListener {

    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R2.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    private String id;
    private String title;

    private RvAdapterArticleList adapterArticleList;

    @Override
    protected int getLayoutId() {
        return R.layout.ac_square_list;
    }

    @Override
    public void initViews() {
        super.initViews();
        showLoading();
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra("title");
        setAcTitle(title);
        LogUtil.show("id=" + id + "  title=" + title);
        adapterArticleList = new RvAdapterArticleList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterArticleList);
        recyclerView.addItemDecoration(new CustomItemDecoration(this,
                CustomItemDecoration.ItemDecorationDirection.VERTICAL_LIST, R.drawable.linear_split_line));
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setEnableRefresh(true);
        smartRefreshLayout.setOnRefreshLoadMoreListener(this);
        adapterArticleList.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId()==R.id.ivCollect){
                List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
                ArticleBean articleBean = data.get(position);
                if (articleBean.isCollect()){
                    ApiUtil.getArticleApi().unCollect(articleBean.getId()).observe(this,apiResponse -> {});
                }else {
                    ApiUtil.getArticleApi().collect(articleBean.getId()).observe(this,apiResponse -> {});
                }
                articleBean.setCollect(!articleBean.isCollect());
                adapterArticleList.notifyItemChanged(position);

            }
        });
        adapterArticleList.setOnItemClickListener((adapter, view, position) -> {
            List<ArticleBean> data = (List<ArticleBean>) adapter.getData();
            Intent intent = ModuleEx.moduleOf(Web.class).getLauncher().newActivityIntentForWebAc(this);
            intent.putExtra("webUrl", data.get(position).getLink());
            startActivity(intent);
        });
        listArticle(id, true);
    }

    private int page = 0;

    private void listArticle(String id, boolean refresh) {
        if (!refresh) {
            page++;
        } else {
            page = 0;
        }
        ApiUtil.getArticleApi().listArticle(page, id).observe(this, new BaseObserver<>(new BaseObserverCallBack<ApiResponse<ArticleListRes>>() {
            @Override
            public void onSuccess(ApiResponse<ArticleListRes> data) {
                if (refresh) {
                    adapterArticleList.setList(data.getData().getDatas());
                }
                adapterArticleList.addData(data.getData().getDatas());
            }

            @Override
            public void onFinish() {
                super.onFinish();
                showSuccess();
                smartRefreshLayout.finishRefresh();
                smartRefreshLayout.finishLoadMore();
            }
        }));

    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        listArticle(id, false);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        listArticle(id, true);

    }
}
