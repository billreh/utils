package net.tralfamadore;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * Class: Random
 * Created by billreh on 6/3/17.
 */
public class Random {
    private static final int BUF_SIZE = 1024;
    private static java.util.Random random;
    private static File randomFile;
    private static boolean trueRandom = false;
    private byte[] randomBytes = new byte[BUF_SIZE];
    private int idx = 0;

    static {
        randomFile = new File("/dev/urandom");
        if(randomFile.exists()) {
            trueRandom = true;
        } else {
            random = new java.util.Random();
        }
    }

    public Random() {
        seedRandom();
    }

    public void nextBytes(byte[] bytes) {
        if(bytes == null)
            return;
        if(trueRandom && !(bytes.length > BUF_SIZE)) {
            if(idx + bytes.length >= BUF_SIZE)
                seedRandom();
            System.arraycopy(randomBytes, idx, bytes, 0, bytes.length);
            idx += bytes.length;
        } else {
            random.nextBytes(bytes);
        }
    }

    public int nextInt() {
        if(trueRandom)
            return siphonBytes(4).getInt();
        return random.nextInt();
    }

    public int nextInt(int bound) {
        if(trueRandom)
            return Math.abs(nextInt() % bound);
        return random.nextInt(bound);
    }

    public long nextLong() {
        if(trueRandom)
            return siphonBytes(8).getLong();
        return random.nextLong();
    }

    public boolean nextBoolean() {
        if(trueRandom)
            return siphonBytes(4).getInt() %2 == 0;
        return random.nextBoolean();
    }

    public float nextFloat() {
        if(trueRandom)
            return siphonBytes(4).getFloat();
        return random.nextFloat();
    }

    public double nextDouble() {
        if(trueRandom)
            return siphonBytes(8).getDouble();
        return random.nextDouble();
    }

    /**
     * Read a bunch of random bytes into the buffer.
     */
    private void seedRandom() {
        idx = 0;

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(randomFile);
            //noinspection ResultOfMethodCallIgnored
            fileInputStream.read(randomBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    /**
     * Return <code>numBytes</code> bytes in a ByteBuffer.
     *
     * @param numBytes The number of bytes to return in the ByteBuffer.
     *
     * @return <code>numBytes</code> bytes in a ByteBuffer.
     */
    private ByteBuffer siphonBytes(int numBytes) {
        if(idx + numBytes >= BUF_SIZE)
            seedRandom();

        ByteBuffer byteBuffer = ByteBuffer.wrap(randomBytes, idx, numBytes);
        idx += numBytes;

        return byteBuffer;
    }
}
