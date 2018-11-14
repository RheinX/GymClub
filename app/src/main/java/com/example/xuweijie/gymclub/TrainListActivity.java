package com.example.xuweijie.gymclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrainListActivity extends AppCompatActivity {

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_list);

        rv=(RecyclerView)findViewById(R.id.rv);

        Bundle bundle=this.getIntent().getExtras();
        String data=bundle.getString("data");
        try {
            JSONObject msg=new JSONObject(data);
            System.out.println(msg);
            LinearLayoutManager llm = new LinearLayoutManager(this);
            rv.setLayoutManager(llm);
            rv.setHasFixedSize(true);

            initializeData(msg);
            initializeAdapter();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void initializeData(JSONObject msg) throws JSONException {
        persons = new ArrayList<>();
        persons.add(new Person(msg.get("1").toString(), "犹太教创始者", R.drawable.moses));
        persons.add(new Person(msg.get("2").toString(), "诺亚方舟", R.drawable.noya));
        persons.add(new Person(msg.get("3").toString(), "先知", R.drawable.yabolahan));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
