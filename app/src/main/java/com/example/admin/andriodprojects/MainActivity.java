package com.example.admin.andriodprojects;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listViewContextMenu;
    String language[] = {"java", "javascript", "HTML", "Andriod"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        listViewContextMenu = (ListView) findViewById(R.id.listViewContextMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, language);
        listViewContextMenu.setAdapter(adapter);
        registerForContextMenu(listViewContextMenu);
    }
    public void onCreateContentMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v, menuInfo);
        menu.setHeaderTitle("select the Action");
        menu.add(0, v.getId(), 0, "Code");
        menu.add(0, v.getId(), 0, "Example");
        menu.add(0, v.getId(), 0, "Tutorial");

    }

    public boolean onCentextItemSelected(MenuItem item) {
        if (item.getTitle() == "Code") {
            Toast.makeText(getApplicationContext(), "Selected code", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "Example") {
            Toast.makeText(getApplicationContext(), "selected Example", Toast.LENGTH_SHORT).show();

        } else if (item.getTitle() == "Tutorial") {
            Toast.makeText(getApplicationContext(), "selected Turorial", Toast.LENGTH_SHORT).show();
        } else {
            return false;

        }
        return true;

    }

}
