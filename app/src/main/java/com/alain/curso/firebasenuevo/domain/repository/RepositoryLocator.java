package com.alain.curso.firebasenuevo.domain.repository;

public interface RepositoryLocator {
  PhotoRepository photoRepository();

  UserRepository userRepository();

  LikeRepository likeRepository();

  CommentRepository commentRepository();

  AuthenticatedUserRepository loggedUserRepository();
}
