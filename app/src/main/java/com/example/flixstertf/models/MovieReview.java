package com.example.flixstertf.models;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieReview {

    String author;
    String avatar_path;
    String content;
    String createdAt;

    public MovieReview(JSONObject jsonObject) throws JSONException {
        this.author = jsonObject.getString("author");
        this.avatar_path = jsonObject.getString("avatar_path");
        this.content = jsonObject.getString("content");
        this.createdAt = jsonObject.getString("createdAt");
    }

    public String getAuthor() {
        return author;
    }

    public String getAvatar_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", avatar_path);
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
