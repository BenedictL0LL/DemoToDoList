package sg.edu.rp.c346.id22021506.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CustomAdapter extends ArrayAdapter<ToDoItem> {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> todoList;

    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        todoList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentTodo = todoList.get(position);

        // Convert the Calendar object to a formatted String
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = sdf.format(currentTodo.getDate().getTime());

        // Set the formatted date as the text for the TextView
//        tvDate.setText(formattedDate);

        formattedDate += " "+currentTodo.getDay(1);
        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentTodo.getTitle());
        tvDate.setText(formattedDate);

        return rowView;
    }



}
