package desiginPattern.behavioral.observer.improvement;

/***
 * �ώ@�҃C���^�[�t�F�[�X
 * @author naka
 *
 */
public interface Observer {
	public void recive(String msg);
	//method to update the observer, used by subject
	//public void update();
	
	//attach with subject to observe
	//public void setSubject(Subject sub);
}