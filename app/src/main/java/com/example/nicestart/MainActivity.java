package com.example.nicestart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView mycontext = (TextView) findViewById(R.id.buenas);
        registerForContextMenu(mycontext);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.myMainConstraint), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item2)
        {
            Toast toast = Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_aptbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.item1)
        {
            Toast toast = Toast.makeText(this,"Infecting",Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item2)
        {
            Toast toast2 = Toast.makeText(this,"Fixing",Toast.LENGTH_LONG);
            toast2.show();

            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    switch(item.getItemId())
    {
        case R.id.item1:
            Toast toast = Toast.makeText(this,"From copied", Toast.LENGTH_LONG);
            toast.show();
            return true;

        case R.id.item2:
            Toast toast2 = Toast.makeText(this,"Downloading item...", Toast.LENGTH_LONG);
            toast2.show();
            return true;

        default:
            return false;
    }
    */
    /*
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {

        @Override
        public void onRefresh(){

            final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);

            Snackbar snackbar = Snackbar
                    .make(mLayout,"fancy a Snack while you refresh?",Snackbar.LENGTH_SHORT)
                    .setAction("UNDO", new View.onClickListener() {
                        @Override
                        public void onClick(View view){
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!",Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();
        }
    }
    */
}