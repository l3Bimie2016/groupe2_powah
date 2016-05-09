package fr.assurance.controller;

import com.google.gson.Gson;
import fr.assurance.bean.ApplicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Max on 09/05/2016.
 */
@RestController
public class VertXController {

    @Autowired
    private ApplicationData appData;

    @RequestMapping(path = "/listVehicule",method = RequestMethod.GET)
    public String list() {

        String uri = "http://localhost:8090/private/list";

        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer "+appData.getToken());
        header.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("action", "modele");
        data.put("marque", 1);
        data.put("modele", 0);
        data.put("chevaux", 0);

        String request = new Gson().toJson(data);
        HttpEntity<String> entity = new HttpEntity<>(request, header);
        RestTemplate restTemplate = new RestTemplate();
        String response = "";
        try{
            response = restTemplate.postForObject(uri, entity, String.class);
        }catch(Exception e){
            response = "Pas autorisé.";
        }


        System.out.println("-- "+response);
        System.out.println("-- "+appData.getToken());
        return response;
    }
}
