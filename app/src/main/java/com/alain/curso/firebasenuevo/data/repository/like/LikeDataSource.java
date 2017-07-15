package com.alain.curso.firebasenuevo.data.repository.like;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Like;
import java.util.List;

public interface LikeDataSource {
  ObservableTask<List<Like>> getLikes(String photoId);

  ObservableTask<Boolean> toggleLike(Like like);
}
