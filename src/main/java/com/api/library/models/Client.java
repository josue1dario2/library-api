package com.api.library.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@SQLDelete(sql = "UPDATE client SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted=false")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long document;
    private String name;
    private String lastName;
    private String direction;
    private String phone;
    private String email;
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;
    private boolean deleted = Boolean.FALSE;
}
