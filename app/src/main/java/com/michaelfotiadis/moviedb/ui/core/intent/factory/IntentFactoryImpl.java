package com.michaelfotiadis.moviedb.ui.core.intent.factory;

import android.content.Context;
import android.content.Intent;

import com.michaelfotiadis.moviedb.ui.components.home.HomeActivity;
import com.michaelfotiadis.moviedb.ui.components.moviedetails.MovieDetailsActivity;
import com.michaelfotiadis.moviedb.ui.components.seriesdetails.TvSeriesDetailsActivity;


/**
 *
 */
public class IntentFactoryImpl implements IntentFactory {

    private final Context mContext;

    public IntentFactoryImpl(final Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public Intent getMovieDetailsIntent(final String id) {
        return MovieDetailsActivity.getInstance(mContext, id);
    }

    @Override
    public Intent getHomeIntent() {
        final Intent intent = HomeActivity.getInstance(mContext);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public Intent getTvSeriesDetailsIntent(final String id) {
        return TvSeriesDetailsActivity.getInstance(mContext, id);
    }
}
