package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Comment;
import com.alain.curso.firebasenuevo.domain.repository.CommentRepository;
import java.util.List;

public class GetPhotoComments extends UseCase<String, List<Comment>> {
  private final CommentRepository commentRepository;

  public GetPhotoComments(
      UseCaseExecutor useCaseExecutor, CommentRepository commentRepository) {
    super(useCaseExecutor);
    this.commentRepository = commentRepository;
  }

  @Override public ObservableTask<List<Comment>> createObservableTask(final String photoId) {
    return commentRepository.getComments(photoId);
  }
}
