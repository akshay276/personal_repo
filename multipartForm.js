myApp.service('multipartForm', [ '$http', function($http) {
	this.post = function(uploadUrl, data) {
		var fd = new FormData();
		for ( var key in data)
			fd.append('key', data[key]);

		$http.post(uploadUrl, fd, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}
		}).success(function() {
			console.log("success function after post in service");
		}).error(function() {
			console.log("error function after post in service");
		});
	}
} ]);