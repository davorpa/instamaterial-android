package com.alain.curso.firebasenuevo.data.repository.comment;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Comment;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedComment;
import com.alain.curso.firebasenuevo.domain.repository.CommentRepository;
import java.util.List;

public class CommentDataRepository implements CommentRepository {
  private final CommentDataSource commentDataSource;

  public CommentDataRepository(CommentDataSource commentDataSource) {
    this.commentDataSource = commentDataSource;
  }

  @Override public ObservableTask<List<Comment>> getComments(String photoId) {
    return commentDataSource.getComments(photoId);
  }

  @Override public ObservableTask<Comment> publishComment(UnpublishedComment unpublishedComment) {
    return commentDataSource.publishComment(unpublishedComment);
  }
}
