package shaolizhi.shaolizhigraduationdesign.presenter;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.bean.UserBean;
import shaolizhi.shaolizhigraduationdesign.model.MainModel;
import shaolizhi.shaolizhigraduationdesign.model.MainModelInterface;
import shaolizhi.shaolizhigraduationdesign.view.MainViewInterface;

/**
 * 由邵励治于2017/4/28创造.
 */

public class MainPresenter implements BottomNavigationView.OnNavigationItemSelectedListener {
    private MainViewInterface mainView;
    private MainModelInterface mainModel;

    public MainPresenter(MainViewInterface mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }

    public void loadUserInterface() {
        mainView.initViewABCD();
        mainView.loadBottomNavigationView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mainView.openViewA();
                return true;
            case R.id.navigation_dashboard:
                mainView.openViewB();
                return true;
            case R.id.navigation_notifications:
                mainView.openViewC();
                return true;
            case R.id.navigation_personal_information:
                UserBean userBean = mainModel.getUserBeanFromServer();
                if (!userBean.getLoginStatus())
                    mainView.openViewWelcome();
                else
                    mainView.openViewD();
                return true;
        }
        return false;
    }


}
