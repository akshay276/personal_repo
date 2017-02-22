var myApp = angular.module('myApp', []);
myApp.controller('submitController', [ '$scope', 'multipartForm',

function($scope, multipartForm) {
	$scope.customer = {}
	$scope.Submit = function() {
		console.log("Inside submitController");
		var uploadUrl = 'upload';
		console.log("$scope customer is :" , $scope.customer);
		multipartForm.post(uploadUrl, $scope.customer);
		console.log("controller last Line");

	}

} ])