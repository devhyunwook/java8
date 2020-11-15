package com.devhwkang.java8;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        /**
         * PART 2
         */
        System.out.println("================================================================================");
        System.out.println("== PART2");
        // Funtion : T type 받아서 R type return
        // Plus10 plus10 = new Plus10();
        Function<Integer, Integer> plus10 = (number) -> number + 10;
        Function<Integer, Integer> multy2 = (i) -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multy2);
        Function<Integer, Integer> multiply2AndThenPlus10 = plus10.andThen(multy2);
        System.out.println(multiply2AndPlus10.apply(10));
        System.out.println(multiply2AndThenPlus10.apply(10));

        // Consumer : void return
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // Supplier : 들어온 값을 return
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate : Boolean return
        Predicate<String> isEqualString = (tempString) -> tempString.equalsIgnoreCase("test");
        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println(isEqualString.test("test"));
        System.out.println(isEven.test(2));

        // UnaryOperator : 입력값과 출력값이 같은 경우
        UnaryOperator<Integer> unaryOperator = (number) -> number + 10;
        System.out.println(unaryOperator.apply(10));

        /**
         * PART 1
         */
        System.out.println("================================================================================");
        System.out.println("== PART1");
        RunSomething runSomething = (number) -> {
            System.out.println("hello do it");
            System.out.println("hello do it2");
            return number + 10;
        };
        System.out.println(runSomething.doIt(1));

    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);
    }
}
