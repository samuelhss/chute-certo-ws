define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroPartidaController', 
			['$scope',
			 'PartidaService',
			 '$sce',
			 '$alert', 
			 '$routeParams',
			 function ($scope, partidaService, $sce, $alert, $routeParams) {
			
		$scope.instrumento = {};
		
		if (angular.isDefined($routeParams.idPartida)) {
			partidaService.findById($routeParams.idPartida).then(function(result) {
				$scope.partida.id = result.data.id;
				$scope.partida.homeTeam = result.data.homeTeam;
				$scope.partida.awayTeam = result.data.awayTeam;
			});
		}
			        
        $scope.save = function() {
        	partidaService.save($scope.partida).success(function(data) {
    			var mensagem = "Partida '" + data.id + "' inserida com sucesso.";				
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com o instrumento.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.instrumento = instrumentoService.init();
        };
    }]);
});