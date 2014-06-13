define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroProfessorController', 
			['$scope',
			 'ProfessorService', 
			 'PessoaService',
			 '$sce',
			 '$alert',
			 '$routeParams',
			 function ($scope, professorService, pessoaService, $sce, $alert, $routeParams) {
		$scope.pessoa = pessoaService.init();		
		$scope.professor = professorService.init();
		
		if (angular.isDefined($routeParams.idProfessor)) {
			professorService.findById($routeParams.idProfessor).then(function(result) {
				$scope.pessoa.id = result.data.id;
				$scope.pessoa.nome = result.data.nome;
				$scope.pessoa.email = result.data.email;
				$scope.pessoa.cpf = result.data.cpf;
				$scope.pessoa.telefone = result.data.telefone;
				$scope.pessoa.endereco = result.data.endereco;
				$scope.pessoa.cep = result.data.cep;
				$scope.pessoa.sexo = result.data.sexo;
				$scope.professor.nivelExperiencia = result.data.nivelExperiencia;
				$scope.professor.disponibilidadeHorario = result.data.disponibilidadeHorario;
				
			});
		}
	        
        $scope.save = function() {
        	$scope.professor = extend($scope.professor, $scope.pessoa);
    		professorService.save($scope.professor).success(function(data) {
    			var mensagem = "";
				if ($scope.pessoa.id != undefined) {
					if ($scope.pessoa.sexo === 'M')
						mensagem =  "Cadastro do professor '" + data.nome + "' alterado com sucesso. ID: " + data.id;
					else
						mensagem = "Cadastro da professora '" + data.nome + "' alterado com sucesso. ID: " + data.id;
				} else {
					if ($scope.pessoa.sexo === 'M')
						mensagem = "Professor '" + data.nome + "' inserido com sucesso. ID: " + data.id;
					else
						mensagem = "Professora '" + data.nome + "' inserida com sucesso. ID: " + data.id;
				}
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operação com o professor.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operação.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.professor = professorService.init();
    		$scope.pessoa = pessoaService.init();
        };
    }]);
});