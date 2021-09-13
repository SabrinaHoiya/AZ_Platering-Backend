package com.example.AZplastering.controller;


import com.example.AZplastering.models.Devis;
import com.example.AZplastering.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DevisController {

    @Autowired
    DevisRepository tutorialRepository;
    @GetMapping("/devis")
    public ResponseEntity<List<Devis>>getAllTutorials(@RequestParam(required = false) String sujet) {
        try {
            List<Devis> tutorials = new ArrayList<Devis>();

            if (sujet == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findBysujetContaining(sujet).forEach(tutorials::add);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/devis")
    public ResponseEntity<Devis> createTutorial(@RequestBody Devis devis) {
        try {
            Devis _tutorial = tutorialRepository
                    .save(new Devis(devis.getSujet(), devis.getDescription(),devis.getemail(),devis.getNomprenom()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/devis/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}