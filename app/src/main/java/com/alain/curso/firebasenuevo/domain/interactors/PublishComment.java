package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Comment;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedComment;
import com.alain.curso.firebasenuevo.domain.repository.CommentRepository;

public class PublishComment extends UseCase<UnpublishedComment, Comment> {
  private final CommentRepository commentRepository;

  public PublishComment(UseCaseExecutor useCaseExecutor, CommentRepository commentRepository) {
    super(useCaseExecutor);
    this.commentRepository = commentRepository;
  }

  @Override
  public ObservableTask<Comment> createObservableTask(final UnpublishedComment unpublishedComment) {
    return commentRepository.publishComment(unpublishedComment);
  }
}
