package com.alain.curso.firebasenuevo.data.repository.loggedUser;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;

public interface LoggedUserDataSource {
  ObservableTask<String> get();
}
