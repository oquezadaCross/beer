package com.cross.beer.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author cross
 */
@Data
@Document(collection = "partners")
public class Partner {

    @Id
    public ObjectId _id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;

    @Indexed
    private Address address;

}
