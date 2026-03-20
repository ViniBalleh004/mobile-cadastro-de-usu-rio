package com.joaofelipe.vinicius.cadastro_usuario;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import adroidx.appcompat.app.AppCompatActivity;
public class CreateUser  extends AppCompatActivity {
    TextInputEditText editNome, editEmail;

    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate((savedInstanceState));
        setContentView((R.layout.create_user));

        // vincula variavel com elemento da interface grafica, escrito no arquivo xml

        editNome = findViewById(R.id.nome_completo);
        editEmail = findViewById(R.id.Email);
        btnSalvar = findViewById(R.id.bntSalvar);

        btnSalvar.setOnClickListener(View v ->{
            String nome  = editNome.getText().toString();
            String email  = editEmail.getText().toString();

            if (!nome.isEmpty()){
                MainActivity.listaNomes.add(nome + "( "+ email +" ");
                finish();
            }
        });


    }


}
