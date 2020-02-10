package com.example.mynote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public EditText titleET;
    public EditText descET;
    public NumberPicker priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleET = findViewById(R.id.ETtitle);
        descET = findViewById(R.id.ETdesc);
        priority = findViewById(R.id.priorityNum);


        priority.setMinValue(1);
        priority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveButton:
                saveNote();
            default:

                return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {
        String title = titleET.getText().toString().trim();
        String desc = descET.getText().toString().trim();
        //@todo: add priority after connecting to internet


        if (title.trim().isEmpty() || desc.trim().isEmpty()) {
            Toast.makeText(this, "Please write something naaaa", Toast.LENGTH_SHORT).show();
        }

        Intent data = new Intent();
        data.putExtra("Title", title);
        data.putExtra("Desc", desc);
        data.putExtra("Priority", title);

        setResult(RESULT_OK, data);
        finish();


    }
}
