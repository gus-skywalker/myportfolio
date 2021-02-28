package com.gus.makeandsell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Components extends AppCompatActivity {

    //references to buttons and other controls on the layout
    Button btn_Clear, btn_Save, btn_Delete;
    EditText edit_Code, edit_Name, edit_Qty, edit_Price;
    ListView list_View;

    ArrayAdapter ingredientArrayAdapter; //List Adapter
    SqlHelper sqlHelper;
    Ingredient ing_selected = new Ingredient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        btn_Clear = findViewById(R.id.btnClear);
        btn_Save = findViewById(R.id.btnSave);
        btn_Delete = findViewById(R.id.btnDelete);

        edit_Code = findViewById(R.id.editCode);
        edit_Name = findViewById(R.id.editName);
        edit_Qty = findViewById(R.id.editQty);
        edit_Price = findViewById(R.id.editPrice);
        list_View = findViewById(R.id.listView);

        sqlHelper = new SqlHelper(Components.this);

        ShowAllIngredients(sqlHelper);

        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ingredient content = (Ingredient) list_View.getItemAtPosition(position);
                ing_selected = content; // Put var ingredient to be used in the whole / to be deleted e.g.

                //Put data on fields
                edit_Code.setText(String.valueOf(content.getId()));
                edit_Name.setText(content.getName());
                edit_Qty.setText(String.valueOf(content.getQty()));
                edit_Price.setText(String.valueOf(content.getPrice()));

                Toast.makeText(Components.this, "Selected: " + content, Toast.LENGTH_LONG).show();

            }
        });


        //button listeners for add and view all buttons
        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_Code.setText("");
                edit_Name.setText("");
                edit_Qty.setText("");
                edit_Price.setText("");

                Toast.makeText(Components.this, "Clear button", Toast.LENGTH_SHORT).show();

           }
        });

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Ingredient ingredient; //Variável definida antes do bloco TRY/CATCH
                try {
                    ingredient = new Ingredient(-1, edit_Name.getText().toString(), Double.parseDouble(edit_Qty.getText().toString()), Double.parseDouble(edit_Price.getText().toString()));
                    Toast.makeText(Components.this, ingredient.toString(), Toast.LENGTH_SHORT).show();
               }
                catch (Exception e){
                    Toast.makeText(Components.this, "Need to fill the fields first", Toast.LENGTH_SHORT).show();
                    ingredient = new Ingredient(-1, "error", 0, 0);
                }

                SqlHelper sqlHelper = new SqlHelper(Components.this);
                boolean success = sqlHelper.addOne(ingredient);
                Toast.makeText(Components.this, "Success " + success, Toast.LENGTH_SHORT).show();

                ShowAllIngredients(sqlHelper);
            }
        });

        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String simple_check = edit_Name.getText().toString();

                if (simple_check.isEmpty()) {
                    Toast.makeText(Components.this, "Nenhum ingrediente selecionado", Toast.LENGTH_SHORT).show();
                 } else if (sqlHelper.deleteOne(ing_selected)) {
                    Toast.makeText(Components.this, "Success deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Components.this, "Error to erase", Toast.LENGTH_SHORT).show();
                }

                ShowAllIngredients(sqlHelper);
            }
        });
    }

    private void ShowAllIngredients(SqlHelper sqlHelper2) {
        ingredientArrayAdapter = new ArrayAdapter<Ingredient>(Components.this, android.R.layout.simple_list_item_1, sqlHelper2.selectAll());
        list_View.setAdapter(ingredientArrayAdapter);
    }
}
