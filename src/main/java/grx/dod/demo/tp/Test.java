package grx.dod.demo.tp;

public abstract class Test {

    private Test() {}

    public static long start() {
        return System.currentTimeMillis();
    }

    public static void end(long start) {
        long end = System.currentTimeMillis();

        System.out.println(" => "+(end-start)+" (ms)");
    }

}
