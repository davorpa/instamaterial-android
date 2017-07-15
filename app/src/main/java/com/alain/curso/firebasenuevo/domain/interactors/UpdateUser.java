package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.User;
import com.alain.curso.firebasenuevo.domain.repository.UserRepository;

public class UpdateUser extends UseCase<User, Boolean> {
  private final UserRepository userRepository;

  public UpdateUser(UseCaseExecutor useCaseExecutor, UserRepository userRepository) {
    super(useCaseExecutor);
    this.userRepository = userRepository;
  }

  @Override public ObservableTask<Boolean> createObservableTask(User user) {
    return userRepository.putUser(user);
  }
}
