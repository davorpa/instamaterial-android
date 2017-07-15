package com.alain.curso.firebasenuevo.domain.repository;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Comment;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedComment;
import java.util.List;

public interface CommentRepository {
  ObservableTask<List<Comment>> getComments(String photoId);

  ObservableTask<Comment> publishComment(UnpublishedComment unpublishedComment);
}
