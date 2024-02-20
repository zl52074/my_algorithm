package com.zl52074.design_pattern.builder;

/**
 * @description:
 * @author: zl52074
 * @time: 2023/12/3 4:16
 */
public class UserConfigBuilder {
    private String id;
    private String username;
    private String type;

    public UserConfigBuilder setId(String id) {
        this.id = id;
        return this;
    }


    public UserConfigBuilder setUsername(String username) {
        this.username = username;
        return this;
    }


    public UserConfigBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public UserConfig build(){
        return new UserConfig(this);
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public static void main(String[] args) {
        UserConfigBuilder builder = new UserConfigBuilder();
        UserConfig userConfig = builder.setId("1111").
                setUsername("zhangsan").
                setType("111").
                build();
        System.out.println(userConfig);
    }
}
