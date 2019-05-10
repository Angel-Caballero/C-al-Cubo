<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deezer Info</title>
</head>
<body>

	<h1>Tracks from "<c:out value="${requestScope.playlist}"/>"</h1>
	<c:forEach items="${requestScope.tracks}" var="track">
		<span>Track Name: <c:out value="${track.title}"/></span><br/>
	</c:forEach>
	
	<div id="dz-root"></div>
	<script src="https://e-cdns-files.dzcdn.net/js/min/dz.js"></script>
	<script>
	  window.dzAsyncInit = function() {
		DZ.init({
			appId  : '341062',
			channelUrl : 'http://c-al-cubo.appspot.com//channel.html',
		    player: {
		    	container: 'player',
				width : 800,
				height : 300,
                onload: function () { 
                    //configure the player with a set of tracks
                    //autoplay set to false
                    DZ.player.playPlaylist(15, false);
                }
            }
		});
	  };
	  (function() {
		var e = document.createElement('script');
		e.src = 'https://e-cdns-files.dzcdn.net/js/min/dz.js';
		e.async = true;
		document.getElementById('dz-root').appendChild(e);
	  }());
	</script>
	
	 <br/>

    <div id="container">
 
        <!-- Previous track -->
        <input class="player-button" type="button" onclick="DZ.player.prev();" value="Prev"/> 
        <!-- Play -->
        <input class="player-button" type="button" onclick="DZ.player.play();" value="Play"/>
        <!-- Pause -->
         <input class="player-button" type="button" onclick="DZ.player.pause();" value="Pause"/> 
        <!-- Next -->
         <input class="player-button" type="button" onclick="DZ.player.next();" value="Next"/>
    </div>
    <br/>
	
</body>
</html>