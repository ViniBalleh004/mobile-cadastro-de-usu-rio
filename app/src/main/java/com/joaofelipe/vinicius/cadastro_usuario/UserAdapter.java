package com.joaofelipe.vinicius.cadastro_usuario;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


    //Classe Adapter: Gerencia a criação e o preenchimento dos itens na RecyclerView.
    public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    // atributo privado que armazena a referencia dos dados que serão exibidos

    private List<String> listaUsuarios;

    //Costrutor que permite que a MainActivity "entregue" a lista de dados para este adapter

    public UserAdapter(List<String> lista){
        this.listaUsuarios = lista;

    }

    // Metodo 1:    CRIA "do zero" o visual de uma linha da lista (+ViewHolder)

    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutFlater transfdorma o arquivo XML em um objeto View Java

        // aqui usamos um layout padrão do Android (simple_list_item_1) para facilitar

        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);

        //retorna uma nova instancia da nossa classe interna ViewHolder com a view criada

        return new ViewHolder(view);
    }

    //metodo 2: vincula os dados de um objeto de lista a uma linha especifica da tela

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        // recupera os dados da lista de acordo com a posição que o android está desenhando agora

            String nome = listaUsuarios.get(position);

            //define o texto no componente visual que está guardado dentro de 'holder'

            holder.tvNome.setText(nome);

        }

        //metodo 3: informa ao android quantos itens a lista possui ao todo

        @Override
        public int getItemCount(){
        //se a lista existir, retorna o tamanho. Se não, retorna zero
            return listaUsuarios != null ? listaUsuarios.size() :0;
    }

    //classe interna ViewHoloder: Servir para "segurar" as referências dos componentes de cada linha
        // evitar chamadas respectivas ao findViewById, melhorando a performance do RecycleView

        public class ViewHolder extends RecyclerView.ViewHolder{
        //referencia para o TextView da linha
            TextView tvNome;

            public ViewHolder(@NonNull View itenView){
                super(itenView);
                //faz o mapeamento do id do layout para o objeto java

                // android.R.id.text1 é o padrão do layout 'simple_list_item_1'

                tvNome = itemView.findViewById(android.R.id.text1);
            }

    }
}
