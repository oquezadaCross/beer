package com.cross.beer.repository;

import com.cross.beer.model.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cross
 */
public interface PartnerRepository extends MongoRepository<Partner, String> {

}
