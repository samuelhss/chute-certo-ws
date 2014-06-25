define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroUsuarioController',
			['$scope',
			 'UsuarioService',
			 '$alert',
			 '$sce',
			 '$routeParams',
			 function ($scope, alunoService, $alert, $sce, $routeParams) {
		
		$scope.aluno = {};
		$scope.submitted = false;

		if (angular.isDefined($routeParams.idAluno)) {
			alunoService.findById($routeParams.idAluno).then(function(result) {
				$scope.pessoa.id = result.data.id;
				$scope.pessoa.nome = result.data.nome;
				$scope.pessoa.email = result.data.email;
				$scope.pessoa.cpf = result.data.cpf;
				$scope.pessoa.telefone = result.data.telefone;
				$scope.pessoa.endereco = result.data.endereco;
				$scope.pessoa.cep = result.data.cep;
				$scope.pessoa.sexo = result.data.sexo;
				$scope.aluno.fundamentosPercepcao = result.data.fundamentosPercepcao;
			});
		}
		
		$scope.submit = function() {
			if (!$scope.pessoaForm.$invalid && !$scope.pessoaForm.$pristine) {
				$scope.save();
			}
			$scope.submitted = true;
		};
		
		$scope.isInvalid = function(field) {
		    return $scope.pessoaForm[field].$invalid;
		};
		
		$scope.isDirty = function(field) {
		    return $scope.pessoaForm[field].$dirty;
		};
		
		$scope.isBlured = function(field) {
		    return $scope.pessoaForm[field].$blured;
		};
		
		$scope.isSubmitted = function() {
		    return $scope.submitted;
		};
		
		$scope.cepIsFilled = function() {
			return $scope.pessoa.cep.length == 8;
		};
		
		$scope.cpfIsFilled = function() {
			return $scope.pessoa.cpf.length == 11;
		};
		
		$scope.telefoneIsFilled = function() {
			return $scope.pessoa.telefone.length == 10;
		};
	        
        $scope.save = function() {
        	$scope.aluno = extend($scope.aluno, $scope.pessoa);
    		alunoService.save($scope.aluno).success(function(data) {
    			var mensagem = "";
				if ($scope.aluno.id != undefined) {
					if ($scope.aluno.sexo === 'M')
						mensagem =  "Cadastro do aluno '" + data.nome + "' alterado com sucesso. ID: " + data.id;
					else
						mensagem = "Cadastro da aluna '" + data.nome + "' alterado com sucesso. ID: " + data.id;
				} else {
					if ($scope.aluno.sexo === 'M')
						mensagem = "Aluno '" + data.nome + "' inserido com sucesso. ID: " + data.id;
					else
						mensagem = "Aluna '" + data.nome + "' inserida com sucesso. ID: " + data.id;
				}
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p><br><p><a href="#/turma/matricula/">Matricular em uma turma?</a><p>'), placement: 'top', type: 'success', show: true});
    		}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com o aluno.");
				$alert({title: '', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a opera&ccedil;&atilde;o com o aluno.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.aluno = alunoService.init();
    		$scope.submitted = false;
    		$scope.pessoaForm.$setValidity();
        };
    }]);
});