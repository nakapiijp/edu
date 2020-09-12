//Person Model
const Person = Backbone.Model.extend(
  {
    defaults:
    {
      area: "東京都"
    }
  }
);

//Person Collection
const Users = Backbone.Collection.extend(
  {
    model: Person
  }
);

const users = new Users();

//データ追加
users.add({ name: "次郎", age: 28 });
users.add({ name: "花子", age: 25 });
users.add({ name: "三郎", age: 32 });
users.add({ name: "田中", age: 25 });

//li要素の作成
const LI_view = Backbone.View.extend(
  {
    tagName: "li",
    template: _.template($("#user-template").html()),
    render: function () {
      //コレクションのデータをテンプレートに反映
      const template = this.template(this.model.toJSON());
      this.$el.html(template);
      return this;
    }
  }
);

//ul要素の作成
const UL_view = Backbone.View.extend(
  {
    tagName: "ul",
    render: function () {
      //コレクションの各データを元にli要素を作成する
      this.collection.each(
    	function (data) {
          const li = new LI_view(
            {
              model: data
            }
          );
          //LI_view.render()をCallしHtmlのli要素を返す
          //console.log(li.render().el);
          this.$el.append(li.render().el);
        },
        this
      );//each
      return this;
    }
  }
);


const ul = new UL_view({ collection: users });

//ul要素を画面に描画
//UL_view.render()をCallしHtmlのUi要素を返しbodyに挿入する
$("body").html(ul.render().el);