package us.bojie.bootbo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // From age
    List<Girl> findByAge(Integer age);
}
