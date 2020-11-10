package com.mamalimomen.base.domains;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Transient
    private static Long entitiesCount = 100L;

    @Id
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    private Long id;

    public BaseEntity() {
        this.id = (long) Objects.hash(entitiesCount);
        entitiesCount++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return this.getId().intValue();
    }
}
