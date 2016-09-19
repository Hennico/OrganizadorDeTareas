<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tarea.label', default: 'Tarea')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-tarea" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-tarea" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.tarea}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.tarea}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.tarea}" method="PUT">
                <g:hiddenField name="version" value="${this.tarea?.version}" />
                <fieldset class="form">
                    <f:field bean="tarea" property="titulo"/>
                    <f:field bean="tarea" property="descripcion"/>
                    <f:field bean="tarea" property="prioridad"/>
					<f:field bean="tarea" property="objetivo"/>
					
					<div class="fieldcontain">
						<label>Estado</label>
						<g:textField name="estado" disabled="true" value="${this.tarea?.estado}"/>
						<input type="submit" controller="tarea" formaction="/tarea/cambiarAEjecucion?id=${this.tarea?.id}" value="En ejecucion" />
					</div>

					<div class="fieldcontain">
						<label>NuevoPadre</label>
						<g:select name="tarea.id"
						noSelection="['':'-NuevoPadree-']"
          					from="${Tarealist}"
						optionValue="name"
						optionKey="id"/>

						<input type="submit" controller="tarea" formaction="/tarea/agregarPadre?id=${this.tarea?.id}" value="Agregar" />
					</div>

                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>


        </div>
    </body>
</html>




