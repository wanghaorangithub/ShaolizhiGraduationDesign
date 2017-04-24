package shaolizhi.shaolizhigraduationdesign.my_fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.my_tools.AlwaysInvisibleAnimation;

/**
 * 邵励治，中国，北京，2017年4月17日创建
 */

public class BFragment extends Fragment {

    Activity activity;
    PullToRefreshView pullToRefreshView;

    final String USER_AVATAR_IMAGE = "user_avatar_image";
    final String USER_NAME_TEXT = "user_name_text";
    final String DATE_TEXT = "date_text";
    final String PRICE_TEXT = "price_text";
    final String DESCRIPTION_TEXT = "description";

    List<Map<String, Integer>> imageList;
    List<Map<String, String>> textList;
    List<Map<String, Integer>> sliderImageList;

    private void modelToView() {
        Map<String, Integer> map_image_list;
        Map<String, String> map_text_list;
        Map<String, Integer> map_slider_list;


        imageList = new ArrayList<>();
        textList = new ArrayList<>();
        sliderImageList = new ArrayList<>();

        /*
         问：imageList负责了什么？
         答：imageList负责了存储一组「用户头像」，「用户头像」用Map<String, Integer>存储，其名字叫做USER_AVATAR_IMAGE
         现在，我要在其中设置一个加载一个头像
         */
        map_image_list = new HashMap<>();
        map_image_list.put(USER_AVATAR_IMAGE, R.drawable.slz_zheng);
        imageList.add(map_image_list);

        /*
         问:textList负责了什么？
         答：textList负责存储map_text_list<String,String>
         （1）一组「用户名」，USER_NAME_TEXT
         （2）一组「日期」，DATE_TEXT
         （3）一组「价格」，PRICE_TEXT
         （4）一组「商品说明」，DESCRIPTION
         现在，我要在其中设置加载这些内容
         */
        map_text_list = new HashMap<>();
        map_text_list.put(USER_NAME_TEXT, "胡迪宇");
        map_text_list.put(DATE_TEXT, "2017年4月21日");
        map_text_list.put(PRICE_TEXT, "999");
        map_text_list.put(DESCRIPTION_TEXT, "布鲁斯口琴，很好用的布鲁斯口琴");
        textList.add(map_text_list);

        /*
         问：sliderImageList负责了什么？
         答：sliderImageList负责存储map_slider_list
         map_slider_list中是一组轮播图
         */
        map_slider_list = new HashMap<>();
        map_slider_list.put("1", R.drawable.kouqin1);
        map_slider_list.put("2", R.drawable.kouqin2);
        map_slider_list.put("3", R.drawable.kouqin3);
        map_slider_list.put("4", R.drawable.kouqin4);
        sliderImageList.add(map_slider_list);

        /*
         问：imageList负责了什么？
         答：imageList负责了存储一组「用户头像」，「用户头像」用Map<String, Integer>存储，其名字叫做USER_AVATAR_IMAGE
         现在，我要在其中设置一个加载一个头像
         */
        map_image_list = new HashMap<>();
        map_image_list.put(USER_AVATAR_IMAGE, R.drawable.slz_zheng);
        imageList.add(map_image_list);

        /*
         问:textList负责了什么？
         答：textList负责存储map_text_list<String,String>
         （1）一组「用户名」，USER_NAME_TEXT
         （2）一组「日期」，DATE_TEXT
         （3）一组「价格」，PRICE_TEXT
         （4）一组「商品说明」，DESCRIPTION
         现在，我要在其中设置加载这些内容
         */
        map_text_list = new HashMap<>();
        map_text_list.put(USER_NAME_TEXT, "胡迪宇");
        map_text_list.put(DATE_TEXT, "2017年4月21日");
        map_text_list.put(PRICE_TEXT, "999");
        map_text_list.put(DESCRIPTION_TEXT, "布鲁斯口琴，很好用的布鲁斯口琴");
        textList.add(map_text_list);

        /*
         问：sliderImageList负责了什么？
         答：sliderImageList负责存储map_slider_list
         map_slider_list中是一组轮播图
         */
        map_slider_list = new HashMap<>();
        map_slider_list.put("1", R.drawable.kouqin1);
        map_slider_list.put("2", R.drawable.kouqin2);
        map_slider_list.put("3", R.drawable.kouqin3);
        map_slider_list.put("4", R.drawable.kouqin4);
        sliderImageList.add(map_slider_list);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<DreamHolder> {

        @Override
        public DreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new DreamHolder(view);
        }

        @Override
        public void onBindViewHolder(DreamHolder holder, int position) {
            Map<String, Integer> image_data = imageList.get(position);
            Map<String, String> text_data = textList.get(position);
            Map<String, Integer> slider_image_data = sliderImageList.get(position);

            holder.bindImage(image_data);
            holder.bindText(text_data);
            holder.bindSliderImage(slider_image_data);
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }
    }

