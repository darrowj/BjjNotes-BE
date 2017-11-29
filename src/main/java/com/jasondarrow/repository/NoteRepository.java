package com.jasondarrow.repository;

import com.jasondarrow.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by darrowj on 6/23/17.
 */
@Repository
public interface NoteRepository extends MongoRepository<Note,String> {

    public List<Note> findByUid(String uid);
}
