define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroPartidaController', 
			['$scope',
			 'PartidaService',
			 '$sce',
			 '$alert', 
			 '$routeParams',
			 'TimeService',
			 function ($scope, partidaService, $sce, $alert, $routeParams, timeService) {
				
		$scope.match = {};
		
		if (angular.isDefined($routeParams.idPartida)) {
			partidaService.findById($routeParams.idPartida).then(function(result) {
				$scope.match.id = result.data.id;
				$scope.match.homeTeam = result.data.homeTeam;
				$scope.match.awayTeam = result.data.awayTeam;
			});
		}
		
		timeService.findAll().then(function(result) {
			$scope.teams = result.data;
		});
			        
        $scope.save = function() {
        	partidaService.save($scope.match).success(function(data) {
    			var mensagem = "Partida '" + data.id + "' inserida com sucesso.";				
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.match = {};
        };
    }]);
});