package com.webileapps.testingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.username)
    EditText userName;

    @Bind(R.id.password)
    EditText userPassword;

    @Bind(R.id.alert_message)
    TextView alertMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void doLogin(View view) {

        String username = userName.getText().toString();
        String password = userPassword.getText().toString();

        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Validation OK",Toast.LENGTH_SHORT).show();
                return;
        }
        Toast.makeText(this,"Validation Failed",Toast.LENGTH_SHORT).show();
    }
}
