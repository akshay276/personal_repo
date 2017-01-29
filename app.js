/**
 * Akshay Kolhe 20-1-30 1:19 AM
 */

var app = angular.module('myApp', [ 'ui.router' ]);

/*-------------------------------CONTROLLER FOR DYNAMIC STATES--------------------------*/

app.controller('myCtrl', function($scope, $http) {
	$scope.profileData;

	$scope.getProfileData = function() {

		console.log("inside Function()");

		var _successCallback = function(data, status, headers) {

			$scope.profileData = data;
			console.log('data is ', $scope.profileData.data);

		};

		var _errorCallback = function(data, status, headers) {

		};

		$http({

			method : 'GET',
			url : 'NgArray'

		}).then(_successCallback, _errorCallback);

	}

	$scope.getProfileData();

}

);

/*-------------------------------CONFIG STATES--------------------------*/

app.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state("settings", {
		url : "/settings",
		templateUrl : "settings.html"
	}).state("settings.summary", {
		url : "/summary",
		templateUrl : "summary.html"
	}).state("settings.profile", {
		url : "/profile",
		templateUrl : "profile.html"
	})

	.state("settings.profile.personal", {
		url : "/personal",
		templateUrl : "personal.html"
	}).state("settings.downloads", {
		url : "/downloads",
		templateUrl : "downloads.html"
	})

	.state("settings.statements", {
		url : "/statements",
		templateUrl : "statements.html"

	})
	/*
	 * .state("settings.tradeHistory", { url : "/tradeHistory", templateUrl :
	 * "tradeHistory.html" })
	 * 
	 * .state("settings.portfolio", { url : "/portfolio", templateUrl :
	 * "portfolio.html" })
	 * 
	 * .state("settings.capgain", { url : "/capgain", templateUrl :
	 * "capgain.html" });
	 */
	$urlRouterProvider.otherwise("/settings");

});