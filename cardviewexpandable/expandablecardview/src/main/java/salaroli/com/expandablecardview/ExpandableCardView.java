package salaroli.com.expandablecardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ExpandableCardView extends MaterialCardView {
    private TextView primaryText, secondaryText;
    public ImageView arrow, actionOne, actionTwo;
    private boolean cardOpenStatus = true;
    private GridView grid;
    private View cardDivider, actionOneDivider, actionTwoDivider, header;

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
        header = view.findViewById(R.id.header);
        primaryText = view.findViewById(R.id.primary_text);
        secondaryText = view.findViewById(R.id.secondary_text);
        actionOne = view.findViewById(R.id.card_action_one);
        actionOneDivider = view.findViewById(R.id.card_divider_action_one);
        actionTwo = view.findViewById(R.id.card_action_two);
        actionTwoDivider = view.findViewById(R.id.card_divider_action_two);
        arrow = view.findViewById(R.id.card_arrow);
        cardDivider = view.findViewById(R.id.card_divider);
        grid = view.findViewById(R.id.card_grid_devices);

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

    public void setPrimaryText(String room) {
        primaryText.setText(room);
    }
    public void setSecondaryText(String info) {
        secondaryText.setText(info);
    }
    public void setText(String room, String info) {
        primaryText.setText(room);
        secondaryText.setText(info);
    }

    public void setDevices(List<IotDevice> devices) {
        ItemAdapter listItemAdapter = new ItemAdapter(getContext(), devices);
        grid.setAdapter(listItemAdapter);
    }

    public void enableFirstAction() {
        actionOneDivider.setVisibility(VISIBLE);
        actionOne.setVisibility(VISIBLE);
    }
    public void enableSecondAction() {
        actionTwoDivider.setVisibility(VISIBLE);
        actionTwo.setVisibility(VISIBLE);
    }

    public void disableFirstAction() {
        actionOneDivider.setVisibility(GONE);
        actionOne.setVisibility(GONE);
    }
    public void disableSecondAction() {
        actionTwoDivider.setVisibility(GONE);
        actionTwo.setVisibility(GONE);
    }


    public void setFirstAction(int firstAction) {
        actionOne.setImageResource(firstAction);
    }

    public void setSecondAction(int secondAction) {
        actionTwo.setImageResource(secondAction);
    }
}
