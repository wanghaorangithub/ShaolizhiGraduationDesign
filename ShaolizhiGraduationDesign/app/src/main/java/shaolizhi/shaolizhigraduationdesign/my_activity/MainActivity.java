package shaolizhi.shaolizhigraduationdesign.my_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.my_fragment.AFragment;
import shaolizhi.shaolizhigraduationdesign.my_fragment.BFragment;
import shaolizhi.shaolizhigraduationdesign.my_fragment.CFragment;
import shaolizhi.shaolizhigraduationdesign.my_fragment.DFragment;
import shaolizhi.shaolizhigraduationdesign.my_tools.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    AFragment aFragment;
    BFragment bFragment;
    CFragment cFragment;
    DFragment dFragment;
    Boolean isLogin;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchToA();
                    return true;
                case R.id.navigation_dashboard:
                    switchToB();
                    return true;
                case R.id.navigation_notifications:
                    switchToC();
                    return true;
                case R.id.navigation_personal_information:
                    if (!isLogin)
                        switchToWelcome();
                    else
                        switchToD();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        aFragment = new AFragment();
        bFragment = new BFragment();
        cFragment = new CFragment();
        dFragment = new DFragment();
        fragmentManager = getSupportFragmentManager();
        isLogin = false;
        initializeFragment();
    }

    void initializeFragment() {
        switchToA();
    }

    void switchToA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, aFragment);
        fragmentTransaction.commit();
    }

    void switchToB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, bFragment);
        fragmentTransaction.commit();
    }

    void switchToC() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, cFragment);
        fragmentTransaction.commit();
    }

    void switchToD() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, dFragment);
        fragmentTransaction.commit();
    }

    void switchToWelcome() {
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }

}
