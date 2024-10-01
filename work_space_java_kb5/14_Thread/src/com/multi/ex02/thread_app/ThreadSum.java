package com.multi.ex02.thread_app;

import java.util.ArrayList;

public class ThreadSum {
	// 병렬 프로그래밍 알고리즘
	// -> 그래픽카드 연산하거나 산술연산중에 독립적인 연산을 병렬적으로 처리할때 사용
	public static void main(String[] args) {
		int threadNum = 5000; // Thread의 수!
		// 0 ~ 1억 까지 더하는 프로그램
		// double -> 부동소수점 -> int 50배 느리다!
		// 1 : 3317.0
		// 2 : 1809.0
		// 4 : 1031.0
		// 8 : 585.0
		// 16 : 470.0
		// 32 : 472.0
		// 64 : 411.0
		// 128 : 439.0
		// 256 : 472
		// 5000 : 847.0

		// 결론 : 적절한 Thread의 갯수를 유지하는 것이 중요하다.
		//       -> Thread가 많아지면 오히려 Thread 간의 Swap 시간으로 인해 성능 저하 발생
		//       적절? -> System이나 돌아가는 프로그램마다 달라짐으로 이걸 찾아내는게 엔지니어 일이다..

		double startValue = 0;
		double endValue   = 1_000_000_000; // threadNum 배수만큼만!
		double sumValue   = 0;
		long start = System.currentTimeMillis();

		if(endValue % threadNum != 0) {
			System.out.println("다시 입력해주세요.");
			return;
		}

		ArrayList<DoubleSumThread> threadList = new ArrayList<>(threadNum);

		// start!!
		for(int i=0; i<threadNum; i++) {
			double threadStart = (endValue / threadNum) * (i)+1;
			double threadEnd = (endValue / threadNum) * (i+1)+1;
            DoubleSumThread thread = new DoubleSumThread(threadStart, threadEnd);
			threadList.add(thread);
			thread.start();
		}

		// calc!!
		for(int i=0; i<threadList.size(); i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

        for(int i=0; i<threadList.size(); i++) {
            sumValue += threadList.get(i).getSumValue();
        }

		// finish!!
		long end = System.currentTimeMillis();


		double estimated = end - start;

		System.out.println("sumValue : "+ sumValue);
		System.out.println("time estimated : " + estimated);
	}
}
