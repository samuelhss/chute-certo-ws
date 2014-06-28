define(['./_module'], function (services) {
	'use strict';
	
    services.factory('CampeonatoService', ['$http',function ($http) {
    	return {    		
    		findById: function(id) {
    			return $http.get('/chute-certo/api/championship/get/'+id).success(function(data, status) {
    				console.log("Retornando campeonato '" + data.description + "'.");
    			});
    		},
    		findByName: function(description) {
    			return $http.get('/chute-certo/api/championship/find?description='+description).success(function(data, status) {
    				console.log("Retornando campeonatos que contenham '" + description + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/chute-certo/api/championship/search', pesquisaDto).success(function(data, status) {
    				console.log("Pesquisa de campeonatos efetuada.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/chute-certo/api/championship/list').success(function(data, status, headers, config) {
    				console.log("Lista de campeonatos carregada.");
    			});
    		},
    		
    		save: function(championship) {
    			return $http.post('/chute-certo/api/championship/save', championship);	
    		},
    		remove: function(championship) {
    			return $http.get('/chute-certo/api/team/remove/'+championship.id).success(function(data) {
    				console.log("Campeonato '" + championship.description + "' removido.");
    			});
    		},
    	};
    }]);
});