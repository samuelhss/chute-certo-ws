define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('NotificarUsuarioController', 
			['$scope',
			 'UsuarioService', 
			 '$sce',
			 '$alert',
			 '$routeParams',
			 function ($scope, usuarioService, $sce, $alert, $routeParams) {
		
		$scope.message = {};
		
		$scope.submitted = false;
		
		$scope.submit = function() {
			if (!$scope.notificationForm.$invalid && !$scope.notificationForm.$pristine) {
				$scope.save();
			}
			$scope.submitted = true;
		};
		
		$scope.isInvalid = function(field) {
		    return $scope.notificationForm[field].$invalid;
		};
		
		$scope.isDirty = function(field) {
		    return $scope.notificationForm[field].$dirty;
		};
		
		$scope.isBlured = function(field) {
		    return $scope.notificationForm[field].$blured;
		};
		
		$scope.isSubmitted = function() {
		    return $scope.submitted;
		};

		
		if (angular.isDefined($routeParams.idTime)) {
			timeService.findById($routeParams.idTime).then(function(result) {
				$scope.team.id = result.data.id;
				$scope.team.name = result.data.name;
				$scope.team.sigla = result.data.sigla;
			});
		}
	        
        $scope.send = function() {
    		usuarioService.save($scope.team).success(function(data) {
				$alert({title: '', content: $sce.trustAsHtml('<p>' + data + '</p>'), placement: 'top', type: 'success', show: true});
				$scope.start(data.sigla);
			}).error(function(data, status) {
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>' + data + '</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.team = {};
        };
 
    }]);
});