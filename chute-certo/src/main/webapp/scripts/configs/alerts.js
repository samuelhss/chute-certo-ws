define(['./plataforma'], function (plataforma) {
    'use strict';
    return plataforma.config(['$alertProvider', function ($alertProvider) {
    	angular.extend($alertProvider.defaults, {
            animation: 'am-fade-and-slide-top',
            placement: 'top-right',
            duration: '4',
            keyboard: true
          });
    }]);
});