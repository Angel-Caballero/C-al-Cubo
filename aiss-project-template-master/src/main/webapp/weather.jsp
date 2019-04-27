<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather Info</title>
</head>
<body>
	<div id="openweathermap-widget-11"></div>
	<script src='//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/d3.min.js'></script>
	<script>window.myWidgetParam ? window.myWidgetParam : window.myWidgetParam = [];  window.myWidgetParam.push({id: 11,cityid: '2643743',appid: 'eaddc12fe18c112838e912e6534cb747',units: 'metric',containerid: 'openweathermap-widget-11',  });  
	(function() {var script = document.createElement('script');script.async = true;script.charset = "utf-8";script.src = "//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/weather-widget-generator.js";
	var s = document.getElementsByTagName('script')[0];
	s.parentNode.insertBefore(script, s);  })();
	</script>
</body>
</html>