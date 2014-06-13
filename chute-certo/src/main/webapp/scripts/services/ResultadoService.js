define(['./_module'], function (services) {
	'use strict';
	
    services.factory('TurmaService', ['$http',function ($http) {
    	return {
    		init: function() { 
    			return {
	    			id: null,
	    			descricao: '',
    			 	maximoAlunos: '',
    			 	dataHora: null,
    			 	disciplina: null,
    			 	professor: null
    			};
    		},
    		findById: function(id) {
    			return $http.get('/escola-imaa/api/turma/get/'+id).success(function(data, status) {
    				console.log("Retornando turma '" + nome + "'.");
    			});
    		},
    		findByName: function(descricao) {
    			return $http.get('/escola-imaa/api/turma/search?descricao='+descricao).success(function(data, status) {
    				console.log("Retornando turmas que contenham '" +descricao + "' na descri��o");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/escola-imaa/api/turma/advancedSearch', pesquisaDto).success(function(data, status) {
    				console.log("Retornando turmas que contenham '" + descricao + "' no descri��o");
    			});
    		},
    	
    		findAll: function() {
    			return $http.get('/escola-imaa/api/turma/list').success(function(data, status, headers, config) {
    				console.log("Lista de turmas carregada com sucesso.");
    			});
    		},
    		
    		save: function(turma) {
    			return $http.post('/escola-imaa/api/turma/save', turma);	
    		},
    		matricula: function(matricula) {
    			return $http.post('/escola-imaa/api/turma/matricula', matricula);	
    		},
    		remove: function(turma) {
    			return $http.get('/escola-imaa/api/turma/remove/'+turma.id).success(function(data) {
    				console.log("Turma '" + turma.descricao + "' removido com sucesso. ID: " + turma.id);
    			});
    		},
    	};
    }]);
});