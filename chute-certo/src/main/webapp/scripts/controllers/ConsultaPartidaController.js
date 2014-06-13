define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('ConsultaInstrumentoController', ['$scope', 'InstrumentoService', function ($scope, instrumentoService) {
		$scope.pesquisa = {};
        $scope.instrumentos = null;
     
        $scope.searchInstrumentos = function() {
    		instrumentoService.findByDto($scope.pesquisa).then(function(result) {
				$scope.instrumentos = result.data;
				console.log($scope.instrumentos);
    		});
    		$scope.pesquisa = {};
        };           
        
        $scope.searchInstrumentosObjeto = function() {
        	instrumentoService.findByDto($scope.pesquisa).then(function(result) {
				$scope.instrumentos = result.data;
				console.log($scope.instrumentos);
    		});
    		$scope.pesquisa = {};
        };
        
        $scope.remove = function(instrumento) {
        	var index = $scope.instrumentos.indexOf(instrumento);
        	instrumentoService.remove(instrumento).then(function(result) {
        		console.log("Instrumento removido");
        		$scope.instrumentos.splice(index, 1);
        	});
        };
        $scope.gridOptions = { 
    			data: 'instrumentos',
    			columnDefs: gridInstrumento,
    			plugins: [new ngGridFlexibleHeightPlugin(),
    			          new ngGridLayoutPlugin ()],
    			enableCellSelection: false,
    	        enableRowSelection: false,
    };
    }]);
});

var gridInstrumento = [
            {
            	field: 'nome', displayName: 'Nome', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a href="#" ng-click="detalhar(row.entity)">{{row.getProperty(col.field)}}</a></div>'
            },
            {
            	field: 'nivelComplexidade', displayName: 'Nivel de Complexidade'
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;" data-popover="Editar Instrumento" data-popover-trigger="mouseenter"><a  href="/escola-imaa/#/instrumento/{{row.entity.id}}" style="margin: 0 auto; text-align: center;"><img src="/escola-imaa/images/edit_small.png"></img></a></div>' 
            },
            {
            	displayName: '', cellTemplate: '<div style="margin: 0 auto; text-align: center;"><a data-popover="Excluir Instrumento" data-popover-trigger="mouseenter" ng-click="remove(row.entity)"><img src="/escola-imaa/images/remove_small.png"></img></a></div>' 
            }
];