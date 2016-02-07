var jsUi = angular.module('jsUiApp');

jsUi.controller('HomeController', ['serverURL', '$http', '$scope',
	function(serverURL, $http, $scope) {

	$scope.searchedEntriesGridColumns = [
       		{field: "entry", title: "Searched entry", width: "100%"}
       	];

    $scope.searchedEntriesOptions = {
     		sortable: true,
     		pageable: true,
     		dataSource: $scope.searchedConceptEntriesDataSource
     	};

    $scope.searchedConceptEntriesDataSource = new kendo.data.DataSource({
 		pageSize: 20,
 		serverPaging: true,
 		serverFiltering: true,
 		serverSorting: true,
 		transport: {
 			read: serverURL.url + "/searchEntry",
 		}
 	});
	
}]);
