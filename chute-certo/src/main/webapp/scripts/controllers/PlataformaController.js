define(['./_module'], function (controllers) {
	'use strict';
	
    controllers.controller('PlataformaController', ['$scope', '$rootScope', '$location', '$alert', function ($scope, $rootScope, $location, $alert) {
    	
    	$scope.currentPage = '';
    	
	   	$scope.navbarActive = function(route) {
	   		
	   		$scope.currentPage = route;
	   		
            return route === $location.path();
        };        
    }]);
});