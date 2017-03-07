var app = angular.module('app', [ 'ngTouch', 'ui.grid', 'ui.grid.edit' ]);

app.controller('MainCtrl', function($scope, $rootScope, $http, $log) {
	$rootScope.rootJsonData ={};
	var _successCallback = function(data, status, headers) {
		$rootScope.rootJsonData;
		$rootScope.rootJsonData = data;
		console.log($rootScope.rootJsonData.data.clientFileList[0].listofFields[0]);
		$scope.getJsonData();
	};
	var _errorCallback = function(data, status, headers) {
	};

	$scope.UserAkshay = $http({
		method : 'GET',
		url : 'NgJsonServlet'
	}).then(_successCallback, _errorCallback);
	
	$scope.getJsonData = function() {
		console.log("in func" ,$rootScope.rootJsonData.data.clientFileList[0].listofFields[0]);
	}

	$scope.myData = [$rootScope.rootJsonData];

	$scope.gridOptions = {
		enableSorting : true,
		data : $scope.myData
	};
});
