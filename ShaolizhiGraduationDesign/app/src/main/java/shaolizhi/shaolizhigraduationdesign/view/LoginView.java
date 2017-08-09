package shaolizhi.shaolizhigraduationdesign.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import shaolizhi.shaolizhigraduationdesign.R;
import shaolizhi.shaolizhigraduationdesign.constant.LoginConstant;
import shaolizhi.shaolizhigraduationdesign.presenter.LoginPresenter;
import shaolizhi.shaolizhigraduationdesign.widget.BaseActivity;

public class LoginView extends BaseActivity implements LoginViewInterface {
    LoginPresenter loginPresenter;
    Button backButton;
    Button commitButton;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.loadUserInterface();
    }

    @Override
    public void initViews() {
        backButton = (Button) findViewById(R.id.back);
        commitButton = (Button) findViewById(R.id.commit);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        backButton.setOnClickListener(loginPresenter);
        backButton.setTag(LoginConstant.BACK_BUTTON);
        commitButton.setOnClickListener(loginPresenter);
        commitButton.setTag(LoginConstant.COMMIT_BUTTON);
    }

    @Override
    public void backToPreviousInterface() {
        finish();
    }

    @Override
    public void openMainView() {
        Intent intent = new Intent(LoginView.this, MainView.class);
        startActivity(intent);
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showLoginFailed() {
        Toast.makeText(getApplicationContext(), "登录失败，请检查您的用户名和密码以及网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }
}
