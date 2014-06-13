define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroResultadoController', 
			['$scope', 
			 'TurmaService', 
			 '$sce',
			 'ResultadoService', 
			 '$alert',
			 'ProfessorService',
			 '$routeParams',
			 function ($scope, turmaService, $sce, disciplinaService, $alert, professorService, $routeParams) {
			
		$scope.turma = turmaService.init();
		
		$scope.disciplina = {};
		$scope.professor = {};

		if (angular.isDefined($routeParams.idTurma)) {
			turmaService.findById($routeParams.idTurma).then(function(result) {
				$scope.turma.id = result.data.id;
				$scope.turma.descricao = result.data.descricao;
				$scope.turma.maximoAlunos = result.data.maximoAlunos;
				$scope.turma.dataHora = result.data.dataHora;
				$scope.disciplina = result.data.disciplina;
				$scope.professor = result.data.professor;
			});
		}
		
		disciplinaService.findAll().then(function(result) {
			$scope.disciplinas = result.data;
		});
		
		professorService.findAll().then(function(result) {
			$scope.professores = result.data;
		});
	        
        $scope.save = function() {
        	$scope.turma.disciplina = $scope.disciplina.selected;
        	$scope.turma.professor = $scope.professor.selected;
        	
        	turmaService.save($scope.turma).success(function(data) {
    			var mensagem = "";
						mensagem = "Turma '" + data.descricao  + "' inserida com sucesso." ;
					
				
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com a turma.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.turma = turmaService.init();
        };
       
    }]);
});