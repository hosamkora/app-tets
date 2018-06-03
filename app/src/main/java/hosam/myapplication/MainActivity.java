package hosam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import hosam.myapplication.model.Person;
import hosam.myapplication.model.PersonAdaptor;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnNewPeerson;
    PersonAdaptor personAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.list);
        btnNewPeerson = findViewById(R.id.newPersonButton);


        // Initialize data
        ArrayList<Person> people = Person.getListOfPerson();

        // Create adapter passing in the sample people data
        personAdaptor = new PersonAdaptor(people);

        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(personAdaptor);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnNewPeerson.setOnClickListener(view -> {
            Intent intent = new Intent(this, NewPersonActivity.class);

            // start with request code
            startActivityForResult(intent, 20);
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 20 && resultCode == 200) {
            String name = data.getStringExtra("name");
            int age = Integer.parseInt(data.getStringExtra("age"));

            Person person = new Person(name, age);
            personAdaptor.addPerson(person);
        }
    }
}
