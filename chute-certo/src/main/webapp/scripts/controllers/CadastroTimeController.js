define(['./_module'], function (controllers) {
	'use strict';
	
	controllers.controller('CadastroTimeController', 
			['$scope',
			 'TimeService', 
			 '$sce',
			 '$alert',
			 '$routeParams',
			 '$upload',
			 '$timeout',
			 function ($scope, timeService, $sce, $alert, $routeParams, $upload, $timeout) {
		
		$scope.team = {};
		
		$scope.submitted = false;
		
		$scope.submit = function() {
			if (!$scope.teamForm.$invalid && !$scope.teamForm.$pristine) {
				$scope.save();
			}
			$scope.submitted = true;
		};
		
		$scope.isInvalid = function(field) {
		    return $scope.teamForm[field].$invalid;
		};
		
		$scope.isDirty = function(field) {
		    return $scope.teamForm[field].$dirty;
		};
		
		$scope.isBlured = function(field) {
		    return $scope.teamForm[field].$blured;
		};
		
		$scope.isSubmitted = function() {
		    return $scope.submitted;
		};

		$scope.siglaIsFilled = function() {
			return $scope.team.sigla.length == 11;
		};
		
		if (angular.isDefined($routeParams.idTime)) {
			timeService.findById($routeParams.idTime).then(function(result) {
				$scope.team.id = result.data.id;
				$scope.team.name = result.data.name;
				$scope.team.sigla = result.data.sigla;
			});
		}
	        
        $scope.save = function() {
    		timeService.save($scope.team).success(function(data) {
    			var mensagem = "";
				if ($scope.team.id != undefined) {
						mensagem =  "Cadastro do time '" + data.name + "' alterado com sucesso. ID: " + data.id;
				} else {
						mensagem = "Time '" + data.name + "' inserido com sucesso. ID: " + data.id;
				}
				$alert({title: '', content: $sce.trustAsHtml('<p>' + mensagem + '</p>'), placement: 'top', type: 'success', show: true});
				$scope.start(data.sigla);
			}).error(function(data, status) {
				console.log("Ocorreu erro ao efetuar a operacao com o time.");
				$alert({title: 'Erro', content: $sce.trustAsHtml('<p>Ocorreu erro ao efetuar a operacao.</p>'), placement: 'top', type: 'danger', show: true});
			});
    		$scope.team = {};
        };
        
        $scope.fileReaderSupported = window.FileReader != null;
        
    	$scope.hasUploader = function(index) {
    		return $scope.upload[index] != null;
    	};
    	
    	$scope.abort = function(index) {
    		$scope.upload[index].abort();
    		$scope.upload[index] = null;
    	};
    	
    	$scope.onFileSelect = function($files) {
    		$scope.selectedFiles = [];
    		$scope.progress = [];
    		if ($scope.upload && $scope.upload.length > 0) {
    			for (var i = 0; i < $scope.upload.length; i++) {
    				if ($scope.upload[i] != null) {
    					$scope.upload[i].abort();
    				}
    			}
    		}
    		$scope.upload = [];
    		$scope.uploadResult = [];
    		$scope.selectedFiles = $files;
    		$scope.dataUrls = [];
    		for ( var i = 0; i < $files.length; i++) {
    			var $file = $files[i];
    			if (window.FileReader && $file.type.indexOf('image') > -1) {
    				var fileReader = new FileReader();
    				fileReader.readAsDataURL($files[i]);
    				var loadFile = function(fileReader, index) {
    					fileReader.onload = function(e) {
    						$timeout(function() {
    							$scope.dataUrls[index] = e.target.result;
    						});
    					};
    				}(fileReader, i);
    			}
    			$scope.progress = -1;
    		}
    	};

    	$scope.start = function(fileName) {
    		$scope.errorMsg = null;
    		if (angular.isDefined($scope.selectedFiles[0])) {
    			$scope.upload = $upload.upload({
    				url : '/chute-certo/api/team/flag/upload?name='+fileName,
    				method: $scope.httpMethod,
    				headers: {'enctype': 'multipart/form-data'},
    				data : {
    					myModel : $scope.myModel
    				},
    				file: $scope.selectedFiles[0],
    				fileFormDataName: 'file'
    			}).then(function(response) {
    				$scope.uploadResult.push(response.data);
    			}, function(response) {
    				if (response.status > 0) $scope.errorMsg = response.status + ': ' + response.data;
    			}, function(evt) {
    				$scope.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
    			}).xhr(function(xhr){
    				xhr.upload.addEventListener('abort', function() {console.log('abort complete');}, false);
    			});
    		}
    	};
    }]);
});