package shaolizhi.shaolizhigraduationdesign.plugin;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * 由邵励治于2017/4/29创造.
 */

public class RecyclerViewNoScrollLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public RecyclerViewNoScrollLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled;
    }
}
