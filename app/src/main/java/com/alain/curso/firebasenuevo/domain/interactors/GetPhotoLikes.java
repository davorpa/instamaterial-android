package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Like;
import com.alain.curso.firebasenuevo.domain.repository.LikeRepository;
import java.util.List;

public class GetPhotoLikes extends UseCase<String, List<Like>> {
  private final LikeRepository likeRepository;

  public GetPhotoLikes(UseCaseExecutor useCaseExecutor, LikeRepository likeRepository) {
    super(useCaseExecutor);
    this.likeRepository = likeRepository;
  }

  @Override public ObservableTask<List<Like>> createObservableTask(final String photoId) {
    return likeRepository.getLikes(photoId);
  }
}
