class Item extends Backbone.Model
	defaults:
		part1: 'Hello'
		part2: 'Backbone'
class ItemView extends Backbone.View
	tagName: 'li'
	initialize: ->
    	_.bindAll @
    	@render()
    render: ->
    		$(@el).html "<span>#{@model.get 'part1'} #{@model.get 'part2'}!</span>"
class List extends Backbone.Collection
	model: Item
class ListView extends Backbone.View
	el: $ 'body'
	initialize: ->
      	@collection = new List
      	@collection.bind 'add', @appendItem
      	@counter = 0
      	@render()
	render: ->
	      	$(@el).append '<button>Add List Item</button>'
	      	$(@el).append '<ul>dd</ul>'
	addItem: ->
      	item = new Item
      	@counter++
      	item.set part2: "#{item.get 'part2'} #{@counter}"
      	@collection.add item
	appendItem: (item) ->
		item_view = new ItemView model: item
		$('ul').append item_view.el
	events: 'click button': 'addItem'
list_view = new ListView