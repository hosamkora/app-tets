package hosam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonActivity extends AppCompatActivity {
    EditText etNewName, etNewAge;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);
        etNewName = findViewById(R.id.newName);
        etNewAge = findViewById(R.id.newAge);
        btnAdd = findViewById(R.id.Add);

        btnAdd.setOnClickListener(view -> {
            String newName = etNewName.getText().toString();
            String newAge = etNewAge.getText().toString();

            Intent data = new Intent();
            data.putExtra("name", newName);
            data.putExtra("age", newAge);

            // contract between sender and reciver
            setResult(200, data);

            // emulate back button
            this.finish();

        });
    }
}
