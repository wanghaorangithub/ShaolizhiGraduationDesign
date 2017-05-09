package shaolizhi.shaolizhigraduationdesign.presenter;

import android.view.View;

import shaolizhi.shaolizhigraduationdesign.constant.WelcomeConstant;
import shaolizhi.shaolizhigraduationdesign.view.WelcomeViewInterface;

/**
 * 由邵励治于2017/5/9创造.
 */

public class WelcomePresenter implements View.OnClickListener {
    private WelcomeViewInterface welcomeView;


    public WelcomePresenter(WelcomeViewInterface welcomeViewInterface) {
        this.welcomeView = welcomeViewInterface;
    }

    public void loadUserInterface(){
        welcomeView.loadButtonLogin();
        welcomeView.loadButtonRegister();
    }

    @Override
    public void onClick(View v) {
        int tag = (Integer) v.getTag();
        switch (tag){
            case WelcomeConstant.LOGIN_BUTTON:
                welcomeView.openViewLogin();
                break;
            case WelcomeConstant.REGISTER_BUTTON:
                welcomeView.openViewRegister();
                break;
        }
    }

}
