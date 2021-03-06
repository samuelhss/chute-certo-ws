define(['./plataforma'], function (plataforma) {
    'use strict';
    return plataforma.config(['$routeProvider', function ($routeProvider) {
    	$routeProvider.when('/index', {
            templateUrl: 'scripts/views/init.html',
            controller: 'PlataformaController'
        });
    	
    	$routeProvider.when('/login', {
            templateUrl: 'scripts/views/login.html',
            controller: 'LoginController'
        });
    	
    	$routeProvider.when('/usuario/cadastro', {
            templateUrl: 'scripts/views/usuario/cadastro.html',
            controller: 'CadastroUsuarioController'
        });
    	$routeProvider.when('/usuario/consulta', {
            templateUrl: 'scripts/views/usuario/consulta.html',
            controller: 'ConsultaUsuarioController'
        });
    	$routeProvider.when('/usuario/:idUsuario', {
            templateUrl: 'scripts/views/usuario/cadastro.html',
            controller: 'CadastroUsuarioController'
        });
    	$routeProvider.when('/time/cadastro', {
            templateUrl: 'scripts/views/time/cadastro.html',
            controller: 'CadastroTimeController'
        });
    	$routeProvider.when('/time/consulta', {
            templateUrl: 'scripts/views/time/consulta.html',
            controller: 'ConsultaTimeController'
        });
    	$routeProvider.when('/time/:idTime', {
            templateUrl: 'scripts/views/time/cadastro.html',
            controller: 'CadastroTimeController'
        });
    	
    	$routeProvider.when('/partida/cadastro', {
            templateUrl: 'scripts/views/partida/cadastro.html',
            controller: 'CadastroPartidaController'
        });
    	$routeProvider.when('/partida/consulta', {
            templateUrl: 'scripts/views/partida/consulta.html',
            controller: 'ConsultaPartidaController'
        });
    	$routeProvider.when('/partida/:idPartida', {
            templateUrl: 'scripts/views/partida/cadastro.html',
            controller: 'CadastroPartidaController'
        });	
    	$routeProvider.when('/resultado/cadastro', {
    		templateUrl: 'scripts/views/resultado/cadastro.html',
    		controller: 'CadastroResultadoController'
    	});
    	$routeProvider.when('/resultado/consulta', {
            templateUrl: 'scripts/views/resultado/consulta.html',
            controller: 'ConsultaResultadoController'
        });
    	$routeProvider.when('/resultado/:idResultado', {
    		templateUrl: 'scripts/views/resultado/cadastro.html',
    		controller: 'CadastroResultadoController'
    	});
    	$routeProvider.when('/campeonato/cadastro', {
    		templateUrl: 'scripts/views/campeonato/cadastro.html',
    		controller: 'CadastroCampeonatoController'
    	});
    	$routeProvider.when('/campeonato/consulta', {
            templateUrl: 'scripts/views/campeonato/consulta.html',
            controller: 'CadastroCampeonatoController'
        });
    	$routeProvider.when('/campeonato/:idCampeonato', {
    		templateUrl: 'scripts/views/campeonato/cadastro.html',
    		controller: 'CadastroCampeonatoController'
    	});
    	$routeProvider.when('/rodada/cadastro', {
    		templateUrl: 'scripts/views/rodada/cadastro.html',
    		controller: 'CadastroRodadaController'
    	});
    	$routeProvider.when('/rodada/consulta', {
            templateUrl: 'scripts/views/rodada/consulta.html',
            controller: 'CadastroRodadaController'
        });
    	$routeProvider.when('/rodada/:idRodada', {
    		templateUrl: 'scripts/views/rodada/cadastro.html',
    		controller: 'CadastroRodadaController'
    	});
    	$routeProvider.when('/notificar/todos', {
            templateUrl: 'scripts/views/notificacao/todos.html',
            controller: 'NotificarTodosController'
        });
    	$routeProvider.when('/notificar/usuario', {
    		templateUrl: 'scripts/views/notificacao/usuario.html',
    		controller: 'NotificarUsuarioController'
    	});
    	
        $routeProvider.otherwise({
            redirectTo: '/index'
        });
        
    }]);
});