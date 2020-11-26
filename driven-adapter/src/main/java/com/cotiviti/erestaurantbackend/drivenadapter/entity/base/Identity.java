package com.cotiviti.erestaurantbackend.drivenadapter.entity.base;

import javax.persistence.*;

@MappedSuperclass
public class Identity<I> {

    @Id
    @Column
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private I id;

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
