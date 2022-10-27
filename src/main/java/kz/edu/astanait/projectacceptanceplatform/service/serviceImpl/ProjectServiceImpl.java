package kz.edu.astanait.projectacceptanceplatform.service.serviceImpl;

import kz.edu.astanait.projectacceptanceplatform.dto.request.ProjectDtoRequest;
import kz.edu.astanait.projectacceptanceplatform.exception.CustomNotFoundException;
import kz.edu.astanait.projectacceptanceplatform.exception.ExceptionDescription;
import kz.edu.astanait.projectacceptanceplatform.exception.RepositoryException;
import kz.edu.astanait.projectacceptanceplatform.model.Project;
import kz.edu.astanait.projectacceptanceplatform.repository.ProjectRepository;
import kz.edu.astanait.projectacceptanceplatform.service.serviceInterface.ProjectService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> getById(Long id) {
        return this.projectRepository.findById(id);
    }

    @Override
    public Project getByIdThrowException(Long id) {
        return this.getById(id)
                .orElseThrow(() -> new CustomNotFoundException
                        (String.format(ExceptionDescription.CustomNotFoundException, "Project", "id", id)));
    }

    @Override
    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public void create(ProjectDtoRequest projectDtoRequest) {
        Project project = new Project();

        project.setTitle(projectDtoRequest.getTitle());
        project.setDescription(projectDtoRequest.getDescription());
        project.setCompany(projectDtoRequest.getCompany());
        project.setContact(projectDtoRequest.getContact());
        project.setAccepted(projectDtoRequest.getAccepted());

        try{
            this.projectRepository.save(project);
        }catch (Exception e){
            log.error(e);
            throw new RepositoryException(String.format(ExceptionDescription.RepositoryException, "creating", "project"));
        }

    }

    @Override
    public void update(ProjectDtoRequest projectDtoRequest, Long id) {
        Project project = this.getByIdThrowException(id);

        if(Strings.isNotBlank(projectDtoRequest.getTitle())) project.setTitle(projectDtoRequest.getTitle());
        if(Strings.isNotBlank(projectDtoRequest.getDescription())) project.setDescription(projectDtoRequest.getDescription());
        if(Strings.isNotBlank(projectDtoRequest.getCompany())) project.setCompany(projectDtoRequest.getCompany());
        if(Strings.isNotBlank(projectDtoRequest.getContact())) project.setContact(projectDtoRequest.getContact());
        if(Objects.nonNull((projectDtoRequest.getAccepted()))) project.setAccepted(projectDtoRequest.getAccepted());
        try{
            this.projectRepository.save(project);
        }catch (Exception e){
            log.error(e);
            throw new RepositoryException(String
                    .format(ExceptionDescription.RepositoryException, "updating", "project"));
        }
    }

    @Override
    public void delete(Long id) {
        Project project = this.getByIdThrowException(id);

        try {
            this.projectRepository.delete(project);
        }catch (Exception e){
            log.error(e);
            throw new RepositoryException(String
                    .format(ExceptionDescription.RepositoryException, "deleting", "project"));
        }
    }
}
