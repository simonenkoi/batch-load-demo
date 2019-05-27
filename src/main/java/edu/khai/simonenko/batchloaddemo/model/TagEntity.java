package edu.khai.simonenko.batchloaddemo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@Entity
public class TagEntity {

    @Id
    @GeneratedValue
    private long id;
    private String name;
}
