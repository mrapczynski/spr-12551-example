//= require_self (1)
//= require_tree /ng-views

// Create FHDA Angular application and its main dependencies
var fhdaApp = angular.module('fhdaApp', ['ngAria', 'ngRoute']);

// Create the view router
fhdaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/index', {
        templateUrl: 'index.htm',
        controller: 'indexController'
    })
    .otherwise({
        redirectTo: '/index'
    });
}]);

// Create a controller for the 'index' view
fhdaApp.controller('indexController', ['$scope', function($scope) {
    $scope.clickEvent = function() {
        alert('You clicked me!');
    }
}]);
angular.module('fhdaApp').run(['$templateCache', function($templateCache) {
	$templateCache.put('index.htm', '<div class="jumbotron"> <h1>Hello world!</h1> <p> Welcome to your AngularJS application! </p> </div> <button class="btn btn-primary" ng-click="clickEvent()">Click me!</button>');
}]);

