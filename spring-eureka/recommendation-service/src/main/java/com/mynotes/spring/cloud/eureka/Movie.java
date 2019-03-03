package com.mynotes.spring.cloud.eureka;

public class Movie {

    private Integer id;

    private String name;

    private String synopsis;

    public Movie() {
    }

    public Movie(Integer id, String name, String synopsis) {
        super();
        this.id = id;
        this.name = name;
        this.synopsis = synopsis;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

}
