package shaolizhi.shaolizhigraduationdesign.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.plugin.AlwaysInvisibleAnimation;
import shaolizhi.shaolizhigraduationdesign.presenter.APresenter;

/**
 * 由邵励治于2017/4/7创造.
 */

public class AView extends Fragment implements AViewInterface {
    SwipeRefreshLayout swipeRefreshLayout;
    APresenter aPresenter;
    Context context;
    SliderLayout sliderLayout;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        rootView = inflater.inflate(R.layout.a_fragment, viewGroup, false);

        aPresenter = new APresenter(this);
        aPresenter.loadUserInterface();

        return rootView;
    }

    @Override
    public void loadRefreshLayout() {
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(aPresenter);
    }

    @Override
    public void stopRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadSliderLayout(HashMap<String, Integer> hashMap) {
        sliderLayout = (SliderLayout) rootView.findViewById(R.id.slider);

        for (String name : hashMap.keySet()) {

            TextSliderView textSliderView = new TextSliderView(context);
            textSliderView
                    .description(name)
                    .image(hashMap.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(aPresenter);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new AlwaysInvisibleAnimation());
        sliderLayout.setDuration(2);
        sliderLayout.addOnPageChangeListener(aPresenter);
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


}
