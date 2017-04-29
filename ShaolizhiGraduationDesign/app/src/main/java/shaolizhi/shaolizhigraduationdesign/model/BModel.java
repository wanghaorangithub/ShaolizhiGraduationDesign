package shaolizhi.shaolizhigraduationdesign.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.bean.BBean;

/**
 * 由邵励治于2017/4/29创造.
 */

public class BModel implements BModelInterface {

    @Override
    public List<BBean> getBBeanListFromServer() {
        List<BBean> list = new ArrayList<>();
        BBean bBean = new BBean();
        bBean.setUserAvatar(R.drawable.slz_zheng);
        bBean.setUserName("邵励治");
        bBean.setDate("2017年4月21日");
        bBean.setPrice("998");
        bBean.setDescription("布鲁斯口琴，很好用的布鲁斯口琴");

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", R.drawable.kouqin1);
        hashMap.put("2", R.drawable.kouqin2);
        hashMap.put("3", R.drawable.kouqin3);
        hashMap.put("4", R.drawable.kouqin4);
        bBean.setSliderLayoutImage(hashMap);
        list.add(bBean);
        list.add(bBean);
        return list;
    }
}
