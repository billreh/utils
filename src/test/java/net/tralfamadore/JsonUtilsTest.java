package net.tralfamadore;

import org.junit.Test;

/**
 * Class: JsonUtilsTest
 * Created by billreh on 4/30/17.
 */
public class JsonUtilsTest {
    @Test
    public void testJsonUtils() throws Exception {
        System.out.println(JsonUtils.toJson("hello"));
        System.out.println(JsonUtils.toJson(1));
        Moo moo = new Moo();
        moo.setBlah(12L);
        moo.setMoo("OOM");
        System.out.println(JsonUtils.toJson(moo));
    }

    class Moo {
        private String moo;
        private long blah;
        private int bang;
        transient private long ugh;

        public String getMoo() {
            return moo;
        }

        public void setMoo(String moo) {
            this.moo = moo;
        }

        public long getBlah() {
            return blah;
        }

        public void setBlah(long blah) {
            this.blah = blah;
        }

        public long getUgh() {
            return ugh;
        }

        public void setUgh(long ugh) {
            this.ugh = ugh;
        }
    }
}
