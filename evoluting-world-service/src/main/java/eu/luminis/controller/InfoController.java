package eu.luminis.controller;

import eu.luminis.entities.Animal;
import eu.luminis.export.ExportInfo;
import eu.luminis.export.ExportInfoImpl;
import eu.luminis.ui.Stats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gerardverbeek on 25/08/16.
 */
@RestController
public class InfoController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET, value = "/currentStats")
    public Stats getStats(){
        ExportInfo exportInfo =  ExportInfoImpl.getInstance();
        if(exportInfo == null){
            log.error("No ExportInfo instance available. Start the 'world' first!");
            return null;
        }
        return exportInfo.getStats();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getPopulation")
    public List<Animal> getPopulation(){
        ExportInfo exportInfo =  ExportInfoImpl.getInstance();
        if(exportInfo == null){
            log.error("No ExportInfo instance available. Start the 'world' first!");
            return null;
        }
        return null; //exportInfo.getAnimals();
    }

}
