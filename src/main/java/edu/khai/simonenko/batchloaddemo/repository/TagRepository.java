package edu.khai.simonenko.batchloaddemo.repository;

import edu.khai.simonenko.batchloaddemo.model.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
