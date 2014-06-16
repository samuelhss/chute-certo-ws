define(['./_module'], function (services) {
	'use strict';
	
    services.factory('TimeService', ['$http',function ($http) {
    	return {    		
    		findById: function(id) {
    			return $http.get('/chute-certo/api/professor/get/'+id).success(function(data, status) {
    				console.log("Retornando time '" + data.name + "'.");
    			});
    		},
    		findByName: function(name) {
    			return $http.get('/chute-certo/api/professor/search?name='+name).success(function(data, status) {
    				console.log("Retornando times que contenham '" + name + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/chute-certo/api/professor/advancedSearch', pesquisaDto).success(function(data, status) {
    				console.log("Pesquisa de times efetuada.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/chute-certo/api/team/list').success(function(data, status, headers, config) {
    				console.log("Lista de times carregada.");
    			});
    		},
    		
    		save: function(team) {
    			return $http.post('/chute-certo/api/team/save', team);	
    		},
    		remove: function(team) {
    			return $http.get('/chute-certo/api/team/remove/'+team.id).success(function(data) {
    				console.log("Time '" + team.sigla + "' removido.");
    			});
    		},
    	};
    }]);
});