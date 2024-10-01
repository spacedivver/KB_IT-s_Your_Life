package com.multi.ex01.lambda_basic;

// 람다식이란? (Java8 부터 활용)
// - 함수형 프로그래밍이 가능한 순수 함수 문법
// - 메서드를 하나의 식(반드시 입력과 출력이 있는 식)으로 표현 가능한 문법
// - 기존 익명 클래스로 가능한 방법이었으나 그 문법을 간편화하여 구성

public class LambdaBasic {

    public static void main(String[] args) {
        // 기존의 익명 클래스로 MyLambda를 구현하는 문법
        MyLambda1 f0 = new MyLambda1() {
            @Override
            public void run() {
                System.out.println("MyLambda1 call!!");
            }
        };
        f0.run();

        // 람다 기본형 : (v1, v2 ...) -> { ~~~~ }
        // -> 중괄호 사용시 여러줄의 내용을 사용할수 있다.
        MyLambda1 f1 = () -> {
            System.out.println("MyLambda1 call!!");
            System.out.println("MyLambda1 call!!");
        };
        f1.run();

        // 람다 단축표현1 - { ... } 표현이 한줄일때는 중괄호 생략 가능!
        MyLambda1 f2 = () -> System.out.println("MyLambda1 call!!");
        f2.run();

        // 람다 단축표현2 - 인자가 한개일때는 (~~) 괄호도 생략 가능!
//        MyLambda1 f3 = () -> System.out.println("MyLambda1 call!!"); // 0개 안됨!!
        MyLambda2 f3 = msg -> System.out.println("msg : " + msg);
        f3.print("Hello World!");

        // 여러 파라메터 + 리턴값을 받는 람다식 활용
        MyLambda3 f4 = (a, b) ->{
            return a * b;
        };
        int result = f4.calc(2, 5);
        System.out.println(result);
        
        // 람다 단축표현3 - return이 있을때 한줄짜리 리턴은 생략 가능 (여러 줄은 생략 불가!)
        MyLambda3 f5 = (a,b) -> a * b;
        int result2 = f5.calc(4, 5);
        System.out.println(result2);

        // 람다 함수의 메소드 인자 활용
        MyLambda3 f6 = (a,b) -> a * b;
        int result3 = staticMethod(f6, 10, 5);
        System.out.println(result3);

        // 직접 람다를 선언하여 인자로 활용!
        int result4 = staticMethod((a,b) -> a * b, 10, 20);
        // 익명 클래스 버전!
        int result5 = staticMethod(new MyLambda3() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        }, 10, 20);
        System.out.println(result4);
        System.out.println(result5);

        // 이미 생성된 람다함수 활용법 '::' 활용, static 메소드만 활용 가능!!
        int result6 = staticMethod(MyClass::sum, 10, 20);
        System.out.println(result6);
        int result7 = staticMethod(MyClass::multiply, 10, 20);
        System.out.println(result7);
        int result8 = staticMethod(Integer::sum, 5, 4);
        System.out.println(result8);
        int result9 = staticMethod(Math::multiplyExact, 5, 4);
        System.out.println(result9);

        // 생성자 람다 활용법
        MyMember member = staticMethod2(MyMember::new);
        System.out.println(member);

        MyMember member2 = staticMethod3(MyMember::new, "홍길동", 31);
        System.out.println(member2);

    }
    public static int staticMethod(MyLambda3 func, int a, int b) {
        return func.calc(a, b);
    }

    public static MyMember staticMethod2(MyLambdaCreatable creatable){
        return creatable.createMember();
    }
    public static MyMember staticMethod3(MyLambdaCreatable2 creatable, String name, int age){
        return creatable.createMember(name, age);
    }
}
