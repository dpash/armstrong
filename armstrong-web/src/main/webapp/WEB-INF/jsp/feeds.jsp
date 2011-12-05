<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <html>
         <head>
            <title>Planet Catnip</title>
            <link rel="stylesheet" media="screen" type="text/css"
               href="http://www.catnip.org.uk/css/site.css"/>
            <base href="http://www.catnip.org.uk"/>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"/>
            <!--<script
               src="https://www.catnip.org.uk/js/jquery-1.2.6.min.js"/>-->
            <script src="http://www.catnip.org.uk/js/jquery.dimensions.min.js"/>
            <script src="http://www.catnip.org.uk/js/armstrong.js"/>
         </head>
         <body>
            <div id="control">
               <ul>
                  <li>
                     <a href="javascript:toggle_read()" id="show_read_link">Show read items</a>
                  </li>
               </ul>
               <p id="status"></p>
            </div>
            <div id="page">
               <div id="header">
                  Planet Catnip
               </div>
               <div id="menu">
                  Home | Blog | Articles | About | Projects | Contact
               </div>

               <div id="sidebar">
                  <div id="about">
                     <h1>About</h1>
                     <p>
                        <a href="rss10.xml"><img class="button" src="/images/rss10.png" width="80" height="15" alt="[RSS 1.0 Feed]"/></a>
                        <a href="rss20.xml"><img class="button" src="/images/rss20.png" width="80" height="15" alt="[RSS 2.0 Feed]"/></a>
                        <a href="foafroll.xml"><img class="button" src="/images/foaf.png" width="80" height="15" alt="[FOAF Subscriptions]"/></a>
                        <a href="opml.xml"><img class="button" src="/images/opml.png" width="80" height="15" alt="[OPML Subscriptions]"/></a>
                        <a href="http://www.catb.org/hacker-emblem/"><img class="button" src="/images/hacker.png" width="80" height="15" alt="[Hacker]"/></a>
                        <a href="http://www.planetplanet.org/"><img class="button" src="/images/planet.png" width="80" height="15" alt="[Planet]"/></a>
                     </p>
                  </div>
                  <div id="freshness">
                     <p>
                        <em>Last updated: ${modified}</em>
                     </p>
                  </div>
				   <div id="blogroll">
					   <h1>Subscriptions</h1>
					   <ul>
						   <c:forEach var="feed" items="${feeds}">
							   <li>
								   <a href="${feed.feedUrl}" title="feed.feedName">
									   <img src="http://www.catnip.org.uk/images/feed-icon-10x10.png" alt="feed"/>
								   </a>
								   <c:choose>
									   <c:when test="${feed.statusMessage != ''}">
										   <a href="${feed.url}" title="${feed.statusMessage}" class="message">${feed.feedName}</a>
									   </c:when>
									   <c:otherwise>
										   <a href="${feed.url}" title="${feed.title}">${feed.feedName}</a>
									   </c:otherwise>
								   </c:choose>

							   </li>
						   </c:forEach>
					   </ul>
				   </div>

			   </div>
	<div id="body">
		<div id="content">
			<ul>
				<c:forEach var="entry" items="${entries}">
					<li><c:out value="${entry.link}"/></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="footer">
		Design and Content Copyright 2006 David Pashley<br/>
		All Rights Reserved
	</div>


</div>
</body>
</html>