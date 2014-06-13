define(['./_module'], function (services) {
	'use strict';
	
    services.factory('PartidaService', ['$http',function ($http) {
    	return {	
    		findById: function(id) {
    			return $http.get('/chute-certo/api/match/get/'+id).success(function(data, status) {
    				console.log("Retornando partida '" + data.id + "'.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/escola-imaa/api/match/list').success(function(data, status, headers, config) {
    				console.log("Retornando lista de partidas.");
    			});
    		},   		
    		save: function(partida) {
    			return $http.post('/escola-imaa/api/match/save', partida);	
    		},
    		remove: function(partida) {
    			return $http['delete']('/escola-imaa/api/match/remove/'+partida.id).success(function(data) {
    				console.log("Partida '" + partida.id + "' removida.");
    			});
    		},
    	};
    }]);
});