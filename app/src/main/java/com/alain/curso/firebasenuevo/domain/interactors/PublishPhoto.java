package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.Subscriber;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedPhoto;
import com.alain.curso.firebasenuevo.domain.repository.PhotoRepository;

public class PublishPhoto extends UseCase<UnpublishedPhoto, Photo> {
  private final UploadPhoto uploadPhoto;
  private final PhotoRepository photoRepository;

  public PublishPhoto(UseCaseExecutor useCaseExecutor, UploadPhoto uploadPhoto,
      PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.uploadPhoto = uploadPhoto;
    this.photoRepository = photoRepository;
  }

  @Override public ObservableTask<Photo> createObservableTask(final UnpublishedPhoto unpublishedPhoto) {
    return new ObservableTask<Photo>() {
      @Override public void run(Subscriber<Photo> result) {
        String photoUri = uploadPhoto.createObservableTask(unpublishedPhoto.getPhotoUri()).getResult();
        photoRepository.publishPhoto(unpublishedPhoto.withPhotoUri(photoUri)).run(result);
      }
    };
  }
}
