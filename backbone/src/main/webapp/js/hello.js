/*
var User = Backbone.Model.extend({
  defaults: {
    name: null,
    age: null
  },

  say: function() {
    alert('僕は' + this.get('name') + '！' + this.get('age')  + '歳！');
  }
});*/
var AppView = Backbone.View.extend ({
   // el - stands for element. Every view has an element associated with HTML content, will be rendered.
   el: '#container',

   // It's the first function called when this view is instantiated.
   initialize: function() {
      this.render();
   },

   // $el - it's a cached jQuery object (el), in which you can use jQuery functions to push content.

   //Like the Hello TutorialsPoint in this case.
   render: function() {
      this.$el.html("Hello!");
   }
});
var appView = new AppView();