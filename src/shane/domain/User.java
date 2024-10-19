package shane.domain;

public class User {
    private String account;
    private String password;


    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    /**
     * 获取
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{account = " + account + ", password = " + password + "}";
    }
}
