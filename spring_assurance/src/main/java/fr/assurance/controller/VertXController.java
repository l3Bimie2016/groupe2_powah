package fr.assurance.controller;

import fr.assurance.controller.model.ListVehiculeModel;
import fr.assurance.service.VertXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Max on 09/05/2016.
 */
@RestController
public class VertXController {

    @Autowired
    private VertXService vertx;

    @RequestMapping(path = "/listVehicule",method = RequestMethod.POST)
    public String list(@RequestBody ListVehiculeModel listVehMod) {

        String response = vertx.getListVehicule(listVehMod);

        return response;
    }
}
