package salaroli.com.expandablecardview.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import salaroli.com.expandablecardview.CardView.ItemAdapter;
import salaroli.com.expandablecardview.IotDevice;
import salaroli.com.expandablecardview.R;

import static android.view.View.VISIBLE;
import static android.view.View.GONE;

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.SpaceViewHolder> {
    private List<Space> listSpace;
    private Context context;
    private InterfaceRecyclerCardView interfaceRecyclerCardView;

    public SpaceAdapter(Context context) {
        this.context = context;
    }

    public SpaceAdapter(Context context, List<Space> listSpace) {
        this.context = context;
        this.listSpace = listSpace;
    }

    public void setSpaces(List<Space> listSpace) {
        this.listSpace = listSpace;
    }

    public static class SpaceViewHolder extends RecyclerView.ViewHolder {
        private View header;
        private TextView primaryText, secondaryText;
        private ImageView arrow, actionOne, actionTwo;
        private GridView grid;
        private boolean cardOpenStatus = true;
        private View cardDivider, actionOneDivider, actionTwoDivider;
        private boolean noDevices = false;

        public SpaceViewHolder(MaterialCardView view) {
            super(view);
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
        }

    }
    @NonNull
    @Override
    public SpaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MaterialCardView cardView = (MaterialCardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.room_card, parent, false);
        SpaceViewHolder spaceViewHolder = new SpaceViewHolder(cardView);
        return spaceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceViewHolder holder, int position) {
        Space space = listSpace.get(position);
        ItemAdapter listItemAdapter = new ItemAdapter(context, space.devices);
        listItemAdapter.setInterfaceObjectsListener(device -> interfaceRecyclerCardView.onItemSelect(space, device));
        holder.grid.setAdapter(listItemAdapter);
        holder.primaryText.setText(space.nameSpace);
        holder.secondaryText.setText(space.infoSpace);
        if (space.firstAction) {
            holder.actionOneDivider.setVisibility(VISIBLE);
            holder.actionOne.setVisibility(VISIBLE);
            holder.actionOne.setImageResource(space.resourceFirstAction);
        } else {
            holder.actionOneDivider.setVisibility(GONE);
            holder.actionOne.setVisibility(GONE);
        }
        if (space.secondAction) {
            holder.actionTwoDivider.setVisibility(VISIBLE);
            holder.actionTwo.setVisibility(VISIBLE);
            holder.actionTwo.setImageResource(space.resourceSecondAction);
        } else {
            holder.actionTwoDivider.setVisibility(GONE);
            holder.actionTwo.setVisibility(GONE);
        }

        holder.header.setOnClickListener(view -> onClickHeader(holder, view, space));
        if (!space.devices.isEmpty()) {
            holder.noDevices = true;
            holder.arrow.setVisibility(VISIBLE);
        }
    }

    private void onClickHeader(@NonNull SpaceViewHolder holder, View view, Space space) {
        if (holder.noDevices) {
            if (holder.cardOpenStatus) {
                holder.grid.setVisibility(VISIBLE);
                holder.cardDivider.setVisibility(VISIBLE);
                TransitionManager.beginDelayedTransition((ViewGroup) view.getParent(), new AutoTransition());
                changeIconArrow(holder, 1);
            } else {
                holder.cardDivider.setVisibility(GONE);
                holder.grid.setVisibility(GONE);
                changeIconArrow(holder, 2);
            }
        } else {
            changeIconArrow(holder, 3);
            interfaceRecyclerCardView.noDevice(space);
        }
        holder.cardOpenStatus = !holder.cardOpenStatus;
    }

    @Override
    public int getItemCount() {
        return listSpace.size();
    }

    private void changeIconArrow(SpaceViewHolder holder, int position) {
        if(position == 1) {
            holder.arrow.setImageResource(R.drawable.arrow_up);
        } else if (position == 2){
            holder.arrow.setImageResource(R.drawable.arrow_down);
        } else {
            holder.arrow.setImageDrawable(null);
        }
    }

    public interface InterfaceRecyclerCardView {
        void onItemSelect(Space space, IotDevice device);
        void noDevice(Space space);
    }
    public void setInterfaceListener(InterfaceRecyclerCardView interfaceRecyclerCardView) {
        this.interfaceRecyclerCardView = interfaceRecyclerCardView;
    }
}
