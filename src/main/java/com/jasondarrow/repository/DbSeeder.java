package com.jasondarrow.repository;

import com.jasondarrow.model.Lookups;
import com.jasondarrow.model.Note;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by darrowj on 6/23/17.
 */
@Component
public class DbSeeder implements CommandLineRunner {
   private NoteRepository noteRepository;

    public DbSeeder(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        //Note one = new Note("First", "First Note", "THis is my first note");
        //Note two = new Note("Second", "Second Note", "This is my second note");
        //this.noteRepository.deleteAll();


        //this.noteRepository.save(notes);
    }


}
