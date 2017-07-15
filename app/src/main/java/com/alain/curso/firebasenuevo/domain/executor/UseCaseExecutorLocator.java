package com.alain.curso.firebasenuevo.domain.executor;

public interface UseCaseExecutorLocator {
  ThreadExecutor threadExecutor();

  PostExecutor postExecutor();

  UseCaseExecutor useCaseExecutor();
}
