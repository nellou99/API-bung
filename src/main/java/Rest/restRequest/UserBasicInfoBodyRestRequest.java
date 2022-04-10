package Rest.restRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class UserBasicInfoBodyRestRequest {
    private String name;
    private String vorname;
    private int age;
    private String email;
    private String password;
}
