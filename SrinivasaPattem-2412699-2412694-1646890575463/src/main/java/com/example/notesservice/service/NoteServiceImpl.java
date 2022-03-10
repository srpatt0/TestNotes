package com.example.notesservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.repo.NoteRepository;


@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<NotesDto> findAll() {
        List<Note> notesList =noteRepository.findAll();
        List<NotesDto> notesDtoList = new ArrayList(notesList.size());
        for(Note note : notesList){
            NotesDto notesDto = new NotesDto();
            notesDto.setId(note.getId());
            notesDto.setTitle(note.getTitle());
            notesDto.setAuthor(note.getAuthor());
            notesDto.setDescription(note.getDescription());
            notesDto.setStatus(note.getStatus());
            notesDtoList.add(notesDto);
        }
		return notesDtoList;
	}

	@Override
	public NotesDto findById(Integer id) {
        Optional<Note> note =noteRepository.findById(id);
        NotesDto notesDto  =  new NotesDto();
        notesDto.setId(note.get().getId());
        notesDto.setTitle(note.get().getTitle());
        notesDto.setAuthor(note.get().getAuthor());
        notesDto.setDescription(note.get().getDescription());
        notesDto.setStatus(note.get().getStatus());
		return notesDto;
	}
	@Override
	public NotesDto addNote(NotesDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
            note.setTitle(noteDto.getTitle());
            note.setAuthor(noteDto.getAuthor());
            note.setDescription(noteDto.getDescription());
            note.setStatus(noteDto.getStatus());
		noteRepository.save(note);
		return noteDto;
	}

	@Override
	public NotesDto deleteNote(Integer id) {

        Optional <Note> note = noteRepository.findById(id);
		if (note.isPresent())
		{
            noteRepository.deleteById(id);
            NotesDto notesDto  =  new NotesDto();
        notesDto.setId(note.get().getId());
        notesDto.setTitle(note.get().getTitle());
        notesDto.setAuthor(note.get().getAuthor());
        notesDto.setDescription(note.get().getDescription());
        notesDto.setStatus(note.get().getStatus());
			return notesDto;			
		}
	
		return null;
		
	}

	@Override
	public List<NotesDto> findAllByStatus(String status) {
		List<Note> notesList =noteRepository.findAllByStatus(status);
		List<NotesDto> notesDtoList = new ArrayList(notesList.size());
        for(Note note : notesList){
            NotesDto notesDto = new NotesDto();
            notesDto.setId(note.getId());
            notesDto.setTitle(note.getTitle());
            notesDto.setAuthor(note.getAuthor());
            notesDto.setDescription(note.getDescription());
            notesDto.setStatus(note.getStatus());
            notesDtoList.add(notesDto);
        }
		return notesDtoList;
	}

	@Override
	public List<NotesDto> findAllByAuthor(String author) {
		List<Note> notes =noteRepository.findAllByAuthor(author);
		List<NotesDto> notesDtoList = new ArrayList(notesList.size());
        for(Note note : notesList){
            NotesDto notesDto = new NotesDto();
            notesDto.setId(note.getId());
            notesDto.setTitle(note.getTitle());
            notesDto.setAuthor(note.getAuthor());
            notesDto.setDescription(note.getDescription());
            notesDto.setStatus(note.getStatus());
            notesDtoList.add(notesDto);
        }
		return notesDtoList;
	}

	@Override
	public NotesDto updateStatus(Integer id, String status) {
        NotesDto notesDto  =  new NotesDto();
        notesDto.setId(id);
        notesDto.setStatus(status);
Optional<Note> note =noteRepository.findById(id);
        if(note.isPresent()){
            Note modifiedNote = note.get();
            modifiedNote.setStatus(status);
            noteRepository.save(modifiedNote);
            notesDto.setAuthor(modifiedNote.getAuthor());
            notesDto.setTitle(modifiedNote.getTitle());
            notesDto.setDescription(modifiedNote.getDescription());
        }
        
        return notesDto;    
        }
}
