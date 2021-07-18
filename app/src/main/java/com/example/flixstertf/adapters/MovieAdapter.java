package com.example.flixstertf.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixstertf.DetailsActivity;
import com.example.flixstertf.R;
import com.example.flixstertf.models.Movie;
import com.example.flixstertf.models.MovieReview;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.List;
import java.util.Objects;

import okhttp3.Headers;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<Movie> movieList;
    Context context;
    public static String GET_MOVIE = "https://api.themoviedb.org/3/movie/";

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;

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

//                    String GET_MOVIE_REVIEWS = GET_MOVIE + movie.getId() + "/reviews?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
//                    AsyncHttpClient client = new AsyncHttpClient();
//
//                    client.get(GET_MOVIE_REVIEWS, new JsonHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Headers headers, JSON json) {
//                        JSONObject jsonObject = json.jsonObject;
//
//                        JSONArray jsonArray = null;
//                        try {
//                            jsonArray = jsonObject.getJSONArray("results");
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                        for(int i = 0; i < Objects.requireNonNull(jsonArray).length(); i++){
//
//                            try {
//                                MovieReview movieReview = new MovieReview(jsonArray.getJSONObject(i));
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//                        Log.e("Adapter", "onFailure");
//                    }
//
//                });

                    Intent i = new Intent(context, DetailsActivity.class);
                    i.putExtra("movie", Parcels.wrap(movie));
                    context.startActivity(i);

                }
            });



        }
    }

}
