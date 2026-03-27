package com.joaofelipe.vinicius.cadastro_usuario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // declaração dos componentes visuais e do adaptador da lista

    RecyclerView recyclerView;
    UserAdapter adapter;
    Button btnCadastrar;

    //atenção: atritbutos (statatic) permite que os dados persistam na memória
    //enquanto o app estiver aberto e sejam acessados diretamente por outras telas(Activities)

    public static List<String> listaNomes = new ArrayList<>();

    //metodo de inicialização da Activity (Ponto de entrada da tela)

    @Override

    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //vincula o arquivo de layout XML (activity_main.xml) a essa classe Java
        setContentView(R.layout.activity_main);

        // regra de negocio: insere um texto no topo da lista, caso ela esteja vazia
        if(listaNomes.isEmpty()){
            listaNomes.add("Nomes de cadastro");
        }

        //mapeamento dos componentes do RecyclerView do XML  para o objeto java
        recyclerView = findViewById(R.id.recyclerView);


        //Define o LayoutManager: organiza itens da lista coluna vertical simples
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //istancia o adaptador passando a nossa lista de nomes
        adapter = new UserAdapter(listaNomes);

        //conecta o adaptador  ao RecyclerView para que os dados sejam desenhados na tela
        recyclerView.setAdapter(adapter);

        //mapeia o botão de cadastro
        btnCadastrar = findViewById(R.id.btnCadastrar);

        //Configura o evento de clique usando a expressão lambda (java 8+)
        btnCadastrar.setOnClickListener( View ->){
            startActivity(new Intent(MainActivity.this, CreateUser.class));
        }


    }

    //metodo chamado sempre que a tela volta a ficar visivel para o usuário

    @Override

    protected  void onResume(){
        super.onResume();
        //avisar o adaptador que a fonte de dados (listaNomes) pode ter sido alterada
        // na outra tela, forçando a atualização visual da lista
        adapter.notifyDataSetChanged();
    }

}