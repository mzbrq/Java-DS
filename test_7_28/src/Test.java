public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1, 1);
        hashBuck.put(2, 2);
        hashBuck.put(11, 11);
        hashBuck.put(21, 21);
        hashBuck.put(9, 9);
        hashBuck.put(4, 4);

        System.out.println(hashBuck.get(4));
        System.out.println(hashBuck.get(0));

    }
}
