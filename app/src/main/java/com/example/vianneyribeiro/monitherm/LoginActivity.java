package com.example.vianneyribeiro.monitherm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

    }


    public void logar(View view) {
        final EditText login = (EditText) findViewById(R.id.emailEdt);
        EditText pass = (EditText) findViewById(R.id.passEdt);
        System.out.println(login.toString());
        System.out.println(pass.toString());

        firebaseAuth.signInWithEmailAndPassword(login.getText().toString(), pass.getText().toString())

                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(LoginActivity.this, "Entrada Aceita", Toast.LENGTH_SHORT).show();
                            Intent logado = new Intent(LoginActivity.this, MainActivity.class);
                            logado.putExtra("email", login.getText().toString());
                            startActivity(logado);

                        }else{
                            Log.v("ERRRROOO", "DDDSDSDSDSD");
                            Toast.makeText(LoginActivity.this, "Usuário sem Cadastro", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }




}
