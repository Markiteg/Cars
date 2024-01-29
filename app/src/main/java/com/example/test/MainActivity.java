package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cars> cars = new ArrayList();
    EditText name;
    EditText comm;
    ListView countriesList;
    Cars selectedCars;
    ArrayAdapter<Cars> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            String name = arguments.get("name").toString();
            String comment = arguments.getString("comment");
            cars.add(new Cars(name, comment, R.drawable.defultcars));
        }
        setInitialData();
        countriesList = findViewById(R.id.countriesList);
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, cars);
        countriesList.setAdapter(stateAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                selectedCars = (Cars) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedCars.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){
        cars.add(new Cars ("Toyota Mark II", "Задний Привод, Механика, 150 Лошадиных Сил.", R.drawable.mark2));
        cars.add(new Cars ("Mitsubishi Lancer", "Передний Привод, Автомат, 100 Лошадиных Сил", R.drawable.mitsubishi));
        cars.add(new Cars ("Nissan Skyline R34", "Полный Привод, Механика 280 Лошадиных Сил", R.drawable.nissan));
    }

    public void OpenAddMenu(View view) {

        setContentView(R.layout.addcars);
    }
    public void OpenDeleteMenu(View view) {
        adapter.remove(selectedCars);

        adapter.notifyDataSetChanged();
    }

    public void AddCar(View view) {
        name = findViewById(R.id.name);
        comm = findViewById(R.id.comment);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("comment", comm.getText().toString());
        startActivity(intent);
    }
}