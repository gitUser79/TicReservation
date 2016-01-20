package reservation;

class Reserve implements Runnable {
	int availble = 2;
	int wanted;

	public Reserve(int i) {
		wanted = i;
	}

	@Override
	public void run() {
		// runnable
          ReserveTicket();
	}

	synchronized void ReserveTicket() {

		// running
		System.out.println("Available Berths=" + availble);
		if (availble >= wanted) {
			System.out.println(Thread.currentThread().getPriority());
			String name = Thread.currentThread().getName();
			System.out.println(wanted + " Berths Reserved for " + name);
			try {

				availble = availble - wanted;// deduct
				for (int i = 0; i <= 5; i++) {
					Thread.sleep(1500);
					System.out.println("Wait.....");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Sorry no berths availbe.");

		}

	}

}

class Test {
	void startAll() {
		Reserve reserve = new Reserve(1);
		Thread t1 = new Thread(reserve);
		Thread t2 = new Thread(reserve);
		Thread t3 = new Thread(reserve);
		t1.setName("xxx");
		t2.setName("yyy");
		t3.setName("ggg");
		t1.start();
		t2.start();
		t3.start();

	}

}

public class BookTicket {

	public static void main(String[] args) {

		new Test().startAll();
	}

}
