<%@ page contentType="text/html;charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
    <title>${Title}</title>
    <META http-equiv=Content-Type content="text/html; charset=GBK">
	<LINK href="${Context}/common/css/std_jx.css" type=text/css rel=stylesheet>
    
    <!-- 
    <script src="${Context }/test/backbone/js/backbone-localstorage.min.js"></script>
    -->
    <script type="text/javascript">
    	var context="${Context}";
    </script>
</head>
<body>
<div style="width: 650px;margin: 0 auto;" id="app">
<button id="check">报到</button>
<div id="search_container"></div>

<ul id="world-list">
    
</ul>
<script src="${Context }/test/backbone/js/jquery-1.8.2.min.js"></script>
<script src="${Context }/test/backbone/js/underscore-1.4.4.min.js"></script>
<script src="${Context }/test/backbone/js/backbone-0.3.3.min.js"></script>
<script src="${Context }/test/backbone/js/json2.min.js"></script>
<script type="text/template" id="search_template">
        <label>{{search_label}}</label>
        <input type="text" id="search_input" />
        <input type="button" id="search_button" value="Search" />


</script>
<script src="${Context }/test/backbone/app.js"></script>
<script type="text/javascript">
//underscore.js 用法
//_.each([1, 2, 3], function(num){ alert(num); }); 
</script>
</div>
</body>
</html>