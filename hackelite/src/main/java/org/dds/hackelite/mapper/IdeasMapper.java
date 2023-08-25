package org.dds.hackelite.mapper;

import org.apache.ibatis.annotations.*;
import org.dds.hackelite.model.Idea;

import java.util.List;
import java.util.UUID;

@Mapper
public interface IdeasMapper {

        @Insert("INSERT INTO idea (owner, description, ownerEmail, summary) VALUES (#{owner}, #{description}, #{ownerEmail}, #{summary})")
        @Options(useGeneratedKeys = true, keyProperty = "uuid")
        void insertIdea(Idea idea);

        @Select("SELECT * FROM idea WHERE uuid = #{uuid}")
        Idea getIdeaById(UUID uuid);

        @Select("SELECT * FROM idea")
        List<Idea> getAllIdeas();

        @Update("UPDATE idea SET owner = #{owner}, description = #{description}, ownerEmail = #{ownerEmail}, summary = #{summary} WHERE uuid = #{uuid}")
        void updateIdea(Idea idea);

        @Delete("DELETE FROM idea WHERE uuid = #{uuid}")
        void deleteIdea(UUID uuid);

}


