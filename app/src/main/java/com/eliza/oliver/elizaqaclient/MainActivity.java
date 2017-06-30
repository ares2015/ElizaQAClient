package com.eliza.oliver.elizaqaclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private EditText msgTextField;

    private Button sendButton;

    TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make message text field object
        msgTextField = (EditText) findViewById(R.id.msgTextField);
        //make button object
        sendButton = (Button) findViewById(R.id.sendButton);

        answerTextView = (TextView) findViewById(R.id.answerTextView);

    }

    public void send(View v) {
        //get message from message box
        String question = msgTextField.getText().toString();


        String stringURL = "http://95.105.237.84/answer?question=" + question;
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET, stringURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //got our Response as response
                        //same to make any call to UI thread
                        answerTextView.setText("Answer: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //got error
            }
        });
        queue.add(stringRequest);

    }

}
