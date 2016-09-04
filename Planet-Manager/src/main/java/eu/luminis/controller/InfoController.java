package eu.luminis.controller;

import eu.luminis.domain.Planet;
import eu.luminis.service.PlanetDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gerardverbeek on 02/09/16.
 */
@RestController
public class InfoController {

    @Autowired
    PlanetDiscoveryService planetDiscoveryService;

    @RequestMapping(method = RequestMethod.GET, value = "/getPlanets")
    public List<Planet> getPlanets(){
        return planetDiscoveryService.getDiscoverdPlanets();
    }
}
