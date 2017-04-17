package shaolizhi.shaolizhigraduationdesign.my_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import shaolizhi.shaolizhigraduationdesign.R;

/**
 * Created by shaol on 2017/4/13.
 */

public class TopMenu extends LinearLayout {
    Button erweima;
    Button search;
    TextView textView;

    public TopMenu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_menu, this);
    }
}
