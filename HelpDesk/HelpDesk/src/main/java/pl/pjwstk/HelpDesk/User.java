package pl.pjwstk.HelpDesk;

public class User {

    private String userId;

    User(String userId){
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
