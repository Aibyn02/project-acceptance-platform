package kz.edu.astanait.projectacceptanceplatform.controller;

import kz.edu.astanait.projectacceptanceplatform.dto.request.ProjectDtoRequest;
import kz.edu.astanait.projectacceptanceplatform.model.Project;
import kz.edu.astanait.projectacceptanceplatform.service.serviceInterface.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "https://diploma-projects-front.onrender.com", maxAge = 3600)
@RestController
@RequestMapping("/api/test/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<Project> getById(@PathVariable(value = "id")Long id){
        Project project = this.projectService.getByIdThrowException(id);
        return ResponseEntity.ok().body(project);
    }

    @GetMapping("/")
    public List<Project> getAll(){
        return this.projectService.getAll();
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody ProjectDtoRequest projectDtoRequest){
        this.projectService.create(projectDtoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<HttpStatus> update(@RequestBody ProjectDtoRequest projectDtoRequest,
                                             @PathVariable(name = "id") Long id){
        this.projectService.update(projectDtoRequest, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id){
        this.projectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
