package id.ac.poliban.dts.farah.prj04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private List<String> data = new ArrayList<>();
    {
        data.add("Manchester United");
        data.add("Real Madrid");
        data.add("Barcelona");
        data.add("Bayern Munchen");
        data.add("Manchester City");
        data.add("Liverpool");
        data.add("Chelsea");
        data.add("Arsenal");
        data.add("Paris Saint-Germain");
        data.add("Tottenham Hotspur");
        data.add("Santos");
        data.add("Botafogo");
        data.add("Sevilla");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar()!=null) getSupportActionBar().setTitle("Demo Simple List View");

        ListView listView = findViewById(R.id.list_view);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(this, "You choosed : " + data.get(i), Toast.LENGTH_SHORT).show();
        } );

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            data.remove(i);
            adapter.notifyDataSetChanged();
            return true;
        } );
    }
}
