package kz.edu.astanait.projectacceptanceplatform.service.serviceInterface;


import kz.edu.astanait.projectacceptanceplatform.dto.request.ProjectDtoRequest;
import kz.edu.astanait.projectacceptanceplatform.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Optional<Project> getById(Long id);

    Project getByIdThrowException(Long id);

    List<Project> getAll();

    void create(ProjectDtoRequest projectDtoRequest);

    void update(ProjectDtoRequest projectDtoRequest, Long id);

    void delete(Long id);
}

