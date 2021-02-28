package com.gus.makeandsell;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizzas extends AppCompatActivity implements IngredientFragment.onMultiChoiceListener {

    PizzaMenuAdapter pizzamenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);


        List<Pizza> listadepizzas = new ArrayList<>();
        /*SqlHelper sqlHelper = new SqlHelper(this); // ************** IMPORTANTE ****************
        listadepizzas = sqlHelper.selectAll(); // <---- COMO PEGAR SOMENTE OS DADOS DO NOME, INGREDIENTES [STRING] e escolher PREÇO?
*/

        listadepizzas.add(new Pizza("mussarela", "queijo molho oregano", "25.3"));
        listadepizzas.add(new Pizza("quatroqueijoscomrucula", "queijo gorngonzola bufala muçarela catupiry e folhas de rucula", "22.0"));

        pizzamenuAdapter = new PizzaMenuAdapter(listadepizzas);
        RecyclerView rv = findViewById(R.id.activity_pizzas_rv);
        rv.setAdapter(pizzamenuAdapter);

        findViewById(R.id.add_pizza).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MÉTODO PARA ADICIONAR AS PIZZAS
                DialogFragment multiChoiceDialog = new IngredientFragment();
                multiChoiceDialog.setCancelable(false);
                multiChoiceDialog.show(getSupportFragmentManager(), "Multichoice Dialog");

            }
        });

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHandler(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT)
        );

        helper.attachToRecyclerView(rv);
    }

    @Override
    public void onPositiveButtonClicked(String[] list, ArrayList<String> selectedItemList) {
        // RESULTADO DO CLICK APÓS SELECIONAR AS PIZZAS DO FRAGMENTO

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Selected Choices = ");
        for (String str : selectedItemList) {
            stringBuilder.append(str + " ");
        }
            // ListView.setText(stringBuilder); // <--- SAÏDA FINAL
    }

    @Override
    public void onNegativeButtonClicked() {
        // ListView.setText("Dialog Cancel"); // <--- SAÏDA FINAL
    }

    private class ItemTouchHandler extends ItemTouchHelper.SimpleCallback {

        public ItemTouchHandler(int dragDirs, int swipeDirs) {
            super(dragDirs, swipeDirs);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int from = viewHolder.getAdapterPosition();
            int to = target.getAdapterPosition();

            Collections.swap(pizzamenuAdapter.pizzas, from, to); // REVEER SE A LISTA ESTÁ SENDO MODIFICADA
            pizzamenuAdapter.notifyItemMoved(from, to);
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    }

    private static class PizzaMenuAdapter extends RecyclerView.Adapter<PizzaMenuAdapter.PizzaViewHolder> {

        private final List<Pizza> pizzas;

        public PizzaMenuAdapter(List<Pizza> pizzas) {
            this.pizzas = pizzas;
        }

        @NonNull
        @Override
        public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_pizza, parent, false);
            return new PizzaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
            Pizza pizza = pizzas.get(position);
            holder.bind(pizza);
        }

        @Override
        public int getItemCount() {
            return pizzas.size();
        }

        private static class PizzaViewHolder extends RecyclerView.ViewHolder {

            TextView pizza_icon;
            TextView pizza_name;
            TextView pizza_ing;
            TextView pizza_price;

           public PizzaViewHolder(@NonNull View itemview) {
               super(itemview);
               pizza_icon = itemview.findViewById(R.id.pizza_icon);
               pizza_name = itemview.findViewById(R.id.pizza_name);
               pizza_ing = itemview.findViewById(R.id.pizza_ing);
               pizza_price = itemview.findViewById(R.id.pizza_price);

           }

            public void bind(Pizza pizza) {
               int hash = pizza.getName_pizza().hashCode();
               pizza_icon.setText(String.valueOf(pizza.getName_pizza().charAt(0)));
               pizza_icon.setBackground(oval(Color.rgb(hash, hash/2, 0), pizza_icon));
               pizza_name.setText(pizza.getName_pizza());
               pizza_ing.setText(pizza.getIngredients());
               pizza_price.setText(pizza.getPrice());

            }

        }
        private static ShapeDrawable oval(@ColorInt int color, View view) {
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.setIntrinsicHeight(view.getHeight());
            shapeDrawable.setIntrinsicWidth(view.getWidth());
            shapeDrawable.getPaint().setColor(color);
            return shapeDrawable;

        }
    }

}
