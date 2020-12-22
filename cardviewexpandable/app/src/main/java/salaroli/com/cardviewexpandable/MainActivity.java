package salaroli.com.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import salaroli.com.expandablecardview.ExpandableCardView;
import salaroli.com.expandablecardview.IotDevice;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableCardView cardView = findViewById(R.id.cardview_principal);

        List<IotDevice> devices = new ArrayList<>();
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));

        cardView.setText("Room", "22.18 °C");
        cardView.enableFirstAction();
        cardView.enableSecondAction();

        cardView.setFirstAction(R.drawable.lamp);
        cardView.setSecondAction(R.drawable.window_open);

        cardView.setDevices(devices);
        //cardView.setPrimaryText("Room");
        //cardView.setSecondaryText("22.1 °C");
    }
}