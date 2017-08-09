package shaolizhi.shaolizhigraduationdesign.presenter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.List;
import java.util.Map;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.bean.BBean;
import shaolizhi.shaolizhigraduationdesign.model.BModel;
import shaolizhi.shaolizhigraduationdesign.plugin.SliderLayout_AlwaysInvisibleAnimation;
import shaolizhi.shaolizhigraduationdesign.view.BViewInterface;

/**
 * 由邵励治于2017/4/29创造.
 */

public class BPresenter extends RecyclerView.Adapter<BPresenter.DreamHolder> implements PullToRefreshView.OnRefreshListener {

    private BViewInterface bView;

    private BModel bModel;

    private List<BBean> dataForRecycler;

    public BPresenter(BViewInterface bView) {
        this.bView = bView;
        bModel = new BModel();
        dataForRecycler = bModel.getBBeanListFromServer();
    }

    public void loadUserInterface() {
        bView.loadPullToRefreshView();
        bView.loadRecyclerView();
    }

    @Override
    public void onRefresh() {
        dataForRecycler = bModel.getBBeanListFromServer();
        bView.stopRefreshing();
    }

    @Override
    public DreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new DreamHolder(view);
    }

    @Override
    public void onBindViewHolder(DreamHolder holder, int position) {
        holder.bindDataToItem(dataForRecycler.get(position));
    }

    @Override
    public int getItemCount() {
        return dataForRecycler.size();
    }

    class DreamHolder extends android.support.v7.widget.RecyclerView.ViewHolder
            implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

        private ImageView user_avatar_imageview;
        private TextView user_name_textview;
        private TextView date_textview;
        private TextView price_textview;
        private SliderLayout sliderLayout;
        private TextView description_textview;
        private Button collection_button;

        DreamHolder(View itemView) {
            super(itemView);
            user_avatar_imageview = (ImageView) itemView.findViewById(R.id.user_avatar_imageview);
            user_name_textview = (TextView) itemView.findViewById(R.id.user_name_textview);
            date_textview = (TextView) itemView.findViewById(R.id.date_textview);
            price_textview = (TextView) itemView.findViewById(R.id.price_textview);
            sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider_item);
            description_textview = (TextView) itemView.findViewById(R.id.description_textview);
            collection_button = (Button) itemView.findViewById(R.id.collection_button);
        }

        void bindDataToItem(BBean bBean) {
            user_avatar_imageview.setImageResource(bBean.getUserAvatar());
            user_name_textview.setText(bBean.getUserName());
            date_textview.setText(bBean.getDate());
            price_textview.setText(bBean.getPrice());
            description_textview.setText(bBean.getDescription());

            Map<String, Integer> map = bBean.getSliderLayoutImage();
            for (String name : map.keySet()) {
                TextSliderView textSliderView = new TextSliderView(bView.getFuckingContextFromBView());
                textSliderView
                        .description(name)
                        .image(map.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra", name);

                sliderLayout.addSlider(textSliderView);
            }
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new SliderLayout_AlwaysInvisibleAnimation());
            sliderLayout.setDuration(2000);
            sliderLayout.addOnPageChangeListener(this);
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

}
