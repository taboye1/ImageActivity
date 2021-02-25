package temple.edu.imageactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {
     ListView listView;
     Spinner spinner;
     ImageView imageView;

     int[]catResIds;
     ArrayList catArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        catArray = new ArrayList<String>();

        catArray.add("cat1");
        catArray.add("cat2");
        catArray.add("cat3");
        catArray.add("cat4");
        catArray.add("cat5");
        catResIds = new int[]{R.drawable.cat1, R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,R.drawable.cat5};

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,catArray);
        ImageAdapter adapter = new ImageAdapter(this,catArray,int[]imageRes);
        spinner.setAdapter(adapter);

        listView.setAdapter(adapter);


        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }
            });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ImageActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void showPicture (int position){
        imageView.setImageResource(catResIds[position]);}
}