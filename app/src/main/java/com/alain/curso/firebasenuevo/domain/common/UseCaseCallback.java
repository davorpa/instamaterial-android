package com.alain.curso.firebasenuevo.domain.common;

public interface UseCaseCallback<R> {
  void onSuccess(R result);

  void onError(Exception exception);
}
