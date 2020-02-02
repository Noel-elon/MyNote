package com.example.mynote;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {

    private String title;

    public void setId(int id) {
        this.id = id;
    }

    public Note(String title, int priority, String description) {
        this.title = title;
        this.priority = priority;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int priority;
    private String description;
}
