package com.zeroq6.java.other.path;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPathTest {

    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(getPlanList("1", "5", null, null, null)));
    }


    private static List<Plan> getPlanList(String start, String end, List<Plan> planList, List<Path> currPathList, Integer currWeight) {
        if (null == planList) {
            planList = new ArrayList<>();
        }
        if (null == currPathList) {
            currPathList = new ArrayList<>();
        }
        if (null == currWeight || currWeight < 0) {
            currWeight = 0;
        }
        if (StringUtils.isBlank(start)) {
            return planList;
        }

        for (Path item : getPathStartWith(start)) {
            if (isCycle(currPathList, item)) {
                continue;
            }
            List<Path> newPathList = new ArrayList<>();
            newPathList.addAll(currPathList);
            newPathList.add(item);

            Integer newWeight = currWeight + item.getWeight();

            if (item.getEnd().equals(end)) {
                Plan plan = new Plan();
                plan.setStart(start);
                plan.setEnd(end);
                plan.setLength(newPathList.size());
                plan.setWeight(newWeight);
                plan.setPathList(newPathList);
                planList.add(plan);
            } else {
                getPlanList(item.getEnd(), end, planList, newPathList, newWeight);
            }

        }
        return planList;

    }


    private static boolean isCycle(List<Path> linkedPath, Path nextPathToAdd) {
        if (null == linkedPath || null == nextPathToAdd) {
            throw new RuntimeException("linkedPath and nextPathToAdd can not be null");
        }

        String start = nextPathToAdd.getStart();
        String end = nextPathToAdd.getEnd();
        //
        if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
            throw new RuntimeException("start and end can not be blank in nextPathToAdd");
        }
        if (start.equals(end)) {
            return true;
        }
        //
        int linkPathSize = linkedPath.size();
        if (linkPathSize == 0) {
            return false;
        }

        //
        if (!start.equals(linkedPath.get(linkPathSize - 1).getEnd())) {
            throw new RuntimeException("start in nextPathToAdd not equals end in previous path ");
        }
        for (int i = 0; i < linkPathSize - 1; i++) {
            Path item = linkedPath.get(i);
            if (end.equals(item.getStart()) || end.equals(item.getEnd())) {
                return true;
            }
            /*if (i == linkPathSize - 1) {
                if (end.equals(item.getEnd())) {
                    return true;
                }
            }*/
        }
        return false;

    }


    private static List<Path> getPathStartWith(String start) {
        List<Path> startWithList = new ArrayList<>();
        if (StringUtils.isBlank(start)) {
            return startWithList;
        }
        for (Path item : getAllPathList()) {
            if (start.equals(item.getStart())) {
                startWithList.add(item);
            }
        }
        return startWithList;

    }

    private static List<Path> getAllPathList() {
        List<Path> allPathList = new ArrayList<Path>();
        allPathList.add(new Path("0", "1", "2", 1));
        allPathList.add(new Path("1", "2", "3", 1));
        allPathList.add(new Path("2", "3", "4", 1));
        allPathList.add(new Path("3", "4", "5", 1));
        allPathList.add(new Path("4", "3", "5", 1));
        allPathList.add(new Path("5", "3", "2", 1));
        allPathList.add(new Path("6", "7", "3", 1));
        allPathList.add(new Path("7", "9", "8", 1));
        allPathList.add(new Path("8", "8", "1", 1));
        allPathList.add(new Path("9", "5", "7", 1));
        return allPathList;

    }


}
