package net.tralfamadore;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Class: RandomTest
 * Created by billreh on 6/3/17.
 */
public class RandomTest {
    @Test
    public void testRandom() {
        Random random = new Random();
        byte[] buf = new byte[16];
        random.nextBytes(buf);
        System.out.println(new String(buf));
        System.out.println(random.nextInt());
        System.out.println(random.nextLong());
        System.out.println(random.nextBoolean());
        System.out.println(random.nextFloat());
        System.out.println(random.nextDouble());
        System.out.println(random.nextDouble());
        IntStream.range(0, 1000).forEach( i -> System.out.println(random.nextInt(i + 1)));
    }
}
