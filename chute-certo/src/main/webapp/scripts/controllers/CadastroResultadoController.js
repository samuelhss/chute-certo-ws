define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroResultadoController', 
			['$scope', 
			 '$sce',
			 'ResultadoService', 
			 '$alert',
			 '$routeParams',
			 'PartidaService',
			 function ($scope, $sce, resultadoService, $alert, $routeParams, partidaService) {
			
		$scope.result = {};
		$scope.match = {};

		if (angular.isDefined($routeParams.idResultado)) {
			resultadoService.findById($routeParams.idResultado).then(function(result) {
				$scope.result.id = result.data.id;
				//$scope.result.match = result.data.match;
				$scope.result.scoreHome = result.data.scoreHome;
				$scope.result.scoreAway = result.data.scoreAway;
			});
		}
		
		partidaService.findAll().then(function(result) {
			$scope.matches = result.data;
		});
	        
        $scope.save = function() {
        	$scope.result.idMatch = $scope.match.selected.id;
        	resultadoService.save($scope.result).success(function(data) {
    			var mensagem = "Resultado inserido com sucesso.";
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.result = {};
        };
       
    }]);
});