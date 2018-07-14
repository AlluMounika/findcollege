package com.example.lenovo.findcollege;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Loader;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    FirebaseDatabase firebaseDatabase;
    static ArrayList<collegepojo> collegearray;
    static RecyclerView rv;
    String clgid;
    public static int LOADER_ID = 13;
    DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase=FirebaseDatabase.getInstance();
        myref=firebaseDatabase.getReference("clg1");
        rv=(RecyclerView) findViewById(R.id.recycler);
  //      getLoaderManager().restartLoader(LOADER_ID, null,  MainActivity.this);
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectcolleges((Map<String,Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void collectcolleges(Map<String, Object> value) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        String namevalues="";
        collegearray=new ArrayList<>();
        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : value.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            collegepojo cp=new collegepojo((String) singleUser.get("accrediatatedto"),(String) singleUser.get("district"),
                    (String) singleUser.get("image"),(String) singleUser.get("location"),(String) singleUser.get("name")
                    ,(String) singleUser.get("type"),(Double) singleUser.get("userrating"),(String) singleUser.get("weblink"));
            phoneNumbers.add((String) singleUser.get("name"));
            collegearray.add(cp);
            Log.i("name2",cp.getName());
            namevalues=namevalues+"\n"+(String) singleUser.get("name");
        }
      //  Log.i("name",namevalues);
        Log.i("name",collegearray.get(1).getName());

        if(collegearray.size()>0) {
            Log.i("name3",collegearray.get(1).getName()+"hiii");
            //ikkada
            MainActivity.rv.setLayoutManager(new GridLayoutManager(this, 1));
            rv.setAdapter(new MyAdapter(this, collegearray));
        }
        Log.i("number",Integer.toString(collegearray.size()));
        System.out.println(phoneNumbers.toString());
    }
}
