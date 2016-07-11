var encTypeRestUrl = "../ws/rest/v1/encountertype";

angular.module("encTypesApp", []).controller("encTypesController", function($scope) {//basic angular app and controller definition, its added onto an element as on table
	jQuery.ajax({//this does a rest webservice request to get encounter types
		url:encTypeRestUrl,
		async:false,
		success: function(fetchedEncounterTypes) {
			$scope.encounterTypes = fetchedEncounterTypes.results;//these are looped through with ng-repeat in the encounter types table data below
		}
	});
});