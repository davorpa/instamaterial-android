package com.alain.curso.firebasenuevo.ui.orchestrator;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.Subscriber;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhoto;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhotoLikes;
import com.alain.curso.firebasenuevo.domain.interactors.GetUser;
import com.alain.curso.firebasenuevo.domain.model.Like;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.model.User;
import com.alain.curso.firebasenuevo.ui.model.FeedItem;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class GetFeedItem extends UseCase<String, FeedItem> {
  private final GetPhoto getPhoto;
  private final GetUser getUser;
  private final GetPhotoLikes getPhotoLikes;

  public GetFeedItem(UseCaseExecutor useCaseExecutor,
      GetPhoto getPhoto, GetUser getUser, GetPhotoLikes getPhotoLikes) {
    super(useCaseExecutor);
    this.getPhoto = getPhoto;
    this.getUser = getUser;
    this.getPhotoLikes = getPhotoLikes;
  }

  @Override public ObservableTask<FeedItem> createObservableTask(final String photoId) {
    return new ObservableTask<FeedItem>() {
      @Override public void run(Subscriber<FeedItem> result) {
        Photo photo = getPhoto.createObservableTask(photoId).getResult();
        User user = getUser.createObservableTask(photo.getUserId()).getResult();
        if (photoId != null && user != null) {
          List<String> userLikes = getPhotoLikes(photo.getId());
          result.onSuccess(FeedItem.Builder()
              .photoId(photo.getId())
              .photoSourceUrl(photo.getSourceUrl())
              .photoDescription(photo.getDescription())
              .userId(user.getId())
              .userNickname(user.getUsername())
              .userAvatarUrl(user.getPhotoUrl())
              .userLikes(userLikes)
              .build());
        } else {
          result.onError(new NoSuchElementException());
        }
      }
    };
  }

  private List<String> getPhotoLikes(String photoId) {
    List<String> result = new LinkedList<>();
    List<Like> likes = getPhotoLikes.createObservableTask(photoId).getResult();
    if (likes != null) {
      for (Like like : likes) {
        result.add(like.getUserId());
      }
    }
    return result;
  }
}
