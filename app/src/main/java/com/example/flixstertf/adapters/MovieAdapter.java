package com.example.flixstertf.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.flixstertf.R;
import com.example.flixstertf.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public interface OnClickListener{
        void onItemClicked(int position);
    }

    List<Movie> movieList;
    OnClickListener clickListener;
    Context context;

    public MovieAdapter(List<Movie> movieList, Context context, OnClickListener onClickListener) {
        this.movieList = movieList;
        this.context = context;
        this.clickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivPosterPath;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPosterPath = itemView.findViewById(R.id.ivPoster);


        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            Glide.with(context).load(movie.getPosterPath()).placeholder(R.drawable.placeholder).into(ivPosterPath);

            ivPosterPath.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClicked(getAdapterPosition());
                }
            });

        }
    }

}
