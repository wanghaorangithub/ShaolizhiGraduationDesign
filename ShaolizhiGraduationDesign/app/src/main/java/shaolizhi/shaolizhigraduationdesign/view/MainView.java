package shaolizhi.shaolizhigraduationdesign.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.plugin.BottomNavigationViewHelper;
import shaolizhi.shaolizhigraduationdesign.presenter.MainPresenter;

public class MainView extends AppCompatActivity implements MainViewInterface {
    FragmentManager fragmentManager;
    AView aView;
    BView bView;
    CView cView;
    DView dView;

    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        mainPresenter = new MainPresenter(this);
        mainPresenter.loadUserInterface();
    }

    @Override
    public void initViewABCD() {
        aView = new AView();
        bView = new BView();
        cView = new CView();
        dView = new DView();
        fragmentManager = getSupportFragmentManager();
        openViewA();
    }

    @Override
    public void openViewA() {
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, aView);
        fragmentTransaction.commit();
    }

    @Override
    public void openViewB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, bView);
        fragmentTransaction.commit();
    }

    @Override
    public void openViewC() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, cView);
        fragmentTransaction.commit();
    }

    @Override
    public void openViewD() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, dView);
        fragmentTransaction.commit();
    }

    @Override
    public void openViewWelcome() {
        Intent intent = new Intent(MainView.this, WelcomeView.class);
        startActivity(intent);
    }

    @Override
    public void loadBottomNavigationView() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mainPresenter);
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }
}
