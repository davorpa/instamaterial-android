package com.alain.curso.firebasenuevo.domain.common;

public interface Subscriber<R> {
  void onSuccess(R result);

  void onError(Exception exception);
}
