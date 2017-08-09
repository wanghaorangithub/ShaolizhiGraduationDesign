package shaolizhi.shaolizhigraduationdesign.widget;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 由邵励治于2017/5/9创造.
 */

class ActivityCollector {

    //List用来暂存活动
    private static List<Activity> activities = new ArrayList<>();

    //addActivity用来向List里添加一个活动
    static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //removeActivity用来从List中移除一个活动
    static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    //finishAll方法用于将List中存储的活动全部销毁掉
    public static void finishAll() {
        for (Activity activity : activities) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
