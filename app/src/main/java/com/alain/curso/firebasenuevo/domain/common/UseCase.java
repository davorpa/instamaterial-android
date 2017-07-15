package com.alain.curso.firebasenuevo.domain.common;

import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;

public abstract class UseCase<I, R> {
  protected final UseCaseExecutor useCaseExecutor;

  public UseCase(UseCaseExecutor useCaseExecutor) {
    this.useCaseExecutor = useCaseExecutor;
  }

  public final void execute(UseCaseCallback<R> callback) {
    execute(null, callback);
  }

  public final void execute(I input, UseCaseCallback<R> callback) {
    useCaseExecutor.execute(createObservableTask(input), callback);
  }

  public abstract ObservableTask<R> createObservableTask(final I input);
}
