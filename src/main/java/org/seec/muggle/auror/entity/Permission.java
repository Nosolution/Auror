package org.seec.muggle.auror.entity;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private Integer id;
    private String name;
    private List<Role> roles;
}
