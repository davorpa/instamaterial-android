package com.alain.curso.firebasenuevo.domain.repository;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Like;
import java.util.List;

public interface LikeRepository {
  ObservableTask<List<Like>> getLikes(String photoId);

  ObservableTask<Boolean> toggleLike(Like like);
}
