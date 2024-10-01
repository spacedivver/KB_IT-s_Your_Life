package com.multi.ex03.abstract_exam;


public class Sonata extends HyundaiCar {
    public Sonata() {
        super("소나타", 2000); // 2000cc
    }

    @Override
    public void oilling() {
        System.out.println("휘발유를 주유합니다.");
    }

    @Override
    public void move() {
        System.out.println("소나타가 부르르르릉");
    }

    @Override
    public void nickName() {
        System.out.println("소나 타는 차");
    }
}