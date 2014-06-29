define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('ConsultaTurmaController', ['$scope', 'TurmaService','ProfessorService', 'DisciplinaService', function ($scope, turmaService, professorService, disciplinaService) {
		$scope.pesquisa = {};
        $scope.turmas = null;        
        
        professorService.findAll().then(function(result) {
			$scope.professores = result.data;
		});
        disciplinaService.findAll().then(function(result) {
			$scope.disciplinas = result.data;
		});
        
     
        $scope.searchTurmasByDescricao = function() {
    		turmaService.findByName($scope.pesquisa.descricao != undefined ? $scope.pesquisa.descricao : '').then(function(result) {
				$scope.turmas = result.data;
				console.log($scope.turmas);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.searchTurmas = function() {
        	turmaService.findByDto($scope.pesquisa).then(function(result) {
				$scope.turmas = result.data;
				console.log($scope.turmas);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.remove = function(turma) {
        	var index = $scope.turmas.indexOf(turma);
        	turmaService.remove(turma).then(function(result) {
        		console.log("Turma removida");
        		$scope.turmas.splice(index, 1);
        	});
        };
        
        $scope.gridOptions = { 
    			data: 'turmas',
    			columnDefs: gridTurmas,
    			plugins: [new ngGridFlexibleHeightPlugin(),
    			          new ngGridLayoutPlugin ()],
    			enableCellSelection: false,
    	        enableRowSelection: false,
    };
    }]);
});

var gridTurmas = [
             {
            	field: 'descricao', displayName: 'Descrição', 
            },
            {
            	displayName: 'Disciplina', field: 'disciplina.descricao'
            },
            {
            	field: 'professor.nome', displayName: 'Professor', 
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;" data-popover="Editar Turma" data-popover-trigger="mouseenter"><a  href="/escola-imaa/#/turma/{{row.entity.id}}" style="margin: 0 auto; text-align: center;"><img src="/escola-imaa/images/edit_small.png"></img></a></div>' 
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a data-popover="Excluir Turma" data-popover-trigger="mouseenter" ng-click="remove(row.entity)"><img src="/escola-imaa/images/remove_small.png"></img></a></div>' 
            }
];

