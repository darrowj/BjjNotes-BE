package com.jasondarrow.repository;

import com.jasondarrow.model.Lookup;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by darrowj on 7/1/17.
 */
public interface LookupsRepository extends MongoRepository<Lookup,String> {

    public Lookup findByTitle(String Guard);
}