define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroRodadaController', 
			['$scope', 
			 '$sce',
			 'RodadaService', 
			 '$alert',
			 'CampeonatoService',
			 '$routeParams',
			 function ($scope, $sce, roundService, $alert, championshipService, $routeParams) {
			
		$scope.round = {};
		
$scope.submitted = false;
		
		$scope.submit = function() {
			if (!$scope.roundForm.$invalid && !$scope.roundForm.$pristine) {
				$scope.save();
			}
			$scope.submitted = true;
		};
		
		$scope.isInvalid = function(field) {
		    return $scope.roundForm[field].$invalid;
		};
		
		$scope.isDirty = function(field) {
		    return $scope.roundForm[field].$dirty;
		};
		
		$scope.isBlured = function(field) {
		    return $scope.roundForm[field].$blured;
		};
		
		$scope.isSubmitted = function() {
		    return $scope.submitted;
		};

		if (angular.isDefined($routeParams.idRodada)) {
			roundService.findById($routeParams.idRodada).then(function(result) {
				$scope.round.id = result.data.id;
				$scope.round.descricao = result.data.descricao;
				$scope.round.championship = result.data.championship;
			});
		}
		
		championshipService.findAll().then(function(result) {
			$scope.championships = result.data;
		});
	        
        $scope.save = function() {
        	roundService.save($scope.round).success(function(data) {
    			var mensagem = "Rodada '" + data.description  + "' inserida com sucesso." ;
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com a rodada.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.round = {};
        };
       
    }]);
});