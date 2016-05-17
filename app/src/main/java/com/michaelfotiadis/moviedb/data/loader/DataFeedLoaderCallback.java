package com.michaelfotiadis.moviedb.data.loader;

import android.os.Parcelable;

import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;

import java.util.List;

/**
 *
 */
public interface DataFeedLoaderCallback<T extends Parcelable> {

    void onError(final UiDataLoadError error);

    void onSuccess(final List<T> result);
}
