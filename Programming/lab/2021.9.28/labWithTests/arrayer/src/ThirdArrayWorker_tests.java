import static org.junit.Assert.assertTrue;

import org.junit.Test;

import arrayer.ThirdArrayWorker;

public class ThirdArrayWorker_tests {
    private final ThirdArrayWorker worker = new ThirdArrayWorker();

    @Test
    public void testBasicWork() {
        double[] a = { 2, 4, 3, -3, -5, -10, 0, 4, 3, -2, -3 };
        double[] b = { 3, 1, 6, -5, -1, -10, 0, -3, -7, 2, 5 };
        double[] c = { 5, 5, 9, 15, 5, 100, 0, 0, 0, 0, 0 };
        double[] res = worker.work(a, b);
        for (int i = 0; i < c.length; i++) {
            assertTrue(res[i] == c[i]);
        }
    }

    @Test
    public void testWithInvalidInput() {
        double[] a = { 1, 2, 3 };
        double[] b = { 1, 2 };
        assertTrue(null == worker.work(a, b));
    }
}
