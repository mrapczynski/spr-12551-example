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