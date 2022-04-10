package Rest.restResponse;

import entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserBodyRestResponse extends BasicBodyRestResponse {
    private List<User> userList;

    public UserBodyRestResponse() {
        this.userList = new ArrayList<>();
    }
}
