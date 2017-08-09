package shaolizhi.shaolizhigraduationdesign.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 由邵励治于2017/5/9创造.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //向活动管理器中添加此活动
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //从活动管理器中移除此活动
        ActivityCollector.removeActivity(this);
    }
}
