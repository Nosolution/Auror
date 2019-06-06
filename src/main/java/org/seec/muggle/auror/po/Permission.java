package org.seec.muggle.auror.po;

import lombok.Data;

import java.util.List;

@Data
public class Permission {
    private Long id;
    private String name;
    private List<Role> roles;
}
