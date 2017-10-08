package us.bojie.bootbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import us.bojie.bootbo.domain.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // From age
    List<Girl> findByAge(Integer age);
}
