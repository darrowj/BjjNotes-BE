package com.jasondarrow.repository;

import com.jasondarrow.model.Note;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        List<Note> notes = new ArrayList<Note>();
        //Note one = new Note("5th", "THis is my dsfgt note");
        //Note two = new Note("3rd Note", "This is my sdfg note");
        //Note three = new Note("4th Note", "This is my dsfguyf note");
        //Note four = new Note("6th", "THis is my dsfgt note");
        //Note five = new Note("7rd Note", "This is my sdfg note");
        //Note six = new Note("8th Note", "This is my dsfguyf note");
        //this.noteRepository.deleteAll();

        //notes.add(one);
        //notes.add(two);
        //notes.add(three);

        //this.noteRepository.save(notes);
    }


}
