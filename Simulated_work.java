package percentage;

public class Simulated_work extends Work {
	private int tmin,tmax;
	public Simulated_work(int nn, int kk,int min,int max) {
		super(nn, kk);tmin=min;tmax=max;
	}

	public void w_finish() throws InterruptedException {
		sleep((long) (Math.random()*(tmax-tmin)));
	}

}
