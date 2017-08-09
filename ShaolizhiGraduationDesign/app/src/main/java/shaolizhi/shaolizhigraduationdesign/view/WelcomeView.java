package shaolizhi.shaolizhigraduationdesign.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.constant.WelcomeConstant;
import shaolizhi.shaolizhigraduationdesign.presenter.WelcomePresenter;
import shaolizhi.shaolizhigraduationdesign.widget.BaseActivity;

public class WelcomeView extends BaseActivity implements WelcomeViewInterface {

    WelcomePresenter welcomePresenter;
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_view);
        welcomePresenter = new WelcomePresenter(this);
        welcomePresenter.loadUserInterface();
    }

    @Override
    public void initViews() {
        loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(welcomePresenter);
        loginButton.setTag(WelcomeConstant.LOGIN_BUTTON);
        registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(welcomePresenter);
        registerButton.setTag(WelcomeConstant.REGISTER_BUTTON);
    }

    @Override
    public void openViewLogin() {
        Intent intent = new Intent(WelcomeView.this, LoginView.class);
        startActivity(intent);
    }

    @Override
    public void openViewRegister() {

    }
}
