var User = Backbone.Model.extend({
  defaults: {
    name: null,
    age: null
  },

  say: function() {
    alert('僕は' + this.get('name') + '！' + this.get('age')  + '歳！');
  }
});
var user = new User({ name: 'hokaccha', age: 28 });
user.say(); //=> 「僕はhokaccha！28歳！」というアラートが表示される