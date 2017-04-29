package shaolizhi.shaolizhigraduationdesign.model;

import java.util.HashMap;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.bean.ABean;

/**
 * 由邵励治于2017/4/28创造.
 */

public class AModel implements AModelInterface {
    @Override
    public ABean getABeanFromServer() {
        ABean aBean = new ABean();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", R.drawable.main_1);
        hashMap.put("2", R.drawable.main_2);
        hashMap.put("3", R.drawable.main_3);
        hashMap.put("4", R.drawable.main_4);
        aBean.setSliderLayoutData(hashMap);
        return aBean;
    }
}
