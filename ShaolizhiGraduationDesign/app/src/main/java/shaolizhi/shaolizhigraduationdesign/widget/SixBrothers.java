package shaolizhi.shaolizhigraduationdesign.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import shaolizhi.shaolizhigraduationdesign.R;

/**
 * Created by shaol on 2017/4/13.
 */

public class SixBrothers extends LinearLayout {
    public SixBrothers(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.six_brothers, this);
    }
}
