package cn.lmu.rentcarts.pojo;

import lombok.Data;

@Data
public class Role {
    private int id;
    private String roleName;
    private String roleDesc;

    public Role(int id, String roleName, String roleDesc) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
    }
}
