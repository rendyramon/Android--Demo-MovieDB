package com.michaelfotiadis.moviedb.common.models.people;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface KnownFor extends AppModel, WithLongId {
    Boolean getAdult();

    String getBackdropPath();

    String getMediaType();

    String getOriginalTitle();

    Float getPopularity();

    String getPosterPath();

    String getReleaseDate();

    String getTitle();

    Float getVoteAverage();

    Integer getVoteCount();
}
