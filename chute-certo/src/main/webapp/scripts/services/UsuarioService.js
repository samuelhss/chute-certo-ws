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
    			return $http.get('/chute-certo/api/user/get/'+id).success(function(data, status) {
    				console.log("Retornando usuario '" + nome + "'.");
    			});
    		},
    		findByName: function(nome) {
    			return $http.get('/chute-certo/api/user/find?nome='+nome).success(function(data, status) {
    				console.log("Retornando usuarios que contenham '" + nome + "' no nome");
    			});
    		},
    		findByDto: function(pesquisaDto) {
    			return $http.post('/chute-certo/api/user/search', pesquisaDto).success(function(data, status) {
    				console.log("Retornando usuarios que contenham '" + nome + "' no nome");
    			});
    		},
    		notificateAll: function(message) {
    			return $http.post('/chute-certo/api/user/notificate/all', message).success(function(data, status) {
    				console.log("Notificacao enviada para todos os usuarios.");
    			});
    		},
    		findAll: function() {
    			return $http.get('/chute-certo/api/user/list').success(function(data, status, headers, config) {
    				console.log("Lista de usuarios carregada.");
    			});
    		},
    		save: function(user) {
    			return $http.post('/chute-certo/api/user/save', user);	
    		},
    		remove: function(user) {
    			return $http.post('/chute-certo/api/user/remove/'+user.id).success(function(data) {
    				console.log("Usuario '" + user.nome + "' removido com sucesso. ID: " + user.id);
    			});
    		},
    	};
    }]);
});