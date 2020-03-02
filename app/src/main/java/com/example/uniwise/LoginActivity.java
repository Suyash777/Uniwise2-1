package com.example.uniwise;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Button newAcc;
    EditText email,password;
    Button submit,forgotPass;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        newAcc=findViewById(R.id.newAccount);
        newAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        mAuth= FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        submit=findViewById(R.id.LoginBtn);
        email=findViewById(R.id.LemailTxt);
        password=findViewById(R.id.LPasswordTxt);
        forgotPass=findViewById(R.id.ForgotPassBtn);
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Fusnm;
                Fusnm=email.getText().toString();
                sendForgotPassLink(Fusnm);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lusnm,Lpass;
                Lusnm=email.getText().toString();
                Lpass=password.getText().toString();
                Login(Lusnm,Lpass);
            }
        });
    }
    public void Login(String Lusnm,String Lpass)
    {
        mAuth.signInWithEmailAndPassword(Lusnm,Lpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.e("testexp",task.getResult().toString());
                if(task.isSuccessful()) {
                    if (mAuth.getCurrentUser().isEmailVerified()) {
                        Toast.makeText(getApplicationContext(), "Login Successful.....", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Verify email....." + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void sendForgotPassLink(String emailId){
        if(!TextUtils.isEmpty(emailId)){
            mAuth.sendPasswordResetEmail(emailId).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    Toast.makeText(getApplicationContext(),"Reset link sent to"+email.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(),"Enter email",Toast.LENGTH_LONG).show();
        }
    }

}



