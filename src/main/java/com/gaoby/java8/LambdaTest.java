package com.gaoby.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    private static List<Apple> appleList = new ArrayList<>();
    static {
        appleList.add(new Apple("red", 100.0));
        appleList.add(new Apple("green", 150.0));
        appleList.add(new Apple("green", 200.0));
    }


    @Test
    public void test() {
        // 查找颜色为绿色的苹果
        List<Apple> greenAppleList = filterApple(appleList, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return apple.getColor().equals("green");
            }
        });
        System.out.println(greenAppleList);

    }

    @Test
    public void test2() {
        // 查找颜色为绿色的苹果
        List<Apple> greenAppleList = filterApple(appleList, (Apple apple) -> {
            return apple.getColor().equals("green");
        });
        // List<Apple> greenAppleList = filterApple(appleList, apple -> apple.getColor().equals("green"));
        System.out.println(greenAppleList);
    }

    @Test
    public void test3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

    }

    private List<Apple> filterApple(List<Apple> appleList, AppleFilter appleFilter) {
        List<Apple> filterAppleList = new ArrayList<>();
        for (Apple apple : appleList) {
            if (appleFilter.filter(apple)) {
                filterAppleList.add(apple);
            }
        }
        return  filterAppleList;
    }
}
