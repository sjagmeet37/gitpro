package com.lenovo.jagmeet.firebaseauthentication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    public void sign(View view) {


        email = findViewById(R.id.email);

        password = findViewById(R.id.password);

        String emailid = email.getText().toString();

        String pass = password.getText().toString();

        if(Patterns.EMAIL_ADDRESS.matcher(emailid).matches())
        {

        }
        else
        {
            Toast.makeText(signup.this,"Invalid Email Syntax",Toast.LENGTH_LONG).show();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(signup.this);

        progressDialog.setTitle("Please Wait");

        progressDialog.setMessage("Creating Account");

        progressDialog.show();



        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listner = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
               progressDialog.hide();
                if(task.isSuccessful())
                {
                    Toast.makeText(signup.this,"Added Successfully",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(signup.this,"Signup Failed",Toast.LENGTH_LONG).show();

                }
            }
        };


        firebaseAuth.createUserWithEmailAndPassword(emailid, pass).addOnCompleteListener(listner);




    }
}
