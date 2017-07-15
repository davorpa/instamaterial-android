package com.alain.curso.firebasenuevo.data.repository.photo;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedPhoto;
import java.util.List;

public interface PhotoDataSource {
  ObservableTask<Photo> getPhoto(String photoId);

  ObservableTask<List<Photo>> getPhotos();

  ObservableTask<Photo> publishPhoto(UnpublishedPhoto unpublishedPhoto);

  ObservableTask<String> uploadPhoto(String photoUri);
}
