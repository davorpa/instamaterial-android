package com.alain.curso.firebasenuevo.data.repository.photo;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.Subscriber;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedPhoto;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FakePhotoDataSource implements PhotoDataSource {
  private static final String ID1 = "507f191e810c19729de860e1";
  private static final String USER_ID1 = "8d57a927b98c4add82e61ea1";
  private static final String SOURCE_URL1 = "https://pbs.twimg.com/media/B1ndmuRCEAAsH8E.jpg";
  private static final String DESCRIPTION1 =
      "Photo of the Day! Tokyo at night. Shot in Time-Lapse Mode while filming \"GoPro HERO4: The Adventure of Life 4K.\" For more: gopro.com/channel";

  private static final String ID2 = "507f191e810c19729de860e2";
  private static final String USER_ID2 = "8d57a927b98c4add82e61ea2";
  private static final String SOURCE_URL2 = "https://pbs.twimg.com/media/C6aVFT3WQAAeljd.jpg";
  private static final String DESCRIPTION2 =
      "Photo by @Wesurfoc who wrote, \"A beautiful morning in Newport Beach, made my better\"";

  private List<Photo> photos;

  public FakePhotoDataSource() {
    photos = new LinkedList<>(Arrays.asList(
        createPhoto(ID1, USER_ID1, System.currentTimeMillis(), SOURCE_URL1, DESCRIPTION1),
        createPhoto(ID2, USER_ID2, System.currentTimeMillis(), SOURCE_URL2, DESCRIPTION2)
    ));
  }

  @Override public ObservableTask<Photo> getPhoto(final String photoId) {
    return new ObservableTask<Photo>() {
      @Override public void run(Subscriber<Photo> result) {
        for (Photo photo : photos) {
          if (photo.getId().equals(photoId)) {
            result.onSuccess(photo);
            break;
          }
        }
      }
    };
  }

  @Override public ObservableTask<List<Photo>> getPhotos() {
    return new ObservableTask<List<Photo>>() {
      @Override public void run(Subscriber<List<Photo>> result) {
        result.onSuccess(photos);
      }
    };
  }

  @Override public ObservableTask<Photo> publishPhoto(final UnpublishedPhoto unpublishedPhoto) {
    return new ObservableTask<Photo>() {
      @Override public void run(Subscriber<Photo> result) {
        Photo photo = Photo.Builder()
            .id(String.valueOf(System.nanoTime()))
            .userId(unpublishedPhoto.getUserId())
            .sourceUrl(unpublishedPhoto.getPhotoUri())
            .description(unpublishedPhoto.getDescription())
            .build();
        photos.add(0, photo);
        result.onSuccess(photo);
      }
    };
  }

  @Override public ObservableTask<String> uploadPhoto(final String photoUri) {
    return new ObservableTask<String>() {
      @Override public void run(Subscriber<String> result) {
        result.onSuccess(photoUri);
      }
    };
  }

  private Photo createPhoto(
      String id, String userId, long timestamp, String sourceUrl, String description) {
    return Photo.Builder()
        .id(id)
        .userId(userId)
        .sourceUrl(sourceUrl)
        .description(description)
        .build();
  }
}
