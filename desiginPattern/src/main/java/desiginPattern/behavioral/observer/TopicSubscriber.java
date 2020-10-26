package desiginPattern.behavioral.observer;

/***
 * My�L���w�ǎ҃N���X
 * @author naka
 *
 */
public class TopicSubscriber implements Observer {

	private String name;
	private Subject topic;

	public TopicSubscriber(String nm) {
		this.name = nm;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else {
			System.out.println(name + ":: Consuming message::" + msg);
		}
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

}