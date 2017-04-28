package shaolizhi.shaolizhigraduationdesign.model;

import shaolizhi.shaolizhigraduationdesign.bean.UserBean;

/**
 * 由邵励治于2017/4/28创造.
 */

public class MainModel implements MainModelInterface{

    @Override
    public UserBean getUserBeanFromServer() {
        UserBean userBean = new UserBean();
        userBean.setLoginStatus(false);
        return userBean;
    }
}
