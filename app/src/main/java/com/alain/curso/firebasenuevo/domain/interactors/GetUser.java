package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.User;
import com.alain.curso.firebasenuevo.domain.repository.UserRepository;

public class GetUser extends UseCase<String, User> {
  private final UserRepository userRepository;

  public GetUser(UseCaseExecutor useCaseExecutor, UserRepository userRepository) {
    super(useCaseExecutor);
    this.userRepository = userRepository;
  }

  @Override public ObservableTask<User> createObservableTask(final String userId) {
    return userRepository.getUser(userId);
  }
}
