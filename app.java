public class App {
    public static void main(String[] args) {
        int[] valores = {11,16,33,8,3,9,77,14,41};
        // Heap h  = new Heap(valores);
        // Heap h  = new Heap(20);
        // h.add(11);
        // h.add(16);
        // h.add(33);
        // h.add(8);
        // h.add(3);
        // h.add(9);
        // h.add(77);
        // h.add(14);
        // h.add(41);

        // System.out.println(h.remove());
        // System.out.println(h.remove());
        // System.out.println(h.remove());
        // System.out.println(h.remove());

        Heapsort hs = new Heapsort(valores);
        hs.heapsort();
        hs.show();
    
    }
}