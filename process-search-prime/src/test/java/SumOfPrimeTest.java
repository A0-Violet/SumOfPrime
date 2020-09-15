import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @author Liangzq
 * @ClassName: SumOfPrimeTest
 * @Description: unit test
 * @date 2020/9/15 15:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SumOfPrimeTest.class)
public class SumOfPrimeTest {

	/**
	 * testConsiderSpeedCase
	 * The sum of all prime numbers below 200000 = 1709600813
	 */
	@Test
	public void testConsiderSpeedCase(){
		Integer belowNum = 200000;
		long startTime = System.currentTimeMillis();
		Long primeSum = 0L;
		boolean isPrime[] = new boolean[belowNum];
		Arrays.fill(isPrime, true);
		for (int i = 2; i < (int)Math.sqrt(belowNum); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < belowNum; j += i)
					isPrime[j] = false;
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



	/**
	 * testConsiderReduceLoopCount
	 * The sum of all prime numbers below 200000 = 1709600813
	 */
	@Test
	public void testConsiderReduceLoopCount(){
		Integer belowNum = 200000;
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
