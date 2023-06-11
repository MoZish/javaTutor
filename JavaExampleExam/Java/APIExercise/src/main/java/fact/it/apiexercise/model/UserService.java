package fact.it.apiexercise.model;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public UserService() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addUser(User user){
        userList.add(user);
    }
}
