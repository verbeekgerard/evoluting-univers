package eu.luminis.controller;

import eu.luminis.export.IStatisticsExporter;
import eu.luminis.export.StatisticsExporter;
import eu.luminis.ui.Stats;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Statistics", description = "Endpoint for statistics about the planet")
public class StatsController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "Current statistics", notes = "This endpoint returns the current statistics of the planet", response = Stats.class)
    @RequestMapping(method = RequestMethod.GET, value = "/currentStats")
    public Stats getCurrentStats() {
        IStatisticsExporter exportInfo =  StatisticsExporter.getInstance();
        if(exportInfo == null){
            log.error("No ExportInfo instance available. Start the 'world' first!");
            return null;
        }

        return exportInfo.getStats();
    }
}
