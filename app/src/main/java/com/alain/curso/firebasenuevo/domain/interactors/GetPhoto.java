package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.repository.PhotoRepository;

public class GetPhoto extends UseCase<String, Photo> {
  private final PhotoRepository photoRepository;

  public GetPhoto(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override public ObservableTask<Photo> createObservableTask(final String photoId) {
    return photoRepository.getPhoto(photoId);
  }
}
