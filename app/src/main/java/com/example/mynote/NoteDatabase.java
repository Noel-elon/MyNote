package com.example.mynote;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.NotActiveException;


@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
new populateAsync(instance).execute();
        }
    };

    private static class populateAsync extends AsyncTask<Void, Void, Void>{
private NoteDao noteDao;

private populateAsync(NoteDatabase db){
    noteDao = db.noteDao();
}

        @Override
        protected Void doInBackground(Void... voids) {
    noteDao.insert(new Note("Noel",1,"Heyo"));
            noteDao.insert(new Note("Orisaemeka",1,"Heyoooo"));
            noteDao.insert(new Note("Nwaelugo",1,"Hey there again"));
            return null;
        }
    }

}
