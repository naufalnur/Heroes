package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.activitymain_rv);
        rvHero.setHasFixedSize(true);

        HeroesAdapter heroesAdapter = new HeroesAdapter(HeroesData.getHeroList(), getApplicationContext());
        rvHero.setLayoutManager(new LinearLayoutManager( this));
        rvHero.setAdapter(heroesAdapter);
    }
}
