<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deezer Info</title>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
 <script type="text/javascript" src="https://e-cdns-files.dzcdn.net/js/min/dz.js"></script>
 
 <style type="text/css">
        .progressbarplay {
            cursor:pointer;overflow: hidden;height: 8px;margin-bottom: 8px;background-color: #F7F7F7;background-image: -moz-linear-gradient(top,whiteSmoke,#F9F9F9);background-image: -ms-linear-gradient(top,whiteSmoke,#F9F9F9);background-image: -webkit-gradient(linear,0 0,0 100%,from(whiteSmoke),to(#F9F9F9));background-image: -webkit-linear-gradient(top,whiteSmoke,#F9F9F9);background-image: -o-linear-gradient(top,whiteSmoke,#F9F9F9);background-image: linear-gradient(top,whiteSmoke,#F9F9F9);background-repeat: repeat-x;filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5',endColorstr='#f9f9f9',GradientType=0);-webkit-box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);-moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);-webkit-border-radius: 6px;-moz-border-radius: 6px;border-radius: 6px;
        }
        .progressbarplay .bar {
            cursor:pointer;background: #4496C6;width: 0;height: 8px;color: white;font-size: 12px;text-align: center;text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);-webkit-box-shadow: inset 0 -1px 0 rgba(0, 0, 0, 0.15);-moz-box-shadow: inset 0 -1px 0 rgba(0,0,0,0.15);box-shadow: inset 0 -1px 0 rgba(0, 0, 0, 0.15);-webkit-box-sizing: border-box;-moz-box-sizing: border-box;box-sizing: border-box;-webkit-transition: width .6s ease;-moz-transition: width .6s ease;-ms-transition: width .6s ease;-o-transition: width .6s ease;transition: width .6s ease;
        }
  </style>
    
</head>
<body>

	<h1>Tracks from "<c:out value="${requestScope.playlist.title}"/>"</h1>
	<c:forEach items="${requestScope.tracks}" var="track">
		<span>Track Name: <c:out value="${track.title}"/></span><br/>
	</c:forEach>

<div id="dz-root"></div>
<div id="controlers">
    <input type="button" onclick="DZ.player.playAlbum(302127); return false;" value="Play Daft Punk - Discovery"/>
    <input type="button" onclick="DZ.player.playAlbum(301775); return false;" value="Play Daft Punk - Homework"/>
    <br/>
    <input type="button" onclick="DZ.player.play(); return false;" value="play"/>
    <input type="button" onclick="DZ.player.pause(); return false;" value="pause"/>
    <input type="button" onclick="DZ.player.prev(); return false;" value="prev"/>
    <input type="button" onclick="DZ.player.next(); return false;" value="next"/>
    <br/>
    <input type="button" onclick="DZ.player.setVolume(20); return false;" value="set Volume 20"/>
    <input type="button" onclick="DZ.player.setVolume(80); return false;" value="set Volume 80"/>
    <br/><br/><br/>
</div>
<div id="slider_seek" class="progressbarplay" style="">
    <div class="bar" style="width: 0%;"></div>
</div>
<script>
    $(document).ready(function(){
        $("#controlers input").attr('disabled', true);
        $("#slider_seek").click(function(evt,arg){
            var left = evt.offsetX;
            console.log(evt.offsetX, $(this).width(), evt.offsetX/$(this).width());
            DZ.player.seek((evt.offsetX/$(this).width()) * 100);
        });
    });
    function event_listener_append() {
        var pre = document.getElementById('event_listener');
        var line = [];
        for (var i = 0; i < arguments.length; i++) {
            line.push(arguments[i]);
        }
        pre.innerHTML += line.join(' ') + "\n";
    }
    function onPlayerLoaded() {
        $("#controlers input").attr('disabled', false);
        event_listener_append('player_loaded');
        DZ.Event.subscribe('current_track', function(arg){
            event_listener_append('current_track', arg.index, arg.track.title, arg.track.album.title);
        });
        DZ.Event.subscribe('player_position', function(arg){
            event_listener_append('position', arg[0], arg[1]);
            $("#slider_seek").find('.bar').css('width', (100*arg[0]/arg[1]) + '%');
        });
 
        DZ.Event.subscribe('track_end', function() {
            event_listener_append('track_end');
        });
    }
    document.addEventListener('DOMContentLoaded', function() {
        DZ.init({
            appId  : '341062',
            channelUrl : 'http://c-al-cubo.appspot.com//channel.html',
            player : {
                onload : onPlayerLoaded
            }
        });
    });
</script><br/>
event_listener : <br/>
<pre id="event_listener" style="height:100px;overflow:auto;"></pre>
</body>
</html>