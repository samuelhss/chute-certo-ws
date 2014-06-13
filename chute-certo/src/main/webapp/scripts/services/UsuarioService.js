define(['./_module'], function (services) {
	'use strict';
	
    services.factory('UsuarioService', ['$http',function ($http) {
    	return {
    		init: function() { 
    			return {
	    			fundamentosPercepcao: false
    			};
    		},
    		findById: function(id) {
    			return $http.get('/escola-imaa/api/aluno/get/'+id).success(function(data, status) {
    				console.log("Retornando aluno '" + nome + "'.");
    			});
    		},
    		findByName: function(nome) {
    			return $http.get('/escola-imaa/api/aluno/search?nome='+nome).success(function(data, status) {
    				console.log("Retornando alunos que contenham '" + nome + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/escola-imaa/api/aluno/advancedSearch', pesquisaDto).success(function(data, status) {
    				console.log("Retornando alunos que contenham '" + nome + "' no nome");
    			});
    		},
    		findAll: function() {
    			return $http.get('/escola-imaa/api/aluno/list').success(function(data, status, headers, config) {
    				console.log("Lista de alunos carregada com sucesso.");
    			});
    		},
    		save: function(aluno) {
    			return $http.post('/escola-imaa/api/aluno/save', aluno);	
    		},
    		remove: function(aluno) {
    			return $http.get('/escola-imaa/api/aluno/remove/'+aluno.id).success(function(data) {
    				console.log("Aluno '" + aluno.nome + "' removido com sucesso. ID: " + aluno.id);
    			});
    		},
    	};
    }]);
});