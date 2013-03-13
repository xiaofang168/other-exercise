	//在jsp中使用
	_.templateSettings = {
		interpolate : /\{\{(.+?)\}\}/g
	};
	Man = Backbone.Model.extend( {
		url : context + '/index.do?method=test',
		// 初始化构造方法
		initialize : function() {
			// 初始化时绑定监听
		this.bind("change:name", function() {
			var name = this.get("name");
			alert("你改变了name属性为：" + name);
		});
		// 为对象添加验证规则，以及错误提示
		this.bind("error", function(model, error) {
			alert(error);
		});
	},
	// 默认值
		defaults : {
			name : '张三',
			age : '38'
		},
		// 验证
		validate : function(attributes) {
			if (attributes.name == '') {
				return "name不能为空！";
			}
		},
		// 类方法定义
		aboutMe : function() {
			return '我叫' + this.get('name') + ',今年' + this.get('age') + '岁';
		}
	});
	SearchView = Backbone.View.extend( {
		initialize : function() {
			this.render();
		},
		render : function() {
			// 使用underscore这个库，来编译模板
		var template = _.template($("#search_template").html(), {
			search_label : 'test search'
		});
		// 加载模板到对应的el属性中
		$(this.el).html(template);
	},
	// 事件绑定
		events : {
			"click #search_button" : "doSearch"
		// 'click input[type=button]' : 'doSearch'
	    //定义类型为button的input标签的点击事件，触发函数doSearch

		},
		doSearch : function(event) {
			alert("search for " + $("#search_input").val());
		}
	});
	var searchView = new SearchView( {
		el : $("#search_container")
	});
   // var man = new Man;
	// //赋值定义
	// man.set({name:'the5fire',age:'10'});
	//根据验证规则，弹出错误提示
	// man.set({name:''});
	// man.save();
	// //不过接受服务器端返回的数据方法是这样的：
	// man.fetch({url:'/index.do?method=test',success:function(collection,response){
	// alert('success');
	// //collection为获取到的数据
	// alert(collection.get('1').name);
	// var jsonStr=JSON.stringify(collection);
	// alert(jsonStr);
	// },error:function(){
	// //当返回格式不正确或者是非json数据时，会执行此方法
	// alert('error');
	// }});
