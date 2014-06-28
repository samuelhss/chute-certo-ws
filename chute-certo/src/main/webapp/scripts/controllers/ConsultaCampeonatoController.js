define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('ConsultaCampeonatoController', ['$scope', 'CampeonatoService', function ($scope, campeonatoService) {
		$scope.pesquisa = {};
        $scope.campeonatos = null;
        
        $scope.searchProfessores = function() {
        	professorService.findByName($scope.pesquisa.nome != undefined ? $scope.pesquisa.nome : '').then(function(result) {
				$scope.professores = result.data;
				console.log($scope.professores);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.searchAlunosObjeto = function() {
        	professorService.findByDto($scope.pesquisa).then(function(result) {
				$scope.professores = result.data;
				console.log($scope.professores);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.remove = function(professor) {
        	var index = $scope.professores.indexOf(professor);
        	professorService.remove(professor).then(function(result) {
        		console.log("Professor removido");
        		$scope.professores.splice(index, 1);
        	});
        };
        
        $scope.gridOptions = { 
        			data: 'professores',
        			columnDefs: gridProfessores,
        			plugins: [new ngGridFlexibleHeightPlugin(),
        			          new ngGridLayoutPlugin ()],
        			enableCellSelection: false,
        	        enableRowSelection: false,
        };
    }]);
});
var gridProfessores = [
            {
            	field: 'nome', displayName: 'Nome', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a href="#" ng-click="detalhar(row.entity)">{{row.getProperty(col.field)}}</a></div>'
            },
            {
            	field: 'cpf', displayName: 'CPF'
            },
            {
            	field: 'telefone', displayName: 'Telefone'
            },
            {
            	field: 'nivelExperiencia', displayName: 'Nivel de Experi�ncia'
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;" data-popover="Editar Professor" data-popover-trigger="mouseenter"><a href="/escola-imaa/#/professor/{{row.entity.id}}" style="margin: 0 auto; text-align: center;"><img src="/escola-imaa/images/edit_small.png"></img></a></div>' 
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a data-popover="Excluir Professor" data-popover-trigger="mouseenter" ng-click="remove(row.entity)"><img src="/escola-imaa/images/remove_small.png"></img></a></div>' 
            }
];

