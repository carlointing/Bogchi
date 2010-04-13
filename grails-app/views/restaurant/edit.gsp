
<%@ page import="org.synergis.bogchi.Restaurant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'restaurant.label', default: 'Restaurant')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${restaurantInstance}">
            <div class="errors">
                <g:renderErrors bean="${restaurantInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${restaurantInstance?.id}" />
                <g:hiddenField name="version" value="${restaurantInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="restaurant.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" maxlength="100" value="${restaurantInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address"><g:message code="restaurant.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'address', 'errors')}">
                                    <g:textArea name="address" cols="40" rows="5" value="${restaurantInstance?.address}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="restaurant.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" maxlength="50" value="${restaurantInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="openingHours"><g:message code="restaurant.openingHours.label" default="Opening Hours" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'openingHours', 'errors')}">
                                    <g:textField name="openingHours" maxlength="200" value="${restaurantInstance?.openingHours}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="phoneNumber"><g:message code="restaurant.phoneNumber.label" default="Phone Number" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'phoneNumber', 'errors')}">
                                    <g:textField name="phoneNumber" maxlength="15" value="${restaurantInstance?.phoneNumber}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="restaurant.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${restaurantInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="website"><g:message code="restaurant.website.label" default="Website" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'website', 'errors')}">
                                    <g:textField name="website" value="${restaurantInstance?.website}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="additionalComments"><g:message code="restaurant.additionalComments.label" default="Additional Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: restaurantInstance, field: 'additionalComments', 'errors')}">
                                    <g:textArea name="additionalComments" cols="40" rows="5" value="${restaurantInstance?.additionalComments}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
