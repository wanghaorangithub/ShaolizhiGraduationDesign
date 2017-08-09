package shaolizhi.shaolizhigraduationdesign.presenter;

import android.support.v4.widget.SwipeRefreshLayout;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import shaolizhi.shaolizhigraduationdesign.bean.ABean;
import shaolizhi.shaolizhigraduationdesign.model.AModel;
import shaolizhi.shaolizhigraduationdesign.view.AViewInterface;

/**
 * 由邵励治于2017/4/28创造.
 */

public class APresenter implements SwipeRefreshLayout.OnRefreshListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private AViewInterface aView;
    private AModel aModel;

    public APresenter(AViewInterface aView) {
        this.aView = aView;
        aModel = new AModel();
    }

    public void loadUserInterface() {
        ABean aViewData = aModel.getABeanFromServer();
        aView.loadRefreshLayout();
        aView.loadSliderLayout(aViewData.getSliderLayoutData());
    }

    @Override
    public void onRefresh() {
        aView.stopRefreshing();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
