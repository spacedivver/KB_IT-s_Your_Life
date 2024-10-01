package com.multi.ex02.poly_exam;

// 상속 초기에 에러가 발생한다.
// There is no parameterless constructor available in 'com.multi.ex02.poly_exam.Car'
public class Avante extends Car{

    // 자동완성시에는 인자 있는 생성자를 자동 생성
//    public Avante(String name, int cc) {
//        super(name, cc);
//    }

    // 이름 없는 생성자를 만들때 에러 발생 -> super()로 선언되어 에러!
    public Avante(){
//        super();
        super("아반떼", 1600);//아반떼, 1600cc 정보 입력
    }

    @Override
    public void oilling() {
        System.out.println("휘발유를 주유합니다.");
    }

    // 자식의 고유 메소드
    public void avanteNickName(){
        System.out.println("아방이");
    }
}
