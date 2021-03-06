package com.michaelfotiadis.moviedb.core.data.parsers.gson;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.configuration.ConfigurationImpl;
import com.michaelfotiadis.moviedb.common.models.configuration.Images;
import com.michaelfotiadis.moviedb.common.models.configuration.ImagesImpl;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainerImpl;
import com.michaelfotiadis.moviedb.common.models.genre.GenreImpl;
import com.michaelfotiadis.moviedb.common.models.guest.GuestSession;
import com.michaelfotiadis.moviedb.common.models.guest.GuestSessionImpl;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.common.models.movies.MovieImpl;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainerImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.BelongsToCollection;
import com.michaelfotiadis.moviedb.common.models.movies.details.BelongsToCollectionImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetailsImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompany;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompanyImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCountry;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCountryImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.SpokenLanguage;
import com.michaelfotiadis.moviedb.common.models.movies.details.SpokenLanguageImpl;
import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.common.models.people.KnownForImpl;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainerImpl;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.common.models.people.PersonImpl;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainerImpl;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesImpl;
import com.michaelfotiadis.moviedb.common.models.tv.details.CreatedBy;
import com.michaelfotiadis.moviedb.common.models.tv.details.CreatedByImpl;
import com.michaelfotiadis.moviedb.common.models.tv.details.Network;
import com.michaelfotiadis.moviedb.common.models.tv.details.NetworkImpl;
import com.michaelfotiadis.moviedb.common.models.tv.details.Season;
import com.michaelfotiadis.moviedb.common.models.tv.details.SeasonImpl;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetailsImpl;

import java.util.HashSet;
import java.util.Set;

/* package */ final class TypeAdapterFactoryCreator {

    private static final String JSON_TYPE_FIELD = "gsonObjectType";
    private final Set<RuntimeTypeAdapterFactory> adapters;
    private final Set<Class<?>> baseTypes = new HashSet<>();
    private final Set<Class<?>> subTypes = new HashSet<>();

    public TypeAdapterFactoryCreator() {
        adapters = new HashSet<>();

        // add pairings for interface - implementation
        adapters.add(create(GuestSession.class, GuestSessionImpl.class));
        adapters.add(create(Movie.class, MovieImpl.class));
        adapters.add(create(MoviesContainer.class, MoviesContainerImpl.class));
        adapters.add(create(KnownFor.class, KnownForImpl.class));
        adapters.add(create(Person.class, PersonImpl.class));
        adapters.add(create(PeopleContainer.class, PeopleContainerImpl.class));
        adapters.add(create(TvSeries.class, TvSeriesImpl.class));
        adapters.add(create(TvSeriesContainer.class, TvSeriesContainerImpl.class));
        adapters.add(create(Images.class, ImagesImpl.class));
        adapters.add(create(Configuration.class, ConfigurationImpl.class));
        adapters.add(create(Genre.class, GenreImpl.class));
        adapters.add(create(GenreContainer.class, GenreContainerImpl.class));
        adapters.add(create(MovieDetails.class, MovieDetailsImpl.class));
        adapters.add(create(ProductionCompany.class, ProductionCompanyImpl.class));
        adapters.add(create(ProductionCountry.class, ProductionCountryImpl.class));
        adapters.add(create(SpokenLanguage.class, SpokenLanguageImpl.class));
        adapters.add(create(BelongsToCollection.class, BelongsToCollectionImpl.class));
        adapters.add(create(CreatedBy.class, CreatedByImpl.class));
        adapters.add(create(Network.class, NetworkImpl.class));
        adapters.add(create(Season.class, SeasonImpl.class));
        adapters.add(create(TvSeriesDetails.class, TvSeriesDetailsImpl.class));

    }

    private <T> RuntimeTypeAdapterFactory create(final Class<T> baseType,
                                                 final Class<? extends T> subType) {
        final String subTypeName = subType.getSimpleName();

        if (!baseTypes.add(baseType)) {
            throw new IllegalStateException("You have already added BaseType " + baseType.getName());
        }

        if (!subTypes.add(subType)) {
            throw new IllegalStateException("You have already added SubType " + subType.getName());
        }

        return RuntimeTypeAdapterFactory
                .of(baseType, subTypeName, JSON_TYPE_FIELD)
                .registerSubtype(subType, subTypeName);
    }


    /**
     * Generates a collection of {@link RuntimeTypeAdapterFactory}
     *
     * @return {@link Set} of {@link RuntimeTypeAdapterFactory}
     */
    public Set<RuntimeTypeAdapterFactory> getAdapters() {
        return adapters;
    }

}