package salaroli.com.cardviewexpandable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.RecyclerView.Room;
import salaroli.com.expandablecardview.RecyclerView.RoomAdapter;

import android.content.Context;
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

        List<Room> listRoom = new ArrayList<>();
        listRoom.add(new Room(1, "Bedroom", "", devices, true, true,
                R.drawable.lamp,R.drawable.window_open));
        listRoom.add(new Room(2,"Kitchen", "", devices1, false, false,  0,0));

        RoomAdapter myAdapter = new RoomAdapter(this, listRoom);
        myAdapter.setInterfaceListener(new RoomAdapter.InterfaceRecyclerCardView() {
            @Override
            public void onItemSelect(Room room, IotDevice device) {
                Toast.makeText(getBaseContext(), room.nameRoom + "  " + device.getTextDevice(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void noDevice(Room room) {
                Toast.makeText(getBaseContext(), room.nameRoom + ": no devices", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}