package com.alain.curso.firebasenuevo.data.repository.user;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.User;
import com.alain.curso.firebasenuevo.domain.repository.UserRepository;

public class UserDataRepository implements UserRepository {
  private final UserDataSource userDataSource;

  public UserDataRepository(UserDataSource userDataSource) {
    this.userDataSource = userDataSource;
  }

  @Override public ObservableTask<User> getUser(String userId) {
    return userDataSource.get(userId);
  }

  @Override public ObservableTask<Boolean> putUser(User user) {
    return userDataSource.put(user);
  }
}
