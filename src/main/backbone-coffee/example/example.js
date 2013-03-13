// Define a Todo Model
var Todo = Backbone.Model.extend( {
	// Default todo attribute values
		defaults : {
			title : '',
			completed : false
		}
	});

// Instantiate the Todo Model with a title, allowing completed attribute
// to default to false
var todo = new Todo( {
	title : 'Check attributes property of the logged models in the console.'
});

var TodoView = Backbone.View.extend( {
	initialize : function() {
		this.render();
	},
	tagName : 'li',
	// Cache the template function for a single item.
	todoTpl : _.template($('#item-template').html()),
	events : {
		'dblclick label' : 'edit',
		'keypress #edit' : 'updateOnEnter',
		'blur #edit' : 'close'
	},
	// Re-render the titles of the todo item.
	render : function() {	
		$(this.el).html(this.todoTpl(this.model.toJSON()));
		this.input = this.$('#edit');
		return this;
	},
	edit : function() {
		// executed when todo label is double clicked
},
close : function() {
	// executed when todo loses focus
},
updateOnEnter : function(e) {
	// executed on each keypress when in todo edit mode,
	// but we'll wait for enter to get in action
}
});

// create a view for a todo
var todoView = new TodoView( {
	model : todo,
	el : $("#todo")
});