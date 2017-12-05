package com.jasondarrow.controller;

import com.jasondarrow.model.Profile;
import com.jasondarrow.repository.ProfileRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @RequestMapping(value = "Profile/{uid}", method = RequestMethod.GET)
    @ApiOperation("Gets the profile with a specific uid")
    public Profile get(@PathVariable String uid) {
        return profileRepository.findOne(uid);
    }

    @RequestMapping(value = "CheckProfileExists/{uid}", method = RequestMethod.GET)
    @ApiOperation("Check if the profile with a specific uid")
    public int checkProfileExists(@PathVariable String uid) {
        List<Profile> notes = profileRepository.findByUid(uid);
        System.out.println("#################################################################################\n");
        System.out.println("The Note Check result: " + notes.size());
        System.out.println("#################################################################################\n");
        return notes.size();
    }


    @RequestMapping(value = "Profile", method = RequestMethod.PUT)
    public Profile update(@RequestBody Profile profile) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        profile.setUpdated(date);
        return profileRepository.save(profile);
    }

    @RequestMapping(value = "Profile/{uid}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable String uid) {
        try {
            Profile existingProfile = profileRepository.findOne(uid);
            profileRepository.delete(existingProfile);
            return true;
        } catch (Exception e) {
            System.out.println("Error when deleting Profile: " + e.getMessage());
            return false;
        }
    }

}