package com.cross.beer.service;

import com.cross.beer.model.Partner;
import java.util.List;

/**
 *
 * @author cross
 */
public interface PartnerService {

    public Partner create(Partner partner);

    public Partner findById(Partner partner);

    public List<Partner> search(double lon, double lat);

}
