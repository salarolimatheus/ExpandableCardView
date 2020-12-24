package salaroli.com.expandablecardview.CardView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import androidx.core.content.ContextCompat;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.R;

public class ItemAdapter extends BaseAdapter {
    private final List<IotDevice> devices;
    private final Context context;
    private InterfaceObjects interfaceObjects;

    public ItemAdapter(Context context, List<IotDevice> devices) {
        this.context = context;
        this.devices = devices;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public IotDevice getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return devices.get(position).getIdDevice();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        IotDevice device = devices.get(position);
        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.device_item, viewGroup, false);
        }
        MaterialButton materialButton = view.findViewById(R.id.button);
        materialButton.setIcon(ContextCompat.getDrawable(context, device.getResourceIconDevice()));
        materialButton.setText(device.getTextDevice());

        materialButton.setOnClickListener(viewButton -> interfaceObjects.callObject(device));
        return view;
    }

    public interface InterfaceObjects {
        void callObject(IotDevice device);
    }
    public void setInterfaceObjectsListener(InterfaceObjects interfaceObjects) {
        this.interfaceObjects = interfaceObjects;
    }
}