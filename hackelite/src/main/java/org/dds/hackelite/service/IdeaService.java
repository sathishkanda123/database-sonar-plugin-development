package org.dds.hackelite.service;

import org.dds.hackelite.model.Idea;

import java.util.List;
import java.util.UUID;

public interface IdeaService {
    void createIdea(Idea idea);
    Idea getIdeaById(UUID uuid);
    List<Idea> getAllIdeas();
    void updateIdea(Idea idea);
    void deleteIdea(UUID uuid);
}
