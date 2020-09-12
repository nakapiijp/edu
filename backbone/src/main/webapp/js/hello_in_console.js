var MyModel = Backbone.Model.extend({
    method: function() {
        console.log('Hello Model!!');
    }
});

var myModel = new MyModel();

myModel.method();