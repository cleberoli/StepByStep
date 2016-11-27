package com.oli.stepbystep.interfaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.oli.stepbystep.R;

import java.util.Arrays;
import java.util.List;

import objects.Recipes;

public class RecipeList extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        List<String> ingredientesbolo = Arrays.asList("3 cenouras médias raspadas e picadas","3 ovos","1 xícara de óleo","2 xícaras de açúcar","1 colher (sopa) de fermento em pó","1 pitada de sal");
        List<String> passobolo = Arrays.asList("1-Bata no liquidificador todos os ingredientes, acrescentando a farinha aos poucos.","Unte e enfarinhe uma forma de furo no meio. Despeje a massa nela. Asse em forno médio preaquecido por 40 minutos. Tire do forno, espere amornar e desenforme.");
        Recipes Bolocenou = new Recipes("Bolo de cenoura de liquidificador",ingredientesbolo,passobolo) ;
        List<String> ingredientesbolo2 = Arrays.asList("3 cenouras médias raspadas e picadas","3 ovos","1 xícara de óleo","2 xícaras de açúcar","1 colher (sopa) de fermento em pó","1 pitada de sal");
        List<String> passobolo2 = Arrays.asList("1-Bata no liquidificador todos os ingredientes, acrescentando a farinha aos poucos.","Unte e enfarinhe uma forma de furo no meio. Despeje a massa nela. Asse em forno médio preaquecido por 40 minutos. Tire do forno, espere amornar e desenforme.");
        Recipes Bolococo = new Recipes("Bolo de coco de liquidificador",ingredientesbolo2,passobolo2) ;
        List<String> ingredientesbolo3 = Arrays.asList("3 partes de uma abobora médias picada","3 ovos","1 xícara de óleo","2 xícaras de açúcar","1 colher (sopa) de fermento em pó","1 pitada de sal");
        List<String> passobolo3 = Arrays.asList("1-Bata no liquidificador todos os ingredientes, acrescentando a farinha aos poucos.","Unte e enfarinhe uma forma de furo no meio. Despeje a massa nela. Asse em forno médio preaquecido por 40 minutos. Tire do forno, espere amornar e desenforme.");
        Recipes Boloabobora = new Recipes("Bolo de abobora de liquidificador",ingredientesbolo3,passobolo3) ;
        List<Recipes> recipes = Arrays.asList(Bolocenou,Bolococo,Boloabobora);
        ArrayAdapter<Recipes> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, recipes);

        ListView lista1= (ListView) findViewById(R.id.Listareceitas);
        lista1.setAdapter(adapter);
        Button favortito = (Button) findViewById(R.id.fav);

/*        favortito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(RecipeList.this, ListaFav.class);
                startActivity(it);
            }
        });
        Button compra = (Button) findViewById(R.id.compra);

        compra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(RecipeList.this, RecipeList.class);
                startActivity(it);
            }
        });
       lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Recipes recipe =(Recipes) parent.getItemAtPosition(i);
                Intent Vaiparareceita = new Intent(RecipeList.this, DetalhesReceita.class);
                Vaiparareceita.putExtra("receita",recipe);
                startActivity(Vaiparareceita);

            }
        });*/
    }
}
