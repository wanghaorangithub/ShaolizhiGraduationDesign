package shaolizhi.shaolizhigraduationdesign.plugin;

import android.view.View;

import com.daimajia.slider.library.Animations.BaseAnimationInterface;

/**
 * Created by 邵励治 on 2017/4/11.
 * 这是让轮播控件底下的提示信息永远不出来的类
 */

public class SliderLayout_AlwaysInvisibleAnimation implements BaseAnimationInterface {
    @Override
    public void onPrepareCurrentItemLeaveScreen(View current) {
        View descriptionLayout = current.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            current.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPrepareNextItemShowInScreen(View next) {
        View descriptionLayout = next.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            next.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onCurrentItemDisappear(View view) {

    }

    @Override
    public void onNextItemAppear(View view) {
        View descriptionLayout = view.findViewById(com.daimajia.slider.library.R.id.description_layout);
        if(descriptionLayout!=null){
            view.findViewById(com.daimajia.slider.library.R.id.description_layout).setVisibility(View.INVISIBLE);
        }
    }
}
