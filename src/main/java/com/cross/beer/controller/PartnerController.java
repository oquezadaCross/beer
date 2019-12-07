package com.cross.beer.controller;

import com.cross.beer.model.Partner;
import com.cross.beer.service.PartnerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cross
 */
@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping()
    public ResponseEntity<Partner> create(@RequestBody Partner partner) {
        partner = partnerService.create(partner);
        return new ResponseEntity<>(partner, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Partner> findById(@PathVariable("id") Long id) {
        Partner partner = new Partner();
        return new ResponseEntity<>(partner, HttpStatus.OK);
    }

    @GetMapping(value = "/{lng}/{lat}")
    public ResponseEntity<List<Partner>> search(@PathVariable("lng") Double lng, @PathVariable("lat") Double lat) {
        return new ResponseEntity<>(partnerService.search(lng, lat), HttpStatus.OK);
    }


}
