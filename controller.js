var app = angular.module("myAppInit", [ "ngRoute" ]);

/*-----------------------------CONFIG--------------------------*/
app.config(function($routeProvider) {
	/*
	 * .when("/welcome", {
	 * 
	 * resolve : { "check" : function($location, $rootScope) {
	 * 
	 * if (!$rootScope.loggedIn) { $location.path('/'); } } }, templateUrl :
	 * "welcome.html", controller : "myAppDataCtrl" })
	 */
	$routeProvider.when("/", {
		templateUrl : "login.html",
		controller : "myAppCtrl"
	}).when("/register", {
		/*
		 * resolve : { "check" : function($location, $rootScope) {
		 * 
		 * if (!$rootScope.loggedIn) { $location.path('/'); } } },
		 */

		templateUrl : "register.html",
		controller : "myAppCtrl"
	}).otherwise({

		redirectTo : '/'
	});

});

/*-----------------------------CONTROLLER--------------------------*/

app.controller('myAppDataCtrl', function($scope, $rootScope, $location,
		$timeout) {

	console.log("USERNAME IS : " + $rootScope.UserDetail.data.username);
	$scope.welcomeName = $rootScope.UserDetail.data.username;

	console.log($scope.welcomeName);

});

app.controller('myAppCtrl', function($scope, $rootScope, $http, $log,
		$location, $timeout) {

	$scope.flag = false;
	$scope.onSubmitLogin = function() {

		var _successCallback = function(data, status, headers) {

			$rootScope.UserDetail = data;
			console.log('data is ' + $rootScope.UserDetail.data.username);
			$log.info($rootScope.UserDetail.data);
			$rootScope.loggedIn = true;
			console.log("Hello");
			/* $location.path('/welcome'); */
			window.location = "welcomeUI.html"
		};

		var _errorCallback = function(data, status, headers) {
			$log.info(data);
			// window.location = "error.html";
			$scope.passWordLogin = null;
			$scope.userNameLogin = null;
			// alert("Incorrect Username or Password");

		};

		$scope.UserAkshay = $http({

			method : 'POST',
			url : 'NgUser',
			params : {
				userName : $scope.userNameLogin,
				passWord : $scope.passWordLogin
			}
		}).then(_successCallback, _errorCallback);

	};

	$scope.onSubmitRegistration = function() {

		var _successEntry = function(data, status, headers) {
			$scope.Users = data;
			$log.info(data);

			$timeout(function() {

				window.location = "afterReg.html";
			}, 2000);

		}
		var _failedEntry = function(data, status, headers) {
			$scope.Users = data;
			$log.info(data);

			$timeout(function() {
				window.location = "afterError.html";

			}, 2000);
		}

		$http({

			method : 'GET',
			url : 'NgUser',
			params : {
				userName : $scope.userNameReg,
				passWord : $scope.passWordReg,
				emailId : $scope.emailReg,
				empId : $scope.empIdReg
			}

		}).then(_successEntry, _failedEntry)

	};

});