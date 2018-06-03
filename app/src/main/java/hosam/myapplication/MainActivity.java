package hosam.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import hosam.myapplication.model.Person;
import hosam.myapplication.model.PersonAdaptor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.list);

        // Initialize data
        ArrayList<Person> people = Person.getListOfPerson();

        // Create adapter passing in the sample people data
        PersonAdaptor personAdaptor = new PersonAdaptor(people);

        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(personAdaptor);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
