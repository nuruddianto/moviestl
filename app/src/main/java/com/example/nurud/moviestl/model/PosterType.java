package com.example.nurud.moviestl.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nurud on 01/01/2017.
 */

public class PosterType {

    public String mPosterTypeName;
    public List<Movie> mMovies = new ArrayList<Movie>();

    public PosterType(String posterTypeName, List<Movie> movies) {
        this.mPosterTypeName = posterTypeName;
        this.mMovies = movies;
    }
}
