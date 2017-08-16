package com.vpaliy.domain.interactor;

import com.vpaliy.domain.executor.BaseSchedulerProvider;
import com.vpaliy.domain.model.Track;
import com.vpaliy.domain.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
@Singleton
public class GetTrack extends SingleUseCase<Track,String> {

    private Repository repository;

    @Inject
    public GetTrack(BaseSchedulerProvider schedulerProvider,
                    Repository repository){
        super(schedulerProvider);
        this.repository=repository;
    }

    @Override
    public Single<Track> buildUseCase(String id) {
        return repository.getTrackBy(id);
    }
}
