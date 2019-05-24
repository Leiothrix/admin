package com.paprika.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author adam
 * @date 2019/5/13
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
@Entity
@Data
@Table(name = "dept")
public class Dept implements Serializable{

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    private Boolean enabled;

    /**
     * 上级部门
     */
    @Column(name = "pid", nullable = false)
    @NotNull
    private long pid;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @ManyToMany(mappedBy = "depts")
    @JsonIgnore
    private Set<Role> roles;

    public @interface Update {}

}