    private class DreamHolder extends android.support.v7.widget.RecyclerView.ViewHolder implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

        private ImageView user_avatar_imageview;
        private TextView user_name_textview;
        private TextView date_textview;
        private TextView price_textview;
        private SliderLayout sliderLayout;
        private TextView description_textview;
        private Button collection_button;

        /**
         * 下面三个是数据接收者
         */
        private Map<String, Integer> map_imageview;
        private Map<String, String> map_textview;
        private Map<String, Integer> map_slider;


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

        void bindImage(Map<String, Integer> data) {
            map_imageview = data;

            user_avatar_imageview.setImageResource(map_imageview.get(USER_AVATAR_IMAGE));
        }

        void bindText(Map<String, String> data) {
            map_textview = data;

            user_name_textview.setText(map_textview.get(USER_NAME_TEXT));
            date_textview.setText(map_textview.get(DATE_TEXT));
            price_textview.setText(map_textview.get(PRICE_TEXT));
            description_textview.setText(map_textview.get(DESCRIPTION_TEXT));
        }

        void bindSliderImage(Map<String, Integer> data) {
            map_slider = data;

            for (String name : map_slider.keySet()) {
            /*
              新建一个TextSliderView类的实例：textSliderView（第三方库），并将本Activity作为Context传入
             */
                TextSliderView textSliderView = new TextSliderView(activity);
                // initialize a SliderLayout
            /*
              按照其官方注释的意思，下面开始正式的初始化SliderLayout了
              我们给textSliderView设置了四个变量
              先给其设置了名字：也就是name
              之后又给其设置了图片：通过name作为key在file_maps中取出的Value
              然后有设置了ScaleType（翻译：缩放类型），这是一个BaseSliderView实现的类型，为FIT
              最后设置了当用户点击时的事件监听器
             */
                textSliderView
                        .description(name)
                        .image(map_slider.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit)
                        .setOnSliderClickListener(this);

            /*
              这里添加了一些额外信息，先不去管它
             */
                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra", name);

            /*
              最后将TextSliderView初始化好的实例使用addSlider添加到SliderLayout中
             */
                sliderLayout.addSlider(textSliderView);
            }
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new AlwaysInvisibleAnimation());
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

    private class NoScrollLayoutManager extends LinearLayoutManager {
        private boolean isScrollEnabled = true;

        NoScrollLayoutManager(Context context) {
            super(context);
        }

        void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollVertically() {
            //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
            return isScrollEnabled;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.b_fragment, viewGroup, false);

        pullToRefreshView = (PullToRefreshView) rootView.findViewById(R.id.pull_to_refresh);
        pullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullToRefreshView.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        NoScrollLayoutManager noScrollLayoutManager = new NoScrollLayoutManager(getActivity());
        noScrollLayoutManager.setScrollEnabled(true);
        recyclerView.setLayoutManager(noScrollLayoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter());
        modelToView();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

}
