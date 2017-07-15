package com.alain.curso.firebasenuevo.ui.locator;

import com.alain.curso.firebasenuevo.domain.executor.PostExecutor;
import com.alain.curso.firebasenuevo.domain.executor.ThreadExecutor;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutorLocator;
import com.alain.curso.firebasenuevo.ui.executor.JobExecutor;
import com.alain.curso.firebasenuevo.ui.executor.UIExecutor;

public class AppServiceLocator implements UseCaseExecutorLocator {
  private ThreadExecutor threadExecutor;
  private PostExecutor postExecutor;
  private UseCaseExecutor useCaseExecutor;

  public static AppServiceLocator getInstance() {
    return Instance.instance;
  }

  @Override public ThreadExecutor threadExecutor() {
    if (threadExecutor == null) {
      threadExecutor = new JobExecutor();
    }
    return threadExecutor;
  }

  @Override public PostExecutor postExecutor() {
    if (postExecutor == null) {
      postExecutor = new UIExecutor();
    }
    return postExecutor;
  }

  @Override public UseCaseExecutor useCaseExecutor() {
    if (useCaseExecutor == null) {
      useCaseExecutor = new UseCaseExecutor(threadExecutor(), postExecutor());
    }
    return useCaseExecutor;
  }

  public ActivityServiceLocator plusActivityServiceLocator() {
    return new ActivityServiceLocator();
  }

  private static class Instance {
    private static final AppServiceLocator instance = new AppServiceLocator();
  }
}
