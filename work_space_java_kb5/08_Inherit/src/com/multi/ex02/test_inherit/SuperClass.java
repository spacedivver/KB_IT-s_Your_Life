package com.multi.ex02.test_inherit;


// 부모(조상) 클래스
public class SuperClass {
    private int privateValue = 5; // 본인만 활용 가능
    protected int protectedValue = 10;  // 같은 패키지 + 상속 받은 자식에서 활용가능
    public int publicValue = 20;    // 모두 사용할수 있는 접근제한자
    
    // 부모의 생성자
    public SuperClass() {
        System.out.println("SuperClass default 생성자 입니다.");
    }

    public void publicMethod(){
        System.out.println("SuperClass의 publicMethod 입니다.");
    }

    public int getPrivateValue() {
        return privateValue;
    }

    public void setPrivateValue(int privateValue) {
        this.privateValue = privateValue;
    }
}
