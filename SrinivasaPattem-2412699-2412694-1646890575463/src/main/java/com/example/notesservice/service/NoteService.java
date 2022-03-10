package com.example.notesservice.service;

import java.util.List;
import java.util.Optional;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;

public interface NoteService {
	public List<NotesDto> findAll();
	public NotesDto findById(Integer id);
	public NotesDto addNote(NotesDto note);
	public NotesDto deleteNote(Integer id);
	public List<NotesDto> findAllByStatus(String status);
	public List<NotesDto> findAllByAuthor(String author);
	public NotesDto updateStatus(Integer id, String status);
}
