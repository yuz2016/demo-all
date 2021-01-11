package com.example.beforeall.produceconsumer;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2021-01-11
 */
public class ProdConsDemo {


    static class Store {
        private int count;
        private int cur = 0;

        public Store(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCur() {
            return cur;
        }

        public void setCur(int cur) {
            this.cur = cur;
        }

        public boolean isEmpty(int i) {
            return cur - i < 0;
        }

        public boolean isFull(int i) {
            return cur + i  > count;
        }

        public void incrCur(int i) {
            cur += i;
        }

        public void reduceCur(int i) {
            cur -= i;
        }

    }

    static class Prod{

        private Store store;

        public Prod(Store store) {
            this.store = store;
        }

        void produce(int i) throws InterruptedException {
            synchronized (store) {
                while(store.isFull(i)) {
                    System.out.println("produce wait it,,," + i);
                    store.wait();
                }
                store.incrCur(i);
                System.out.println("produce do it,,," + i);
                store.notify();
            }
        }


    }

    static class Cons implements Runnable{

        private Store store;

        public Cons(Store store) {
            this.store = store;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumer(1);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        void consumer(int i) throws InterruptedException {
            synchronized (store) {
                while(store.isEmpty(i)) {
                    System.out.println("consumer wait it,,," + i);
                    store.wait();
                }
                store.reduceCur(i);
                System.out.println("consumer do it,,," + i);
                store.notify();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store(10);
        new Thread(new Cons(store)).start();
        Prod prod = new Prod(store);
        Thread.sleep(2000);
        prod.produce(2);
        Thread.sleep(2000);
        prod.produce(3);
        Thread.sleep(2000);
        prod.produce(10);
//        Thread.sleep(2000);
//        prod.produce(10);


    }


}
