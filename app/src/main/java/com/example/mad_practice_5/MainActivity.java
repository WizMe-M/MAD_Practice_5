package com.example.mad_practice_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] elements = {
            "Москва",
            "Санкт-Петербург",
            "Краснодар",
            "Новосибирск",
            "Калининград"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //создаем адаптер c предустановленной разметкой мульти-выбора
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, elements);

        //привязываем адаптер с массивом к листвью
        listView.setAdapter(adapter);

        //добавляем обработчик нажатия на элемент листвью
        listView.setOnItemClickListener((parent, view, position, id) -> {

            SparseBooleanArray selected = listView.getCheckedItemPositions();
            ArrayList<String> checked = new ArrayList<>();

            for (int i = 0; i < elements.length; i++)
                if (selected.get(i))
                    checked.add(elements[i]);

            // установка текста в тост
            String selectedItems = TextUtils.join(", ", checked);

            if(selectedItems != null && !TextUtils.isEmpty(selectedItems))
            Toast.makeText(getApplicationContext(), "Выбрано: " + selectedItems,
                    Toast.LENGTH_SHORT).show();
        });
    }
}