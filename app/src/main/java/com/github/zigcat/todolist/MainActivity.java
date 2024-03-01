package com.github.zigcat.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public Map<Integer, LinearLayout> tasks = new HashMap<>();
    public int counter = 1;

    public void addToList(){
        EditText newTaskText = findViewById(R.id.new_task);
        LinearLayout list = findViewById(R.id.list);
        LinearLayout newTask = new LinearLayout(this);
        newTask.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        newTask.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView = new TextView(this);
        textView.setText(newTaskText.getText());

        Button button = new Button(this);
        button.setText("Delete");
        button.setId(counter*10+2);

        newTask.addView(textView);
        newTask.addView(button);
        list.addView(newTask);
        list.setId(counter*10);

        tasks.put(counter, list);
        counter++;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnid = button.getId();
                int number = btnid/10;
                LinearLayout goneTask = tasks.get(number);
                LinearLayout list = findViewById(R.id.list);
                list.removeView(list);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<LinearLayout> tasks = new ArrayList<>();
        Button add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToList();
            }
        });
    }
}