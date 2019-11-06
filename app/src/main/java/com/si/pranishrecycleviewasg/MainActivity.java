package com.si.pranishrecycleviewasg;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etname, etage;
    RadioButton rbfemale, rbmale;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender, name, age;
    int imageposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        rbfemale = findViewById(R.id.rbfemale);
        rbmale = findViewById(R.id.rbmale);
        spinnerimg = findViewById(R.id.spinimg);
        viewR = findViewById(R.id.recycleV);
        btnsave = findViewById(R.id.btnsave);
        radioGroup = findViewById(R.id.genderG);
        final List<DetailsClass> detailsClasses = new ArrayList<>();
        final int[] title = {
                (R.drawable.arthur),
                (R.drawable.djong),
                (R.drawable.grizi),
                (R.drawable.jordi),
                (R.drawable.mats),
                (R.drawable.messi),
                (R.drawable.pique),
                (R.drawable.roborto),
                (R.drawable.sergio),
                (R.drawable.suarez),
        };
        final String[] titlenaME = {
                "",
                "Arthur Melo",
                "Frankie De Jong",
                "Anton Grizemann",
                "Jordi Alba",
                "Mark Ter Stegen",
                "Leonel Messi",
                "Gerad Pique",
                "Sergio Roborto",
                "Serg Busi",
                "Luies Suarez"
        };
        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, titlenaME);
        spinnerimg.setAdapter(imgtitle);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etname.getText().toString().isEmpty()) {

                    name = etname.getText().toString();

                    try {
                        int selectid = radioGroup.getCheckedRadioButtonId();
                        RadioButton radioButton = findViewById(selectid);
                        gender = radioButton.getText().toString();
                        if (!etname.getText().toString().isEmpty()) {
                            age = (etname.getText().toString());
                            int position = (spinnerimg.getSelectedItemPosition());
                            if (position != 0) {
                                imageposition = title[position - 1];
                                detailsClasses.add(new DetailsClass(name, age, gender, imageposition));
                                AdapterView adapterView = new AdapterView(MainActivity.this, detailsClasses);
                                viewR.setAdapter(adapterView);
                                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            } else {
                                Toast.makeText(MainActivity.this, "Please select images", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Please enter age", Toast.LENGTH_SHORT).show();

                        }
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }


}


