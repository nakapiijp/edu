package desiginPattern.behavioral.observer.improvement;

/***
 * MyãLéñçwì«é“ÉNÉâÉX
 * @author naka
 *
 */
public class TopicSubscriber implements Observer {

	private String name;
	//private Subject topic;

	public TopicSubscriber(String nm) {
		this.name = nm;
	}

	public void recive(String msg) {
		System.out.println(name + " " + msg);
	}
//	@Override
//	public void update() {
//		String msg = (String) topic.getUpdate(this);
//		if (msg == null) {
//			System.out.println(name + ":: No new message");
//		} else {
//			System.out.println(name + ":: Consuming message::" + msg);
//		}
//	}
//
//	@Override
//	public void setSubject(Subject sub) {
//		this.topic = sub;
//	}

}
