define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroCampeonatoController', 
			['$scope',
			 'CampeonatoService', 
			 '$sce',
			 '$alert',
			 '$routeParams',
			 '$upload',
			 '$timeout',
			 function ($scope, campeonatoService, $sce, $alert, $routeParams, $upload, $timeout) {
		
		$scope.championship = {};
		
		$scope.submitted = false;
		
		$scope.submit = function() {
			if (!$scope.championshipForm.$invalid && !$scope.championshipForm.$pristine) {
				$scope.save();
			}
			$scope.submitted = true;
		};
		
		$scope.isInvalid = function(field) {
		    return $scope.championshipForm[field].$invalid;
		};
		
		$scope.isDirty = function(field) {
		    return $scope.championshipForm[field].$dirty;
		};
		
		$scope.isBlured = function(field) {
		    return $scope.championshipForm[field].$blured;
		};
		
		$scope.isSubmitted = function() {
		    return $scope.submitted;
		};

		if (angular.isDefined($routeParams.idCampeonato)) {
			timeService.findById($routeParams.idTime).then(function(result) {
				$scope.championship.id = result.data.id;
				$scope.championship.description = result.data.description;
			});
		}
	        
        $scope.save = function() {
    		campeonatoService.save($scope.championship).success(function(data) {
    			var mensagem = "";
				if ($scope.championship.id != undefined) {
						mensagem =  "Cadastro do Campeonato '" + data.description + "' alterado com sucesso. ID: " + data.id;
				} else {
						mensagem = "Campeonato '" + data.description + "' inserido com sucesso. ID: " + data.id;
				}
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com o campeonato.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.championship = {};
        };
        
    }]);
});