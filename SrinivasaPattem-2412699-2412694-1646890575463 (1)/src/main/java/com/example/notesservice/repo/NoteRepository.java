package com.example.notesservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesservice.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{

}
