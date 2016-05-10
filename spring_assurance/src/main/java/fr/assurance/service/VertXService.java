package fr.assurance.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.assurance.bean.ApplicationData;
import fr.assurance.controller.model.ListVehiculeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Max on 10/05/2016.
 */
@Service
public class VertXService {

    @Autowired
    private ApplicationData appData;

    private String uri = "http://localhost:8090";
    private String jsonNoSuccess = "{\"success\":false}";

    public String getListVehicule(ListVehiculeModel listVehMod){

        String response = jsonNoSuccess;

        JsonObject json = new JsonParser().parse(appData.getToken()).getAsJsonObject();
        if(json.get("success").getAsBoolean()) {
            HttpHeaders header = new HttpHeaders();
            String token = json.get("token").getAsString();
            header.set("Authorization", "Bearer " + token);
            header.setContentType(MediaType.APPLICATION_JSON);

            String request = new Gson().toJson(listVehMod);
            HttpEntity<String> entity = new HttpEntity(request, header);
            RestTemplate restTemplate = new RestTemplate();

            try {
                response = restTemplate.postForObject(uri + "/private/list", entity, String.class);
            } catch (Exception e) { }
        }
        return response;
    }

    public boolean authenticate(String username, String password){

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> data = new HashMap<String, String>();
        data.put("username", username);
        data.put("password", password);

        String request = new Gson().toJson(data);

        HttpEntity<String> entity = new HttpEntity(request, header);

        RestTemplate restTemplate = new RestTemplate();

        String response = jsonNoSuccess;
        try{
            response = restTemplate.postForObject(uri+"/login", entity, String.class);
        }catch(Exception e){ }
        appData.setToken(response);

        return new JsonParser().parse(response).getAsJsonObject().get("success").getAsBoolean();
    }

}
