package hosam.myapplication.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hosam.myapplication.R;

public class PersonAdaptor extends RecyclerView.Adapter<PersonAdaptor.ViewHolder> {

    ArrayList<Person> people;

    public PersonAdaptor(ArrayList<Person> people) {
        this.people = people;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View personView = inflater.inflate(R.layout.list_element, parent, false);

        ViewHolder holder = new ViewHolder(personView);

        // Return a new holder instance
        return holder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Person person = people.get(position);

        // Set item views based on your views and data model
        TextView nameView = holder.nameView;
        nameView.setText(person.getName());
        TextView ageView = holder.ageView;
        ageView.setText(String.valueOf(person.getAge()));

    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row

        public TextView nameView;
        public TextView ageView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            ageView = itemView.findViewById(R.id.age);
        }
    }
}
