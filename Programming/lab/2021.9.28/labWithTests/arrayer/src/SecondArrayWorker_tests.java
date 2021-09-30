import static org.junit.Assert.assertTrue;

import org.junit.Test;

import arrayer.SecondArrayWorker;

public class SecondArrayWorker_tests {
    private final SecondArrayWorker worker = new SecondArrayWorker();

    @Test
    public void testBasicWork() {
        double[] a = { -5, 10, 5, -5, 3, -565, -34, 1, 5, 6 };
        double res = 8;
        assertTrue(res == worker.work(a));

        double[] b = { 1, 0, -1 };
        res = 1;
        assertTrue(res == worker.work(b));

        double[] c = { Double.MAX_VALUE, 0 };
        res = Double.MAX_VALUE;
        assertTrue(res == worker.work(c));

        double[] d = { -1, -2, -3, -4, -5, -6, -7, -8 };
        res = worker.work(d);
        assertTrue(res != res);

    }

    @Test
    public void testBesicWorkWithUnsupportedInput() {
        double[] a = null;
        double res = worker.work(a);
        assertTrue(res != res);
        double[] b = {};
        res = worker.work(b);
        assertTrue(res != res);
    }
}
