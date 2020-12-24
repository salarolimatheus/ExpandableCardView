package salaroli.com.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.RecyclerView.MyLinearLayoutManager;
import salaroli.com.expandablecardview.RecyclerView.Room;
import salaroli.com.expandablecardview.RecyclerView.RoomAdapter;
import salaroli.com.expandablecardview.RecyclerView.WCLinearLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<IotDevice> devices = new ArrayList<>();
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 5"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 6"));

        List<Room> listRoom = new ArrayList<>();
        listRoom.add(new Room("Bedroom", "", devices, true, true,
                R.drawable.lamp,R.drawable.window_open));
        listRoom.add(new Room("Kitchen", "", devices, false, false,  0,0));

        RoomAdapter myAdapter = new RoomAdapter(listRoom, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//    private List<IotDevice> gerarLista() {
//        ArrayList roomList = new ArrayList<>();
//        MutableList<IotDevice> devices = new ArrayList();
//
//        devices.add(IotDevice(R.drawable.lamp, "Objeto 1"))
//        devices.add(IotDevice(R.drawable.window_open, "Objeto 2"))
//        devices.add(IotDevice(R.drawable.lamp, "Objeto 3"))
//        devices.add(IotDevice(R.drawable.window_open, "Objeto 4"))
//        //devices.add(IotDevice(R.drawable.lamp, "Objeto 5"))
//        //devices.add(IotDevice(R.drawable.window_open, "Objeto 6"))
//        //devices.add(IotDevice(R.drawable.lamp, "Objeto 7"))
//        //devices.add(IotDevice(R.drawable.window_open, "Objeto 8"))
//
//        roomList += Room("Bedroom", "", devices, true, true, R.drawable.ic_baseline_scatter_plot_24, R.drawable.ic_baseline_sensor_window_24)
//        roomList += Room("Kitchen", "", devices, false, false, 0, 0)
//        return roomList
//    }
}

//ExpandableCardView cardView1 = findViewById(R.id.cardview_principal);
//        ExpandableCardView cardView2 = findViewById(R.id.cardview_secundario);
//
//        List<IotDevice> devices = new ArrayList<>();
//        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
//        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
//        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
//        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));
//
//        cardView1.setText("Room", "22.18 °C");
//        cardView1.enableFirstAction();
//        cardView1.enableSecondAction();
//
//        cardView1.setInterfaceListener(new ExpandableCardView.InterfaceExpandableCardView() {
//            @Override
//            public void onItemSelect(IotDevice device) {
//                Toast.makeText(getBaseContext(), device.getTextDevice(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void noDevice() {
//                Toast.makeText(getBaseContext(), "No Device", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        cardView1.setFirstAction(R.drawable.lamp);
//        cardView1.setSecondAction(R.drawable.window_open);
//        cardView1.setDevices(devices);
//
//        cardView2.setPrimaryText("Kitchen");
//        cardView2.setSecondaryText("");
//        cardView2.disableFirstAction();
//        cardView2.disableSecondAction();
//        //cardView2.setDevices(devices);
//
//        cardView2.setInterfaceListener(new ExpandableCardView.InterfaceExpandableCardView() {
//            @Override
//            public void onItemSelect(IotDevice device) {
//                Toast.makeText(getBaseContext(), device.getTextDevice(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void noDevice() {
//                Toast.makeText(getBaseContext(), "No Device", Toast.LENGTH_SHORT).show();
//            }
//        });