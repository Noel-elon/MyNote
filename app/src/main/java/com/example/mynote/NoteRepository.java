package com.example.mynote;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();

    }


    public void insert(Note note) {
        new InsertNoteAsync(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNoteAsync(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsync(noteDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNoteAsync(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsync extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private InsertNoteAsync(NoteDao noteDao) {
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);

            return null;
        }
    }

    private static class UpdateNoteAsync extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private UpdateNoteAsync(NoteDao noteDao) {
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);

            return null;
        }
    }

    private static class DeleteNoteAsync extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private DeleteNoteAsync(NoteDao noteDao) {
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);

            return null;
        }
    }

    private static class DeleteAllNoteAsync extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private DeleteAllNoteAsync(NoteDao noteDao) {
            this.noteDao = noteDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();

            return null;
        }
    }
}
