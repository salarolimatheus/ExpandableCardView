package salaroli.com.expandablecardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.button.MaterialButton;

import java.util.List;

class ItemAdapter extends BaseAdapter {
    private final List<IotDevice> devices;
    private final Context context;

    public ItemAdapter(Context context, List<IotDevice> devices) {
        this.context = context;
        this.devices = devices;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return devices.get(position).getIdDevice();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        IotDevice device = devices.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.device_item, viewGroup, false);

        MaterialButton materialButton = view.findViewById(R.id.button);
        materialButton.setIcon(context.getResources().getDrawable(device.getResourceIconDevice()));
        materialButton.setText(device.getTextDevice());
        return view;
    }
}