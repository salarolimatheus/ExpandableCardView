package salaroli.com.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.RecyclerView.Space;
import salaroli.com.expandablecardview.RecyclerView.SpaceAdapter;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExampleRecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examplerecyclerview);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<IotDevice> devices = new ArrayList<>();
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 5"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 6"));

        List<IotDevice> devices1 = new ArrayList<>();
        //devices1.add(new IotDevice(R.drawable.window_semi, "Objeto 1"));
        //devices1.add(new IotDevice(R.drawable.window_closed, "Objeto 2"));

        List<Space> listSpace = new ArrayList<>();
        listSpace.add(new Space(1, "Bedroom", "", devices, true, true,
                R.drawable.lamp,R.drawable.window_open));
        listSpace.add(new Space(2,"Kitchen", "", devices1, false, false,  0,0));

        SpaceAdapter myAdapter = new SpaceAdapter(this, listSpace);
        myAdapter.setInterfaceListener(new SpaceAdapter.InterfaceRecyclerCardView() {
            @Override
            public void onItemSelect(Space space, IotDevice device) {
                Toast.makeText(getBaseContext(), space.nameSpace + "  " + device.getTextDevice(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void noDevice(Space space) {
                Toast.makeText(getBaseContext(), space.nameSpace + ": no devices", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}