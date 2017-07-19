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

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "HomeControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    private NoteRepository noteRepository;

    public HomeController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    //@RequestMapping("/")
    //public String home() {
    //    return "BJJ Notes, reporting for srvice

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
    @ApiOperation("Gets the note with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Note.class)})
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

}