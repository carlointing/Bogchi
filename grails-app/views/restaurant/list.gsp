
<%@ page import="org.synergis.bogchi.Restaurant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'restaurant.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'restaurant.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="address" title="${message(code: 'restaurant.address.label', default: 'Address')}" />
                        
                            <g:sortableColumn property="city" title="${message(code: 'restaurant.city.label', default: 'City')}" />
                        
                            <g:sortableColumn property="openingHours" title="${message(code: 'restaurant.openingHours.label', default: 'Opening Hours')}" />
                        
                            <g:sortableColumn property="phoneNumber" title="${message(code: 'restaurant.phoneNumber.label', default: 'Phone Number')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${restaurantInstanceList}" status="i" var="restaurantInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${restaurantInstance.id}">${fieldValue(bean: restaurantInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: restaurantInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: restaurantInstance, field: "address")}</td>
                        
                            <td>${fieldValue(bean: restaurantInstance, field: "city")}</td>
                        
                            <td>${fieldValue(bean: restaurantInstance, field: "openingHours")}</td>
                        
                            <td>${fieldValue(bean: restaurantInstance, field: "phoneNumber")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${restaurantInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
