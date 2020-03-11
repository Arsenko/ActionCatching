package com.example.configwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ContentList> adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        final ListView listView=findViewById(R.id.listView);

        List<ContentList> adapterList =prepareData();

        final ContentAdapter adapter=new ContentAdapter(this,adapterList);

        listView.setAdapter(adapter);
    }

    private ArrayList<ContentList> prepareData(){
        ArrayList<ContentList> conList=new ArrayList<>();
        String[] headingString= getResources().getStringArray(R.array.headings);
        for(int i=0;i<headingString.length;i++){
            conList.add(new ContentList(getDrawable(R.drawable.ic_launcher_foreground),
                    headingString[i],"project",false));
        }
        return conList;
    }
}
