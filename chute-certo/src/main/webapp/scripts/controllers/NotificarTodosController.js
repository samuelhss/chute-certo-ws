define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('NotificarTodosController', 
			['$scope',
			 'UsuarioService', 
			 '$sce',
			 '$alert',
			 '$routeParams',
			 function ($scope, usuarioService, $sce, $alert, $routeParams) {
		
		$scope.message = {};
		$scope.messages = [
		      {
		    	  label: 'Novos resultados',
		    	  text: 'Novos resultados estão disponíveis!'
		      },
		      {
		    	  label: 'Novas partidas',
		    	  text: 'Novas partidas estão disponíveis!'
		      },
		      {
		    	  label: 'Novos campeonatos',
		    	  text: 'Novos campeonatos estão disponíveis!'
		      },
		      {
		    	  label: 'Resultados para os chutes',
		    	  text: 'Os resultados dos seus chutes já sairam!'
		      }
		];
		
		$scope.submitted = false;
		
		$scope.submit = function() {
			if (!$scope.notificationForm.$invalid && !$scope.notificationForm.$pristine) {
				$scope.send($scope.message);
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
	        
        $scope.send = function(message) {
    		usuarioService.notificateAll(message).success(function(data) {
				$alert({title: '', content: $sce.trustAsHtml('<p>' + data + '</p>'), placement: 'top', type: 'success', show: true});
				$scope.start(data.sigla);
			}).error(function(data, status) {
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>' + data + '</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.message = {};
    		$scope.submitted = false;
        };
 
    }]);
});