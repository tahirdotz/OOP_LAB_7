public class User {
    private String username;
    private String emailID;
    private String password;
    private String userID;
    private UserType usertype;


    public User(String username, String emailID, String password, UserType usertype) {
        this.username = username;
        this.emailID = emailID;
        this.password = password;
        this.userID = username;
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", emailID='" + emailID + '\'' +
                ", password='" + password + '\'' +
                ", userID='" + userID + '\'' +
                ", usertype=" + usertype +
                '}';
    }
}
