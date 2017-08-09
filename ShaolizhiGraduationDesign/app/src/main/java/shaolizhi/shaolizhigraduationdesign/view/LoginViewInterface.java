package shaolizhi.shaolizhigraduationdesign.view;

/**
 * 由邵励治于2017/5/9创造.
 */

public interface LoginViewInterface {
    void initViews();
    void backToPreviousInterface();
    void openMainView();
    void showLoginSuccess();
    void showLoginFailed();
    String getUsername();
    String getPassword();
}
