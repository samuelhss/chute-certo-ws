define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('ConsultaAlunoController', ['$scope', 'AlunoService', function ($scope, alunoService) {
		$scope.pesquisa = {};
        $scope.alunos = null;
     
        $scope.searchAlunos = function() {
    		alunoService.findByName($scope.pesquisa.nome != undefined ? $scope.pesquisa.nome : '').then(function(result) {
				$scope.alunos = result.data;
				console.log($scope.alunos);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.remove = function(aluno) {
        	var index = $scope.alunos.indexOf(aluno);
        	alunoService.remove(aluno).then(function(result) {
        		console.log("Aluno removido");
        		$scope.alunos.splice(index, 1);
        	});
        };
        
        $scope.searchAlunosObjeto = function() {
    		alunoService.findByDto($scope.pesquisa).then(function(result) {
				$scope.alunos = result.data;
				console.log($scope.alunos);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.gridOptions = { 
        			data: 'alunos',
        			columnDefs: gridAlunos,
        			plugins: [new ngGridFlexibleHeightPlugin(),
        			          new ngGridLayoutPlugin ()],
        			enableCellSelection: false,
        	        enableRowSelection: false,
        };
        
        
    }]);
});

var gridAlunos = [
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
            	field: 'fundamentosPercepcao', displayName: 'Fundamentos Percep.',
            	cellTemplate: '<div ng-switch on="row.getProperty(col.field)">' +
                '<div ng-switch-when="true" style="margin: 0 auto; text-align: center;">' + 
                '	<a href="#" ng-click="marcarFundamentos(row.entity)">' + 
                '		<img src="/escola-imaa/images/checked_small.png"></img></a></div>' +
                '<div ng-switch-when="false" style="margin: 0 auto; text-align: center;">' + 
                '	<a href="#" ng-click="marcarFundamentos(row.entity)"><img src="/escola-imaa/images/unchecked_small.png">' + 
                '		</img></a></div>' +
                '<div ng-switch-default class="grid">no data</div>' +
              '</div>'

            },
            {
            	field: 'email', displayName: 'Email'
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;" data-popover="Editar Aluno" data-popover-trigger="mouseenter"><a href="/escola-imaa/#/aluno/{{row.entity.id}}" style="margin: 0 auto; text-align: center;"><img src="/escola-imaa/images/edit_small.png"></img></a></div>' 
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a data-popover="Excluir Aluno" data-popover-trigger="mouseenter" ng-click="remove(row.entity)"><img src="/escola-imaa/images/remove_small.png"></img></a></div>' 
            }
];



