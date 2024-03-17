package com.berkay.entity;

public class Auth extends BaseEntity {
    Long id;
    String userName;
    String password;

    public Auth(long createAt, long updateAt, int state, Long id, String userName, String password) {
        super(createAt, updateAt, state);
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
