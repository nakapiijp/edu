package desiginPattern.behavioral.observer.improvement;

public class ObserverPatternTest {

	public static void main(String[] args) {
		//create subject�@�H�ו��̋L��
		FoodTopic topic = new FoodTopic();
		
		//create observers�@�w�ǎ҂��쐬
		Observer obj1 = new TopicSubscriber("�m�q");
		Observer obj2 = new TopicSubscriber("�b�q");
		Observer obj3 = new TopicSubscriber("�݂䂫");
		
		//register observers to the subject�@�H�ו��̋L���֍w�ǎ҂�o�^
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject�@�e�w�ǎ҂ɐH�ו��̋L����ݒ�
		// FoodTopic <--> TopicSubscriber ���݂Ƀ����o�[�����������̂ł�낵���Ȃ�
		//obj1.setSubject(topic);
		//obj2.setSubject(topic);
		//obj3.setSubject(topic);
		
		//check if any update is available
		//obj1.update();
		
		//now send message to subject
		topic.postMessage("�H�̌I���g��������");
	}

}
