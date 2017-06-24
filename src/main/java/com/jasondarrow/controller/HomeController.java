package com.jasondarrow.controller;

import com.jasondarrow.model.Note;
import com.jasondarrow.repository.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private NoteRepository noteRepository;

    public HomeController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "BJJ Notes, reporting for duty!";
    }

    @GetMapping("/all")
    public List<Note> getAll() {

        List<Note> notes = this.noteRepository.findAll();

        return notes;
    }

    @RequestMapping(value = "Notes", method = RequestMethod.GET)
    public List<Note> list() {
        return noteRepository.findAll();
    }

    @RequestMapping(value = "Notes", method = RequestMethod.POST)
    public Note create(@RequestBody Note Note) {
        return noteRepository.insert(Note);
    }

    @RequestMapping(value = "Notes/{id}", method = RequestMethod.GET)
    public Note get(@PathVariable String id) {
        return noteRepository.findOne(id);
    }

    @RequestMapping(value = "Notes", method = RequestMethod.PUT)
    public Note update(@RequestBody Note Note) {
        //Note existingNote = noteRepository.findOne(id);
        //BeanUtils.copyProperties(Note, existingNote);
        return noteRepository.save(Note);
    }

    @RequestMapping(value = "Notes/{id}", method = RequestMethod.DELETE)
    public Note delete(@PathVariable String id) {
        Note existingNote = noteRepository.findOne(id);
        noteRepository.delete(existingNote);
        return existingNote;
    }

}