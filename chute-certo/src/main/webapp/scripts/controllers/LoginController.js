define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('LoginController', ['$scope', '$location', function ($scope, $location) {
        if (angular.isDefined($scope.loginError)) {
        	$scope.errorMessage = 'Erro ao efetuar o login.';
        }
    }]);
});