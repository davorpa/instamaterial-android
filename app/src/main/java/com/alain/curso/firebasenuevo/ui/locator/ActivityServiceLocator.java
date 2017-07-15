package com.alain.curso.firebasenuevo.ui.locator;

import android.support.v4.app.FragmentActivity;
import com.alain.curso.firebasenuevo.data.locator.DataServiceLocator;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.interactors.GetAuthenticatedUserUid;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhoto;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhotoComments;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhotoLikes;
import com.alain.curso.firebasenuevo.domain.interactors.GetPhotos;
import com.alain.curso.firebasenuevo.domain.interactors.GetUser;
import com.alain.curso.firebasenuevo.domain.interactors.InteractorLocator;
import com.alain.curso.firebasenuevo.domain.interactors.LikePhoto;
import com.alain.curso.firebasenuevo.domain.interactors.PublishComment;
import com.alain.curso.firebasenuevo.domain.interactors.PublishPhoto;
import com.alain.curso.firebasenuevo.domain.interactors.UpdateUser;
import com.alain.curso.firebasenuevo.domain.interactors.UploadPhoto;
import com.alain.curso.firebasenuevo.domain.repository.RepositoryLocator;
import com.alain.curso.firebasenuevo.ui.activity.comments.CommentsPresenter;
import com.alain.curso.firebasenuevo.ui.activity.comments.CommentsPresenterLocator;
import com.alain.curso.firebasenuevo.ui.activity.main.MainPresenter;
import com.alain.curso.firebasenuevo.ui.activity.main.MainPresenterLocator;
import com.alain.curso.firebasenuevo.ui.activity.publish.PublishPresenter;
import com.alain.curso.firebasenuevo.ui.activity.publish.PublishPresenterLocator;
import com.alain.curso.firebasenuevo.ui.orchestrator.GetCommentItem;
import com.alain.curso.firebasenuevo.ui.orchestrator.GetCommentItems;
import com.alain.curso.firebasenuevo.ui.orchestrator.GetFeedItem;
import com.alain.curso.firebasenuevo.ui.orchestrator.GetFeedItems;
import com.alain.curso.firebasenuevo.ui.orchestrator.OrchestratorLocator;

public class ActivityServiceLocator
    implements MainPresenterLocator, PublishPresenterLocator, CommentsPresenterLocator,
    InteractorLocator, OrchestratorLocator {

  private MainPresenter mainPresenter;
  private PublishPresenter publishPresenter;
  private CommentsPresenter commentsPresenter;
  private GetPhoto getPhoto;
  private GetPhotos getPhotos;
  private GetUser getUser;
  private UpdateUser updateUser;
  private GetPhotoLikes getPhotoLikes;
  private GetPhotoComments getPhotoComments;
  private LikePhoto likePhoto;
  private GetAuthenticatedUserUid getAuthenticatedUserUid;
  private PublishPhoto publishPhoto;
  private UploadPhoto uploadPhoto;
  private PublishComment publishComment;
  private GetFeedItem getFeedItem;
  private GetFeedItems getFeedItems;
  private GetCommentItems getCommentItems;
  private GetCommentItem getCommentItem;

  @Override public MainPresenter mainPresenter(FragmentActivity activity) {
    if (mainPresenter == null) {
      mainPresenter =
          new MainPresenter(getLoggedUser(), getFeedItem(), getFeedItems(), likePhoto());
    }
    return mainPresenter;
  }

  @Override public PublishPresenter publishPresenter() {
    if (publishPresenter == null) {
      publishPresenter = new PublishPresenter(getLoggedUser(), publishPhoto());
    }
    return publishPresenter;
  }

  @Override public CommentsPresenter commentsPresenter() {
    if (commentsPresenter == null) {
      commentsPresenter =
          new CommentsPresenter(getCommentItems(), getLoggedUser(), publishComment(),
              getCommentItem());
    }
    return commentsPresenter;
  }

  @Override public GetPhoto getPhoto() {
    if (getPhoto == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getPhoto = new GetPhoto(useCaseExecutor(), repositoryLocator.photoRepository());
    }
    return getPhoto;
  }

  @Override public GetPhotos getPhotos() {
    if (getPhotos == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getPhotos = new GetPhotos(useCaseExecutor(), repositoryLocator.photoRepository());
    }
    return getPhotos;
  }

  @Override public GetUser getUser() {
    if (getUser == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getUser = new GetUser(useCaseExecutor(), repositoryLocator.userRepository());
    }
    return getUser;
  }

  @Override public UpdateUser updateUser() {
    if (updateUser == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      updateUser = new UpdateUser(useCaseExecutor(), repositoryLocator.userRepository());
    }
    return updateUser;
  }

  @Override public GetPhotoLikes getPhotoLikes() {
    if (getPhotoLikes == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getPhotoLikes = new GetPhotoLikes(useCaseExecutor(), repositoryLocator.likeRepository());
    }
    return getPhotoLikes;
  }

  @Override public GetPhotoComments getPhotoComments() {
    if (getPhotoComments == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getPhotoComments =
          new GetPhotoComments(useCaseExecutor(), repositoryLocator.commentRepository());
    }
    return getPhotoComments;
  }

  @Override public LikePhoto likePhoto() {
    if (likePhoto == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      likePhoto = new LikePhoto(useCaseExecutor(), repositoryLocator.likeRepository());
    }
    return likePhoto;
  }

  @Override public GetAuthenticatedUserUid getLoggedUser() {
    if (getAuthenticatedUserUid == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      getAuthenticatedUserUid =
          new GetAuthenticatedUserUid(useCaseExecutor(), repositoryLocator.loggedUserRepository());
    }
    return getAuthenticatedUserUid;
  }

  @Override public PublishPhoto publishPhoto() {
    if (publishPhoto == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      publishPhoto =
          new PublishPhoto(useCaseExecutor(), uploadPhoto(), repositoryLocator.photoRepository());
    }
    return publishPhoto;
  }

  @Override public UploadPhoto uploadPhoto() {
    if (uploadPhoto == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      uploadPhoto = new UploadPhoto(useCaseExecutor(), repositoryLocator.photoRepository());
    }
    return uploadPhoto;
  }

  @Override public PublishComment publishComment() {
    if (publishComment == null) {
      RepositoryLocator repositoryLocator = DataServiceLocator.getInstance();
      publishComment = new PublishComment(useCaseExecutor(), repositoryLocator.commentRepository());
    }
    return publishComment;
  }

  @Override public GetFeedItem getFeedItem() {
    if (getFeedItem == null) {
      getFeedItem = new GetFeedItem(useCaseExecutor(), getPhoto(), getUser(), getPhotoLikes());
    }
    return getFeedItem;
  }

  @Override public GetFeedItems getFeedItems() {
    if (getFeedItems == null) {
      getFeedItems = new GetFeedItems(useCaseExecutor(), getPhotos(), getFeedItem());
    }
    return getFeedItems;
  }

  @Override public GetCommentItems getCommentItems() {
    if (getCommentItems == null) {
      getCommentItems = new GetCommentItems(useCaseExecutor(),
          getPhotoComments(), getCommentItem());
    }
    return getCommentItems;
  }

  @Override public GetCommentItem getCommentItem() {
    if (getCommentItem == null) {
      getCommentItem = new GetCommentItem(useCaseExecutor(), getUser());
    }
    return getCommentItem;
  }

  private UseCaseExecutor useCaseExecutor() {
    return AppServiceLocator.getInstance().useCaseExecutor();
  }
}
