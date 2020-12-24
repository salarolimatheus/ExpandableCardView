package salaroli.com.cardviewexpandable;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import salaroli.com.expandablecardview.CardView.ExpandableCardView;
import salaroli.com.expandablecardview.IotDevice;

public class ExampleCardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examplerecyclerview);

        ExpandableCardView cardView1 = findViewById(R.id.cardview_principal);
        ExpandableCardView cardView2 = findViewById(R.id.cardview_secundario);

        List<IotDevice> devices = new ArrayList<>();
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));

        cardView1.setText("Room", "22.18 °C");
        cardView1.enableFirstAction();
        cardView1.enableSecondAction();

        cardView1.setInterfaceListener(new ExpandableCardView.InterfaceExpandableCardView() {
            @Override
            public void onItemSelect(IotDevice device) {
                Toast.makeText(getBaseContext(), device.getTextDevice(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void noDevice() {
                Toast.makeText(getBaseContext(), "No Device", Toast.LENGTH_SHORT).show();
            }
        });

        cardView1.setFirstAction(R.drawable.lamp);
        cardView1.setSecondAction(R.drawable.window_open);
        cardView1.setDevices(devices);

        cardView2.setPrimaryText("Kitchen");
        cardView2.setSecondaryText("");
        cardView2.disableFirstAction();
        cardView2.disableSecondAction();
        //cardView2.setDevices(devices);

        cardView2.setInterfaceListener(new ExpandableCardView.InterfaceExpandableCardView() {
            @Override
            public void onItemSelect(IotDevice device) {
                Toast.makeText(getBaseContext(), device.getTextDevice(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void noDevice() {
                Toast.makeText(getBaseContext(), "No Device", Toast.LENGTH_SHORT).show();
            }
        });

    }
}