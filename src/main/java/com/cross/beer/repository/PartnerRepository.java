package com.cross.beer.repository;

import com.cross.beer.model.Partner;
import com.mongodb.client.model.geojson.Point;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author cross
 */
public interface PartnerRepository extends MongoRepository<Partner, String> {

    @Query("{coverageArea:{ '$geoIntersects' : { '$geometry' : ?0}},$geoNear:?0}")
    List<Partner> searchInPolygons(Point point);

}
