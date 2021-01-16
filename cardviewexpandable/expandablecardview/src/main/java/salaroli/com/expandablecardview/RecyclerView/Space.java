package salaroli.com.expandablecardview.RecyclerView;

import java.util.List;

import salaroli.com.expandablecardview.IotDevice;

public class Space {
    public int idSpace;
    public String nameSpace;
    public String infoSpace;
    public List<IotDevice> devices;
    public boolean firstAction;
    public boolean secondAction;
    public int resourceFirstAction;
    public int resourceSecondAction;

    public Space(int idSpace, String nameSpace, String infoSpace, List<IotDevice> devices, boolean firstAction, boolean secondAction, int resourceFirstAction, int resourceSecondAction) {
        this.idSpace = idSpace;
        this.nameSpace = nameSpace;
        this.infoSpace = infoSpace;
        this.devices = devices;
        this.firstAction = firstAction;
        this.secondAction = secondAction;
        this.resourceFirstAction = resourceFirstAction;
        this.resourceSecondAction = resourceSecondAction;
    }
}
