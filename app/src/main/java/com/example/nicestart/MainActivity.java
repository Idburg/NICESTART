package com.example.nicestart;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView bFinger = findViewById(R.id.profile);

        Glide.with(this)
                .load("https://as2.ftcdn.net/v2/jpg/00/65/21/89/1000_F_65218950_8gGgy60Q1BFQvz13RLAJOCBtydFwJxFH.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                //.centerCrop()
                .circleCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(bFinger);


    }
}