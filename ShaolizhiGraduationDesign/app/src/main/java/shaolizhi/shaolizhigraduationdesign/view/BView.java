package shaolizhi.shaolizhigraduationdesign.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yalantis.phoenix.PullToRefreshView;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.plugin.RecyclerViewNoScrollLayoutManager;
import shaolizhi.shaolizhigraduationdesign.presenter.BPresenter;

/**
 * 邵励治，中国，北京，2017年4月17日创建
 */

public class BView extends Fragment implements BViewInterface {
    View rootView;
    BPresenter bPresenter;
    PullToRefreshView pullToRefreshView;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        rootView = inflater.inflate(R.layout.b_view, viewGroup, false);
        bPresenter = new BPresenter(this);
        bPresenter.loadUserInterface();
        return rootView;
    }

    @Override
    public void loadPullToRefreshView() {
        pullToRefreshView = (PullToRefreshView) rootView.findViewById(R.id.pull_to_refresh);
        pullToRefreshView.setOnRefreshListener(bPresenter);
    }

    @Override
    public void loadRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        RecyclerViewNoScrollLayoutManager noScrollLayoutManager =
                new RecyclerViewNoScrollLayoutManager(getActivity());
        noScrollLayoutManager.setScrollEnabled(true);
        recyclerView.setLayoutManager(noScrollLayoutManager);
        recyclerView.setAdapter(bPresenter);
    }

    @Override
    public void stopRefreshing() {
        pullToRefreshView.postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefreshView.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public Context getFuckingContextFromBView() {
        return context;
    }
}
