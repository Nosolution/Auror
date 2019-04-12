package org.seec.muggle.auror.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;
    private List<User> users;
    private List<Permission> permissions;

}
