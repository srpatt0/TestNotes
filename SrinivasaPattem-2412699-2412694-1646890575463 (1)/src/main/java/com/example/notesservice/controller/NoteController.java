package com.example.notesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.notesservice.exception.NoteIdNotFoundException;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;
import com.example.notesservice.dto.NotesDto;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
    private NoteService noteService;
    
    

	//@Autowired
	//NoteRepository noteRepository;

	// Get All Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		return noteService.findAll();
	}

	// Create a new Note
	@PostMapping("/notes")
	public Note createNote(@Validated @RequestBody Note note) {

      
            NotesDto notesDto = new NotesDto();
            notesDto.setId(note.getId());
            notesDto.setTitle(note.getTitle());
            notesDto.setAuthor(note.getAuthor());
            notesDto.setDescription(note.getDescription());
            notesDto.setStatus(note.getStatus());        
        	return noteService.addNote(notesDto);
	}

	// Get a Single Note
	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable(value = "id") Integer noteId) {
		return noteService.findById(noteId);
	}

	// Update a Note
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable(value = "id") Integer noteId, @Validated @RequestBody Note noteDetails) {

		Note note = noteService.findById(noteId);	
        note.setTitle(noteDetails.getTitle());
        note.setDescription(noteDetails.getDescription());		
		Note updatedNote = noteService.addNote(note);
		return updatedNote;
	}

	// Delete a Note
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer noteId) {
		Note note = noteService.findById(noteId)
				.orElseThrow(() -> new NoteIdNotFoundException("Note id not found"));

		noteService.deleteNote(noteId);

		return ResponseEntity.ok().build();
	}
	
	


	
	
}











