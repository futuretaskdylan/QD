package com.haocang.patrol.manage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.haocang.base.adapter.BaseAdapter;
import com.haocang.base.ui.BaseActivity;
import com.haocang.base.utils.ToastUtil;
import com.haocang.patrol.R;
import com.haocang.patrol.manage.bean.PatrolTaskListDTO;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//设备下的测点列表
public class TaskListActivity extends BaseActivity {

    private int id;
    private Intent i;
    private TaskListActivity context;
    private PullToRefreshLayout refreshLayout;
    private TaskListAdapter adapter;
    private RecyclerView rv;
    private String title;

    @Override
    protected void doOnCreate() {
        setContentView(R.layout.activity_task_list);
        context = this;
        i = getIntent();
        id = i.getIntExtra("id", 0);
        title = i.getStringExtra("title");
        initView();
        getData();
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_common_tv)).setText("巡检任务列表");
        rv = findViewById(R.id.recyclerview);
        adapter = new TaskListAdapter(R.layout.item_task_list, 0);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(adapter);
        refreshLayout = findViewById(R.id.pulltorefreshlayout);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                ToastUtil.makeText(context, "刷新成功");
                refreshLayout.finishRefresh();
                getData();
            }

            @Override
            public void loadMore() {
                ToastUtil.makeText(context, "已经到底了哦");
                refreshLayout.finishLoadMore();
            }
        });

        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position, Object i) {
                PatrolTaskListDTO item=(PatrolTaskListDTO)i;
                Intent intent = new Intent(context, TaskPointListActivity.class);
                intent.putExtra("id", item.getExecutorId());
                intent.putExtra("name", item.getExecutorName());
                intent.putExtra("taskName", item.getName());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position, Object item) {

            }
        });
    }

    private void getData() {
        adapter.clear();
        List<PatrolTaskListDTO> list = new ArrayList<>();
        list.add(new PatrolTaskListDTO("2020-11-20日度巡检", 10905437, "李军"));
        list.add(new PatrolTaskListDTO("2020-11-21日度巡检", 10905438,
                "张子涛"));
        adapter.addAll(list);
        adapter.notifyDataSetChanged();

     /*   HashMap<Object, Object> map = new HashMap<>();
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

                    }

                    @Override
                    public void fail(final String err) {
                        TextUtilsMy.finish(refreshLayout);
                        ToastUtil.makeText(context, R.string.request_faild_retry);
                    }
                })
                .getEntityNew();*/
    }
}
