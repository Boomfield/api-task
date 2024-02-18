package jsonplaceholder.models;

public class UserData {
    private int userId;
    private int id;
    private String title;
    private String body;

    public UserData(Integer userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public UserData() {
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
