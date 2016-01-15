var angularBoot = angular.module('angularBoot', [ 'ngRoute',
		'angularBootControllers' ]);

angularBoot.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when("/wine", {
		templateUrl : 'templates/wine.html',
		controller : 'WineController'
	}).when('/hello', {
		templateUrl : 'templates/hello.html'
	}).when('/food', {
		templateUrl : 'templates/food.html',
		controller : 'FoodController'
	}).when('/wine/new', {
		templateUrl : 'templates/addwine.html'
	}).when('/food/new', {
		templateUrl : 'templates/addrecipe.html'
	}).otherwise({
		redirectTo : '/index'
	});
} ]);

angularBoot.controller('WineController', function($scope, $http, $location) {

	$http.get("endpoints/wine").success(function(data) {
		$scope.wines = data
	});

	$scope.addWine = function() {

		var added = $scope.wine;

		var params = JSON.stringify(added);

		console.log(params)
		$location.url('/wine');

		$http.post("endpoints/wine", params).success(
				function(data, status) {
					console.log(data)
				})

	};

});

angularBoot.controller('FoodController', function($scope, $http, $location) {
	$http.get("endpoints/food").success(function(data) {
		$scope.cookbook = data
	});

	$scope.addFood = function() {
		var added = $scope.food;
		var params = JSON.stringify(added);
		console.log(params)
		$location.url('/food');

		$http.post("endpoints/food", params).success(
				function(data, status) {
					console.log(data)
				})

	};

});
