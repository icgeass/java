package com.zeroq6.java.other.path;

import java.math.BigDecimal;

public class Path {

    private String pathId;


    private String start;


    private String end;


    private Integer weight = 0;

    public Path(String pathId, String start, String end, Integer weight) {
        this.pathId = pathId;
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Path{" +
                "pathId='" + pathId + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", weight=" + weight +
                '}';
    }
}
