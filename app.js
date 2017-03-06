var app = angular.module('app', [ 'ngTouch', 'ui.grid' ]);

app.controller('MainCtrl', function($scope, $rootScope, $http, $log) {

	var _successCallback = function(data, status, headers) {

		$scope.myArray = [];
		$scope.myArray = data;
		console.log("name is  : : ", $scope.myArray.data[1].name);

		$rootScope.myNewArray = $scope.myArray;
		console.log("New name is  : : ", $rootScope.myNewArray.data[1].name);
	};
	var _errorCallback = function(data, status, headers) {
	};

	$scope.UserAkshay = $http({
		method : 'GET',
		url : 'NgJsonServlet'
	}).then(_successCallback, _errorCallback);

	console.log("Last Line: : ", $rootScope.myNewArray);
	$scope.data = [];

	$scope.columnDefs = [ {
		name : 'name',
		enableCellEdit : true
	}, {
		name : 'title',
		enableCellEdit : true
	} ];

})

/*
 * $scope.data = [ { name : 'Bob', title : 'CEO' }, { name : 'Frank', title :
 * 'Lowly Developer' } ];
 * 
 * $scope.columnDefs = [ { name : 'name', enableCellEdit : true }, { name :
 * 'title', enableCellEdit : true } ];
 */

