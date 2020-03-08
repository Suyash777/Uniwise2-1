package com.example.uniwise;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText email,password;
    Button submit,goLogin;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth= FirebaseAuth.getInstance();
        submit=(Button)findViewById(R.id.RSubmitBtn);
        user=mAuth.getCurrentUser();
        email=findViewById(R.id.REmailTxt);
        password=findViewById(R.id.RPasswordTxt);
        goLogin=findViewById(R.id.RtoLSwitchBtn);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usnm,pass;
                usnm=email.getText().toString();
                pass=password.getText().toString();
                registerNewUser(usnm,pass);
            }
        });
    }
    public void registerNewUser(String mail,String pswd)
    {
        if(TextUtils.isEmpty(mail)){
            Toast.makeText(getApplicationContext(),"Please enter Email...",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pswd)){
            Toast.makeText(getApplicationContext(),"Please enter Password...",Toast.LENGTH_LONG).show();
        }
        mAuth.createUserWithEmailAndPassword(mail,pswd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Verification link has been sent to the above Email ID, Please verify it.",Toast.LENGTH_LONG).show();

                            user=mAuth.getCurrentUser();
                            user.sendEmailVerification();

                            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


}



