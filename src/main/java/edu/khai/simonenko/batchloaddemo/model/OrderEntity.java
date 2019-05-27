package edu.khai.simonenko.batchloaddemo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Accessors(chain = true)
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @OneToMany
    @BatchSize(size = 50)
    private List<TagEntity> tags;
}
