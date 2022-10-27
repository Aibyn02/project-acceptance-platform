package kz.edu.astanait.projectacceptanceplatform.repository;

import kz.edu.astanait.projectacceptanceplatform.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
