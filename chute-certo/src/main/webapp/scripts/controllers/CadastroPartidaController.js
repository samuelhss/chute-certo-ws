define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroPartidaController', 
			['$scope',
			 'PartidaService',
			 '$sce',
			 '$alert', 
			 '$routeParams',
			 'TimeService',
			 'CampeonatoService',
			 function ($scope, partidaService, $sce, $alert, $routeParams, timeService, campeonatoService) {
				
		$scope.match = {};
		$scope.championship = {};
		$scope.round = {};
		$scope.date = {};
		
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
		
		campeonatoService.findAll().then(function(result) {
			$scope.championships = result.data;
			console.log($scope.championships);
		});
			        
        $scope.save = function() {
        	$scope.match.idRound = $scope.round.selected.id;
        	$scope.match.date = $scope.date;
        	var mensagem = "Partida " + $scope.match.homeTeam.name +" x " + $scope.match.awayTeam.name + " inserida com sucesso.";				
        	partidaService.save($scope.match).success(function(data) {
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.match = {};
        };
    }]);
});