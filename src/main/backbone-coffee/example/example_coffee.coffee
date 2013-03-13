jQuery ->
class Todo extends  Backbone.Model
		defaults : 
			title : ''
			completed : false
class List extends Backbone.Collection
		model: Todo
todo = new Todo title : 'Check attributes property of the logged models in the console.',completed:true
class ItemView extends Backbone.View
	tagName: 'li'
	initialize: ->
		_.bindAll @
		@render()
	render: ->
		$(@el).html "<span>#{@model.get 'title'} #{@model.get 'completed'}!</span>"
	@
class TodoView  extends Backbone.View
	el: $ 'body'
	initialize: ->
		_.bindAll @
		@collection = new List
		@collection.bind "add", @appendItem 
		@counter = 0
		@render()
	todoTpl : _.template($('#item-template').html())
	render: ->
			$(@el).html(@todoTpl(@model.toJSON()))
			#注释
			#$(@el).append '<ul><li>Hello, Backbone!注释是"#"</li></ul>'
			$(@el).append '<button>Add List Item</button>'
			$(@el).append '<ul></ul>'
	addItem: ->
			@counter++
			$('ul').append "<li>Hello, Backbone #{@counter}!</li>"
			#alert(@counter)
			item = new Todo title : 'Hello World',completed:true
			item.set title: "#{item.get 'title'} #{@counter}"
			@collection.add item
	appendItem:(item) ->
	 		item_view=new ItemView model:item
      		#$('ul').append item_view.render().el
      		#$('ul').append "<li>#{item.get 'title'} #{item.get 'completed'}!</li>"
	events: 'click button': 'addItem'
todoView = new TodoView model : todo,el : $("#todo")
