define([
    'angular',
    'angular.route',
    'ui.bootstrap',
    'ng.grid',
    'ui.select',
    'ng.grid.flexible.height',
    'ng.grid.layout',
    'angular.animate',
    'angular.upload',
    'angular.sanitize',
    'angular.strap',
    'angular.strap.tpl',
    'ui.utils',
    'angular.validation',
    '../directives/_directives',
    '../services/_services',
    '../controllers/_controllers',
    'utils'
], function (angular) {
    'use strict';

    return angular.module('plataforma', [
        'plataforma.directives',
        'plataforma.services',
        'plataforma.controllers',                                 
        'ngRoute',
        'ngAnimate',
        'ngSanitize',
        'mgcrea.ngStrap',
        'ngGrid',
        'ui.select',
        'angularFileUpload',
        'ui.utils',
        'ui.mask',
        'validation'
    ]);
});