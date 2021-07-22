package net.maoni.SpringBoot.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    /**
     *  @JsonIgnore
     * 此注解是类注解,作用是json在序列化时将java bean 中的一些属性忽略掉,序列化和反序列化都受影响
     * 生成json时不生成pwd属性
     */
    //@JsonIgnore
    private String pwd;

    public User(){}
    public User(int id,String username,String pwd){
        this.id=id;
        this.username=username;
        this.pwd=pwd;
    }
}
