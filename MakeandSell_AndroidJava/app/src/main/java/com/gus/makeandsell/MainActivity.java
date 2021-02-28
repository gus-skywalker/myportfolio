package com.gus.makeandsell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.baseline_assignment_red_300_24dp, R.string.components, 0));
        mainItems.add(new MainItem(2, R.drawable.baseline_assignment_red_300_24dp, R.string.pizzas, 0));
        mainItems.add(new MainItem(3, R.drawable.baseline_assignment_red_300_24dp, R.string.calc, 0));

        MainAdapter mainAdapter = new MainAdapter(this, mainItems);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2 ));
    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder>
            implements MainViewHolder.OnItemClickLister {

        private final ArrayList<MainItem> mainItems;
        private final MainActivity activity;

        MainAdapter(MainActivity activity, ArrayList<MainItem> mainItems) {
            this.activity = activity;
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item_main, parent, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
            MainItem mainItem = this.mainItems.get(position);
            mainViewHolder.bind(mainItem, this);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        @Override
        public void onClick(int position) {
            MainItem mainItem = this.mainItems.get(position);
            switch (mainItem.getId()) {
                case 1: {
                    Intent intent = new Intent(activity, Components.class);
                    activity.startActivity(intent);
                }
                break;
                case 2: {
                    Intent intent = new Intent(activity, Pizzas.class);
                    activity.startActivity(intent);
                }
                break;
                case 3: {
                    Intent intent = new Intent(activity, Calc.class);
                    activity.startActivity(intent);
                } break;
            }
        }
    }

    private static class MainViewHolder extends RecyclerView.ViewHolder {

        interface OnItemClickLister {
            void onClick(int position);
        }

        private final ImageView imgViewMain;
        private final TextView imgViewText;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewMain = itemView.findViewById(R.id.item_main_img);
            imgViewText = itemView.findViewById(R.id.item_main_text);
        }

        public void bind(MainItem mainItem, final OnItemClickLister listener) {
            itemView.setBackgroundColor(mainItem.getColorValue());
            imgViewMain.setImageResource(mainItem.getImgId());
            imgViewText.setText(mainItem.getTextId());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }
}
