package com.Team19.RutujaHrithikSuparna.onpoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WikiFinal extends AppCompatActivity {

    String input;
    String var="hello";
    private String final_Input;
    WebView wv;

    //when back pressed go back.
    @Override
    public void onBackPressed(){
        if(wv.canGoBack()){
            wv.goBack();
        }
        else {
            super.onBackPressed();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_final);
        Intent intent_wiki = getIntent();
        input = intent_wiki.getStringExtra("searchedItem");

        input = input.replaceAll(" ", "_").toLowerCase();
        final_Input = "https://en.wikipedia.org/wiki/" + input;
        wv = (WebView) findViewById(R.id.wv);
        // enable javascript
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        // set render priority to high
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl(final_Input);
        wv.setWebViewClient(new WebViewClient());

    }

    public void WikiNote(View view){

        Intent intent = new Intent(WikiFinal.this,Notes.class);
        startActivity(intent);

    }


}
