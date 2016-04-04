package fr.assurance;

/*import fr.model.Board;
import fr.model.VertxQuery;
import fr.model.VertxResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
*/
/**
 * Created by Nico on 03/03/2016.
 */
//@RestController
public class VertxController {

    /*@RequestMapping(path = "/controller/vertx/query")
    public VertxResponse<String> getWithMessage(String q){
        VertxQuery<Board> query = new VertxQuery<>();
        query.setMessage("Hello from spring");
        query.setEntity(new Board(1,2));

        RestTemplate restTemplate = new RestTemplate();
        VertxResponse<String> response =
                restTemplate.postForObject("http://localhost:8090/public/query",
                        query,VertxResponse.class);

        return response;
    }*/

}
