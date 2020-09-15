package com.process.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author Liangzq
 * @ClassName: SumOfPrimeApplication
 * @Package com.process.prime
 * @Description:
 * @date 2020/9/15 15:50
 */
@SpringBootApplication
public class SumOfPrimeApplication {

	/**
	 * Only consider the speed of computation
	 * @param belowNum
	 */
	private static void considerSpeedCase(Integer belowNum){
		if (belowNum < 1) {
			System.out.println("Invalid argument : "+ belowNum);
		} else {
			long startTime = System.currentTimeMillis();
			Long primeSum = 0L;
			boolean isPrime[] = new boolean[belowNum];
			Arrays.fill(isPrime, true);
			for (int i = 2; i < (int)Math.sqrt(belowNum); i++) {
				if (isPrime[i]) {
					for (int j = i * i; j < belowNum; j += i) {
						isPrime[j] = false;
					}
				}
			}

			for (int i = 2; i < belowNum; i++){
				if (isPrime[i]){
					primeSum += i;
				}
			}


			long end = System.currentTimeMillis();
			System.out.println("The sum of all prime numbers below "+ belowNum +" = " + primeSum);
			System.out.println("ConsiderSpeedCase spends " + (end - startTime) + " ms");
		}

	}

	/**
	 * Reducing the looping count.
	 * @param belowNum
	 */
	private static void considerReduceLoopCount(Integer belowNum){
		if (belowNum < 1) {
			System.out.println("Invalid argument : "+ belowNum);
		} else {
			long startTime = System.currentTimeMillis();
			Long primeSum = 0L;
			int[] array = new int[belowNum/2];
			int size = 0;
			array[size++] = 2;
			boolean is;
			for (int i = 3; i <= belowNum ; i += 2) {
				int n = (int)Math.sqrt(i);
				is = true;
				for (int j = 0; array[j] <= n; j++) {
					if (i % array[j] == 0){
						is = false;
						break;
					}
				}
				if (is){
					array[size++] = i;
				}
			}
			for (int i = 0; i < size; i++) {
				primeSum += array[i];

			}
			long end = System.currentTimeMillis();
			System.out.println("The sum of all prime numbers below "+ belowNum +" = " + primeSum);
			System.out.println("ConsiderReduceLoopCountCase spends " + (end - startTime) + " ms");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SumOfPrimeApplication.class, args);
		//below
		Integer belowNum = 200000;
		considerSpeedCase(belowNum);
		considerReduceLoopCount(belowNum);
	}
}
