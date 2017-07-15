package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Like;
import com.alain.curso.firebasenuevo.domain.repository.LikeRepository;

public class LikePhoto extends UseCase<Like, Boolean> {
  private final LikeRepository likeRepository;

  public LikePhoto(UseCaseExecutor useCaseExecutor, LikeRepository likeRepository) {
    super(useCaseExecutor);
    this.likeRepository = likeRepository;
  }

  @Override public ObservableTask<Boolean> createObservableTask(final Like like) {
    return likeRepository.toggleLike(like);
  }
}