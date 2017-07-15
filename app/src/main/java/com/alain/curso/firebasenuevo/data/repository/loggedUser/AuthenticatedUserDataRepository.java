package com.alain.curso.firebasenuevo.data.repository.loggedUser;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.repository.AuthenticatedUserRepository;

public class AuthenticatedUserDataRepository implements AuthenticatedUserRepository {
  private final LoggedUserDataSource loggedUserDataSource;

  public AuthenticatedUserDataRepository(LoggedUserDataSource loggedUserDataSource) {
    this.loggedUserDataSource = loggedUserDataSource;
  }

  @Override public ObservableTask<String> getUserUid() {
    return loggedUserDataSource.get();
  }
}
