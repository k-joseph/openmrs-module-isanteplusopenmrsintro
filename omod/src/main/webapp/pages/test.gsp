<% ui.includeJavascript("uicommons", "jquery-1.8.3.min.js") %>
<% ui.includeJavascript("uicommons", "angular.js") %>
<% ui.includeJavascript("isanteplusopenmrsintro", "encounterTypesAngular.js") %>

<%
    ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
        { label: "${ ui.message("isanteplusopenmrsintro.title") }" }
    ];
</script>

This is a sample test reference application page: ${user.systemId}
<br />
<h3>List Of All Encounter Types Available:</h3>

<div ng-app="encTypesApp" ng-controller="encTypesController">
	<table>
		<tr>
			<th>Encounter Type Name</th>
			<th>Encounter Type Uuid</th>
		</tr>
		<tr ng-repeat="encType in encounterTypes">
			<td>{{encType.display}}</td>
			<td>{{encType.uuid}}</td>
		</tr>
	</table>
</div>




