define(['./_module'], function (services) {
	'use strict';
	
    services.factory('ProfessorService', ['$http',function ($http) {
    	return {
    		init: function() { 
    			return {
	    			nivelExperiencia:''
    			};
    		},
    		
    		findById: function(id) {
    			return $http.get('/escola-imaa/api/professor/get/'+id).success(function(data, status) {
    				console.log("Retornando professor '" + nome + "'.");
    			});
    		},
    		findByName: function(nome) {
    			return $http.get('/escola-imaa/api/professor/search?nome='+nome).success(function(data, status) {
    				console.log("Retornando professores que contenham '" + nome + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/escola-imaa/api/professor/advancedSearch', pesquisaDto).success(function(data, status) {
    				console.log("Retornando professores que contenham '" + nome + "' no nome");
    			});
    		},
    		findAll: function() {
    			return $http.get('/escola-imaa/api/professor/list').success(function(data, status, headers, config) {
    				console.log("Lista de professores carregada com sucesso.");
    			});
    		},
    		
    		save: function(professor) {
    			return $http.post('/escola-imaa/api/professor/save', professor);	
    		},
    		remove: function(professor) {
    			return $http.get('/escola-imaa/api/professor/remove/'+professor.id).success(function(data) {
    				console.log("Professor '" + professor.nome + "' removido com sucesso. ID: " + professor.id);
    			});
    		},
    	};
    }]);
});