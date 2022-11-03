package com.grupo9.db.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "feature_sequence")
    private Long id;
    @NotEmpty(message = "Feature is mandatory")
    @Column(name = "featureName", nullable = false, length = 80)
    private String featureName;
    @NotEmpty(message = "Icon is mandatory")
    @Column(name="iconUrl", nullable = false, length = 255)
    private String iconUrl;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;

    public Feature() {
    }

    public Feature(String featureName, String iconUrl) {
        this.featureName = featureName;
        this.iconUrl = iconUrl;
    }

    public Feature(String featureName, String iconUrl, Date created_at, Date updated_at) {
        this.featureName = featureName;
        this.iconUrl = iconUrl;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", featureName='" + featureName + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
