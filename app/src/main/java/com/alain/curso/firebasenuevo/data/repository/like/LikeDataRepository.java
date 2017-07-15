package com.alain.curso.firebasenuevo.data.repository.like;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Like;
import com.alain.curso.firebasenuevo.domain.repository.LikeRepository;
import java.util.List;

public class LikeDataRepository implements LikeRepository {
  private final LikeDataSource likeDataSource;

  public LikeDataRepository(LikeDataSource likeDataSource) {
    this.likeDataSource = likeDataSource;
  }

  @Override public ObservableTask<List<Like>> getLikes(String photoId) {
    return likeDataSource.getLikes(photoId);
  }

  @Override public ObservableTask<Boolean> toggleLike(Like like) {
    return likeDataSource.toggleLike(like);
  }
}
