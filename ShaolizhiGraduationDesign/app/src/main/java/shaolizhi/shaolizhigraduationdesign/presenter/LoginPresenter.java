package shaolizhi.shaolizhigraduationdesign.presenter;

import android.view.View;

import shaolizhi.shaolizhigraduationdesign.constant.LoginConstant;
import shaolizhi.shaolizhigraduationdesign.view.LoginViewInterface;

/**
 * 由邵励治于2017/5/9创造.
 */

public class LoginPresenter implements View.OnClickListener {
    private LoginViewInterface loginView;

    public LoginPresenter(LoginViewInterface loginView) {
        this.loginView = loginView;
    }

    public void loadUserInterface(){
        loginView.initViews();
    }

    @Override
    public void onClick(View v) {
        int tag = (Integer) v.getTag();
        switch (tag) {
            case LoginConstant.BACK_BUTTON:
                loginView.backToPreviousInterface();
                break;
            case LoginConstant.COMMIT_BUTTON:

                break;
        }
    }
}
