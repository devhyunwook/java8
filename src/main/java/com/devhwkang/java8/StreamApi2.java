package com.devhwkang.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "spring api development", false));

        System.out.println("1. spring으로 시작하는 수업");
        springClasses.stream()
                .filter(oc-> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("2. closed 되지 않은 시작하는 수업");
        springClasses.stream()
                .filter(oc -> !oc.isClosed())
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("3. 수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The java, Test", true));
        javaClasses.add(new OnlineClass(7, "The java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The java, 8 to 11", false));

        List<List<OnlineClass>> devhwkangEvent = new ArrayList<>();
        devhwkangEvent.add(springClasses);
        devhwkangEvent.add(javaClasses);

        System.out.println("4. 두 수업 목록에 들어있는 모든 수업 아이디 출력");
//        devhwkangEvent.stream()
//                .forEach(ocl -> ocl.forEach(oc -> System.out.println(oc.getTitle())));
        devhwkangEvent.stream()
                .flatMap(Collection::stream)
                .map(oc -> oc.getId())
                .forEach(System.out::println);


        System.out.println("5. 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("6. 자바 수업 중에 Test 가 들어 있는 수업이 있는지 확인");
        boolean temp2 = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(temp2);

        System.out.println("7. 스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> temp = devhwkangEvent.stream()
                .flatMap(Collection::stream)
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .map(oc -> oc.getTitle())
                .collect(Collectors.toList());
        temp.forEach(System.out::println);
    }
}
