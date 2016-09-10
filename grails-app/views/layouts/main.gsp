<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div>
                <div>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/#">
                        <i class="fa grails-icon">
                            <asset:image src="grails-cupsonly-logo-white.svg"/>
                        </i> Grails
                    </a>
                </div>
                <div>
                    <a class="home" href="${createLink(uri: '/')}">
                        <input type="button" 
                                   value="Home" 
                                   style="
                                       color:#000;
                                       background-color:#3A3;
                                       border-color:#151;
                                       border: 2px solid;
                                       border-radius: 5px 15px 15px 15px;
                                   "
                            />
                    </a>

                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <g:link controller="${c.logicalPropertyName}">
                            <input type="button" 
                                   value="${c.name}" 
                                   style="
                                       color:#000;
                                       background-color:#3A3;
                                       border-color:#151;
                                       border: 2px solid;
                                       border-radius: 5px 15px 15px 15px;
                                   "
                            />
                        </g:link>
                    </g:each>
                </div>
            </div>  
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
