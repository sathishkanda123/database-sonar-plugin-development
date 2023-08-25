package org.dds.hackelite.serviceimpl;

import org.dds.hackelite.mapper.IdeasMapper;
import org.dds.hackelite.model.Idea;
import org.dds.hackelite.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IdeaServiceImpl implements IdeaService {

    private final IdeasMapper ideaMapper;

    @Autowired
    public IdeaServiceImpl(IdeasMapper ideaMapper) {
        this.ideaMapper = ideaMapper;
    }

    @Override
    public void createIdea(Idea idea) {
        ideaMapper.insertIdea(idea);
    }

    @Override
    public Idea getIdeaById(UUID uuid) {
        return ideaMapper.getIdeaById(uuid);
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideaMapper.getAllIdeas();
    }

    @Override
    public void updateIdea(Idea idea) {
        ideaMapper.updateIdea(idea);
    }

    @Override
    public void deleteIdea(UUID uuid) {
       ideaMapper.deleteIdea(uuid);
    }

}

