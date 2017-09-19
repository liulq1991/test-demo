public class TestThread {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("A:" + i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("B:" + i);
				}
			}
		}).start();
		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("C:" + i);
			}
		}).start();

	}
}
