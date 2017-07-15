package com.alain.curso.firebasenuevo.domain.repository;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.User;

public interface UserRepository {
  ObservableTask<User> getUser(String userId);

  ObservableTask<Boolean> putUser(User user);
}
