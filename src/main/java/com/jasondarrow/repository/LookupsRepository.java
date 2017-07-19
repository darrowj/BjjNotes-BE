package com.jasondarrow.repository;

import com.jasondarrow.model.Lookups;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by darrowj on 7/1/17.
 */
public interface LookupsRepository extends MongoRepository<Lookups,String> {}