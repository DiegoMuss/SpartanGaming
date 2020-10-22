package com.example.spartangaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txt1,txt2;
    private ProgressBar pb;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText) findViewById(R.id.user);
        txt2=(EditText) findViewById(R.id.pass);
        btn=(Button)findViewById(R.id.btn) ;
        pb= (ProgressBar)findViewById(R.id.pb);
        pb.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user, password;
                user=txt1.getText().toString();
                password=txt2.getText().toString();

                if ((user.equals("android") || user.equals("Android")) && (password.equals("123")))
                {

                    new Task().execute();
                }

            }
        });

    }

    class Task extends AsyncTask<String, Void, String>

    {


        @Override
        protected void onPreExecute()
        {

            pb.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i=1; i<=10; i++)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            Intent i = new Intent(getBaseContext(), Menu.class);
            startActivity(i);
        }

    }

}