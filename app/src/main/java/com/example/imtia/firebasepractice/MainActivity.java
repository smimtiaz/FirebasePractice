package com.example.imtia.firebasepractice;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


     private Button buttonRegister;
     private EditText editTextEmail;
     private EditText editTextPassword;
     private TextView textViewSignIn;
     private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth =FirebaseAuth.getInstance();
        buttonRegister = findViewById(R.id.buttonRegister);
        editTextEmail= findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        textViewSignIn =  findViewById(R.id.textViewSignIn);



        buttonRegister.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        if (view ==buttonRegister){

            registerUser();
    }
    if(view==textViewSignIn){


        }
    }

    private void registerUser() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Email is Empty", Toast.LENGTH_LONG).show();
            return;

    }
         if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Please Enter Password",Toast.LENGTH_LONG).show();
            return;
         }


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){

                    Toast.makeText(MainActivity.this,"Succesfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Could not Successfully",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
