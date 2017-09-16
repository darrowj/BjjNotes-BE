package com.jasondarrow.controller;

import com.jasondarrow.model.Note;
import com.jasondarrow.repository.NoteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "NotesControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class NotesController {

    private NoteRepository noteRepository;
    String pattern = "MM/dd/yyyy HH:mm";

    public NotesController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
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
    public Note create(@RequestBody Note note) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        note.setCreated(date);
        return noteRepository.insert(note);
    }

    @RequestMapping(value = "Notes/{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the note with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Note.class)})
    public Note get(@PathVariable String id) {
        return noteRepository.findOne(id);
    }

    @RequestMapping(value = "Notes", method = RequestMethod.PUT)
    public Note update(@RequestBody Note note) {
        //Note existingNote = noteRepository.findOne(note.getId());
        //BeanUtils.copyProperties(note, existingNote);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        note.setUpdated(date);
        return noteRepository.save(note);
    }

    @RequestMapping(value = "Notes/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable String id) {
        try {
            Note existingNote = noteRepository.findOne(id);
            noteRepository.delete(existingNote);
            return true;
        } catch (Exception e) {
            System.out.println("Error when deleting Note: " + e.getMessage());
            return false;
        }
    }


    @RequestMapping(value = "NoteCount", method = RequestMethod.GET)
    public long noteCount() {
        return noteRepository.count();
    }

}