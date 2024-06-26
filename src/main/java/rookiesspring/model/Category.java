/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rookiesspring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import rookiesspring.model.composite_model.ProductCategory;

/**
 *
 * @author HP
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category extends AuditEntity<Long> {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    @JsonBackReference
    private Set<ProductCategory> products = new HashSet<>();

    @Override
    public String toString() {
        return "Category{" + "id=" + getId() + ", name=" + name + ", description=" + description + ", products=" + products.size() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return Objects.equals(getId(), other.getId());
    }

}
