package com.devhwkang.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalApi {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass temp = new OnlineClass(1, "spring boot", true);
        //System.out.println(temp.getProgress().getStudyDuration()); // 에러 발생

        Optional<OnlineClass> optionaloc = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        System.out.println(optionaloc.isPresent());

        // OnlineClass oc = optionaloc.get(); // 에러 발생 가능
        optionaloc.ifPresent(oc -> {
            System.out.println(oc.getTitle());
        });

        // OnlineClass onlineClass = optionaloc.orElse(createNewClass()); // 상수로 이미 정의해 놓은 경우 orElse가 적합
        OnlineClass onlineClass = optionaloc.orElseGet(OptionalApi::createNewClass); // 동적으로 작업하여 생성하는 경우 orElseGet 적합
        // OnlineClass onlineClass = optionaloc.orElseThrow(IllegalStateException::new); // 원하는 Exception
        //Optional<OnlineClass> onlineClass = optionaloc.filter(oc -> oc.isClosed());
        //Optional<Integer> optionalInteger = optionaloc.map(OnlineClass::getId);

        //Optional<Progress> progress = optionaloc.flatMap(OnlineClass::getProgress); // optional 안에 들어있는 인스턴스가 optional인 경우에 사용하면 편리하다.
        // stream에서의 flatMap은 Input은 하나지만 Output이 여러개 일때 사용

        System.out.println("result :" + onlineClass);
    }

    private static OnlineClass createNewClass() {
        System.out.println("Create New Class");
        return new OnlineClass(10, "New Class", false);
    }

}
