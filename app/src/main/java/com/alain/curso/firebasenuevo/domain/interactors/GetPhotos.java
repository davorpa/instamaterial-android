package com.alain.curso.firebasenuevo.domain.interactors;

import com.alain.curso.firebasenuevo.domain.common.ObservableTask;
import com.alain.curso.firebasenuevo.domain.common.UseCase;
import com.alain.curso.firebasenuevo.domain.executor.UseCaseExecutor;
import com.alain.curso.firebasenuevo.domain.model.Photo;
import com.alain.curso.firebasenuevo.domain.repository.PhotoRepository;
import java.util.List;

public class GetPhotos extends UseCase<Void, List<Photo>> {
  private final PhotoRepository photoRepository;

  public GetPhotos(UseCaseExecutor useCaseExecutor, PhotoRepository photoRepository) {
    super(useCaseExecutor);
    this.photoRepository = photoRepository;
  }

  @Override public ObservableTask<List<Photo>> createObservableTask(Void input) {
    return photoRepository.getPhotos();
  }
}
