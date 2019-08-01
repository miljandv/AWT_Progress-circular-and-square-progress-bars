package percentage;

public abstract class Work extends Thread {
	private int n,k,working;
	private Notifiable o;
	public Work(int nn,int kk) {n=nn;k=kk;start();}
	public void run() {try {		
		while(!interrupted()) {
			for (int i = 0; i < n; i++) {
				synchronized (this) {if(working==0)wait();}
				w_finish();
				if(n%k==0)o.notify_t(i/(n*1.0));
			}
		}
	}catch (InterruptedException e) {}
	}
	public void subscribe(Notifiable oo)throws G_informative {try {
		if(o==null)o=oo;else throw new G_informative();
		}catch (G_informative e) {System.err.println(e);}	
	 }
	
	public synchronized boolean isover() {return working==0?false:true;}
	public synchronized void w_stop() {working=0;}
	public synchronized void w_continue() {working=1;notify();}
	public void w_interrupt() {interrupt();}
	public abstract void w_finish() throws InterruptedException;
}
