package com.Team19.RutujaHrithikSuparna.onpoint;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class SearchPage extends AppCompatActivity {

    private String SearchedItem;
    EditText searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        Intent intent = getIntent();
        SearchedItem = intent.getStringExtra("key");
        searchBar = (EditText) findViewById(R.id.SearchItem);
        searchBar.setText(SearchedItem);

    }





    //check internet connection
    boolean internet;
    public boolean checkInternet(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        }
        else
            return false;
    }


    public void Search(View view){
        if(searchBar.getText().toString()!= SearchedItem){
            SearchedItem = searchBar.getText().toString();
        }
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(searchBar, InputMethodManager.SHOW_IMPLICIT);

        Toast.makeText(getApplicationContext(), "Search successful", Toast.LENGTH_SHORT).show();
    }

    public void goto_OxfordDict(View view)
    {
       internet = checkInternet();
        if(internet == true) {
            Intent intent_def = new Intent(SearchPage.this, com.Team19.RutujaHrithikSuparna.onpoint.DefinitionFinal.class);
            intent_def.putExtra("searchedItem", SearchedItem);
            startActivity(intent_def);
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
        }
}
    public void goto_Quotes(View view)
    {
        internet = checkInternet();
        if(internet == true) {
        Intent intent_quote = new Intent(SearchPage.this, com.Team19.RutujaHrithikSuparna.onpoint.QuotesFinal.class);
        intent_quote.putExtra("searchedItem",SearchedItem);
        startActivity(intent_quote);
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
        }

    }

    public void goto_Wikipedia(View view)
    {
        internet = checkInternet();
        if(internet == true) {
            Intent intent_wiki = new Intent(SearchPage.this, com.Team19.RutujaHrithikSuparna.onpoint.WikiFinal.class);
            intent_wiki.putExtra("searchedItem", SearchedItem);
            startActivity(intent_wiki);
        }
        else{
        Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
    }

    }

    public void goto_Quora(View view)
    {
        internet = checkInternet();
        if(internet == true) {
            Intent intent_quora = new Intent(SearchPage.this, com.Team19.RutujaHrithikSuparna.onpoint.Quora2.class);
            intent_quora.putExtra("searchedItem", SearchedItem);
            startActivity(intent_quora);
        }
        else{
        Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
    }

    }

    public void goto_Reuters(View view)
    {

        internet = checkInternet();
        if(internet == true) {
            Intent intent_reuters = new Intent(SearchPage.this, ReutersFinal.class);
            intent_reuters.putExtra("searchedItem", SearchedItem);
            startActivity(intent_reuters);
        }
        else{
        Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
    }

    }

    public void goto_Hindu(View view)
    {
        internet = checkInternet();
        if(internet == true) {
            Intent intent_hindu = new Intent(SearchPage.this, com.Team19.RutujaHrithikSuparna.onpoint.HinduMain.class);
            intent_hindu.putExtra("searchedItem", SearchedItem);
            startActivity(intent_hindu);
        }
        else{
            Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
        }

    }

    public void goto_Youtube(View view)
    {
        internet = checkInternet();
        if(internet == true) {
            Intent intent_youtube = new Intent(SearchPage.this, YoutubeFinal.class);
            intent_youtube.putExtra("searchedItem", SearchedItem);
            startActivity(intent_youtube);
        }
        else{
        Toast.makeText(getApplicationContext(), "No internet access", Toast.LENGTH_SHORT).show();
    }

    }

    public void goto_Notepad(View view)
    {
        Intent intent_note = new Intent(SearchPage.this,Notes.class);
        startActivity(intent_note);
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        clear_pref();
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }

    public void clear_pref()
    {
         SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        }

}
