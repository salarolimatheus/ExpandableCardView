package salaroli.com.expandablecardview.CardView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.Transition.TransitionListener;
import androidx.transition.TransitionManager;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.R;

public class ExpandableCardView extends MaterialCardView {
    private TextView primaryText, secondaryText;
    public ImageView arrow, actionOne, actionTwo;
    private boolean cardOpenStatus = true;
    private GridView grid;
    private View cardDivider, actionOneDivider, actionTwoDivider;
    private InterfaceExpandableCardView interfaceCardView;
    private boolean noDevices = false;

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
        View header = view.findViewById(R.id.header);
        primaryText = view.findViewById(R.id.primary_text);
        secondaryText = view.findViewById(R.id.secondary_text);
        actionOne = view.findViewById(R.id.card_action_one);
        actionOneDivider = view.findViewById(R.id.card_divider_action_one);
        actionTwo = view.findViewById(R.id.card_action_two);
        actionTwoDivider = view.findViewById(R.id.card_divider_action_two);
        arrow = view.findViewById(R.id.card_arrow);
        cardDivider = view.findViewById(R.id.card_divider);
        grid = view.findViewById(R.id.card_grid_devices);
        changeIconArrow(3);
        header.setOnClickListener(this::onClickHeader);
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
        listItemAdapter.setInterfaceObjectsListener(device -> interfaceCardView.onItemSelect(device));
        if (!devices.isEmpty()) {
            noDevices = true;
            arrow.setVisibility(VISIBLE);
        }
        changeIconArrow(2);
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

    private void onClickHeader(View view) {
        if (noDevices) {
            if (cardOpenStatus) {
                grid.setVisibility(VISIBLE);
                cardDivider.setVisibility(VISIBLE);
                TransitionManager.beginDelayedTransition((ViewGroup) getParent(), new AutoTransition());
                changeIconArrow(1);
            } else {
                AutoTransition transition = new AutoTransition();
                transition.addListener(new TransitionListener() {
                    @Override
                    public void onTransitionStart(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionEnd(@NonNull Transition transition) {
                        cardDivider.setVisibility(GONE);
                    }

                    @Override
                    public void onTransitionCancel(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionPause(@NonNull Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(@NonNull Transition transition) {

                    }
                });
                TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transition);
                grid.setVisibility(GONE);
                changeIconArrow(2);
            }
        } else {
            changeIconArrow(3);
            if (interfaceCardView != null) interfaceCardView.noDevice();
        }
        cardOpenStatus = !cardOpenStatus;
    }

    private void changeIconArrow(int position) {
        if(position == 1) {
            arrow.setImageResource(R.drawable.arrow_up);
        } else if (position == 2){
            arrow.setImageResource(R.drawable.arrow_down);
        } else {
            arrow.setImageDrawable(null);
        }
    }

    public interface InterfaceExpandableCardView {
        void onItemSelect(IotDevice device);
        void noDevice();
    }
    public void setInterfaceListener(InterfaceExpandableCardView interfaceCardView) {
        this.interfaceCardView = interfaceCardView;
    }
}
