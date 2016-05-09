package fr.assurance.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.assurance.bean.ApplicationData;
import fr.assurance.controller.model.ListVehiculeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(path = "/listVehicule",method = RequestMethod.POST)
    public String list(@RequestBody ListVehiculeModel listVehMod) {

        String uri = "http://localhost:8090/private/list";

        HttpHeaders header = new HttpHeaders();
        String token = new JsonParser().parse(appData.getToken()).getAsJsonObject().get("token").getAsString();
        System.out.println("-- token : "+token);
        header.set("Authorization", "Bearer "+token);
        header.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("action", listVehMod.getAction());
        data.put("marque", listVehMod.getMarque());
        data.put("modele", listVehMod.getModele());
        data.put("chevaux", listVehMod.getChevaux());

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
        return response;
    }
}
