package salaroli.com.expandablecardview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class ExpandableCardView extends MaterialCardView {
    public ImageView arrow;
    private boolean cardOpenStatus = true;
    private GridView grid;
    private View cardDivider;
    private View header;

    public ExpandableCardView(Context context) {
        super(context);
        init();
    }
    public ExpandableCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public ExpandableCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.room_card, this, true);
        arrow = view.findViewById(R.id.card_arrow);
        grid = view.findViewById(R.id.grid_devices);
        cardDivider = view.findViewById(R.id.card_divider);
        header = view.findViewById(R.id.header);

        List<IotDevice> devices = new ArrayList<IotDevice>();
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 1"));
        devices.add(new IotDevice(R.drawable.window_open, "Objeto 2"));
        devices.add(new IotDevice(R.drawable.window_semi, "Objeto 3"));
        devices.add(new IotDevice(R.drawable.window_closed, "Objeto 4"));
        devices.add(new IotDevice(R.drawable.lamp, "Objeto 5"));

        ItemAdapter listItemAdapter = new ItemAdapter(getContext(), devices);
        grid.setAdapter(listItemAdapter);

        header.setOnClickListener(view1 -> {
            if (cardOpenStatus) {
                arrow.setImageResource(R.drawable.arrow_up);
                grid.setVisibility(VISIBLE);
                cardDivider.setVisibility(VISIBLE);
            } else {
                arrow.setImageResource(R.drawable.arrow_down);
                grid.setVisibility(GONE);
                cardDivider.setVisibility(GONE);
            }
            cardOpenStatus = !cardOpenStatus;
        });
    }
}
