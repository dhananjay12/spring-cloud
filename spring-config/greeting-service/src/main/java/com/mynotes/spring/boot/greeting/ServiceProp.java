package com.mynotes.spring.boot.greeting;

public class ServiceProp {

    private String name;

    private String group;

    private String host;

    @Override
    public String toString() {
        return "ServiceProp{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }


}
