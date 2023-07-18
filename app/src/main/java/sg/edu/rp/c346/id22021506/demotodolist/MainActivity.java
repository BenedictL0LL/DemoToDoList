package sg.edu.rp.c346.id22021506.demotodolist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvtodo;
    ArrayList<ToDoItem> altodo;
    CustomAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvtodo = findViewById(R.id.listViewToDo);
        altodo = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.AUGUST, 1);

        ToDoItem item1 = new ToDoItem("Go for Movie", calendar );

        altodo.add(item1);

        adapter = new CustomAdapter(this, R.layout.row, altodo);

        lvtodo.setAdapter(adapter);
    }
}