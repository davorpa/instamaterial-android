package com.alain.curso.firebasenuevo.data.repository.comment;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.Comment;
import com.alain.curso.firebasenuevo.domain.model.UnpublishedComment;
import java.util.List;

public interface CommentDataSource {
  ObservableTask<List<Comment>> getComments(String photoId);

  ObservableTask<Comment> publishComment(UnpublishedComment unpublishedComment);
}
