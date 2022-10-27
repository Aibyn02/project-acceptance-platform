package kz.edu.astanait.projectacceptanceplatform.repository;

import kz.edu.astanait.projectacceptanceplatform.model.ERole;
import kz.edu.astanait.projectacceptanceplatform.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
