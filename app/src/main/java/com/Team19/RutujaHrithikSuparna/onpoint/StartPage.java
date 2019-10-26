package com.Team19.RutujaHrithikSuparna.onpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class StartPage extends AppCompatActivity {

    private String input_String;
    String var="hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event){
//        switch (keyCode){
//            case KeyEvent.KEYCODE_DPAD_CENTER:
//            case KeyEvent.KEYCODE_ENTER:
//                makeToast("key pressed");
//                return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    private void makeToast(String message){
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//    }







    private String displayInput() {
        EditText editText = (EditText) findViewById(R.id.enterWord);
        String sub = editText.getText().toString();
        return sub;
    }

    public void startSearch(View view){

        input_String = displayInput();
        Intent intent = new Intent(StartPage.this,SearchPage.class);
        intent.putExtra("key", input_String);
        startActivity(intent);
    }

}
