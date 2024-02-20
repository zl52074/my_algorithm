package com.zl52074.design_pattern.builder;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/12/3 2:51
 */
public class UserConfig {
    private String id;
    private String username;
    private String type;

    public UserConfig() {
    }
    public UserConfig(UserConfigBuilder builder) {
        this.id = builder.getId();
        this.username = builder.getUsername();
        this.type = builder.getType();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserConfig{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
