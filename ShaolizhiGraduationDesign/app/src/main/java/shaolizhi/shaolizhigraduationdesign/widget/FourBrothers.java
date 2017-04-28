package shaolizhi.shaolizhigraduationdesign.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import shaolizhi.shaolizhigraduationdesign.R;

/**
 * Created by shaol on 2017/4/13.
 */

public class FourBrothers extends LinearLayout {
    public FourBrothers(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.four_brothers, this);
    }
}
