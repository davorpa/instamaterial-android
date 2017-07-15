package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.repository.PhotoRepository;

public class UploadPhoto extends UseCase<String, String> {
  private final PhotoRepository photoRepository;

  public UploadPhoto(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override public ObservableTask<String> createObservableTask(String localPhotoUri) {
    return photoRepository.uploadPhoto(localPhotoUri);
  }
}
