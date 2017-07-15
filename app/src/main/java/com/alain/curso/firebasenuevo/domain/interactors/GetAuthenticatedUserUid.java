package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.repository.AuthenticatedUserRepository;

public class GetAuthenticatedUserUid extends UseCase<Void, String> {
  private final AuthenticatedUserRepository authenticatedUserRepository;

  public GetAuthenticatedUserUid(UseCaseExecutor useCaseExecutor,
      AuthenticatedUserRepository authenticatedUserRepository) {
    super(useCaseExecutor);
    this.authenticatedUserRepository = authenticatedUserRepository;
  }

  @Override public ObservableTask<String> createObservableTask(Void input) {
    return authenticatedUserRepository.getUserUid();
  }
}