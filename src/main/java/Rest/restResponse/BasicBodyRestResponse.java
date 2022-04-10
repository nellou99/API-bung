package Rest.restResponse;

import java.util.ArrayList;
import java.util.List;

public class BasicBodyRestResponse {
    private List<String> errorMessagesList = new ArrayList<>();

    public void addErrorMessage(String message) {
        errorMessagesList.add(message);
    }
}
