package japp;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int duration = 5000;

		while (true) {
			try {
				long millis=System.currentTimeMillis();
				java.util.Date date=new java.util.Date(millis);
				System.out.println(date);

				Thread.sleep(duration);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
