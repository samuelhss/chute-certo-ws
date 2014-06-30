define(['./_module'], function (services) {
	'use strict';
	
    services.factory('ResultadoService', ['$http',function ($http) {
    	return {
    		findById: function(id) {
    			return $http.get('/chute-certo/api/result/get/'+id).success(function(data, status) {
    				console.log("Retornando resultado '" + id + "'.");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/chute-certo/api/result/search', pesquisaDto).success(function(data, status) {
    				console.log("Retornando pesquisa de resultados.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/chute-certo/api/result/list').success(function(data, status, headers, config) {
    				console.log("Lista de resultados carregada.");
    			});
    		},		
    		save: function(result) {
    			return $http.post('/chute-certo/api/result/save', result);	
    		},
    		remove: function(result) {
    			return $http.get('/chute-certo/api/turma/remove/'+result.id).success(function(data) {
    				console.log("Resultado removido com sucesso. ID: " + result.id);
    			});
    		},
    	};
    }]);
});