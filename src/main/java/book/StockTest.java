package book;

public  class StockTest {
    public static void main(String[] args) {
        book book1=new book();
        book1.setStock(1);
        // 2. 定义任务：多个人来借这本书
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 这里的逻辑就是：调用书本身的借书方法
                book1.borrow();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 1; i <=10 ; i++) {
            Thread t=new Thread( task,"线程"+i);
            threads[i - 1] = t;
            t.start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("最终库存: " + book1.getStock());
    }
}
