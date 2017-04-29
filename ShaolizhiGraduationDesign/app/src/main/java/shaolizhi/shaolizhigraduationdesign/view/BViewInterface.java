package shaolizhi.shaolizhigraduationdesign.view;

import android.content.Context;

/**
 * 由邵励治于2017/4/29创造.
 */

public interface BViewInterface {
    void loadPullToRefreshView();

    void stopRefreshing();

    void loadRecyclerView();

    Context getFuckingContextFromBView();
}
