package com.alain.curso.firebasenuevo.domain.repository;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;

public interface AuthenticatedUserRepository {
  ObservableTask<String> getUserUid();
}
