package com.jasondarrow.controller;

import com.jasondarrow.model.Profile;
import com.jasondarrow.repository.ProfileRepository;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "ProfileControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private ProfileRepository profileRepository;
    String pattern = "MM/dd/yyyy HH:mm";

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @RequestMapping(value = "Profiles", method = RequestMethod.GET)
    public List<Profile> list() {
        return profileRepository.findAll();
    }

    @RequestMapping(value = "Profile", method = RequestMethod.POST)
    public Profile create(@RequestBody Profile profile) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        profile.setCreated(date);
        return profileRepository.insert(profile);
    }

    @RequestMapping(value = "Profile/{id}", method = RequestMethod.GET)
    public Profile get(@PathVariable String id) {
        return profileRepository.findOne(id);
    }

    @RequestMapping(value = "Profile", method = RequestMethod.PUT)
    public Profile update(@RequestBody Profile profile) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        profile.setUpdated(date);
        return profileRepository.save(profile);
    }

    @RequestMapping(value = "Profile/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable String id) {
        try {
            Profile existingNote = profileRepository.findOne(id);
            profileRepository.delete(existingNote);
            return true;
        } catch (Exception e) {
            System.out.println("Error when deleting Profile: " + e.getMessage());
            return false;
        }
    }

}