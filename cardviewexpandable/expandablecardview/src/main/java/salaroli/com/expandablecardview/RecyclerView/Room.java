package salaroli.com.expandablecardview.RecyclerView;

import java.util.List;

import salaroli.com.expandablecardview.IotDevice;

public class Room {
    public String nameRoom;
    public String infoRoom;
    public List<IotDevice> devices;
    public boolean firstAction;
    public boolean secondAction;
    public int resourceFirstAction;
    public int resourceSecondAction;

    public Room(String nameRoom, String infoRoom, List<IotDevice> devices, boolean firstAction, boolean secondAction, int resourceFirstAction, int resourceSecondAction) {
        this.nameRoom = nameRoom;
        this.infoRoom = infoRoom;
        this.devices = devices;
        this.firstAction = firstAction;
        this.secondAction = secondAction;
        this.resourceFirstAction = resourceFirstAction;
        this.resourceSecondAction = resourceSecondAction;
    }
}
