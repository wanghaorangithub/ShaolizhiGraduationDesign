package shaolizhi.shaolizhigraduationdesign.my_fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.my_tools.AlwaysInvisibleAnimation;

/**
 * Created by shaol on 2017/4/7.
 *
 */

public class AFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    SwipeRefreshLayout swipeRefreshLayout;
    Activity activity;
    /**
     * SliderLayout:第三方库实现
     * 第一步：创建SliderLayout实例mDemoSlider
     */
    private SliderLayout sliderLayout;


    static final int NETWORK_REQUEST = 0x00000001;
    //用于做网络请求
    Handler handler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case NETWORK_REQUEST:

                    swipeRefreshLayout.setRefreshing(false);
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.a_fragment, viewGroup, false);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        sliderLayout = (SliderLayout) rootView.findViewById(R.id.slider);
        /**
         * 新建HashMap的实例url_maps，用于存放需要在轮播组件上展示的四张图片的「名字-URL」键值对
         * URL是直接能加载出来的图片
         */
//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        /**
         * 新建HashMap的实例file_maps，用于存放需要在轮播组件上展示的四张图片的「名字-本地R资源」键值对
         * 我认为file_maps与上文所述的url_maps遥相呼应，对应着本地资源与网络资源，是两种不同的加载方式
         */
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1",R.drawable.main_1);
        file_maps.put("2",R.drawable.main_2);
        file_maps.put("3",R.drawable.main_3);
        file_maps.put("4", R.drawable.main_4);
        /**
         * 设立循环，将file_maps的key值取出来存在String name中，也就是说把"Big Bang Theory"这类的名称
         * 存储在name中。
         */
        for (String name : file_maps.keySet()) {
            /**
             * 新建一个TextSliderView类的实例：textSliderView（第三方库），并将本Activity作为Context传入
             */
            TextSliderView textSliderView = new TextSliderView(activity);
            // initialize a SliderLayout
            /**
             * 按照其官方注释的意思，下面开始正式的初始化SliderLayout了
             * 我们给textSliderView设置了四个变量
             * 先给其设置了名字：也就是name
             * 之后又给其设置了图片：通过name作为key在file_maps中取出的Value
             * 然后有设置了ScaleType（翻译：缩放类型），这是一个BaseSliderView实现的类型，为FIT
             * 最后设置了当用户点击时的事件监听器
             */
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            /**
             * 这里添加了一些额外信息，先不去管它
             */
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            /**
             * 最后将TextSliderView初始化好的实例使用addSlider添加到SliderLayout中
             */
            sliderLayout.addSlider(textSliderView);
        }
        /**
         * 正如Demo中所展现的，本Demo最大的工作量都在这个函数中，AndroidImageSlider提供了大量轮播动画
         * 效果，有：
         * Default、Accordion、Bacground2Foreground、Cubeln、DepthPage、Fade、FlipHorizontal、FlipPage、
         * Foreground2Background、RotateDown、RotateUp、Stack、Tablet、Zoomln、ZoomOutSlide、ZoomOut
         *
         * 而我们这里用的是Accordion这个效果——它把四个图片作为立方体的四个面——百闻不如一见，
         * 感觉我是描述不清了，您还不如自己下一个运行一下。
         */
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        /**
         * 这是设置轮播组件中那四个小圆点位置的函数目前是Center_Bottom，我改成其他的运行一下试一试
         * 比如Center_Top，果然，小圆点儿跑上面儿去了
         */
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        /**
         * 这是给提示信息一个现实动画的，可以再用户界面调节开或者关，但从我的美学直觉来看，我希望是关掉的好
         */
        sliderLayout.setCustomAnimation(new AlwaysInvisibleAnimation());
        /**
         * 设置持续时间，我猜测这是自动翻片儿的动画效果，YES，我猜对了，设置2就是2秒翻一次片儿
         */
        sliderLayout.setDuration(2);
        /**
         * 添加一个PageChangeListener，页面切换监听器
         */
        sliderLayout.addOnPageChangeListener(this);

        swipeRefreshLayout.setOnRefreshListener(this);
        return rootView;
    }

    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public void onRefresh() {
        /**
         * 网络请求部分用1.5秒延迟模拟，最后也是用Handler把数据发出去
         */
        handler.sendEmptyMessageDelayed(NETWORK_REQUEST, 1500);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(activity, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();

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
