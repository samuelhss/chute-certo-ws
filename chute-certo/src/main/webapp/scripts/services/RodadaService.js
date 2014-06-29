define(['./_module'], function (services) {
	'use strict';
	
    services.factory('RodadaService', ['$http',function ($http) {
    	return {    		
    		findById: function(id) {
    			return $http.get('/chute-certo/api/round/get/'+id).success(function(data, status) {
    				console.log("Retornando rodada '" + data.description + "'.");
    			});
    		},
    		findByName: function(description) {
    			return $http.get('/chute-certo/api/round/find?description='+description).success(function(data, status) {
    				console.log("Retornando rodadas que contenham '" + description + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/chute-certo/api/round/search', pesquisaDto).success(function(data, status) {
    				console.log("Pesquisa de rodadas efetuada.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/chute-certo/api/round/list').success(function(data, status, headers, config) {
    				console.log("Lista de rodadas carregada.");
    			});
    		},
    		
    		save: function(round) {
    			return $http.post('/chute-certo/api/round/save', round);	
    		},
    		remove: function(round) {
    			return $http.get('/chute-certo/api/team/remove/'+round.id).success(function(data) {
    				console.log("Rodada '" + round.description + "' removido.");
    			});
    		},
    	};
    }]);
});