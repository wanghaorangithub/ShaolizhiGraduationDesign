package shaolizhi.shaolizhigraduationdesign.bean;

/**
 * 由邵励治于2017/4/28创造.
 */

public class UserBean {
    private Boolean isLogin;

    private String username;

    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getLoginStatus() {
        return isLogin;
    }

    public void setLoginStatus(Boolean login) {
        isLogin = login;
    }


}
