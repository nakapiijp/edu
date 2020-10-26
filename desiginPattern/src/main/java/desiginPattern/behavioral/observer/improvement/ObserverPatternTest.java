package desiginPattern.behavioral.observer.improvement;

public class ObserverPatternTest {

	public static void main(String[] args) {
		//create subject　食べ物の記事
		FoodTopic topic = new FoodTopic();
		
		//create observers　購読者を作成
		Observer obj1 = new TopicSubscriber("洋子");
		Observer obj2 = new TopicSubscriber("恵子");
		Observer obj3 = new TopicSubscriber("みゆき");
		
		//register observers to the subject　食べ物の記事へ購読者を登録
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject　各購読者に食べ物の記事を設定
		// FoodTopic <--> TopicSubscriber 相互にメンバーを持ち合うのでよろしくない
		//obj1.setSubject(topic);
		//obj2.setSubject(topic);
		//obj3.setSubject(topic);
		
		//check if any update is available
		//obj1.update();
		
		//now send message to subject
		topic.postMessage("秋の栗を使った料理");
	}

}
