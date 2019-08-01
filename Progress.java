package percentage;

public class Progress implements Notifiable {
	private Indicator ind;
	public Progress(Indicator indicator) {ind=indicator;}
	@Override
	public void notify_t(double i) {
		ind.notify_t(i);
	}
	public void subscribe(Work p) {
		try {
			p.subscribe(this);
		} catch (G_informative e) {}
	}

}
