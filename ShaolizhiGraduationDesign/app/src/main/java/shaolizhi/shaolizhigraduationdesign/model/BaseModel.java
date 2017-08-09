package shaolizhi.shaolizhigraduationdesign.model;

import android.content.Context;
import android.content.SharedPreferences;

import shaolizhi.shaolizhigraduationdesign.bean.UserBean;

/**
 * 由邵励治于2017/5/10创造.
 */

class BaseModel {

    public UserBean getUserBeanFromCache(Context context) {
        UserBean userBean = new UserBean();
        SharedPreferences preferences = context.getSharedPreferences("UserBean", Context.MODE_PRIVATE);
        String username = preferences.getString("username","");
        String password = preferences.getString("password","");
        Boolean loginStatus = preferences.getBoolean("loginStatus", true);
        userBean.setUsername(username);
        userBean.setPassword(password);
        userBean.setLoginStatus(loginStatus);
        return userBean;
    }

    public void setUserBeanToCache(UserBean bean, Context context) {

        String username = bean.getUsername();
        String password = bean.getPassword();
        Boolean loginStatus = bean.getLoginStatus();

        SharedPreferences preferences = context.getSharedPreferences("UserBean", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (username!=null){
            editor.putString("username",username);
        }
        if (password!=null){
            editor.putString("password",password);
        }
        if (loginStatus!=null){
            editor.putBoolean("loginStatus",loginStatus);
        }
        editor.apply();
    }
}
