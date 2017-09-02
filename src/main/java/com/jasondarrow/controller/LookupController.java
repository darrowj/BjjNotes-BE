package com.jasondarrow.controller;


import com.jasondarrow.model.Lookup;
import com.jasondarrow.repository.LookupsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "LookupControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class LookupController {

    private LookupsRepository lookupsRepository;

    public LookupController(LookupsRepository lookupsRepository) {
        this.lookupsRepository = lookupsRepository;
    }

    @RequestMapping(value = "Lookups", method = RequestMethod.GET)
    public List<Lookup> getAll() {
        List<Lookup> lookups = this.lookupsRepository.findAll();
        return lookups;
    }

    @RequestMapping(value = "Lookup/{title}", method = RequestMethod.GET)
    @ApiOperation("Gets the lookup with specific title")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Lookup.class)})
    public Lookup get(@PathVariable String title) {
        return this.lookupsRepository.findByTitle(title);
    }


}
