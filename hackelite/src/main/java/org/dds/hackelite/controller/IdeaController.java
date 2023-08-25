package org.dds.hackelite.controller;

import org.dds.hackelite.model.Idea;
import org.dds.hackelite.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ideas")
public class IdeaController {

    private final IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping
    public ResponseEntity<Void> createIdea(@RequestBody Idea idea) {
        ideaService.createIdea(idea);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Idea> getIdea(@PathVariable UUID uuid) {
        Idea idea = ideaService.getIdeaById(uuid);
        if (idea != null) {
            return ResponseEntity.ok(idea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getAllIdeas() {
        List<Idea> ideas = ideaService.getAllIdeas();
        return ResponseEntity.ok(ideas);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Idea> updateIdea(@PathVariable UUID uuid, @RequestBody Idea updatedIdea) {
        Idea existingIdea = ideaService.getIdeaById(uuid);
        if (existingIdea != null) {
            updatedIdea.setUuid(uuid);
            ideaService.updateIdea(updatedIdea);
            return ResponseEntity.ok(updatedIdea);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteIdea(@PathVariable UUID uuid) {
        Idea existingIdea = ideaService.getIdeaById(uuid);
        if (existingIdea != null) {
            ideaService.deleteIdea(uuid);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

