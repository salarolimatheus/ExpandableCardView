package salaroli.com.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import salaroli.com.expandablecardview.ExpandableCardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableCardView cardView = findViewById(R.id.carview_princial);
        cardView.setPrimary

    }
}