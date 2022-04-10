package Rest.restRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class AdresseBasicInfoBodyRestRequest {

    private String strasse;
    private int nummer;
}
