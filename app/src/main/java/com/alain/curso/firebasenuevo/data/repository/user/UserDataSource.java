package com.alain.curso.firebasenuevo.data.repository.user;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.model.User;

public interface UserDataSource {
  ObservableTask<User> get(String userId);

  ObservableTask<Boolean> put(User user);
}
