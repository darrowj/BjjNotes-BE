package com.jasondarrow.repository;

import com.jasondarrow.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by darrowj on 6/23/17.
 */
@Repository
public interface ProfileRepository extends MongoRepository<Profile,String> {
}
