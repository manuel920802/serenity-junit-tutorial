package serenityswag.authentication;

public enum User {
    STANDARD_USER("standard_user","secret_sauce","a standard user"),
    LOCKED_OUT_USER("locked_out_user","secret_sauce","a user locked out of their account"),
    PROBLEM_USER("problem_user","secret_sauce","a problem_user user"),
    PERFOMANCE_GLITCH_USER("performance_glitch_user","secret_sauce","a performance_glitch_user user");
    private final String username;
    private final String password;
    private final String description;
    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return description;
    }
}
