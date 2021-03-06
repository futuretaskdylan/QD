package com.haocang.waterlink.pump;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haocang.base.base.CommonModel;
import com.haocang.base.base.impl.CommonModelImpl;
import com.haocang.base.ui.BaseActivity;
import com.haocang.base.utils.GetEntityListener;
import com.haocang.base.utils.ToastUtil;
import com.haocang.waterlink.R;
import com.haocang.waterlink.constant.HomeUrlConst;
import com.haocang.waterlink.utils.TextUtilsMy;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.HashMap;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//设备下的测点列表
public class BZ_FMJ_PointListActivity extends BaseActivity {

    private int id;
    private Intent i;
    private boolean isTypeBZ, isShowWarm;
    private BZ_FMJ_PointListActivity context;
    private PullToRefreshLayout refreshLayout;
    private BZ_FMJ_PointListAdapter adapter;
    private RecyclerView rv;
    private String title;

    @Override
    protected void doOnCreate() {
        setContentView(R.layout.activity_bz_fmj_device_list);
        context = this;
        i = getIntent();
        id = i.getIntExtra("id", 0);
        isTypeBZ = i.getBooleanExtra("isTypeBZ", true);
        isShowWarm = i.getBooleanExtra("isShowWarm", false);
        title = i.getStringExtra("title");
        initView();
        getData();
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_common_tv)).setText(title + "测点");
        rv = findViewById(R.id.recyclerview);
        adapter = new BZ_FMJ_PointListAdapter(R.layout.item_bz_fmj_device_point, isTypeBZ);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(adapter);
        refreshLayout = findViewById(R.id.pulltorefreshlayout);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                getData();
            }

            @Override
            public void loadMore() {
                ToastUtil.makeText(context, getString(R.string.no_more_data));
                TextUtilsMy.finish(refreshLayout);
            }
        });

        //显示预警
        if (isShowWarm) {
            Button warmBt = findViewById(R.id.warm_list_bt);
            warmBt.setVisibility(View.VISIBLE);
            warmBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,BZ_FMJ_WarmListActivity.class);
                    intent.putExtra("id",id);
                    intent.putExtra("title",title);
                    intent.putExtra("isTypeBZ",isTypeBZ);
                    startActivity(intent);
                }
            });
        }

    }

    private void getData() {
        HashMap<Object, Object> map = new HashMap<>();
        CommonModel<BZ_FMJ_Bean> progressModel = new CommonModelImpl<>();
        String url = HomeUrlConst.URL_BZ_FMJ_POINT_LIST + id;
        progressModel.setContext(context)
                .setEntityType(BZ_FMJ_Bean.class)
                .setUrl(url)
                .setParamMap(map)
                .setEntityListener(new GetEntityListener<BZ_FMJ_Bean>() {
                    @Override
                    public void success(final BZ_FMJ_Bean entity) {
                        TextUtilsMy.finish(refreshLayout);
                        adapter.clear();
                        adapter.addAll(entity.equMpoints);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void fail(final String err) {
                        TextUtilsMy.finish(refreshLayout);
                        ToastUtil.makeText(context, R.string.request_faild_retry);
                    }
                })
                .getEntityNew();
    }
}
