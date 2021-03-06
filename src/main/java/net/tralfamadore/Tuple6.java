package net.tralfamadore;

/**
 * Class: Tuple4
 * Created by billreh on 12/23/16.
 */
public class Tuple6<T,U,V,W,X,Y> implements Tuple {
    private T value1;
    private U value2;
    private V value3;
    private W value4;
    private X value5;
    private Y value6;

    public Tuple6() {
    }

    public Tuple6(T value1, U value2, V value3, W value4, X value5, Y value6) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
    }

    public T getValue1() {
        return value1;
    }

    public U getValue2() {
        return value2;
    }

    public V getValue3() {
        return value3;
    }

    public W getValue4() {
        return value4;
    }

    public X getValue5() {
        return value5;
    }

    public Y getValue6() {
        return value6;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public void setValue2(U value2) {
        this.value2 = value2;
    }

    public void setValue3(V value3) {
        this.value3 = value3;
    }

    public void setValue4(W value4) {
        this.value4 = value4;
    }

    public void setValue5(X value5) {
        this.value5 = value5;
    }

    public void setValue6(Y value6) {
        this.value6 = value6;
    }

    @Override
    public Object produceElement(int i) {
        switch (i) {
            case 1:
                return value1;
            case 2:
                return value2;
            case 3:
                return value3;
            case 4:
                return value4;
            case 5:
                return value5;
            case 6:
                return value6;
            default:
                return new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple6<?, ?, ?, ?, ?, ?> tuple6 = (Tuple6<?, ?, ?, ?, ?, ?>) o;

        if (value1 != null ? !value1.equals(tuple6.value1) : tuple6.value1 != null) return false;
        if (value2 != null ? !value2.equals(tuple6.value2) : tuple6.value2 != null) return false;
        if (value3 != null ? !value3.equals(tuple6.value3) : tuple6.value3 != null) return false;
        if (value4 != null ? !value4.equals(tuple6.value4) : tuple6.value4 != null) return false;
        if (value5 != null ? !value5.equals(tuple6.value5) : tuple6.value5 != null) return false;
        return value6 != null ? value6.equals(tuple6.value6) : tuple6.value6 == null;
    }

    @Override
    public int hashCode() {
        int result = value1 != null ? value1.hashCode() : 0;
        result = 31 * result + (value2 != null ? value2.hashCode() : 0);
        result = 31 * result + (value3 != null ? value3.hashCode() : 0);
        result = 31 * result + (value4 != null ? value4.hashCode() : 0);
        result = 31 * result + (value5 != null ? value5.hashCode() : 0);
        result = 31 * result + (value6 != null ? value6.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple6{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                ", value3=" + value3 +
                ", value4=" + value4 +
                ", value5=" + value5 +
                ", value6=" + value6 +
                '}';
    }
}
