package com.Team19.RutujaHrithikSuparna.onpoint;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class NewNote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_discardNote) {


            finish();
        }
        if (id == R.id.action_saveNote) {

            EditText editText = (EditText)findViewById(R.id.text_editor);

            //Get text from user input in the EditText and add it to the listview using adapter
            String theText = (String)editText.getText().toString();
            Notes.notesArray.add(theText);

            String[] beforeNewline = theText.split("\n", 20);
            Notes.displayArray.add(beforeNewline[0]);

            Notes.theListView.setAdapter(Notes.theAdapter);

            try {
                FileOutputStream fileOutputStream = openFileOutput("noteSaves", Context.MODE_PRIVATE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                objectOutputStream.writeObject(Notes.notesArray);
                objectOutputStream.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            finish();

        }



        return super.onOptionsItemSelected(item);
    }
}
