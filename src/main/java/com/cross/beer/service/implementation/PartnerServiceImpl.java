package com.cross.beer.service.implementation;

import com.cross.beer.model.Partner;
import com.cross.beer.repository.PartnerRepository;
import com.cross.beer.service.PartnerService;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cross
 */
@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Partner create(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner findById(Partner partner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Partner> search(double lon, double lat) {
        Position position = new Position(lon, lat);
        Point ref = new Point(position);
        return partnerRepository.searchInPolygons(ref);
    }

}
