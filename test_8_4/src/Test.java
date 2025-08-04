public class Test {
    public static void main(String[] args) {
        HashBucket hb = new HashBucket();

        hb.put(1, 1);
        hb.put(2, 2);
        hb.put(11, 11);
        hb.put(3, 3);
        hb.put(4, 4);
        hb.put(12, 12);
        hb.put(21, 21);
        hb.put(8, 8);

        System.out.println();

        System.out.println(hb.get(1));
        System.out.println(hb.get(2));
        System.out.println(hb.get(3));
        System.out.println(hb.get(14));
        System.out.println(hb.get(8));

    }
}
