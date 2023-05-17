package com.example.wedding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Integer> imageList;
    private OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION; // Track the selected position

    public ImageAdapter(List<Integer> imageList, OnItemClickListener listener) {
        this.imageList = imageList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int imageId = imageList.get(position);
        holder.imageView.setImageResource(imageId);

        // Apply the enlarged scale to the clicked image
        if (selectedPosition == position) {
            holder.imageView.setScaleX(1.2f);
            holder.imageView.setScaleY(1.2f);
        } else {
            holder.imageView.setScaleX(1.0f);
            holder.imageView.setScaleY(1.0f);
        }

        holder.bind(imageId, listener);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        public void bind(int imageId, OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int previousPosition = selectedPosition;
                    selectedPosition = getAdapterPosition();
                    notifyItemChanged(previousPosition); // Revert the previous item to normal size
                    notifyItemChanged(selectedPosition); // Enlarge the clicked item
                    listener.onItemClick(imageList.get(selectedPosition));
                }
            });
        }

        @Override
        public void onClick(View v) {
            // Handle the click event here if needed
        }
    }

    // Listener interface
    public interface OnItemClickListener {
        void onItemClick(int imageId);
    }
}
